/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laii;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rick
 */
public class errores extends Exception{
    private File errores=new File("errores.txt");
    private FileWriter fr;
    
    /**
     * Esta clase permite cargar el error generado en los multiples analizadores conforme se vayan ejecutando, 
     * guardándolos en un archivo de texto llamado errores.txt
     * 
     * @param tipo Esta variable recibe el tipo de error (Sintáctico, léxico, semántico u otros que se utilicen)
     * @param error Aqui se cargan los detalles del error. Si se espera algo en particular, la linea o algun
     * otro detalle que sea necesario
     * 
     * @throws Manda un error en caso de que no se se pueda generar el canal al archivo, o este no se encuentre.
     */
    errores() {
        try {
            fr=new FileWriter(errores);
        } catch (IOException ex) {
            System.out.println("No se pudo abrir el archivo");
            Logger.getLogger(errores.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    void agregar(String tipo,String error){
        try {
            String c="Tipo de error: "+tipo+"\n";
            tipo=c;
            fr.write(tipo+"\t");
            fr.write(error);
        } catch (IOException ex) {
            System.out.println("No se pudo insertar error. Clase:errores");
            Logger.getLogger(errores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Cierra el archivo. Es necesario al terminar de usar los errores
     */
    void cerrar() {
        try {
            fr.close();
        } catch (IOException ex) {
            System.out.println("No se pudo cerrar el archivo. Clase:errores");
            Logger.getLogger(errores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
