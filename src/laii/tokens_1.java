/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Itc
 * 
 * La tabla de tokens se llena de forma manual. Solo para el desarrollador
 */
public class tokens_1 {
    String PalabraReservada, group;
    int cod;
    
    tokens_1(){
    }

    public boolean isBan() {
        return ban;
    }
    
    boolean ban =false; //bandera que indica si se encontró o no el token
    void buscar(String token){
        try {
        String cad; //guarda la cadena que esta en la tabla
        String tok; //guarda el primer token de la cadena leida
        String grupo="",gp;
        
        File tabla=new File("tokens.txt"); //Abre el archivo donde esta la tabla
        FileReader fr =new FileReader(tabla); //abro canal de lectura
        BufferedReader br=new BufferedReader(fr); //genero un buffer para trabajar sobre lo leido
            while (br.readLine()!=null) { //mientras la linea leida sea diferente a null
                cad=br.readLine(); //guardo el contenido de la linea en la variable cad
                //System.out.println("Aqui vamos bien --> " + cad);
                StringTokenizer tk= new StringTokenizer(cad); //instancio un objeto StringTokinizer para trabajar con los tokens sobre la cadena antes guardada
                tok=tk.nextToken(); //leo el siguiente token de la cadena leida de la tabla
                setPalabraReservada(tok);
                if (tok.equalsIgnoreCase(token)) { //si el token leido en la tabla, es igual al buscado, se rompe el ciclo y marco la bandera como true
                    ban = true;
                    grupo=tk.nextToken();
                    setGroup(grupo);
//                    setCod(Integer.parseInt(tk.nextToken()));
                    break;
                }
            }
             if (ban) {
                 gp=grupo.equalsIgnoreCase("pr")?"Palabra Reservada":"otro"; //Si el token de grupo es igual a "pr" entonces asigno "Palabra Reservada" a la variable gp de lo contrario le asigno "otro"
                 //gp=grupo.equalsIgnoreCase("ce")?"Caracter Especial":"otro";//Si el token de grupo es igual a "ce" entonces asigno "Caracter especial" a la variable gp de lo contrario le asigno "otro"
                 imprimir();
                 //JOptionPane.showMessageDialog(null, "El token es parte de la tabla y es: "+ gp); //imprimo resultado si se encuentra
             }else{
                 System.out.println("No se encuentra en la tabla ese token"); //imprime resultado de que no se encuentra
                 ban=false;
             }
             br.close();
             fr.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de lectura en el archivo");
            Logger.getLogger(tokens_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPalabraReservada() {
        validar();
        return PalabraReservada;
    }
    private void setPalabraReservada(String PalabraReservada) {
        this.PalabraReservada = PalabraReservada;
    }
    public String getGroup() {
        validar();
        return group;
    }
    private void setGroup(String group) {
        this.group = group;
    }
    public int getCod() {
        validar();
        return cod;
    }
    private void setCod(int cod) {
        this.cod = cod;
    }
    
    void imprimir(){
        System.out.println("El resultado es: ->"+getPalabraReservada()+" "+getGroup()+ " "+getCod()+ "<- y es un token válido");
    }
    void validar(){
        if (cod==0||PalabraReservada==null||group==null) {
            System.out.println("Favor de realizar antes la busqueda del token");
        }
        
    }
    
    public static void main(String[] args) {
        tokens_1 t=new tokens_1();
        t.buscar("");
        //t.imprimir();
    }
}
