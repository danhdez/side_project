/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laii;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author SONY
 */
public class Lex {
    ArrayList al=new ArrayList();
    ArrayList key=new ArrayList();
    ArrayList todo[]=new ArrayList[2];
    
//   String prueba="@ ";
   String result="";
   String err="";

    public ArrayList[] getTodo() {
        return todo;
    }

   

    
    Lex() throws IOException{
//        Replace(prueba);
        todo[0]=new ArrayList();
        todo[1]=new ArrayList();
        
    }
    
    public void Replace(String s) throws IOException{
        String result="";

//        System.out.println("CADENA SUCIA: "+s);
          s=s.trim().replaceAll(" +", " ").replaceAll("\t+", " ").replaceAll("\n+", " ");
          s=s.replaceAll(" +"," ");
          s=s+" ";
//          System.out.println("CADENA LIMPIA: "+s);

          String aux="";
        char c [];
        c=s.toCharArray();
        
        for (int i = 0; i < c.length; i++){
            if (Character.isSpaceChar(c[i])==false) {
                aux+=c[i];
            }
            else{
                al.add(aux);
                System.out.println("Ingresa al arreglo: "+aux);
                aux="";
                
            }
        }
        Handle();
    } 

    public String getResult() {
        return result;
    }

    public String getErr() {
        return err;
    }
    
    
       void Handle() throws IOException{
           String current="";
           String temp="";
           Constante con=new Constante();
           Variable var=new Variable();
           Symbol sym=new Symbol();
           tokens_1 tok=new tokens_1();
           boolean alpha=false; // Token es constante
           boolean beta=false;     //Token es variable
           boolean gamma=false;     //Token es etiqueta que cierra
           boolean delta=false;         //Token es etiqueta que abre
           boolean epsilon=false;      //Token es caracter reservado
           boolean zeta=false;          //Token es Palabra Reservada ETIQUETA 
           boolean eta=false;       //Token es texto plano
           boolean theta=false;     //Token es Decision
           boolean iota=false;      //Token token es una Operación ya que contiene alguno de los siguientes: = + - * /
           boolean kappa=false;  //Token es palabra reservada ATRIBUTO
           
           
           for (int j = 0; j < al.size(); j++) {
               current=al.get(j).toString();
               
//               System.out.println("En la posicion: "+j+" del ArrayList se encontró el Token: "+al.get(j));
               result=result+"Se encontro el token: "+current+"\n";
//               System.out.println("token Actual "+current+ " iteracion: "+j);
               
               //  Este codigo valida que los token sean numeros y que tengan la longitud adecuada
//               if (current.matches(".*\\d.*")&&((current.contains("+"))==false)&&((current.contains("-"))==false)&&((current.contains("*"))==false)&&((current.contains("/"))==false)) {
               if (current.matches(".*\\d.*")) {
//                   System.out.println("EL TOKEN CONTIENE DIGITOS");
                con.Dividir(current);
                alpha=con.isBandera();
                con.cont=0;
                   if (alpha) {
//                       System.out.println("EL TOKEN ES UN NUMERO VALIDO");
                       
                   }
                   if(alpha==false){
//                       System.out.println("NO ES NUMERO VALIDO");
                   }
                
               }
               
               //Este codigo valida que sean nombres de variable válidos
               if ((current.matches("@.*"))&&(current.length()>1)) {
                   System.out.println("DETECTE UNA VARIABLE");
                   char c[]=current.toCharArray();
                   c=Arrays.copyOfRange(c, 1, c.length);
                   temp="";
                   for (int i = 0; i < c.length; i++) {
                       temp=temp+c[i];
                   }
//                   System.out.println("ENVIANDO A ANALIZAR:  "+temp);
                   System.out.println("SE ENVIÓ: "+temp);
                   var.Dividir(temp);

                   if(var.isBandera()==false){
                       System.out.println("PORQUE??");}
                   beta=var.isBandera();
                    if (beta==true) {
//                     
                        System.out.println("ES VAR");
                       
                   }
                   if(beta==false){
//                       System.out.println("NO ES NOMBRE DE VARIABLE VALIDO");
                       System.out.println("NO ES VARRR");
                   }
                
               }
               
               // Esta parte va a revisar que sean palabras reservadas
                   //Primero como etiqueta que abre
                if ((current.matches("<.*"))&&(current.length()>3)) {
                    boolean res=false;
                   char c2[]=current.toCharArray();
                   c2=Arrays.copyOfRange(c2, 1, c2.length);
                   temp="";
                   for (int i = 0; i < c2.length; i++) {
                       temp=temp+c2[i];
                   }
//                   System.out.println("ENVIANDO A ANALIZAR:  "+temp);
                   tok.buscar(temp);
                   res=tok.isBan();
                           if (res&&(tok.getCod()<8)) {

                       gamma=true;
                   }
                           res=false;
                
                
               }
                //Ahora como etiqueta que cierra
                if ((current.matches(".*>"))&&(current.length()>3)) {
                    boolean res=false;
                   char c3[]=current.toCharArray();
                   c3=Arrays.copyOfRange(c3, 0, c3.length-1);
                   temp="";
                   for (int i = 0; i < c3.length; i++) {
                       temp=temp+c3[i];
                   }
//                   System.out.println("ENVIANDO A ANALIZAR:  "+temp);
                   tok.buscar(temp);
                   res=tok.isBan();
                           if (res&&(tok.getCod()<8)) {
                               delta=true;
                   }
             
                           res=false;
               }
                
                //Ahora verifica que sea un Caracter Reconocido
               if(current.length()==1){
               tok.buscar(current);
               epsilon=tok.isBan();
                   if (epsilon) {
//                       System.out.println("EL TOKEN ES UN CARACTER RECONOCIDO");
                   }
                   if (epsilon==false) {
//                      System.out.println("EL TOKEN ES UN CARACTER NO VALIDO");
                   }
               
               }
               
               if((current.contains("+")||current.contains("-")||current.contains("*")||current.contains("/")||current.contains("="))&&(current.length()>2)){

                   sym.Operacion(current);
                   iota=sym.isBandera();
                   if (iota) {
                       System.out.println("OPERACION");
                       
                   }
                   if (iota==false) {
                       System.out.println("NO PASO LA OPERACION");
                       
                   }
               
               }
               
               //Validamos que sea una palabra reservada etiqueta
               if(current.matches("([a-z]|[A-Z]|\\s)+")){
                   boolean reservado=false;
                   tok.buscar(current);
                   reservado=tok.isBan();
                   
                  if(reservado&&(tok.getCod()<8)){
                      zeta=true;
                  }
                   if(reservado&&(tok.getCod()>27)){
                   kappa=true;
                   }
                   reservado=false;
               }
               
               //  Verifica los caracteres relacionales
               if((current.length()==2)){
                   tok.buscar(current);
                   epsilon=tok.isBan();
               }
               
               
               
                if((!alpha&&!beta&&!gamma&&!delta&&!epsilon&&!zeta&&!eta&&!theta&&!iota&&!kappa)){
//               System.out.println("EL TOKEN NO PERTENCE AL LENGUAJE SIN EMBARGO SE RECONOCE COMO TEXTO PLANO");
               err=err+"El token: "+current+" no pertenece al lenguaje, sin embargo se reconoce como texto plano \n";
               result=result+"error Léxico \n";
               eta=true;
               key.add(4);
           }
               
                if(alpha){
                result=result+"El token: "+current+" es un número válido \n";
                key.add(3);
                }
                if(beta){
                result=result+"El token: "+current+" es una variable válida \n";
                key.add(2);
                }
                if(gamma){
                result=result+"El token: "+current+" es una etiqueta de cierre válida \n";
                key.add(1);
                }
                if(delta){
                result=result+"El token: "+current+" es una etiqueta de apertura válida \n";
                key.add(0);
                }
                if(epsilon){
                result=result+"El token: "+current+" es un caracter reservado válido \n";
                key.add(6);
                }
                if(zeta){
                result=result+"El token: "+current+" es una palabra  reservada que se puede emplear como Etiqueta \n";
                key.add(5);
                }
                if(theta){
                    result=result+"El token: "+current+" es una Decisión  \n";
                key.add(7);
                }
                if(iota){
                    result=result+"El token: "+current+" es una Operación \n";
                key.add(8);
                }
                if(kappa){
                    result=result+"El token: "+current+" es un Atributo \n";
                key.add(9);
                }
                if(temp!=""){
                    todo[0].add(temp);
                    }
                if(temp==""){
                todo[0].add(al.get(j));
                }
                todo[1].add(key.get(j));
                System.out.println("TODO EN 0: "+todo[0].get(j));
                 System.out.println("TODO EN 1: "+todo[1].get(j));
                
               
               alpha=false;beta=false;gamma=false;delta=false;epsilon=false;zeta=false;eta=false;theta=false;iota=false;kappa=false;
               var.bandera=false;con.bandera=false;tok.ban=false;var.cont=0;
           
           }
          
        
           
        }
       
       
       public static void main(String[] args) throws IOException {
        new Lex();
    }
        
        }
      
        
        
