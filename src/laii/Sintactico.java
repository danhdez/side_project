
package laii;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sintactico {
    ArrayList lex[];
    Stack pila=new Stack();
    File errores=new File("errores.txt");
    static String tipo="Sintactico";
    errores error=new errores();
    
    Sintactico (ArrayList ar[]){
        lex=ar;
    }
    
    /**
    private void errores(String tipo, String error){
        try {
            FileWriter fr=new FileWriter(errores);
            fr.write(tipo+"\t");
            fr.write(error);
            fr.close();
        } catch (IOException ex) {
            System.out.println("Error en el manejo de archivos");
            Logger.getLogger(Sintactico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    */
    
    /**
     * Este metodo leerá cada uno de los tokens generados con anterioridad y su categoria, y segun la categoria
     * cargara el metodo necesario para revisar la sintáxis del código completo.
     * Si 0 --> Abre etiqueta
     * Si 1 --> Cierra etiqueta
     * Si 2 --> Variable
     * Si 3 --> Constante
     * Si 4 --> Texto plano
     * Si 5 --> Palabra Reservada
     * Si 6 --> Caracter especial
     */
    
    void leer(){
        int x;
        for (int i = 0; i < lex[0].size(); i++) {
            x=Integer.parseInt(lex[1].get(i).toString());
            switch (x) {
                case 0:
                    etiquetaAbre(lex[0].get(i)+"");
                    break;
                case 1:
                    etiquetaCierra(lex[0].get(i)+"");
                    break;
                
                case 4:
                    textoPlano(lex[0].get(i)+"");
                    break;
                default:
                    System.out.println("Kiubole que paso aqui...??");
                    throw new AssertionError();
            }
        }
        error.cerrar();
    }
    
    
    
    private void etiquetaAbre(String label){
        char c[];//Arreglo de caracteres para revisar si es etiqueta que abre o que cierra
        c=label.toCharArray();//Convierte la etiqueta en arreglo de caracteres
        if (c[c.length-1]=='>') {//Revisa que efectivamente sea una etiqueta que abre
                label=label.replace(">", "");
                pila.push(label);
                System.out.println("Se metio "+ pila.peek()+" exitosamente");
            }else{
                System.out.println("Hubo un error lexico, lo recibido no es una etiqueta que abre");
                for (int i = 0; i < c.length; i++) {
                    System.out.println(c[i]+" leido");
                }
            }
    }
    
    private void etiquetaCierra(String label){
        char c[];//Arreglo de caracteres para revisar si es etiqueta que abre o que cierra
        c=label.toCharArray();//Convierte la etiqueta en arreglo de caracteres
        if (pila.peek().toString().equalsIgnoreCase(label.replace("<", ""))) {
                System.out.println("Se sacó "+pila.peek()+" exitosamente");
                pila.pop();//Si es así entonces es una etiqueta que cierra y por lo tanto hay que sacarla de la pila
/*ERROR*/       }else{
                String aux="No puedes cerrar esta etiqueta aquí\n"
                        + "\tRecibí "+pila.peek()+""
                        + "\tEspero "+label.replace("<", "")+"\n\n";
                error.agregar(tipo,aux);
                System.out.println(aux);
            }
    }
    
    
    /**
     * Este metodo revisará que las etiquetas se abran y cierren correctamente en todo el documento.
     * @param label 
     */
    
    private void etiqueta(String label){//Cargo la supuesta etiqueta ya validada como una
        char c[];//Arreglo de caracteres para revisar si es etiqueta que abre o que cierra
        c=label.toCharArray();//Convierte la etiqueta en arreglo de caracteres
        if (c[0]=='<') {//Revisa si el primer caracter es "<"
            if (pila.peek().toString().equalsIgnoreCase(label.replace("<", ""))) {
                System.out.println("Se sacó "+pila.peek()+" exitosamente");
                pila.pop();//Si es asi entonces es una etiqueta que cierra y por lo tanto hay que sacarla de la pila
/*ERROR */      }else{
                String aux="No puedes cerrar esta etiqueta aqui\n"
                        + "\tRecibí "+pila.peek()+""
                        + "\tEspero "+label.replace("<", "")+"\n\n";
      
                System.out.println(aux);
            }
        }else{//Como no es una etiqueta que cierra, reviso que el ultimo caracter sea una etiqueta que abre
            if (c[c.length-1]=='>') {
                label=label.replace(">", "");
                pila.push(label);
                System.out.println("Se metio "+ pila.peek()+" exitosamente");
            }else{
                System.out.println("Hubo un error lexico, lo recibido no es una etiqueta");
                for (int i = 0; i < c.length; i++) {
                    System.out.println(c[i]+" leido");
                }
            }
        }
        
    }

    
    private void textoPlano(String text){
        char c[];
        c=text.toCharArray();
        String error="Te faltó cerrar una comilla simple para considerar el texto plano";
        if (c[0]=='\''&&c[c.length-1]=='\'') {
            System.out.println("Texto plano recibido correctamente");
        }else{
            this.error.agregar("Sintactico",error);
            System.out.println("Sintactico "+error);
        }
        
    }
    
    private void numero(String num){
        
    }
    
    public static void main(String[] args) {
        ArrayList m[]=new ArrayList[2];
        m[0]=new ArrayList();
        m[0].add("html>");
        m[0].add("php>");
        m[0].add("<html");
        m[0].add("<php");
        m[0].add("\'kjsdfsd\'");
        
        m[1]=new ArrayList();
        m[1].add(0);
        m[1].add(0);
        m[1].add(1);
        m[1].add(1);
        m[1].add(4);
        
        Sintactico n=new Sintactico(m);
        n.leer();
    }
    
}
