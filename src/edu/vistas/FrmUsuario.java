
package edu.vistas;

import edu.dao.DaoRol;
import edu.dao.DaoUsuario;
import edu.modelo.Combo;
import edu.modelo.Rol;
import edu.modelo.Usuario;
import edu.utilidades.Validaciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lopez
 */
public class FrmUsuario extends javax.swing.JInternalFrame {
     DaoUsuario daou=new DaoUsuario();
     edu.modelo.Usuario us=new edu.modelo.Usuario();
     Validaciones validar=new Validaciones();
     DaoRol daoR=new DaoRol();
     Rol rol=new Rol();
      List<Rol> lista;
   Combo cmb = new Combo();
    
    public FrmUsuario() throws Exception {
        initComponents();
        mostrarUsuario();
        cargarCombo();
       
    }
   public void cargarCombo()
    {
        lista = daoR.getRol();
        for(int i=0;i<lista.size();i++)
        {
            cmb = new Combo(lista.get(i).getIdRol(),lista.get(i).getNombre());
            this.jcmRol.addItem(cmb.toString());    
        }    
    }
    
    
 
  public void mostrarUsuario()
 {
     String[]columna={"codigo","nombre","Fecha Ingreso","Estado","Tipo de Usuario"};
     Object[]obj= new Object[5];
     DefaultTableModel tabla = new DefaultTableModel(null,columna);
     try 
       {
         List lista=daou.mostrar();
         for (int i = 0; i < lista.size(); i++) {
             us=(Usuario)lista.get(i);
             obj[0]=us.getIdUsuario();
             obj[1]=us.getUsuario();
             obj[2]=us.getFechaRegistro();
             obj[3]=us.getEstado();
             obj[4]=daoR.getidRol(us.getIdRol()).getNombre();      
             tabla.addRow(obj);                        
         }
         this.jTableuser.setModel(tabla);
     }
     catch (Exception e)
     {
         JOptionPane.showMessageDialog(null,"Error al mostrar"+e.toString());
     }
     
 }
    
   public void llenarTabla()
   {
     int fila=this.jTableuser.getSelectedRow();
     this.jtxtUsuario3.setText(String.valueOf(this.jTableuser.getValueAt(fila,1)));
    this.jtxtContra.setText(String.valueOf(jTableuser.getValueAt(fila, 3)));
     String rol=String.valueOf(this.jTableuser.getValueAt(fila, 4));
     this.jtxtId.setText(String.valueOf(this.jTableuser.getValueAt(fila,0)));
     jcmRol.getModel().setSelectedItem(rol);   
 
   }
   
   public void limpiar()
   {
    
     this.jtxtId.setText("");
     this.jtxtUsuario3.setText("");
     this.jcmRol.setSelectedItem(""); 
     this.jtxtContra.setText("");
     this.jtxtcontra2.setText("");
   }
   
