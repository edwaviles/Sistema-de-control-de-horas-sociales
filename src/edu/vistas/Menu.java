
package edu.vistas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: Menu
 * Version: 1.9
 * Fecha:11/08/18
 * CopyRight:SSE-ITCA
 * @author Roxana Menjivar
 */
public class Menu extends javax.swing.JFrame {

    FrmCoordinador gestionC;
    FrmHorario gestionH;
    
    public static boolean FormularioVal=false;
    
    public Menu() {
        initComponents(); 
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        editMenu1 = new javax.swing.JMenu();
        EditUserMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(java.awt.SystemColor.activeCaption);

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/iconos/coordinador.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("Gestion de Coordinador");
        fileMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileMenuMouseClicked(evt);
            }
        });
        menuBar.add(fileMenu);

        editMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/iconos/calendar.png"))); // NOI18N
        editMenu.setMnemonic('e');
        editMenu.setText("Gestion de Horarios");
        editMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMenuMouseClicked(evt);
            }
        });
        menuBar.add(editMenu);

        editMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/iconos/reporte.png"))); // NOI18N
        editMenu1.setMnemonic('e');
        editMenu1.setText("Reportes");
        editMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMenu1MouseClicked(evt);
            }
        });
        menuBar.add(editMenu1);

        EditUserMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/iconos/users.png"))); // NOI18N
        EditUserMenu1.setText("Gestion De Usuarios");
        EditUserMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditUserMenu1MouseClicked(evt);
            }
        });
        EditUserMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditUserMenu1ActionPerformed(evt);
            }
        });
        menuBar.add(EditUserMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileMenuMouseClicked
        
        if(FormularioVal==false)
        {
            this.gestionC = new FrmCoordinador();
            this.desktopPane.add(gestionC);
            gestionC.setVisible(true);
            gestionC.setLocation(
                    desktopPane.getWidth()/2 - gestionC.getWidth()/2,
                    desktopPane.getHeight()/2 - gestionC.getHeight()/2);
                    FormularioVal=true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Ya tiene una ventana abierta!");
        }
    }//GEN-LAST:event_fileMenuMouseClicked
    public void cerrar()
    {
         FormularioVal=false;
    }
    private void editMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMenuMouseClicked
        this.gestionH = new FrmHorario();
        this.desktopPane.add(gestionH);
        gestionH.setVisible(true);
        gestionH.setLocation(
                desktopPane.getWidth()/2 - gestionH.getWidth()/2,
                desktopPane.getHeight()/2 - gestionH.getHeight()/2);
    }//GEN-LAST:event_editMenuMouseClicked

    public void validarFormularios()
    {
        //si existe una venta, la cierra.
       if (gestionC != null || gestionH !=null) 
        {
            gestionC.dispose();
            gestionH.dispose();
        }
    }
    
    private void editMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editMenu1MouseClicked

    private void EditUserMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditUserMenu1ActionPerformed

        
    }//GEN-LAST:event_EditUserMenu1ActionPerformed

    private void EditUserMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditUserMenu1MouseClicked
        try {
            //no
            FrmUsuario us=new FrmUsuario();
            desktopPane.add(us);
            us.setVisible(true);
            us.setLocation(
                    desktopPane.getWidth()/2 - us.getWidth()/2,
                    desktopPane.getHeight()/2 -us.getHeight()/2);
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_EditUserMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu EditUserMenu1;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu editMenu1;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
