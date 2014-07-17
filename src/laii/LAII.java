/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laii;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Rick
 */
public class LAII {
    
    JFrame f=new JFrame("Insertar nuevo token");
    JPanel p1=new JPanel(),//Panel del formulario para insertar tokens
           p2=new JPanel();//Panel para el buton que envia la insercion del token                 
    
    JTextField insToken=new JTextField(10), //Caja de texto para insertar un nuevo token en campo "token"
                insGrupo=new JTextField(10);//Caja para insertar el grupo al que pertenece el token
    JLabel Token=new JLabel("Token"),       //etiqueta para insertar nuevo token
            Grupo=new JLabel("Grupo");     //etiqueta para insertar grupo del token
    JButton Guardar=new JButton("Guardar");//Envia los datos de las cajas de texto
    
    void insertarToken(){
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (insToken.getText().isEmpty()&&insGrupo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Inserte informacion en todos los campos");
                }else{
                    An_lex_cad n=new An_lex_cad();
                    n.abrirTablaTokens();
                    n.insertarToken(insToken.getText(), insGrupo.getText());
                    n.cerrar();
                }
                
            }
        });
        
        p1.add(Token);
        p1.add(insToken);
        p1.add(Grupo);
        p1.add(insGrupo);
        p1.add(Guardar);
        
        f.add(p1);
        
        
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack();
        
    }
    
    public static void main(String[] args) {
        new LAII().insertarToken();

    }
    
}
