package vista.administrativo;

import controlador.Controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Ticket;
import vista.Ventana;
import vista.VentanaLogin;

public class PanelBandejaAdministrador extends javax.swing.JPanel {

    private PanelBandejaAdministrador() {
        initComponents();
        this.ajustarEventos();
        this.limpiarCampos();
        this.ocultarComponentes();
        this.iniciarValidaciones();
        this.llenarBandeja();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static PanelBandejaAdministrador obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new PanelBandejaAdministrador();
        }
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    private String obtenerPrioridad(int _prioridad) {
        switch (_prioridad) {
            case 1:
                return "baja";
            case 2:
                return "media";
            case 3:
                return "alta";
            default:
                return "";
        }
    }//----------------------------------------------------------------------------- FIN obtenerPrioridad()

    private String obtieneEstado(Ticket _ticket) {
        String estado = "";
        if (_ticket.getEstado().equals("borrado")) {
            estado = "cerrado";
        } else {
            estado = _ticket.getEstado();
        }
        return estado;
    }//----------------------------------------------------------------------------- FIN obtieneEstado()

    private void llenarInformacionExtra(Ticket _ticket) {
        this.jTextAreaDetalle.setText(_ticket.getDetalleProblema());
        this.jTextAreaComentarios.setText(_ticket.getComentarios());
        this.jTextAreaEspecificacion.setText(_ticket.getEspecificacion());
        this.txtResponsable.setText(_ticket.getResponsable());
        this.txtArea.setText(_ticket.getAreaDestino());
        this.txtEstado.setText(this.obtieneEstado(_ticket));
        this.txtPrioridad.setText(String.valueOf(this.obtenerPrioridad(_ticket.getPrioridad())));
        this.txtAsunto.setText(_ticket.getAsunto());
        this.txtFecha.setText(_ticket.getFecha());
        this.txtHora.setText(_ticket.getHora());
        this.txtTiempoSol.setText(_ticket.getTiempoSolucion());
        this.txtCreador.setText(_ticket.getCorreoUsuario());
    }//----------------------------------------------------------------------------- FIN llenarInformacionExtra()

    private void iniciarValidaciones() {
        this.soloNumeros(this.jTextAnnoDesde);
        this.soloNumeros(this.jTextMesDesde);
        this.soloNumeros(this.jTextDiaDesde);
    }//----------------------------------------------------------------------------- FIN iniciarValidaciones()

    private void soloNumeros(JTextField txt) {//para validar que en la fecha solo digite numeros
        txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }//----------------------------------------------------------------------------- FIN soloNumeros()

