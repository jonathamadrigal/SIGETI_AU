package vista.administrativo;

import controlador.Controlador;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.Ventana;
import vista.VentanaLogin;

public class PanelConfigurarTicket extends javax.swing.JPanel {

    private PanelConfigurarTicket() {
        initComponents();
        initComponents();
        this.limpiarCampos();
        this.ajustarEventos();
        this.cargarjComboArea();
        this.cargarjComboAsunto();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static PanelConfigurarTicket obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new PanelConfigurarTicket();
        }
        instancia.limpiarCampos();
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    private void ajustarEventos() {
        addMouseListener(Ventana.obtenerInstancia());
        txtAgregarArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });

        txtAgreagrAsunto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        txtAreaModificar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        txtModificarAsunto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
    }

    private void cargarjComboArea() {
        this.jComboBoxModificarArea.removeAllItems();
        this.jComboBoxEliminarArea.removeAllItems();
        this.jComboBoxModificarArea.addItem("Seleccione aquí");
        this.jComboBoxEliminarArea.addItem("Seleccione aquí");
        ArrayList<String> temp = Controlador.obtenerInstancia().obtieneAreas();
        for (String temp1 : temp) {
            this.jComboBoxModificarArea.addItem(temp1);
            this.jComboBoxEliminarArea.addItem(temp1);
        }
        this.jComboBoxModificarArea.setSelectedIndex(0);
        this.jComboBoxModificarArea.revalidate();
        this.jComboBoxModificarArea.repaint();
        this.jComboBoxEliminarArea.setSelectedIndex(0);
        this.jComboBoxEliminarArea.revalidate();
        this.jComboBoxEliminarArea.repaint();
    }//----------------------------------------------------------------------------- FIN cargarjComboArea()

    private void cargarjComboAsunto() {
        this.jComboBoxModificarAsunto.removeAllItems();
        this.jComboBoxEliminarAsunto.removeAllItems();
        this.jComboBoxModificarAsunto.addItem("Seleccione aquí");
        this.jComboBoxEliminarAsunto.addItem("Seleccione aquí");
        ArrayList<String> temp = Controlador.obtenerInstancia().obtieneAsuntos();
        for (String temp1 : temp) {
            this.jComboBoxModificarAsunto.addItem(temp1);
            this.jComboBoxEliminarAsunto.addItem(temp1);
        }
        this.jComboBoxModificarAsunto.setSelectedIndex(0);
        this.jComboBoxModificarAsunto.revalidate();
        this.jComboBoxModificarAsunto.repaint();
        this.jComboBoxEliminarAsunto.setSelectedIndex(0);
        this.jComboBoxEliminarAsunto.revalidate();
        this.jComboBoxEliminarAsunto.repaint();
    }//----------------------------------------------------------------------------- FIN cargarjComboAsunto()

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelCreador = new javax.swing.JLabel();
        txtAgregarArea = new javax.swing.JTextField();
        labelCreador2 = new javax.swing.JLabel();
        labelCreador3 = new javax.swing.JLabel();
        txtAreaModificar = new javax.swing.JTextField();
        labelCreador4 = new javax.swing.JLabel();
        jComboBoxEliminarArea = new javax.swing.JComboBox();
        jComboBoxModificarArea = new javax.swing.JComboBox();
        labelCreador5 = new javax.swing.JLabel();
        btnAgregarArea = new javax.swing.JButton();
        btnEliminarArea = new javax.swing.JButton();
        btnModificarArea = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        labelCreador6 = new javax.swing.JLabel();
        txtAgreagrAsunto = new javax.swing.JTextField();
        labelCreador7 = new javax.swing.JLabel();
        labelCreador8 = new javax.swing.JLabel();
        txtModificarAsunto = new javax.swing.JTextField();
        labelCreador9 = new javax.swing.JLabel();
        jComboBoxEliminarAsunto = new javax.swing.JComboBox();
        jComboBoxModificarAsunto = new javax.swing.JComboBox();
        labelCreador10 = new javax.swing.JLabel();
        btnAgregarAsunto = new javax.swing.JButton();
        btnEliminarAsunto = new javax.swing.JButton();
        btnModificarAsunto = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(208, 144, 56));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitulo.setText("Configuracion de Ticket");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(222, 68, 33));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLimpiar.setText("Limpiar datos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnLimpiar)
                .addGap(170, 170, 170)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(158, 143, 123));

        jPanel2.setBackground(new java.awt.Color(226, 221, 205));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelCreador.setText("Eliminar:");

        labelCreador2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelCreador2.setText("Configurar Area");

        labelCreador3.setText("Agregar Area :");

        labelCreador4.setText("Modificar");

        jComboBoxEliminarArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxModificarArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelCreador5.setText("por:");

        btnAgregarArea.setText("Agregar");
        btnAgregarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAreaActionPerformed(evt);
            }
        });

        btnEliminarArea.setText("Eliminar");
        btnEliminarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAreaActionPerformed(evt);
            }
        });

        btnModificarArea.setText("Modifica");
        btnModificarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(labelCreador2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelCreador4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBoxModificarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelCreador3)
                                .addComponent(labelCreador))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBoxEliminarArea, 0, 160, Short.MAX_VALUE)
                                .addComponent(txtAgregarArea))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelCreador5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(txtAreaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificarArea)
                    .addComponent(btnAgregarArea)
                    .addComponent(btnEliminarArea))
                .addGap(110, 110, 110))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCreador2)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreador3)
                    .addComponent(txtAgregarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCreador)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxEliminarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarArea)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxModificarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCreador4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarArea)
                    .addComponent(labelCreador5)
                    .addComponent(txtAreaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(226, 221, 205));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelCreador6.setText("Eliminar:");

        labelCreador7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelCreador7.setText("Configurar Asunto");

        labelCreador8.setText("Agregar Asunto :");

        labelCreador9.setText("Modificar");

        jComboBoxEliminarAsunto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxModificarAsunto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelCreador10.setText("por:");

        btnAgregarAsunto.setText("Agregar");
        btnAgregarAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAsuntoActionPerformed(evt);
            }
        });

        btnEliminarAsunto.setText("Eliminar");
        btnEliminarAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAsuntoActionPerformed(evt);
            }
        });

        btnModificarAsunto.setText("Modifica");
        btnModificarAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAsuntoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(labelCreador7)
                .addGap(21, 188, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCreador9)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBoxModificarAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelCreador8)
                                .addComponent(labelCreador6))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBoxEliminarAsunto, 0, 160, Short.MAX_VALUE)
                                .addComponent(txtAgreagrAsunto)))
                        .addComponent(txtModificarAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelCreador10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificarAsunto)
                    .addComponent(btnAgregarAsunto)
                    .addComponent(btnEliminarAsunto))
                .addGap(67, 67, 67))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAgregarAsunto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarAsunto)
                        .addGap(42, 42, 42)
                        .addComponent(btnModificarAsunto))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labelCreador7)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCreador8)
                            .addComponent(txtAgreagrAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCreador6)
                            .addComponent(jComboBoxEliminarAsunto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxModificarAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCreador9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCreador10)
                            .addComponent(txtModificarAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente desea terminar ahora?", null, JOptionPane.YES_NO_OPTION)) {
            Ventana.obtenerInstancia().ventanaPrincipalAdmin();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAreaActionPerformed
        boolean bandera = false;
        for (String areas : Controlador.obtenerInstancia().obtieneAreas()) {
            if (areas.equals(txtAgregarArea.getText())) {
                System.out.println(areas);
                bandera = true;
            }
        }
        if (bandera) {
            JOptionPane.showMessageDialog(this, "No se pudo Agregar el Area, Ya Existe", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String contrasenna;
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                    + "desea Agregar el Area?", null, JOptionPane.YES_NO_OPTION)) {
                contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
                if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                    if (Controlador.obtenerInstancia().agregarArea(txtAgregarArea.getText())) {
                        JOptionPane.showMessageDialog(this, "   Area agregada con éxito", "Area Agregada", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo Agregar el Area", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "   No se pudo Agregar el Area, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarAreaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnModificarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarAreaActionPerformed

    private void btnEliminarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAreaActionPerformed
        if (jComboBoxEliminarArea.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione el Area a Eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String contrasenna;
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                    + "desea Eliminar el Area?", null, JOptionPane.YES_NO_OPTION)) {
                contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
                if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                    if (Controlador.obtenerInstancia().eliminarArea(jComboBoxEliminarArea.getSelectedItem().toString() )) {
                        JOptionPane.showMessageDialog(this, "   Area Eliminada con éxito", "Area Eliminada", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo Eliminar el Area", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "   No se pudo Eliminar el Area, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarAreaActionPerformed

    private void btnAgregarAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAsuntoActionPerformed
        boolean bandera = false;
        for (String asuntos : Controlador.obtenerInstancia().obtieneAsuntos()) {
            if (asuntos.equals(txtAgreagrAsunto.getText())) {
                System.out.println(asuntos);
                bandera = true;
            }
        }
        if (bandera) {
            JOptionPane.showMessageDialog(this, "No se pudo Agregar el Asunto, Ya Existe", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String contrasenna;
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                    + "desea Agregar el Asunto?", null, JOptionPane.YES_NO_OPTION)) {
                contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
                if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                    if (Controlador.obtenerInstancia().agregarAsunto(txtAgreagrAsunto.getText())) {
                        JOptionPane.showMessageDialog(this, "   Asunto agregada con éxito", "Asunto Agregada", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo Agregar el Asunto", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "   No se pudo Agregar el Asunto, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarAsuntoActionPerformed

    private void btnEliminarAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAsuntoActionPerformed
        if (jComboBoxEliminarAsunto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione el Asunto a Eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String contrasenna;
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente "
                    + "desea Eliminar el Asunto?", null, JOptionPane.YES_NO_OPTION)) {
                contrasenna = JOptionPane.showInputDialog("Digite su contraseña:");
                if (Controlador.obtenerInstancia().verificarContrasenna(VentanaLogin.correo, contrasenna)) {
                    if (Controlador.obtenerInstancia().eliminarAsunto(jComboBoxEliminarAsunto.getSelectedItem().toString() )) {
                        JOptionPane.showMessageDialog(this, "   Asunto Eliminado con éxito", "Asunto Eliminado", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo Eliminar el Asunto", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "   No se pudo Eliminar el Asunto, constraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarAsuntoActionPerformed

    private void btnModificarAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAsuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarAsuntoActionPerformed

    private void limpiarCampos() {
        txtAgregarArea.setText("");
        txtAgreagrAsunto.setText("");
        txtAreaModificar.setText("");
        txtModificarAsunto.setText("");
         this.cargarjComboArea();
        this.cargarjComboAsunto();
        this.jComboBoxEliminarArea.setSelectedIndex(0);
        this.jComboBoxEliminarAsunto.setSelectedIndex(0);
        this.jComboBoxModificarArea.setSelectedIndex(0);
        this.jComboBoxModificarAsunto.setSelectedIndex(0);
    }

    //Declaracion de variables
    private static PanelConfigurarTicket instancia = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarArea;
    private javax.swing.JButton btnAgregarAsunto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarArea;
    private javax.swing.JButton btnEliminarAsunto;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificarArea;
    private javax.swing.JButton btnModificarAsunto;
    private javax.swing.JComboBox jComboBoxEliminarArea;
    private javax.swing.JComboBox jComboBoxEliminarAsunto;
    private javax.swing.JComboBox jComboBoxModificarArea;
    private javax.swing.JComboBox jComboBoxModificarAsunto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelCreador;
    private javax.swing.JLabel labelCreador10;
    private javax.swing.JLabel labelCreador2;
    private javax.swing.JLabel labelCreador3;
    private javax.swing.JLabel labelCreador4;
    private javax.swing.JLabel labelCreador5;
    private javax.swing.JLabel labelCreador6;
    private javax.swing.JLabel labelCreador7;
    private javax.swing.JLabel labelCreador8;
    private javax.swing.JLabel labelCreador9;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField txtAgreagrAsunto;
    private javax.swing.JTextField txtAgregarArea;
    private javax.swing.JTextField txtAreaModificar;
    private javax.swing.JTextField txtModificarAsunto;
    // End of variables declaration//GEN-END:variables
}
