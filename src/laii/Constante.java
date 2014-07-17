/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laii;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.Arrays;

public class Constante {
    
String cadena="99999";
    int cont=0;
    boolean bandera=true;
    
    Constante() throws IOException{
//    Dividir(cadena);
    }
    

    
    void Dividir(String s) throws IOException{
        
        char aux [ ];
        aux=s.toCharArray();
        
        Estado0(aux); 
    }
    
    void Estado0(char c[]) throws IOException{
        CharArrayReader car=new CharArrayReader(c, 1, 1);
        int i=0;
        char a;
//        System.out.println("Estado Cero, recibo: "+c[0]);

        if(c.length==1&&Character.isDigit(c[0])){
                
                System.out.println("Longitud de c es un solo caracter");
                EstadoA();
                  
            }
        else{

        if(Character.isDigit(c[0])){
            c=Arrays.copyOfRange(c, 1, c.length);
           
           while((i = car.read()) != -1) { 
                    a=((char)i); 

                    if(Character.isDigit(a)==true){
//                        System.out.println("Encontre Digito en estado 0");
                    EstadoD(c);
                        
                    }
                      if(Character.isDigit(a)==false){
//                          System.out.println("No en 0");
                    EstadoN();
                    }
                     
                }
           }
                            else{
  
                                EstadoN();

                            }
        }
    }
    
     
      void EstadoD(char c[]) throws IOException{
//          System.out.println("Llegue a D y recibo: "+ c[0]);
//          System.out.println("Estoy en D");

    
        int i=0;
        char a;
        cont+=1;
//          System.out.println("Contador: "+cont);
        if(cont>=6){
        EstadoN();
        
        }
        else{
            if(c.length==1&&Character.isDigit(c[0])){
                
                System.out.println("Longitud de c es menor a 0 en  D");
                EstadoA();
                  
            }

            if(Character.isDigit(c[0])){
          
                 CharArrayReader car=new CharArrayReader(c, 1, 1);
            
             c=Arrays.copyOfRange(c, 1, c.length);
             
           while((i = car.read()) != -1) { 
     
                    a=((char)i); 
//                    System.out.println("En D encontre "+a);
                    
                      if(Character.isDigit(a)){
//                          System.out.println("Digito en D");
                    EstadoD(c);
                          
                    }
                      if(Character.isDigit(a)==false){
//                          System.out.println("Digito nope");
                      EstadoN();
                              }
                }
                }
            else{
            EstadoN();}

            } 
    }

    public boolean isBandera() {
        return bandera;
    }
      
      
     
      
            void EstadoA(){
               bandera=true;
                System.out.println("SI ES CONST");
    }
            
      void EstadoN(){
           bandera=false;
           System.out.println("NO es CONST");
    }
      
      
    
    public static void main(String[] args) throws IOException {
        new Constante();
    }
    
}