   public void insertar()
   {
    try {
             
    java.util.Date date = new java.util.Date();
    java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
    String fecha = sdf.format(date);
    
    int id=0;
    
     for(int i=0;i<lista.size();i++)
     {
      if(jcmRol.getSelectedItem().equals(lista.get(i).getNombre()))
         {
          id = lista.get(i).getIdRol();
         }
     }
     String pass=new String(jtxtContra.getPassword());
     String repitepass = new String(jtxtcontra2.getPassword());
    
     if(pass.equals(repitepass))
     { 
         if(daou.Verificasiexiste(jtxtUsuario3.getText())==0)
         {
            us.setUsuario(jtxtUsuario3.getText());  
            us.setFechaRegistro(fecha);
            us.setContrasenia(pass);
            us.setEstado(1);
            us.setFechaModificacion(null);
            us.setIdRol(id);
            daou.insertar(us); 
            mostrarUsuario();
            limpiar();
            JOptionPane.showMessageDialog(null,"Datos insertados");
         }else
         {
         
          JOptionPane.showMessageDialog(null,"El usuario Ya existe");
         }
     }
     else
     {
       JOptionPane.showMessageDialog(null,"las contraseñas no coinciden");
     }
       } 
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null,"Error al insertar" +e.toString());
       }
   }
   
   public void modificar()
   {
           java.util.Date date = new java.util.Date();
           java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
           String fecha = sdf.format(date); 
           
  
     us.setUsuario(jtxtUsuario3.getText());
     us.setIdUsuario(Integer.parseInt(jtxtId.getText()));
     
     int pregunta= JOptionPane.showConfirmDialog(null,"Desea modificar el registro","modificar",JOptionPane.YES_NO_OPTION);
     if(pregunta==0)
     {
       daou.Modificar(us);
       mostrarUsuario();
       limpiar();
     }
   
   }
   
    public void eliminar()
   {
   us.setIdUsuario(Integer.parseInt(jtxtId.getText()));
     int pregunta= JOptionPane.showConfirmDialog(null,"Desea eliminar el registro","eliminar",JOptionPane.YES_NO_OPTION);
     if(pregunta==0)
     {
       daou.Eliminar(us);
       mostrarUsuario();
       limpiar();
     }
   
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jtxtUsuario3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jbtnModificar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnAgregar = new javax.swing.JButton();
        jbtnAgregar1 = new javax.swing.JButton();
        jcmRol = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableuser = new javax.swing.JTable();
        jtxtId = new javax.swing.JTextField();
        jtxtContra = new javax.swing.JPasswordField();
        jtxtcontra2 = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/iconos/usuario.png"))); // NOI18N
        jLabel1.setText("Registro de Usuario");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0)));

        jLabel11.setText("USUARIO");

        jtxtUsuario3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtUsuario3KeyTyped(evt);
            }
        });

        jLabel13.setText("TIPO DE USUARIO");

        jLabel14.setText("CONTRASEÑA");

        jLabel15.setText("REPITA CONTRASEÑA");

        jLabel12.setText("CODIGO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        jbtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/iconos/mod.png"))); // NOI18N
        jbtnModificar.setText("   MODIFICAR");
        jbtnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnModificarMouseClicked(evt);
            }
        });
        jbtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarActionPerformed(evt);
            }
        });

        jbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/iconos/delete.png"))); // NOI18N
        jbtnEliminar.setText("  ELIMINAR");
        jbtnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnEliminarMouseClicked(evt);
            }
        });
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/iconos/clear.png"))); // NOI18N
        jbtnAgregar.setText("LIMPIAR");
        jbtnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnAgregarMouseClicked(evt);
            }
        });
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jbtnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/iconos/agregar.png"))); // NOI18N
        jbtnAgregar1.setText("  AGREGAR");
        jbtnAgregar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnAgregar1MouseClicked(evt);
            }
        });
        jbtnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbtnAgregar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jbtnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTableuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableuserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableuser);

        jtxtId.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12))
                .addGap(66, 66, 66)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtUsuario3, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jcmRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtContra)
                    .addComponent(jtxtcontra2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jtxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jtxtUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jcmRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jtxtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jtxtcontra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtUsuario3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtUsuario3KeyTyped
        validar.wordsOnly(evt);
    }//GEN-LAST:event_jtxtUsuario3KeyTyped

    private void jbtnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnModificarMouseClicked
       modificar();
    }//GEN-LAST:event_jbtnModificarMouseClicked

    private void jbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarActionPerformed

    }//GEN-LAST:event_jbtnModificarActionPerformed

    private void jbtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEliminarMouseClicked
       eliminar();
    }//GEN-LAST:event_jbtnEliminarMouseClicked

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed

    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnAgregarMouseClicked
   limpiar();
    }//GEN-LAST:event_jbtnAgregarMouseClicked

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed

    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jTableuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableuserMouseClicked
    llenarTabla();
    }//GEN-LAST:event_jTableuserMouseClicked

    private void jbtnAgregar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnAgregar1MouseClicked
       insertar();
    }//GEN-LAST:event_jbtnAgregar1MouseClicked

    private void jbtnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAgregar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableuser;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnAgregar1;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JComboBox<String> jcmRol;
    private javax.swing.JPasswordField jtxtContra;
    private javax.swing.JTextField jtxtId;
    private javax.swing.JTextField jtxtUsuario3;
    private javax.swing.JPasswordField jtxtcontra2;
    // End of variables declaration//GEN-END:variables
}
