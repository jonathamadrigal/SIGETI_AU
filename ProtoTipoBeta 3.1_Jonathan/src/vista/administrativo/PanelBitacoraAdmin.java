package vista.administrativo;

import controlador.Controlador;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Bitacora;
import modelo.Ticket;
import vista.Ventana;
import vista.VentanaLogin;

public class PanelBitacoraAdmin extends javax.swing.JPanel {

    private PanelBitacoraAdmin() {
        initComponents();
        this.limpiarCampos();
        this.ocultarComponentes();
        this.iniciarValidaciones();
        this.ajustarEventos();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static PanelBitacoraAdmin obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new PanelBitacoraAdmin();
        }
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    private void ajustarEventos() {
        addMouseListener(Ventana.obtenerInstancia());
        jTableBitacora.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTextAnnoDesde.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTextAnnoHasta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTextDiaDesde.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTextDiaHasta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTextUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTextMesDesde.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTextMesHasta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });

    }

    private void ocultarComponentes() {
        this.jPanelUsuario.setVisible(false);
        this.jPanelRangoFechas.setVisible(false);
        this.jPanelTabla.setVisible(false);
        this.jPanelRangoHoras.setVisible(false);
    }//----------------------------------------------------------------------------- FIN ocultarComponentes()

    private void iniciarValidaciones() {
        soloNumeros(this.jTextAnnoDesde);
        soloNumeros(this.jTextMesDesde);
        soloNumeros(this.jTextDiaDesde);
        soloNumeros(this.jTextAnnoHasta);
        soloNumeros(this.jTextMesHasta);
        soloNumeros(this.jTextDiaHasta);
        soloNumeros(this.jTextHoraInicial);
        soloNumeros(this.jTextMinutoInicial);
        soloNumeros(this.jTextHoraFinal);
        soloNumeros(this.jTextMinutoFinal);
    }//----------------------------------------------------------------------------- FIN iniciarValidaciones()

    public void soloNumeros(JTextField txt) {//para validar que en la fecha solo digite numeros
        txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }//----------------------------------------------------------------------------- FIN soloNumeros()

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelSeleccion = new javax.swing.JPanel();
        jLabelSubtitulo = new javax.swing.JLabel();
        ComboBusqueda = new javax.swing.JComboBox();
        jPanelUsuario = new javax.swing.JPanel();
        jLabelAreas = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanelRangoFechas = new javax.swing.JPanel();
        jLabelDesde = new javax.swing.JLabel();
        jTextDiaDesde = new javax.swing.JTextField();
        jLabelGuion1 = new javax.swing.JLabel();
        jTextMesDesde = new javax.swing.JTextField();
        jLabelGuion2 = new javax.swing.JLabel();
        jTextAnnoDesde = new javax.swing.JTextField();
        jLabelHasta = new javax.swing.JLabel();
        jTextDiaHasta = new javax.swing.JTextField();
        jLabelGuion3 = new javax.swing.JLabel();
        jTextMesHasta = new javax.swing.JTextField();
        jLabelGuion4 = new javax.swing.JLabel();
        jTextAnnoHasta = new javax.swing.JTextField();
        jPanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBitacora = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelBoton = new javax.swing.JPanel();
        btnConsultarTodos = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanelRangoHoras = new javax.swing.JPanel();
        jLabelHoraInicio = new javax.swing.JLabel();
        jTextHoraInicial = new javax.swing.JTextField();
        jLabelGuion5 = new javax.swing.JLabel();
        jTextMinutoInicial = new javax.swing.JTextField();
        jLabelHoraFinal = new javax.swing.JLabel();
        jTextHoraFinal = new javax.swing.JTextField();
        jLabelGuion7 = new javax.swing.JLabel();
        jTextMinutoFinal = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(208, 144, 56));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitulo.setText("Bitácora");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelSeleccion.setBackground(new java.awt.Color(226, 221, 205));
        jPanelSeleccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelSubtitulo.setText("Seleccione el tipo de consulta: ");

        ComboBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí", "Fechas", "Horas", "Usuario" }));
        ComboBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSeleccionLayout = new javax.swing.GroupLayout(jPanelSeleccion);
        jPanelSeleccion.setLayout(jPanelSeleccionLayout);
        jPanelSeleccionLayout.setHorizontalGroup(
            jPanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSubtitulo)
                .addGap(52, 52, 52)
                .addComponent(ComboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSeleccionLayout.setVerticalGroup(
            jPanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSeleccionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSubtitulo)
                    .addComponent(ComboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelUsuario.setBackground(new java.awt.Color(158, 143, 123));
        jPanelUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelAreas.setText("Ingrese el correo del usuario: ");

        jLabel1.setText("@castillo.cr");

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAreas)
                .addGap(55, 55, 55)
                .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelUsuarioLayout.setVerticalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAreas)
                    .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRangoFechas.setBackground(new java.awt.Color(158, 143, 123));
        jPanelRangoFechas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelDesde.setText("Desde: ");

        jTextDiaDesde.setText("dd");

        jLabelGuion1.setText("-");

        jTextMesDesde.setText("mm");

        jLabelGuion2.setText("-");

        jTextAnnoDesde.setText("aaaa");
        jTextAnnoDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAnnoDesdeActionPerformed(evt);
            }
        });

        jLabelHasta.setText("Hasta:");

        jTextDiaHasta.setText("dd");

        jLabelGuion3.setText("-");

        jTextMesHasta.setText("mm");

        jLabelGuion4.setText("-");

        jTextAnnoHasta.setText("aaaa");
        jTextAnnoHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAnnoHastaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRangoFechasLayout = new javax.swing.GroupLayout(jPanelRangoFechas);
        jPanelRangoFechas.setLayout(jPanelRangoFechasLayout);
        jPanelRangoFechasLayout.setHorizontalGroup(
            jPanelRangoFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRangoFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDesde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextMesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextAnnoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabelHasta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextDiaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextMesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextAnnoHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRangoFechasLayout.setVerticalGroup(
            jPanelRangoFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRangoFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRangoFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDesde)
                    .addComponent(jTextDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGuion1)
                    .addComponent(jTextMesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGuion2)
                    .addComponent(jTextAnnoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHasta)
                    .addComponent(jTextDiaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGuion4)
                    .addComponent(jTextAnnoHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGuion3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTabla.setBackground(new java.awt.Color(226, 221, 205));
        jPanelTabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableBitacora.setBackground(new java.awt.Color(226, 221, 205));
        jTableBitacora.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableBitacora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Fecha", "Hora", "Tabla", "Acción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableBitacora);
        if (jTableBitacora.getColumnModel().getColumnCount() > 0) {
            jTableBitacora.getColumnModel().getColumn(1).setPreferredWidth(35);
            jTableBitacora.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("TABLA DE BITÁCORA");

        jSeparator1.setBackground(new java.awt.Color(208, 144, 56));
        jSeparator1.setToolTipText("");

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(332, Short.MAX_VALUE))
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBoton.setBackground(new java.awt.Color(222, 68, 33));
        jPanelBoton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnConsultarTodos.setText("Consultar");
        btnConsultarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarTodosActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
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
                .addComponent(btnConsultarTodos)
                .addGap(65, 65, 65)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotonLayout.setVerticalGroup(
            jPanelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultarTodos)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRangoHoras.setBackground(new java.awt.Color(158, 143, 123));
        jPanelRangoHoras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelHoraInicio.setText("Hora inicial: ");

        jTextHoraInicial.setText("hh");

        jLabelGuion5.setText("-");

        jTextMinutoInicial.setText("mm");

        jLabelHoraFinal.setText("Hora Final: ");

        jTextHoraFinal.setText("hh");

        jLabelGuion7.setText("-");

        jTextMinutoFinal.setText("mm");

        javax.swing.GroupLayout jPanelRangoHorasLayout = new javax.swing.GroupLayout(jPanelRangoHoras);
        jPanelRangoHoras.setLayout(jPanelRangoHorasLayout);
        jPanelRangoHorasLayout.setHorizontalGroup(
            jPanelRangoHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRangoHorasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHoraInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion5, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextMinutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(jLabelHoraFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion7, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextMinutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRangoHorasLayout.setVerticalGroup(
            jPanelRangoHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRangoHorasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRangoHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHoraInicio)
                    .addComponent(jTextHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGuion5)
                    .addComponent(jTextMinutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHoraFinal)
                    .addComponent(jTextHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMinutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGuion7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRangoFechas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSeleccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRangoHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRangoFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRangoHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea finalizar la consulta?", null, JOptionPane.YES_NO_OPTION)) {
            Ventana.obtenerInstancia().ventanaPrincipalAdmin();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void ComboBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBusquedaActionPerformed
        String tipoConsulta = ComboBusqueda.getSelectedItem().toString();

        switch (tipoConsulta) {
            case "Fechas":
                this.jPanelRangoFechas.setVisible(true);
                this.jPanelRangoHoras.setVisible(false);
                this.jPanelUsuario.setVisible(false);
                break;
            case "Usuario":
                this.jPanelRangoFechas.setVisible(false);
                this.jPanelRangoHoras.setVisible(false);
                this.jPanelUsuario.setVisible(true);
                break;
            case "Horas":
                this.jPanelRangoFechas.setVisible(false);
                this.jPanelRangoHoras.setVisible(true);
                this.jPanelUsuario.setVisible(false);
                break;
            default:
                break;
        }

//        if (ComboBusqueda.getSelectedItem().equals("Fechas")) {
//            if (!jTextAnnoHasta.getText().contains("a")
//                    && !jTextAnnoDesde.getText().contains("a")
//                    && !jTextMesDesde.getText().contains("m")
//                    && !jTextMesHasta.getText().contains("m")
//                    && !jTextDiaDesde.getText().contains("d")
//                    && !jTextDiaHasta.getText().contains("d")) {
//                //falta llamar al metodo de la consulta
//            }else {
//                JOptionPane.showMessageDialog(null, "Fecha invalida.", "ERROR",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//        } else 
//            if (ComboBusqueda.getSelectedItem().equals("Usuario")) {
//                if(!this.jTextUsuario.getText().equals("")){
//                    
//                }else {
//                JOptionPane.showMessageDialog(null, "Es necesario el correo del usuario.", "ERROR",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//                
//        } else 
//                if (this.ComboBusqueda.getSelectedItem().equals("Horas")) {
//                    
//                    if (!jTextHoraInicial.getText().contains("h")
//                    && !jTextMinutoInicial.getText().contains("m")
//                    && !jTextHoraInicial.getText().contains("h")
//                    && !jTextMinutoFinal.getText().contains("m")) {
//                //falta llamar al metodo de la consulta
//            }else {
//                JOptionPane.showMessageDialog(null, "Hora invalida.", "ERROR",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//                   
//        }
    }//GEN-LAST:event_ComboBusquedaActionPerformed

    private void jTextAnnoDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAnnoDesdeActionPerformed

    }//GEN-LAST:event_jTextAnnoDesdeActionPerformed

    private void jTextAnnoHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAnnoHastaActionPerformed

    }//GEN-LAST:event_jTextAnnoHastaActionPerformed

    private void btnConsultarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarTodosActionPerformed
        if (ComboBusqueda.getSelectedIndex() != 0) {
            String tipoConsulta = ComboBusqueda.getSelectedItem().toString();
            modelAux = (DefaultTableModel) jTableBitacora.getModel();

            while (modelAux.getRowCount() > 0) {
                modelAux.removeRow(0);
            }
            switch (tipoConsulta) {
                case "Fechas":
                    this.jPanelRangoFechas.setVisible(true);
                    this.jPanelRangoHoras.setVisible(false);
                    this.jPanelUsuario.setVisible(false);
                    if (!jTextAnnoHasta.getText().contains("a")
                            && !jTextAnnoDesde.getText().contains("a")
                            && !jTextMesDesde.getText().contains("m")
                            && !jTextMesHasta.getText().contains("m")
                            && !jTextDiaDesde.getText().contains("d")
                            && !jTextDiaHasta.getText().contains("d")) {

                        String fecha1 = this.jTextAnnoDesde.getText() + "-" + this.jTextMesDesde.getText() + "-" + this.jTextDiaDesde.getText();
                        String fecha2 = this.jTextAnnoHasta.getText() + "-" + this.jTextMesHasta.getText() + "-" + this.jTextDiaHasta.getText();
                        ArrayList<Bitacora> aux = Controlador.obtenerInstancia().consultaBitacoraFechas(fecha1, fecha2);
                        if (aux.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No ha ocurrido acciones entre " + fecha1 + " y " + fecha2 + ".", "ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            int i = 0;
                            while (i < aux.size()) {
                                modelAux.insertRow(modelAux.getRowCount(), new Object[]{aux.get(i).getUsuario(),
                                    aux.get(i).getFecha(), aux.get(i).getHora(), aux.get(i).getTabla(), aux.get(i).getAccion()});
                                i++;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Fecha invalida.", "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "Usuario":
                    this.jPanelRangoFechas.setVisible(false);
                    this.jPanelRangoHoras.setVisible(false);
                    this.jPanelUsuario.setVisible(true);
                    if (!this.jTextUsuario.getText().equals("")) {
                        String usuario = Controlador.obtenerInstancia().recortaCorreo(this.jTextUsuario.getText()) + "@castillo.cr";
                        ArrayList<Bitacora> aux = Controlador.obtenerInstancia().consultaBitacoraUsuario(usuario);
                        if (aux.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no ha realizado acciones.", "ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            int i = 0;
                            while (i < aux.size()) {
                                modelAux.insertRow(modelAux.getRowCount(), new Object[]{this.jTextUsuario.getText(),
                                    aux.get(i).getFecha(), aux.get(i).getHora(), aux.get(i).getTabla(), aux.get(i).getAccion()});
                                i++;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Es necesario el correo del usuario.", "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "Horas":
                    this.jPanelRangoFechas.setVisible(false);
                    this.jPanelRangoHoras.setVisible(true);
                    this.jPanelUsuario.setVisible(false);
                    if (!jTextHoraInicial.getText().contains("h")
                            && !jTextMinutoInicial.getText().contains("m")
                            && !jTextHoraInicial.getText().contains("h")
                            && !jTextMinutoFinal.getText().contains("m")) {
                        String hora1 = this.jTextHoraInicial.getText() + ":" + this.jTextMinutoInicial.getText() + ":00";
                        String hora2 = this.jTextHoraFinal.getText() + ":" + this.jTextMinutoFinal.getText() + ":59";
                        ArrayList<Bitacora> aux = Controlador.obtenerInstancia().consultaBitacoraHoras(hora1, hora2);
                        if (aux.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No ha ocurrido acciones entre "+hora1+" y "+hora2+".", "ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            int i = 0;
                            while (i < aux.size()) {
                                modelAux.insertRow(modelAux.getRowCount(), new Object[]{aux.get(i).getUsuario(),
                                    aux.get(i).getFecha(), aux.get(i).getHora(), aux.get(i).getTabla(), aux.get(i).getAccion()});
                                i++;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Hora invalida.", "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                default:
                    break;
            }
            jTableBitacora.revalidate();
            jTableBitacora.repaint();
            this.jPanelTabla.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un tipo de busqueda.", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarTodosActionPerformed

    private void limpiarCampos(){
        ComboBusqueda.setSelectedIndex(0);
        jTextAnnoDesde.setText("");
        jTextAnnoHasta.setText("");
        jTextDiaDesde.setText("");
        jTextDiaHasta.setText("");
        jTextHoraFinal.setText("");
        jTextHoraInicial.setText("");
        jTextMesDesde.setText("");
        jTextMesHasta.setText("");
        jTextMinutoFinal.setText("");
        jTextMinutoInicial.setText("");
        jTextUsuario.setText("");        
    }
    
    //Declaracion de variables
    private static PanelBitacoraAdmin instancia = null;
    private DefaultTableModel modelAux;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBusqueda;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultarTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabelAreas;
    private javax.swing.JLabel jLabelDesde;
    private javax.swing.JLabel jLabelGuion1;
    private javax.swing.JLabel jLabelGuion2;
    private javax.swing.JLabel jLabelGuion3;
    private javax.swing.JLabel jLabelGuion4;
    private javax.swing.JLabel jLabelGuion5;
    private javax.swing.JLabel jLabelGuion7;
    private javax.swing.JLabel jLabelHasta;
    private javax.swing.JLabel jLabelHoraFinal;
    private javax.swing.JLabel jLabelHoraInicio;
    private javax.swing.JLabel jLabelSubtitulo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBoton;
    private javax.swing.JPanel jPanelRangoFechas;
    private javax.swing.JPanel jPanelRangoHoras;
    private javax.swing.JPanel jPanelSeleccion;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableBitacora;
    private javax.swing.JTextField jTextAnnoDesde;
    private javax.swing.JTextField jTextAnnoHasta;
    private javax.swing.JTextField jTextDiaDesde;
    private javax.swing.JTextField jTextDiaHasta;
    private javax.swing.JTextField jTextHoraFinal;
    private javax.swing.JTextField jTextHoraInicial;
    private javax.swing.JTextField jTextMesDesde;
    private javax.swing.JTextField jTextMesHasta;
    private javax.swing.JTextField jTextMinutoFinal;
    private javax.swing.JTextField jTextMinutoInicial;
    private javax.swing.JTextField jTextUsuario;
    // End of variables declaration//GEN-END:variables

}
