package vista.Area;

import java.awt.event.KeyAdapter;
import javax.swing.JOptionPane;
import vista.Ventana;

public class PanelReportesArea extends javax.swing.JPanel {

    private PanelReportesArea() {
        initComponents();
        this.limpiarCampos();
        ocultarComponentes();
        ajustarEventos();
    }//----------------------------------------------------------------------------- FIN Constructor()

    public static PanelReportesArea obtenerInstancia() {//para garantizar hay solo una instancia
        if (instancia == null) {
            instancia = new PanelReportesArea();
        }
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    private void ajustarEventos() {
        addMouseListener(Ventana.obtenerInstancia());
        jTextAnnoDesde.addKeyListener(new KeyAdapter() {
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
        jTextHoraHasta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTextHoraHasta.addKeyListener(new KeyAdapter() {
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
        jTextMinutoDesde.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTextMinutoDesde1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTextMinutoHasta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTextMinutoHasta1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTexthoradesde.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });
        jTexthoradesde1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                super.keyPressed(evt);
                Ventana.obtenerInstancia().tecla();
            }
        });

    }

    private void ocultarComponentes() {
        this.btnReporte.setEnabled(false);
        this.jPanelArea.setVisible(false);
        this.PanelRangoFechas.setVisible(false);
        this.jPanelTiempoSolucion.setVisible(false);
        this.jPanelRangoHoras.setVisible(false);
    }//----------------------------------------------------------------------------- FIN ocultarComponentes()

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jPanelSeleccion = new javax.swing.JPanel();
        jLabelSubtitulo = new javax.swing.JLabel();
        ComboBusqueda = new javax.swing.JComboBox();
        jPanelArea = new javax.swing.JPanel();
        jLabelAreas = new javax.swing.JLabel();
        ComboAreas = new javax.swing.JComboBox();
        PanelRangoFechas = new javax.swing.JPanel();
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
        PanelBotones = new javax.swing.JPanel();
        btnReporte = new javax.swing.JButton();
        btnCancelarReporte = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanelRangoHoras = new javax.swing.JPanel();
        jLabelDesde1 = new javax.swing.JLabel();
        jTexthoradesde = new javax.swing.JTextField();
        jLabelGuion5 = new javax.swing.JLabel();
        jTextMinutoDesde = new javax.swing.JTextField();
        jLabelHasta1 = new javax.swing.JLabel();
        jTextHoraHasta = new javax.swing.JTextField();
        jLabelGuion7 = new javax.swing.JLabel();
        jTextMinutoHasta = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jPanelTiempoSolucion = new javax.swing.JPanel();
        jLabelDesde2 = new javax.swing.JLabel();
        jTexthoradesde1 = new javax.swing.JTextField();
        jLabelGuion6 = new javax.swing.JLabel();
        jTextMinutoDesde1 = new javax.swing.JTextField();
        jLabelHasta2 = new javax.swing.JLabel();
        jTextHoraHasta1 = new javax.swing.JTextField();
        jLabelGuion8 = new javax.swing.JLabel();
        jTextMinutoHasta1 = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(252, 239, 148));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(102, 51, 0));
        labelTitulo.setText("Generar reportes de tickets");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelSeleccion.setBackground(new java.awt.Color(217, 213, 206));
        jPanelSeleccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelSubtitulo.setText("Seleccione el tipo de reporte que desea: ");

        ComboBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione aquí", "Rango de fechas", "Rango de horas", "Según área especifica", "Tickets redireccionados", "Tiempos de solución" }));
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
                .addComponent(ComboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(532, Short.MAX_VALUE))
        );
        jPanelSeleccionLayout.setVerticalGroup(
            jPanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSeleccionLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSubtitulo)
                    .addComponent(ComboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanelArea.setBackground(new java.awt.Color(119, 172, 209));
        jPanelArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelAreas.setText("Seleccione el área: ");

        ComboAreas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soporte técnico", "Mantenimiento" }));
        ComboAreas.setToolTipText("");
        ComboAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAreasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAreaLayout = new javax.swing.GroupLayout(jPanelArea);
        jPanelArea.setLayout(jPanelAreaLayout);
        jPanelAreaLayout.setHorizontalGroup(
            jPanelAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAreas)
                .addGap(115, 115, 115)
                .addComponent(ComboAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAreaLayout.setVerticalGroup(
            jPanelAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAreas)
                    .addComponent(ComboAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        PanelRangoFechas.setBackground(new java.awt.Color(119, 172, 209));
        PanelRangoFechas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        jTextAnnoHasta.setText("aaa");
        jTextAnnoHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAnnoHastaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRangoFechasLayout = new javax.swing.GroupLayout(PanelRangoFechas);
        PanelRangoFechas.setLayout(PanelRangoFechasLayout);
        PanelRangoFechasLayout.setHorizontalGroup(
            PanelRangoFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRangoFechasLayout.createSequentialGroup()
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
        PanelRangoFechasLayout.setVerticalGroup(
            PanelRangoFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRangoFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelRangoFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

        PanelBotones.setBackground(new java.awt.Color(9, 46, 105));
        PanelBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnReporte.setText("Generar reporte");

        btnCancelarReporte.setText("Cancelar");
        btnCancelarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReporteActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBotonesLayout = new javax.swing.GroupLayout(PanelBotones);
        PanelBotones.setLayout(PanelBotonesLayout);
        PanelBotonesLayout.setHorizontalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReporte)
                .addGap(65, 65, 65)
                .addComponent(btnLimpiar)
                .addGap(65, 65, 65)
                .addComponent(btnCancelarReporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporte)
                    .addComponent(btnCancelarReporte)
                    .addComponent(btnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRangoHoras.setBackground(new java.awt.Color(119, 172, 209));
        jPanelRangoHoras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelDesde1.setText("Desde: ");

        jTexthoradesde.setText("hh");

        jLabelGuion5.setText("-");

        jTextMinutoDesde.setText("mm");

        jLabelHasta1.setText("Hasta:");

        jTextHoraHasta.setText("hh");

        jLabelGuion7.setText("-");

        jTextMinutoHasta.setText("mm");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));

        javax.swing.GroupLayout jPanelRangoHorasLayout = new javax.swing.GroupLayout(jPanelRangoHoras);
        jPanelRangoHoras.setLayout(jPanelRangoHorasLayout);
        jPanelRangoHorasLayout.setHorizontalGroup(
            jPanelRangoHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRangoHorasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDesde1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTexthoradesde, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion5, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextMinutoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabelHasta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextHoraHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion7, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextMinutoHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRangoHorasLayout.setVerticalGroup(
            jPanelRangoHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRangoHorasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRangoHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDesde1)
                    .addComponent(jTexthoradesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGuion5)
                    .addComponent(jTextMinutoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHasta1)
                    .addComponent(jTextHoraHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMinutoHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGuion7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTiempoSolucion.setBackground(new java.awt.Color(119, 172, 209));
        jPanelTiempoSolucion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelDesde2.setText("Desde: ");

        jTexthoradesde1.setText("hh");

        jLabelGuion6.setText("-");

        jTextMinutoDesde1.setText("mm");

        jLabelHasta2.setText("Hasta:");

        jTextHoraHasta1.setText("hh");

        jLabelGuion8.setText("-");

        jTextMinutoHasta1.setText("mm");

        javax.swing.GroupLayout jPanelTiempoSolucionLayout = new javax.swing.GroupLayout(jPanelTiempoSolucion);
        jPanelTiempoSolucion.setLayout(jPanelTiempoSolucionLayout);
        jPanelTiempoSolucionLayout.setHorizontalGroup(
            jPanelTiempoSolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTiempoSolucionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDesde2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTexthoradesde1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion6, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextMinutoDesde1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(jLabelHasta2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextHoraHasta1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuion8, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextMinutoHasta1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTiempoSolucionLayout.setVerticalGroup(
            jPanelTiempoSolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTiempoSolucionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTiempoSolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDesde2)
                    .addComponent(jTexthoradesde1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGuion6)
                    .addComponent(jTextMinutoDesde1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHasta2)
                    .addComponent(jTextHoraHasta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMinutoHasta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGuion8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelRangoFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRangoHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTiempoSolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelRangoFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelRangoHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelTiempoSolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBusquedaActionPerformed
        //Rango de fechas, Rango de horas, Según área especifica, Tickets redireccionados, Tiempos de solución
        if (ComboBusqueda.getSelectedItem().equals("Rango de fechas")) {
            ocultarComponentes();
            PanelRangoFechas.setVisible(true);
//            PanelBotones.setVisible(true);
            this.btnReporte.setEnabled(true);
        }
        if (ComboBusqueda.getSelectedItem().equals("Rango de horas")) {
            ocultarComponentes();
            jPanelRangoHoras.setVisible(true);
//            PanelBotones.setVisible(true);
            this.btnReporte.setEnabled(true);
        }
        if (ComboBusqueda.getSelectedItem().equals("Según área especifica")) {
            ocultarComponentes();
            jPanelArea.setVisible(true);
//            PanelBotones.setVisible(true);
            this.btnReporte.setEnabled(true);
        }
        if (ComboBusqueda.getSelectedItem().equals("Tickets redireccionados")) {
            ocultarComponentes();
            JOptionPane.showMessageDialog(null, "¿No hay tickets redireccionados?");
        }
        if (ComboBusqueda.getSelectedItem().equals("Tiempos de solución")) {
            ocultarComponentes();
            JOptionPane.showMessageDialog(null, "¿No hay tickets insertados?");
        }
    }//GEN-LAST:event_ComboBusquedaActionPerformed

    private void jTextAnnoDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAnnoDesdeActionPerformed

    }//GEN-LAST:event_jTextAnnoDesdeActionPerformed

    private void jTextAnnoHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAnnoHastaActionPerformed

    }//GEN-LAST:event_jTextAnnoHastaActionPerformed

    private void btnCancelarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReporteActionPerformed
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea finalizar el reporte?", null, JOptionPane.YES_NO_OPTION)) {
            Ventana.obtenerInstancia().ventanaPrincipalArea();
        }
    }//GEN-LAST:event_btnCancelarReporteActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void ComboAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAreasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboAreasActionPerformed

    private void limpiarCampos() {
    ComboAreas.setSelectedIndex(0);
    ComboBusqueda.setSelectedIndex(0);
    jComboBox1.setSelectedIndex(0);
    jComboBox2.setSelectedIndex(0);
    
}
//Declaracion de variables
private static PanelReportesArea instancia = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboAreas;
    private javax.swing.JComboBox ComboBusqueda;
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JPanel PanelRangoFechas;
    private javax.swing.JButton btnCancelarReporte;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabelAreas;
    private javax.swing.JLabel jLabelDesde;
    private javax.swing.JLabel jLabelDesde1;
    private javax.swing.JLabel jLabelDesde2;
    private javax.swing.JLabel jLabelGuion1;
    private javax.swing.JLabel jLabelGuion2;
    private javax.swing.JLabel jLabelGuion3;
    private javax.swing.JLabel jLabelGuion4;
    private javax.swing.JLabel jLabelGuion5;
    private javax.swing.JLabel jLabelGuion6;
    private javax.swing.JLabel jLabelGuion7;
    private javax.swing.JLabel jLabelGuion8;
    private javax.swing.JLabel jLabelHasta;
    private javax.swing.JLabel jLabelHasta1;
    private javax.swing.JLabel jLabelHasta2;
    private javax.swing.JLabel jLabelSubtitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelArea;
    private javax.swing.JPanel jPanelRangoHoras;
    private javax.swing.JPanel jPanelSeleccion;
    private javax.swing.JPanel jPanelTiempoSolucion;
    private javax.swing.JTextField jTextAnnoDesde;
    private javax.swing.JTextField jTextAnnoHasta;
    private javax.swing.JTextField jTextDiaDesde;
    private javax.swing.JTextField jTextDiaHasta;
    private javax.swing.JTextField jTextHoraHasta;
    private javax.swing.JTextField jTextHoraHasta1;
    private javax.swing.JTextField jTextMesDesde;
    private javax.swing.JTextField jTextMesHasta;
    private javax.swing.JTextField jTextMinutoDesde;
    private javax.swing.JTextField jTextMinutoDesde1;
    private javax.swing.JTextField jTextMinutoHasta;
    private javax.swing.JTextField jTextMinutoHasta1;
    private javax.swing.JTextField jTexthoradesde;
    private javax.swing.JTextField jTexthoradesde1;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
