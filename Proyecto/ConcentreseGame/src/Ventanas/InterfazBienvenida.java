
package Ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class InterfazBienvenida extends javax.swing.JFrame {

    
    public InterfazBienvenida() {
        initComponents();
        setTitle("Concétrese Game");
        setSize(560,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        ImageIcon fondo = new ImageIcon("src/imagenes/fondo.png");
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(jLabel1fondo.getWidth(),jLabel1fondo.getHeight(), Image.SCALE_DEFAULT));
        jLabel1fondo.setIcon(icono);
        this.repaint();
        
        setIconImage(getIconImage());
    }
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icon.png"));
        return retValue;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jugar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        Derechos = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        subtitulo = new javax.swing.JLabel();
        jLabel1fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jugar.setBackground(new java.awt.Color(0, 102, 0));
        Jugar.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        Jugar.setForeground(new java.awt.Color(255, 255, 255));
        Jugar.setText("Empezar");
        Jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarActionPerformed(evt);
            }
        });
        getContentPane().add(Jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 427, 130, 50));

        salir.setBackground(new java.awt.Color(0, 102, 0));
        salir.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 100, 40));

        Derechos.setFont(new java.awt.Font("Script MT Bold", 1, 14)); // NOI18N
        Derechos.setForeground(new java.awt.Color(255, 255, 255));
        Derechos.setText("© 2021 Concéntrese Game");
        getContentPane().add(Derechos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 180, 20));

        titulo.setFont(new java.awt.Font("Script MT Bold", 2, 90)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Concéntrese");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 440, -1));

        subtitulo.setFont(new java.awt.Font("Script MT Bold", 2, 48)); // NOI18N
        subtitulo.setForeground(new java.awt.Color(255, 255, 255));
        subtitulo.setText("Juego de memoria");
        getContentPane().add(subtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 360, -1));
        getContentPane().add(jLabel1fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void JugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarActionPerformed
        Game juego = new Game();
        juego.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JugarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(InterfazBienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazBienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazBienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazBienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazBienvenida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Derechos;
    private javax.swing.JButton Jugar;
    private javax.swing.JLabel jLabel1fondo;
    private javax.swing.JButton salir;
    private javax.swing.JLabel subtitulo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
