package laii;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class An_lex_cad {
    File tokens;
    RandomAccessFile consecutivo;
    FileWriter fw;
    FileReader fr;
    public An_lex_cad(){
        abrirTablaTokens();
    }
    
    void abrirTablaTokens(){
        tokens=new File("C:\\Users\\Rick\\Documents\\NetBeansProjects\\LAII\\tokens");
        try {
            if (tokens.createNewFile()) {
                System.out.println("Archivo tokens abierto");
            }else{
                System.out.println("No se pudo abrir el archivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(An_lex_cad.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            consecutivo=new RandomAccessFile("numero","rw");
//            try {
//                consecutivo.writeInt(0);
//                consecutivo.close();
//                
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(null, "No se pudo insertar el entero");
//                Logger.getLogger(An_lex_cad.class.getName()).log(Level.SEVERE, null, ex);
//            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo");
            Logger.getLogger(An_lex_cad.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    /**
     * 
     * @param token = guarda el token que se usa
     * @param grupo = identificador(id), palabra reservada (pr), caracteres(cr)
     * @param codigo = Codigo asignado a cada token
     */
    
    void insertarToken(String token, String grupo){
        String cad=token+" "+grupo+" "+"\n";
        int c=0;
        //Carga el ultimo codigo que se cargó a su ves indica cantidad de lineas
            try {
                c=consecutivo.readInt();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo leer el entero");
                Logger.getLogger(An_lex_cad.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            fw=new FileWriter(tokens);
            fr=new FileReader(tokens);
            //Mueve el apuntador hasta el ultimo registro
            while (c!=0) {
                System.out.println("Entro al while con contador valor en: "+c);
                fr.read();
                c--;
            }
            
            fw.write(cad);
            fw.flush();
            consecutivo.seek(0);
            c=consecutivo.readInt();
            c++;
            consecutivo.writeInt(c);
            
        } catch (IOException ex) {
            Logger.getLogger(An_lex_cad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void cerrar(){
        try {
            
            fw.close();
            fr.close();
            consecutivo.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron cerrar los archivos");
            Logger.getLogger(An_lex_cad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
