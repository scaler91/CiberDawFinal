package hackBeers.vista;

import hackBeers.modelo.Usuario;
import hackBeers.modelo.controlCibercafe;
import hackBeers.jOptionPane.crearUsuario;
import hackBeers.jOptionPane.eliminarUsuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import hackBeers.dao.exception.ErrorConexionBD;

public class ModificarV extends javax.swing.JDialog {

    public String DNI;
    controlCibercafe ccc;
    Usuario u;

    int seleccion;

    String cabecera[] = {"DNI", "idOrdenador", "FechaConexion"};
    String vacia[][] = {};

    DefaultTableModel tablaConexiones;

    /**
     * Creates new form ModificarV
     */
    public ModificarV(java.awt.Frame parent, boolean modal) throws ErrorConexionBD {
        super(parent, modal);
        DNI = "Vacio";
        ccc = new controlCibercafe();
        this.setUndecorated(true);
        initComponents();
        this.setAlwaysOnTop(true);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        this.getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTextApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JCheckboxVIP1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        usuarioActual = new javax.swing.JLabel();
        jButtonCerrar = new javax.swing.JButton();
        jTextBuscarUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonBusqueda = new javax.swing.JButton();
        JTextNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JTextApellidos.setBackground(new java.awt.Color(0, 0, 0));
        JTextApellidos.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        JTextApellidos.setForeground(new java.awt.Color(255, 255, 255));
        JTextApellidos.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos");

        JCheckboxVIP1.setBackground(new java.awt.Color(0, 0, 0));
        JCheckboxVIP1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        JCheckboxVIP1.setForeground(new java.awt.Color(255, 255, 255));
        JCheckboxVIP1.setText("Si / No");
        JCheckboxVIP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JCheckboxVIP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCheckboxVIP1ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("VIP:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario Actual:");

        usuarioActual.setBackground(new java.awt.Color(0, 0, 0));
        usuarioActual.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        usuarioActual.setForeground(new java.awt.Color(255, 255, 255));
        usuarioActual.setText(DNI);

        jButtonCerrar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCerrar.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButtonCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hackBeers/iconos/cruz.png"))); // NOI18N
        jButtonCerrar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        jButtonCerrar.setBorderPainted(false);
        jButtonCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jTextBuscarUsuario.setBackground(new java.awt.Color(0, 0, 0));
        jTextBuscarUsuario.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jTextBuscarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jTextBuscarUsuario.setText("Introduce el DNI");
        jTextBuscarUsuario.setToolTipText("Introduce el DNI");
        jTextBuscarUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        jTextBuscarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextBuscarUsuarioMouseClicked(evt);
            }
        });
        jTextBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscarUsuarioActionPerformed(evt);
            }
        });
        jTextBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextBuscarUsuarioKeyTyped(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");

        jButtonBusqueda.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBusqueda.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButtonBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hackBeers/iconos/lupa.png"))); // NOI18N
        jButtonBusqueda.setToolTipText("Buscar");
        jButtonBusqueda.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        jButtonBusqueda.setBorderPainted(false);
        jButtonBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBusqueda.setFocusable(false);
        jButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusquedaActionPerformed(evt);
            }
        });

        JTextNombre.setBackground(new java.awt.Color(0, 0, 0));
        JTextNombre.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        JTextNombre.setForeground(new java.awt.Color(255, 255, 255));
        JTextNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Registro del Usuario");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Crear");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Eliminar");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel5)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(JCheckboxVIP1)
                                    .addComponent(JTextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(JTextApellidos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioActual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextBuscarUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(usuarioActual)
                        .addComponent(jTextBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCheckboxVIP1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCheckboxVIP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCheckboxVIP1ActionPerformed
        // TODO add your handling code here:
        try {
            int vip = 0;
            if (!u.getNombre().equals("null")) {

                if (JCheckboxVIP1.isSelected()) {
                    vip = 1;
                } else {
                    vip = 0;
                }

                ccc.actualizarVip(u, vip);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModificarV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_JCheckboxVIP1ActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jTextBuscarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextBuscarUsuarioMouseClicked
        // TODO add your handling code here:
        jTextBuscarUsuario.setText("");
        jTextBuscarUsuario.setForeground(Color.white);
    }//GEN-LAST:event_jTextBuscarUsuarioMouseClicked

    private void jTextBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBuscarUsuarioActionPerformed

    private void jTextBuscarUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBuscarUsuarioKeyTyped
        // TODO add your handling code here:
        int limite = 9;
        if (jTextBuscarUsuario.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextBuscarUsuarioKeyTyped

    private void jButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusquedaActionPerformed
        // TODO add your handling code here:

        try {
            JTextNombre.setText("");
            JTextApellidos.setText("");
            JCheckboxVIP1.setSelected(false);
            
            DNI = jTextBuscarUsuario.getText();
            usuarioActual.setText(DNI);

            tablaConexiones = new DefaultTableModel(vacia, cabecera);
            jTable1.setModel(tablaConexiones);

            u = ccc.verConexionesUsuario(DNI);

            if (u.getApellidos().equals("null")) {
                jButton1.setEnabled(true);
                jButton2.setEnabled(false);
            } else {

                JTextNombre.setText(u.getNombre());
                JTextApellidos.setText(u.getApellidos());
                if (u.getVIP() == 1) {
                    JCheckboxVIP1.setSelected(true);
                }
                jButton1.setEnabled(false);
                jButton2.setEnabled(true);
                tablaConexiones = new DefaultTableModel(u.crearArrayConexiones(), cabecera);
                jTable1.setModel(tablaConexiones);
            }
        } catch (SQLException | ErrorConexionBD ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonBusquedaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            crearUsuario cu = new crearUsuario(null, true);
            cu.setVisible(true);
            seleccion = cu.getSeleccion();
            if (seleccion == 0) {
                int vip = 0;
                if (JCheckboxVIP1.isSelected()) {
                    vip = 1;
                }
                u = new Usuario(JTextNombre.getText(), JTextApellidos.getText(), jTextBuscarUsuario.getText(), "contraseña", vip);
                ccc.annadirUsuario(u);

                jButton1.setEnabled(false);
                jButton2.setEnabled(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ErrorConexionBD ex) {
            Logger.getLogger(ModificarV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            eliminarUsuario eu = new eliminarUsuario(null, true);
            eu.setVisible(true);
            seleccion = eu.getSeleccion();
            if (seleccion == 0) {
                ccc.eliminarUsuario(u);
                JTextApellidos.setText("");
                JTextNombre.setText("");
                jTextBuscarUsuario.setText("");
                JCheckboxVIP1.setSelected(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModificarV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ModificarV dialog = new ModificarV(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (ErrorConexionBD ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JCheckboxVIP1;
    private javax.swing.JTextField JTextApellidos;
    private javax.swing.JTextField JTextNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextBuscarUsuario;
    private javax.swing.JLabel usuarioActual;
    // End of variables declaration//GEN-END:variables
}