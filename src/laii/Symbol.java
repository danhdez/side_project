/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laii;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author SONY
 */
public class Symbol {
        boolean paso=false;
        boolean fail=false;
        boolean bandera=false;
        boolean igual=false;
        boolean pc=false;
        String tok="";
        Variable var;
        Constante con;
        
        
        String prueba="1+1";
       
        
        
    Symbol() throws IOException{
//        Operacion(prueba);
       
    
    }

    void Operacion(String s) throws IOException{
        
                char aux [ ];
        aux=s.toCharArray();
        
        Valida(aux);
      
    }
    
    void Valida(char[] c) throws IOException{
        if((c.length==0)){
            System.out.println("Llego por esto");
            EstadoA();
        }
        else{
            
        System.out.println("LLEGO");
        int aux;
        aux=c.length-1;
        
        if((c[0]=='+')||(c[0]=='-')||(c[0]=='*')||(c[0]=='/')||(c[0]=='=')){
                            fail=true;
                        EstadoN();
                        }
        
        if((c[aux]=='+')||(c[aux]=='-')||(c[aux]=='*')||(c[aux]=='/')||(c[aux]=='=')){
            fail=true;
                    EstadoN();  
                    int i=7;
                    
                    }
        
        
                   if (fail==false) {
                            if(c[0]=='@'){
                                  c=Arrays.copyOfRange(c, 1, c.length);
                                Var(c);
                            }
                            if(Character.isDigit(c[0])){
                                System.out.println("FOUND NUMBER");
                                Num(c);
                            }
                            if(c[0]==';'){
                             c=Arrays.copyOfRange(c, 1, c.length);
                                Valida(c);
                            }
                        }
        }
        
    }
    
    
            void Var(char[] c) throws IOException{
                System.out.println("ES VAR ");
                var=new Variable();
                boolean cierto=false;
                String aux="";
                System.out.println("LENGTH "+c.length);
                
                
                for (int i = 0; i <= c.length-1; i++) {
                    
                    System.out.println("Encontre. "+c[i]+" En: i= "+i);
                    if((c[i]!='+')&&(c[i]!='-')&&(c[i]!='*')&&(c[i]!='/')&&(c[i]!='=')&&(c[i]!=';')){
                        paso=false;
                         if (c.length==(i+1)) {
                             System.out.println("ultimo");
                                    EstadoA();
                        }
                    aux=aux+c[i];
                    
                        System.out.println("Agregue: "+c[i]);
                 
                      }     
                    
                   
                    else{   
                         if (c[i]==';') {
                             pc=false;
                            
                        }
                        if((c[i]=='+')||(c[i]=='-')||(c[i]=='*')||(c[i]=='/')){
                                pc=false;
                            }
                        
                        if(c[i]=='='){
                        if (igual) {
                            EstadoN();
                            break;
                        }
                        igual=true;
                        
                        }
                        
                        if(paso==false){
                    paso=true;
                       
                            System.out.println("Variable: "+aux);
                    var.Dividir(aux);

                        
                                if (cierto) {
                                
                                      c=Arrays.copyOfRange(c, i+1, c.length);
                                      Valida(c);
                                      
                                    } 
                              
                                    else{EstadoN();}
                                
                                
                               
//                                 if((c[i+1]=='+')||(c[i+1]=='-')||(c[i+1]=='*')||(c[i+1]=='/')||(c[i+1]=='=')){
//                                     EstadoN();
//                                          }
//                                  if ((i+1)>c.length) {
//                                     EstadoN();
//                                  }
                    }
                     else{
                            EstadoN();
                            }
                    }
                   
                 
                    }
                }
            
            
                void Num(char[] c) throws IOException{
                    con=new Constante();
                boolean cierto=false;
                String aux="";
                
                
                for (int i = 0; i < c.length; i++) {
                 
                    if((c[i]!='+')&&(c[i]!='-')&&(c[i]!='*')&&(c[i]!='/')&&(c[i]!='=')&&(c[i]!=';')){
                        
                        paso=false;
                         if (c.length==(i)) {
                             System.out.println("ultimo");
                                    EstadoA();
                        }
                       
                    aux=aux+c[i];
                    
                       }
                    else{
                       if (c[i]==';') {
                           if(pc==true){
                           EstadoN();
                           break;
                           }
                           else{
                           pc=true;}
                        }
                        
                            if(c[i]=='='){
                        EstadoN();
                        break;
                        }  
                            if((c[i]=='+')||(c[i]=='-')||(c[i]=='*')||(c[i]=='/')){
                                pc=false;
                            }
                        
                        if(paso==false){
                        paso=true;
                            
                    con.Dividir(aux);
                    cierto=con.isBandera();
                                if (cierto) {
                                  
                                      c=Arrays.copyOfRange(c, i+1, c.length);
                                      Valida(c);
                                      
                                       } 
                               
                                    else{EstadoN();
                                }
                              
                              
//                                 if((c[i+1]=='+')||(c[i+1]=='-')||(c[i+1]=='*')||(c[i+1]=='/')||(c[i+1]=='=')){
//                                     EstadoN();
//                                          }
//                                 if ((i+1)==c.length) {
//                                     EstadoN();
//                                  }
                    }
                    else{
                        EstadoN();
                            }
                    }
                    
                    }
            }
            
            void Evalua(){
            
            }
    
    
    
                void EstadoA(){
               bandera=true;
          //      System.out.println("Valida");
    }
            
      void EstadoN(){
           bandera=false;
 //          System.out.println("NO VAL");
    }

    public boolean isBandera() {
        return bandera;
    }
      
    
    public static void main(String[] args) throws IOException {
        new Symbol();
    }
      
      
}
