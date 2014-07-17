
package laii;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author SONY
 */
public class Variable {
    
    String cadena;
    int cont=0;
    boolean bandera=true;
    
    Variable() throws IOException{
  //Verifica(cadena);
    }
    
    void Verifica(String s) throws IOException{
        
        if(cadena.length()<1){
            System.out.println("Nombre para variable vacio");
        }
        if(cadena.length()==1){
            System.out.println("Longitud de nombre de variable invalida");
        }
        else{
        Dividir(s);
        }
    
    }
    
    void Dividir(String s) throws IOException{
        
        char aux [ ];
        aux=s.toCharArray();
        
        Estado0(aux); 
    }
    
    void Estado0(char c[]) throws IOException{
        System.out.println("LLEGA A CERO: "+c[0]);
        CharArrayReader car=new CharArrayReader(c, 1, 1);
        int i=0;
        char a;
//        System.out.println("Primer caracter   "+c[0]);
        if(Character.isLetter(c[0])){
            c=Arrays.copyOfRange(c, 1, c.length);
           
           while((i = car.read()) != -1) { 
//               System.out.println("O");
                    a=((char)i); 
                     System.out.println("AQUI   "+a);
                    if(Character.isLetter(a)){
//                        System.out.println("Encontre Letra en estado 0");
                    EstadoL(c);
                        
                    }
                    if(Character.isDigit(a)){
                          System.out.println("ESTADO CERO MANDO A D: "+a);
                    EstadoD(c);
                          
                    }
                     if(Character.isLetterOrDigit(a)==false){
                          System.out.println("FUE RARO EN CERO");
                      EstadoN();
                              }
                     
                }
           } 
    }
    
     void EstadoL(char c[]) throws IOException{
        
        int i=0;
        char a;
//         System.out.println("Estoy en L");
         if(c.length==1){
//                 System.out.println("Longitud de c es 0 en L");
                EstadoA();
           
            }
            else{
              
         CharArrayReader car=new CharArrayReader(c, 1, 1);
               c=Arrays.copyOfRange(c, 1, c.length);
           while((i = car.read()) != -1) { 
            
                    a=((char)i); 
//                    System.out.println("En L encontre "+a);
//                    System.out.println(""+a);
                    if(Character.isLetter(a)){
                        System.out.println("Letra VARIABLE");
                       
                    EstadoL(c);
                        
                    }
                      if(Character.isDigit(a)){
                          System.out.println("DIGITO VARIABLE");
                          cont=0;
                    EstadoD(c);
                          
                    }
                     if(Character.isLetterOrDigit(a)==false){
                          System.out.println("NONE");
                      EstadoN();
                              }
                }
            }
           } 
    
    
     
      void EstadoD(char c[]) throws IOException{
          System.out.println("Estoy en D: recibo "+c[0]);
//          System.out.println(""+c.length);
    
        int i=0;
        char a;
        cont+=1;
        if(cont>=300000000){
        EstadoN();
            System.out.println("ESTE FUE, CONTADOR");
        }
        else{
            if(c.length==1){
                
//                System.out.println("Longitud de c es menor a 0 en  D");
                EstadoA();
                  
            }
    
            else{
          
                 CharArrayReader car=new CharArrayReader(c, 1, 1);
            
             c=Arrays.copyOfRange(c, 1, c.length);
             
           while((i = car.read()) != -1) { 
     
                    a=((char)i); 
//                    System.out.println("En D encontre "+a);
                    if(Character.isLetter(a)){
//                        System.out.println("Letra en D");
                         EstadoL(c);
                        
                    }
                      if(Character.isDigit(a)){
//                          System.out.println("Digito en D");
                    EstadoD(c);
                          
                    }
                      if(Character.isLetterOrDigit(a)==false){
//                          System.out.println("Digito nope");
                      EstadoN();
                          System.out.println("ESTE FUE  CARACTER RARO");
                              }
                }
                }

            } 
    }

    
     
      
            void EstadoA(){
               bandera=true;
               System.out.println("BIEN VALIDADA");
               cont=0;
    }
            

      public boolean isBandera() {
        return bandera;
    }
      
            void EstadoN(){
           bandera=false;
          System.out.println("NO VAL");
    }
      
      
    
    public static void main(String[] args) throws IOException {
        new Variable();
    }
    
}