    private void llenarBandeja() {
        this.cantidad.setText(String.valueOf(Controlador.obtenerInstancia().cantidadNuevosAdmin()));
        modelAux = (DefaultTableModel) tablaTickets.getModel();
        while (modelAux.getRowCount() > 0) {
            modelAux.removeRow(0);
        }
        ArrayList<Ticket> aux = Controlador.obtenerInstancia().ticketsBandejaEntradaAdmin();
        if (aux.isEmpty()) {
        } else {
            int i = 0;
            while (i < aux.size()) {
                modelAux.insertRow(modelAux.getRowCount(), new Object[]{aux.get(i).getConsecutivo(),
                    aux.get(i).getAsunto(), aux.get(i).getCorreoUsuario(), aux.get(i).getFecha()});
                i++;
            }
            
            Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                    VentanaLogin.correo, "Ticket", "Consultó tickets nuevos");
            
        }
        tablaTickets.setVisible(true);
        tablaTickets.revalidate();
        tablaTickets.repaint();
//        this.cantidad.setText(String.valueOf(modelAux.getRowCount()));
    }//----------------------------------------------------------------------------- FIN LlenaTicketsDelArea()

    private void ocultarComponentes() {
        this.jPanelDetalle.setVisible(false);
        this.jPanelGestion.setVisible(false);
        this.jPanelRadios.setVisible(false);
        this.jPanelComentario.setVisible(false);
        this.jPanelFecha.setVisible(false);
        this.jPanelPrioridad.setVisible(false);
        this.jPanelResponsable.setVisible(false);
        this.jPanelArea.setVisible(false);
        this.btnAplicarCambios.setVisible(false);
    }//----------------------------------------------------------------------------- FIN ocultarComponentes()

    private void cargarjComboArea() {
        this.jComboBoxArea2.removeAllItems();
        this.jComboBoxArea2.addItem("Seleccione aquí");
        ArrayList<String> temp = Controlador.obtenerInstancia().obtieneAreas();
        for (int i = 0; i < temp.size(); i++) {
            this.jComboBoxArea2.addItem(temp.get(i));
        }
        this.jComboBoxArea2.setSelectedIndex(0);
        this.jComboBoxArea2.revalidate();
        this.jComboBoxArea2.repaint();
    }//----------------------------------------------------------------------------- FIN cargarjComboArea()

    private void ajustarEventos() {
        addMouseListener(Ventana.obtenerInstancia());
        tablaTickets.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        this.jRadioComentario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanelFecha.setVisible(false);
                jPanelPrioridad.setVisible(false);
                jPanelResponsable.setVisible(false);
                jPanelArea.setVisible(false);
                btnAplicarCambios.setVisible(true);
                jPanelComentario.setVisible(true);
            }
        });
        this.jRadioFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanelComentario.setVisible(false);
                jPanelPrioridad.setVisible(false);
                jPanelResponsable.setVisible(false);
                jPanelArea.setVisible(false);
                btnAplicarCambios.setVisible(true);
                jPanelFecha.setVisible(true);
            }
        });
        this.jRadioPrioridad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanelFecha.setVisible(false);
                jPanelComentario.setVisible(false);
                jPanelResponsable.setVisible(false);
                jPanelArea.setVisible(false);
                btnAplicarCambios.setVisible(true);
                jPanelPrioridad.setVisible(true);
            }
        });
        this.jRadioRedireccioinar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarjComboArea();
                jPanelFecha.setVisible(false);
                jPanelComentario.setVisible(false);
                jPanelResponsable.setVisible(false);
                btnAplicarCambios.setVisible(true);
                jPanelArea.setVisible(true);
                jPanelPrioridad.setVisible(false);
            }
        });
        this.jRadioResponsable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanelFecha.setVisible(false);
                jPanelComentario.setVisible(false);
                jPanelResponsable.setVisible(true);
                btnAplicarCambios.setVisible(true);
                jPanelArea.setVisible(false);
                jPanelPrioridad.setVisible(false);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGestionar = new javax.swing.ButtonGroup();
        jPanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTickets = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelvermas = new javax.swing.JLabel();
        btnVerMAs = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelCantidad = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cantidad = new javax.swing.JLabel();
        jPanelBoton = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        jPanelDetalle = new javax.swing.JPanel();
        jTabbedPaneComentarios = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDetalle = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaComentarios = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaEspecificacion = new javax.swing.JTextArea();
        btnRegresar = new javax.swing.JButton();
        jPanelDatos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtResponsable = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtPrioridad = new javax.swing.JTextField();
        txtCreador = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        txtAsunto = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtTiempoSol = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanelGestion = new javax.swing.JPanel();
        jPanelComentario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaComentario2 = new javax.swing.JTextArea();
        jPanelRadios = new javax.swing.JPanel();
        jRadioComentario = new javax.swing.JRadioButton();
        jRadioRedireccioinar = new javax.swing.JRadioButton();
        jRadioPrioridad = new javax.swing.JRadioButton();
        jRadioResponsable = new javax.swing.JRadioButton();
        jRadioFecha = new javax.swing.JRadioButton();
        jPanelArea = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxArea2 = new javax.swing.JComboBox();
        jPanelPrioridad = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxPrioridad = new javax.swing.JComboBox();
        jPanelResponsable = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextResponsable = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanelFecha = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextDiaDesde = new javax.swing.JTextField();
        jTextMesDesde = new javax.swing.JTextField();
        jTextAnnoDesde = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnAplicarCambios = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        jPanelTabla.setBackground(new java.awt.Color(158, 143, 123));
        jPanelTabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaTickets.setBackground(new java.awt.Color(226, 221, 205));
        tablaTickets.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de ticket", "Asunto", "Creado por", "Fecha de creación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTickets);
        if (tablaTickets.getColumnModel().getColumnCount() > 0) {
            tablaTickets.getColumnModel().getColumn(0).setResizable(false);
            tablaTickets.getColumnModel().getColumn(1).setResizable(false);
            tablaTickets.getColumnModel().getColumn(2).setResizable(false);
            tablaTickets.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("BANDEJA DE ENTRADA");

        jLabelvermas.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabelvermas.setText("Seleccione un ticket para ver más detalles");

        btnVerMAs.setText("Ver más");
        btnVerMAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMAsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTablaLayout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelTablaLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTablaLayout.createSequentialGroup()
                                .addComponent(jLabelvermas)
                                .addGap(18, 18, 18)
                                .addComponent(btnVerMAs))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelvermas)
                    .addComponent(btnVerMAs))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(208, 144, 56));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitulo.setText("Bandeja de entrada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addContainerGap())
        );

        jPanelCantidad.setBackground(new java.awt.Color(226, 221, 205));
        jPanelCantidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Cantidad de tickets nuevos");

        cantidad.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanelCantidadLayout = new javax.swing.GroupLayout(jPanelCantidad);
        jPanelCantidad.setLayout(jPanelCantidadLayout);
        jPanelCantidadLayout.setHorizontalGroup(
            jPanelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCantidadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cantidad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCantidadLayout.setVerticalGroup(
            jPanelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCantidadLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cantidad))
                .addContainerGap())
        );

        jPanelBoton.setBackground(new java.awt.Color(222, 68, 33));
        jPanelBoton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCancelar.setText("Regresar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonLayout = new javax.swing.GroupLayout(jPanelBoton);
        jPanelBoton.setLayout(jPanelBotonLayout);
        jPanelBotonLayout.setHorizontalGroup(
            jPanelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotonLayout.setVerticalGroup(
            jPanelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDetalle.setBackground(new java.awt.Color(158, 143, 123));
        jPanelDetalle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextAreaDetalle.setEditable(false);
        jTextAreaDetalle.setColumns(20);
        jTextAreaDetalle.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDetalle);

        jTabbedPaneComentarios.addTab("Detalle del problema", jScrollPane2);

        jTextAreaComentarios.setEditable(false);
        jTextAreaComentarios.setColumns(20);
        jTextAreaComentarios.setRows(5);
        jScrollPane3.setViewportView(jTextAreaComentarios);

        jTabbedPaneComentarios.addTab("Comentarios", jScrollPane3);

        jTextAreaEspecificacion.setEditable(false);
        jTextAreaEspecificacion.setColumns(20);
        jTextAreaEspecificacion.setRows(5);
        jScrollPane4.setViewportView(jTextAreaEspecificacion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );

        jTabbedPaneComentarios.addTab("Especificación", jPanel2);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jPanelDatos.setBackground(new java.awt.Color(158, 143, 123));
        jPanelDatos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Área:");

        jLabel6.setText("Estado:");

        jLabel13.setText("Responsable:");

        jPanel6.setBackground(new java.awt.Color(158, 143, 123));

        txtResponsable.setEditable(false);

        txtArea.setEditable(false);

        txtEstado.setEditable(false);

        txtPrioridad.setEditable(false);

        txtCreador.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(txtArea)
            .addComponent(txtResponsable)
            .addComponent(txtPrioridad)
            .addComponent(txtCreador)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCreador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBackground(new java.awt.Color(158, 143, 123));

        txtAsunto.setEditable(false);

        txtFecha.setEditable(false);

        txtHora.setEditable(false);

        txtTiempoSol.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtHora, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(txtFecha)
            .addComponent(txtAsunto)
            .addComponent(txtTiempoSol)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTiempoSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel15.setText("Asunto:");

        jLabel8.setText("Fecha: ");

        jLabel10.setText("Hora:");

        jLabel7.setText("Prioridad:");

        jLabel12.setText("Tiempo de solución:");

        jLabel9.setText("Creador:");

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel8)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelGestion.setBackground(new java.awt.Color(158, 143, 123));

        jPanelComentario.setBackground(new java.awt.Color(226, 221, 205));
        jPanelComentario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Escriba su comentario: ");

        jTextAreaComentario2.setColumns(20);
        jTextAreaComentario2.setRows(5);
        jScrollPane5.setViewportView(jTextAreaComentario2);

        javax.swing.GroupLayout jPanelComentarioLayout = new javax.swing.GroupLayout(jPanelComentario);
        jPanelComentario.setLayout(jPanelComentarioLayout);
        jPanelComentarioLayout.setHorizontalGroup(
            jPanelComentarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComentarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelComentarioLayout.setVerticalGroup(
            jPanelComentarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComentarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelComentarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRadios.setBackground(new java.awt.Color(226, 221, 205));
        jPanelRadios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRadios.setForeground(new java.awt.Color(51, 255, 0));

        jRadioComentario.setBackground(new java.awt.Color(226, 221, 205));
        buttonGroupGestionar.add(jRadioComentario);
        jRadioComentario.setText("Agregar comentario");

        jRadioRedireccioinar.setBackground(new java.awt.Color(226, 221, 205));
        buttonGroupGestionar.add(jRadioRedireccioinar);
        jRadioRedireccioinar.setText("Redireccionar ticket");

        jRadioPrioridad.setBackground(new java.awt.Color(226, 221, 205));
        buttonGroupGestionar.add(jRadioPrioridad);
        jRadioPrioridad.setText("Cambiar prioridad");

        jRadioResponsable.setBackground(new java.awt.Color(226, 221, 205));
        buttonGroupGestionar.add(jRadioResponsable);
        jRadioResponsable.setText("Asignar responsable");

        jRadioFecha.setBackground(new java.awt.Color(226, 221, 205));
        buttonGroupGestionar.add(jRadioFecha);
        jRadioFecha.setText("Asignar fecha de solución");

        javax.swing.GroupLayout jPanelRadiosLayout = new javax.swing.GroupLayout(jPanelRadios);
        jPanelRadios.setLayout(jPanelRadiosLayout);
        jPanelRadiosLayout.setHorizontalGroup(
            jPanelRadiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRadiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioComentario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioRedireccioinar)
                .addGap(18, 18, 18)
                .addComponent(jRadioPrioridad)
                .addGap(18, 18, 18)
                .addComponent(jRadioResponsable)
                .addGap(10, 10, 10)
                .addComponent(jRadioFecha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRadiosLayout.setVerticalGroup(
            jPanelRadiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRadiosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRadiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioComentario)
                    .addComponent(jRadioRedireccioinar)
                    .addComponent(jRadioPrioridad)
                    .addComponent(jRadioResponsable)
                    .addComponent(jRadioFecha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelArea.setBackground(new java.awt.Color(226, 221, 205));
        jPanelArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Seleccione el área: ");

        jComboBoxArea2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí" }));
        jComboBoxArea2.setToolTipText("");

        javax.swing.GroupLayout jPanelAreaLayout = new javax.swing.GroupLayout(jPanelArea);
        jPanelArea.setLayout(jPanelAreaLayout);
        jPanelAreaLayout.setHorizontalGroup(
            jPanelAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAreaLayout.setVerticalGroup(
            jPanelAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxArea2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPrioridad.setBackground(new java.awt.Color(226, 221, 205));
        jPanelPrioridad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Seleccione la prioridad: ");

        jComboBoxPrioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí", "Baja", "Media", "Alta" }));
        jComboBoxPrioridad.setToolTipText("");

        javax.swing.GroupLayout jPanelPrioridadLayout = new javax.swing.GroupLayout(jPanelPrioridad);
        jPanelPrioridad.setLayout(jPanelPrioridadLayout);
        jPanelPrioridadLayout.setHorizontalGroup(
            jPanelPrioridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrioridadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPrioridadLayout.setVerticalGroup(
            jPanelPrioridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrioridadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrioridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelResponsable.setBackground(new java.awt.Color(226, 221, 205));
        jPanelResponsable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setText("Correo del responsable: ");

        jLabel19.setText("@castillo.cr");

        javax.swing.GroupLayout jPanelResponsableLayout = new javax.swing.GroupLayout(jPanelResponsable);
        jPanelResponsable.setLayout(jPanelResponsableLayout);
        jPanelResponsableLayout.setHorizontalGroup(
            jPanelResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResponsableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jTextResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelResponsableLayout.setVerticalGroup(
            jPanelResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResponsableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelFecha.setBackground(new java.awt.Color(226, 221, 205));
        jPanelFecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setText("Escriba la fecha de solución: ");

        jTextDiaDesde.setText("dd");

        jTextMesDesde.setText("mm");

        jTextAnnoDesde.setText("aaaa");
        jTextAnnoDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAnnoDesdeActionPerformed(evt);
            }
        });

        jLabel17.setText("-");

        jLabel18.setText("-");

        javax.swing.GroupLayout jPanelFechaLayout = new javax.swing.GroupLayout(jPanelFecha);
        jPanelFecha.setLayout(jPanelFechaLayout);
        jPanelFechaLayout.setHorizontalGroup(
            jPanelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jTextDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextMesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextAnnoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFechaLayout.setVerticalGroup(
            jPanelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAnnoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAplicarCambios.setText("Aplicar cambios");
        btnAplicarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGestionLayout = new javax.swing.GroupLayout(jPanelGestion);
        jPanelGestion.setLayout(jPanelGestionLayout);
        jPanelGestionLayout.setHorizontalGroup(
            jPanelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelComentario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelRadios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelPrioridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelGestionLayout.createSequentialGroup()
                .addComponent(btnAplicarCambios)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelGestionLayout.setVerticalGroup(
            jPanelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionLayout.createSequentialGroup()
                .addComponent(jPanelRadios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAplicarCambios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnModificar.setText("Modificar ticket");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDetalleLayout = new javax.swing.GroupLayout(jPanelDetalle);
        jPanelDetalle.setLayout(jPanelDetalleLayout);
        jPanelDetalleLayout.setHorizontalGroup(
            jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPaneComentarios)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDetalleLayout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelGestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelDetalleLayout.setVerticalGroup(
            jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetalleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnModificar))
                .addGap(18, 18, 18)
                .addComponent(jPanelGestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Realmente desea salir?", null, JOptionPane.YES_NO_OPTION)) {
            Ventana.obtenerInstancia().ventanaPrincipalAdmin();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVerMAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMAsActionPerformed
        //a partir de aqui se obtiene el codigo del ticket y se llena la demas informacion

        int dato = this.tablaTickets.getSelectedRow();
        if (dato >= 0) {
            int codi = Integer.parseInt(String.valueOf(this.tablaTickets.getValueAt(dato, 0)));
            this.codigoTicket = codi;
            
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, " ¿Realmente desea ver el ticket " + codi + "?", null, JOptionPane.YES_NO_OPTION)) {
                Controlador.obtenerInstancia().cambioEstadoLeido(codi);
                Ticket aux = Controlador.obtenerInstancia().informacionTicket(codi);
                this.jLabelTitulo.setText("Información del ticket " + codi);
                this.jPanelTabla.setVisible(false);
                this.jPanelBoton.setVisible(false);
                this.jPanelCantidad.setVisible(false);
                this.llenarInformacionExtra(aux);
                this.jPanelDetalle.setVisible(true);
               // this.llenarBandeja();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un ticket", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnVerMAsActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, " ¿Realmente desea regresar?", null, JOptionPane.YES_NO_OPTION)) {
            this.jPanelDetalle.setVisible(false);
            this.jLabelTitulo.setText("Bandeja de entrada");
            this.jPanelTabla.setVisible(true);
            this.jPanelBoton.setVisible(true);
            this.jPanelCantidad.setVisible(true);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void jTextAnnoDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAnnoDesdeActionPerformed

    }//GEN-LAST:event_jTextAnnoDesdeActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        this.jPanelGestion.setVisible(true);
        this.jPanelRadios.setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAplicarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarCambiosActionPerformed
        if (this.jRadioComentario.isSelected()) {
            if (this.jTextAreaComentario2.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe escribir un comentario", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String comentarios = this.jTextAreaComentarios.getText() + "\n" + this.jTextAreaComentario2.getText();
                if (Controlador.obtenerInstancia().agregaComentario(this.codigoTicket, comentarios)) {
                    JOptionPane.showMessageDialog(this, "Comentario agregado con éxito", "", JOptionPane.INFORMATION_MESSAGE);

                    
                    Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                            VentanaLogin.correo, "Ticket", "Agregó comentario al ticket " + this.codigoTicket);
                    

                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo agregar el comentario", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (this.jRadioFecha.isSelected()) {
            if (this.jTextAnnoDesde.getText().equals("") || this.jTextMesDesde.getText().equals("")
                    || this.jTextDiaDesde.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Faltan datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String año, mes, dia;
                año = this.jTextAnnoDesde.getText();
                mes = this.jTextMesDesde.getText();
                dia = this.jTextDiaDesde.getText();
                if (!año.contains("a") && !mes.contains("m") && !dia.contains("d")) {
                    String fecha = año + "-" + mes + "-" + dia;
                    if (Controlador.obtenerInstancia().cambiaFechaSolucion(this.codigoTicket, fecha)) {
                        JOptionPane.showMessageDialog(this, "Fecha de solución cambiada con éxito", "", JOptionPane.INFORMATION_MESSAGE);

                      
                        Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                                VentanaLogin.correo, "Ticket", "Cambió fecha de solución al ticket " + this.codigoTicket);
                        

                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo cambiar la fecha de solución", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Fecha de solución invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        if (this.jRadioPrioridad.isSelected()) {
            if (this.jComboBoxPrioridad.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar la prioridad", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                int _prioridad = 0;
                String seleccion = this.jComboBoxPrioridad.getSelectedItem().toString();
                switch (seleccion) {
                    case "Baja":
                        _prioridad = 1;
                        break;
                    case "Media":
                        _prioridad = 2;
                        break;
                    case "Alta":
                        _prioridad = 3;
                        break;
                }
                if (Controlador.obtenerInstancia().cambiaPrioridad(this.codigoTicket, _prioridad)) {
                    JOptionPane.showMessageDialog(this, "Prioridad cambiada con éxito", "", JOptionPane.INFORMATION_MESSAGE);


                    Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                            VentanaLogin.correo, "Ticket", "Cambió prioridad al ticket " + this.codigoTicket);
                   
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo cambiar la prioridad", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (this.jRadioRedireccioinar.isSelected()) {
            if (this.jComboBoxArea2.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar el área de destino", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String _area = this.jComboBoxArea2.getSelectedItem().toString();
                if (Controlador.obtenerInstancia().redireccionarTicket(this.codigoTicket, _area)) {
                    JOptionPane.showMessageDialog(this, "Ticket redireccionado con éxito", "", JOptionPane.INFORMATION_MESSAGE);

                 
                    Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                            VentanaLogin.correo, "Ticket", "Redireccionó el ticket " + this.codigoTicket);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha podido redireccionar el ticket", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (this.jRadioResponsable.isSelected()) {
            if (this.jTextResponsable.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe escribir el correo del responsable", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String correo = Controlador.obtenerInstancia().recortaCorreo(this.jTextResponsable.getText()) + "@castillo.cr";
                if (Controlador.obtenerInstancia().asignarResponsable(this.codigoTicket, correo)) {
                    JOptionPane.showMessageDialog(this, "Responsable asignado con éxito", "", JOptionPane.INFORMATION_MESSAGE);

                    Controlador.obtenerInstancia().ejecutarSentenciaSQL(Controlador.obtenerInstancia().consultarConsecutivoBitacora(),
                            VentanaLogin.correo, "Ticket", "Asignó responsable al ticket " + this.codigoTicket);
                   
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha podido asignar el responsable", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAplicarCambiosActionPerformed

    private void limpiarCampos() {
        buttonGroupGestionar.setSelected(null, true);
        jComboBoxArea2.setSelectedIndex(-1);
        jComboBoxPrioridad.setSelectedIndex(0);
        jTextAnnoDesde.setText("");
        jTextAreaComentario2.setText("");
        jTextAreaComentarios.setText("");
        jTextAreaDetalle.setText("");
        jTextAreaEspecificacion.setText("");
        jTextDiaDesde.setText("");
        jTextMesDesde.setText("");
        jTextResponsable.setText("");
        txtArea.setText("");
        txtAsunto.setText("");
        txtCreador.setText("");
        txtEstado.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txtPrioridad.setText("");
        txtResponsable.setText("");
        txtTiempoSol.setText("");
//comentario desde git
    }

    //Declaracion de variables
    private static PanelBandejaAdministrador instancia = null;
    private DefaultTableModel modelAux;
    private int codigoTicket;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarCambios;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerMAs;
    private javax.swing.ButtonGroup buttonGroupGestionar;
    private javax.swing.JLabel cantidad;
    private javax.swing.JComboBox jComboBoxArea2;
    private javax.swing.JComboBox jComboBoxPrioridad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelvermas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelArea;
    private javax.swing.JPanel jPanelBoton;
    private javax.swing.JPanel jPanelCantidad;
    private javax.swing.JPanel jPanelComentario;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelDetalle;
    private javax.swing.JPanel jPanelFecha;
    private javax.swing.JPanel jPanelGestion;
    private javax.swing.JPanel jPanelPrioridad;
    private javax.swing.JPanel jPanelRadios;
    private javax.swing.JPanel jPanelResponsable;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JRadioButton jRadioComentario;
    private javax.swing.JRadioButton jRadioFecha;
    private javax.swing.JRadioButton jRadioPrioridad;
    private javax.swing.JRadioButton jRadioRedireccioinar;
    private javax.swing.JRadioButton jRadioResponsable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPaneComentarios;
    private javax.swing.JTextField jTextAnnoDesde;
    private javax.swing.JTextArea jTextAreaComentario2;
    private javax.swing.JTextArea jTextAreaComentarios;
    private javax.swing.JTextArea jTextAreaDetalle;
    private javax.swing.JTextArea jTextAreaEspecificacion;
    private javax.swing.JTextField jTextDiaDesde;
    private javax.swing.JTextField jTextMesDesde;
    private javax.swing.JTextField jTextResponsable;
    private javax.swing.JTable tablaTickets;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtCreador;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtPrioridad;
    private javax.swing.JTextField txtResponsable;
    private javax.swing.JTextField txtTiempoSol;
    // End of variables declaration//GEN-END:variables
}
