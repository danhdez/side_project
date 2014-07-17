package laii;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Interfaz extends javax.swing.JFrame {
 
String resultado="",error="";

public Interfaz() {
        initComponents();
    }
    
 void Cadena(String cadena) throws IOException{
        
      Lex lexico=new Lex();
      lexico.Replace(cadena);
      String r=lexico.getResult();
      String e=lexico.getErr();
      quehace.setText(r);
      errores.setText(e);
      
//      Sintactico sin=new Sintactico(lexico.getTodo());
//      sin.leer();
}
    

//
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        codigo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        quehace = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        errores = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuarchivo = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        menucompilar = new javax.swing.JMenu();
        lexico = new javax.swing.JMenuItem();
        sintactico = new javax.swing.JMenuItem();
        semantico = new javax.swing.JMenuItem();
        compilar = new javax.swing.JMenuItem();
        menuayuda = new javax.swing.JMenu();
        doc = new javax.swing.JMenuItem();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        codigo.setColumns(20);
        codigo.setRows(5);
        jScrollPane1.setViewportView(codigo);

        quehace.setEditable(false);
        quehace.setColumns(20);
        quehace.setRows(5);
        jScrollPane2.setViewportView(quehace);

        errores.setEditable(false);
        errores.setColumns(20);
        errores.setRows(5);
        jScrollPane3.setViewportView(errores);

        jLabel1.setFont(new java.awt.Font("ITC Avant Garde Std XLt", 0, 14)); // NOI18N
        jLabel1.setText("Output");

        jLabel2.setFont(new java.awt.Font("ITC Avant Garde Std XLt", 0, 14)); // NOI18N
        jLabel2.setText("Errores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(308, 308, 308))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        menuarchivo.setText("Archivo");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Guardar");
        menuarchivo.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Guardar y Limpiar");
        menuarchivo.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Abrir");
        menuarchivo.add(jMenuItem6);

        jMenuBar1.add(menuarchivo);

        menucompilar.setText("Compilador");

        lexico.setText("Analizador Léxico");
        lexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lexicoActionPerformed(evt);
            }
        });
        menucompilar.add(lexico);

        sintactico.setText("Analizador Sintáctico");
        menucompilar.add(sintactico);

        semantico.setText("Analizador Semántico");
        menucompilar.add(semantico);

        compilar.setText("Compilar");
        menucompilar.add(compilar);

        jMenuBar1.add(menucompilar);

        menuayuda.setText("Ayuda");

        doc.setText("Dcumentación");
        menuayuda.add(doc);

        about.setText("Acerca de...");
        menuayuda.add(about);

        jMenuBar1.add(menuayuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void lexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lexicoActionPerformed
//        if (evt.getActionCommand().compareTo("Analizador Léxico")==0) {
//            System.out.println("Sí funciona");
//        } 
        quehace.setText("");
        errores.setText("");
          String cod=codigo.getText();
    try {
        Cadena(cod);}
    catch(IOException a){
    }
    
    //          ArrayList n=new ArrayList();
//         boolean bandera=true;
//          An_lex_cad_1 tokenizador=new An_lex_cad_1();
//          
//    try {
//        //tokenizador.cargar(Cadena(cod));
//    } catch (Exception ex) {
//        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
//    }
//          n=tokenizador.getTokens();
//          
//          for (int i = 0; i < n.size(); i++) {
//              tokens_1 m=new tokens_1();
//              resultado+="\n"+n.get(i);
//             // System.out.println(""+n.get(i));
//              m.buscar(n.get(i)+"");
//              if(m.ban==true){
//                  resultado+="\n Token: \""+n.get(i)+"\" es válido";
//                   quehace.setText(resultado);                   }
//              else{
//                  error+="\n Token: \""+n.get(i)+" \" NO es válido";
//                  errores.setText(error);
//                  bandera=false;
//                      }    
//        
//          }
//          System.out.println("Sali del for");
//          if(!bandera){
//          resultado+="\n SE ENCONTRARON ERRORES EN EL CÓDIGO, REVISE ANTES DE CONTINUAR \n atte: Analizador Léxico <3"
//                  + "\n +++++++++++++++++++++++++++++++++++++++++++++++";
//          quehace.setText(resultado);
//          }
//          else{
//          resultado+="\n PUEDE CONTINUAR, NICE CODING \n atte: Analizador Léxico <3"
//                  + "\n ---------------------------------------------------------------------------";}
//          quehace.setText(resultado);
          
    }//GEN-LAST:event_lexicoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        new Interfaz();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JTextArea codigo;
    private javax.swing.JMenuItem compilar;
    private javax.swing.JMenuItem doc;
    private javax.swing.JTextArea errores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem lexico;
    private javax.swing.JMenu menuarchivo;
    private javax.swing.JMenu menuayuda;
    private javax.swing.JMenu menucompilar;
    private javax.swing.JTextArea quehace;
    private javax.swing.JMenuItem semantico;
    private javax.swing.JMenuItem sintactico;
    // End of variables declaration//GEN-END:variables
}
