package Presentacion;

import Datos.conexion;
import Negocios.mensajes;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;


public class RecepcionarProd extends javax.swing.JFrame {
    
    public Integer totalregistros;
    private String estado;
    int id_registro;
    conexion con = new conexion();
    mensajes msj = new mensajes();
    
    public RecepcionarProd() {
        initComponents();
        mostrar("");
        this.setLocationRelativeTo(null);
    }
    
    void ocultar_columnas() {
        tablaOc.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaOc.getColumnModel().getColumn(0).setMinWidth(0);
        tablaOc.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    
    public DefaultTableModel mostrarDatos(String buscar){
        DefaultTableModel modelo;
        JTableHeader Theader = tablaOc.getTableHeader();
        Theader.setBackground(Color.decode("#69CDF3"));
        Theader.setForeground(Color.white);
        Theader.setFont(new Font("Calibri", Font.PLAIN, 15));
       // Theader.setUI(null);
       String [] titulos = {"N° Orden de Compra","Estado","Fecha Emisión","Empleado"};
       
       String [] registro =new String [4];
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
        try {
            Statement st = con.conectar().createStatement();
            String selectQuery = "SELECT OP.ID_ORDEN, OP.ESTADO, OP.FECHA, P.NOMBRE_P FROM ORDEN_PEDIDO OP\n" +
                                 "INNER JOIN PERSONA P ON OP.ID_EMPLEADO = P.ID_PERSONA ORDER BY OP.ID_ORDEN ASC";
            ResultSet rs=st.executeQuery(selectQuery);
            while(rs.next()){
               registro [0]=rs.getString("ID_ORDEN");
               registro [1]=rs.getString("ESTADO");
               registro [2]=rs.getString("FECHA");
               registro [3]=rs.getString("NOMBRE_P");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
            }
                    
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
       return modelo;
    }
    
    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            modelo = mostrarDatos(buscar);

            tablaOc.setModel(modelo);
            lblTotal.setText("Total Registros " + Integer.toString(totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOc = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdbPendi = new javax.swing.JRadioButton();
        rdbRechaza = new javax.swing.JRadioButton();
        rdbAprob = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        btnRecept = new javax.swing.JButton();
        btnVolverRecep = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnGenerar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBarCode = new javax.swing.JFormattedTextField();
        lblCode = new javax.swing.JLabel();
        btnVer = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(830, 420));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 420));

        tablaOc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablaOc.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        tablaOc.setForeground(new java.awt.Color(105, 205, 243));
        tablaOc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaOc.setGridColor(new java.awt.Color(105, 205, 243));
        tablaOc.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tablaOc.setSelectionForeground(new java.awt.Color(204, 204, 204));
        tablaOc.setSurrendersFocusOnKeystroke(true);
        tablaOc.getTableHeader().setReorderingAllowed(false);
        tablaOc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaOcMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaOc);

        lblTotal.setFont(new java.awt.Font("Aharoni", 0, 13)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(105, 205, 243));
        lblTotal.setText("Total Ordenes de Compra:");

        jPanel2.setBackground(new java.awt.Color(105, 205, 243));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 100));

        rdbPendi.setBackground(new java.awt.Color(105, 205, 243));
        buttonGroup1.add(rdbPendi);
        rdbPendi.setFont(new java.awt.Font("Aharoni", 0, 13)); // NOI18N
        rdbPendi.setForeground(new java.awt.Color(255, 255, 255));
        rdbPendi.setText("Pendiente");
        rdbPendi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPendiActionPerformed(evt);
            }
        });

        rdbRechaza.setBackground(new java.awt.Color(105, 205, 243));
        buttonGroup1.add(rdbRechaza);
        rdbRechaza.setFont(new java.awt.Font("Aharoni", 0, 13)); // NOI18N
        rdbRechaza.setForeground(new java.awt.Color(255, 255, 255));
        rdbRechaza.setText("Rechazado");
        rdbRechaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbRechazaActionPerformed(evt);
            }
        });

        rdbAprob.setBackground(new java.awt.Color(105, 205, 243));
        buttonGroup1.add(rdbAprob);
        rdbAprob.setFont(new java.awt.Font("Aharoni", 0, 13)); // NOI18N
        rdbAprob.setForeground(new java.awt.Color(255, 255, 255));
        rdbAprob.setText("Aprobado");
        rdbAprob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAprobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(rdbAprob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbRechaza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbPendi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbPendi)
                    .addComponent(rdbRechaza)
                    .addComponent(rdbAprob))
                .addGap(36, 36, 36))
        );

        jPanel3.setBackground(new java.awt.Color(105, 205, 243));
        jPanel3.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 100));

        btnRecept.setBackground(new java.awt.Color(255, 255, 255));
        btnRecept.setFont(new java.awt.Font("Aharoni", 0, 13)); // NOI18N
        btnRecept.setForeground(new java.awt.Color(105, 205, 243));
        btnRecept.setText("Recepcionar Pedido");
        btnRecept.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRecept.setPreferredSize(new java.awt.Dimension(140, 30));
        btnRecept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceptActionPerformed(evt);
            }
        });

        btnVolverRecep.setBackground(new java.awt.Color(255, 255, 255));
        btnVolverRecep.setFont(new java.awt.Font("Aharoni", 0, 13)); // NOI18N
        btnVolverRecep.setForeground(new java.awt.Color(105, 205, 243));
        btnVolverRecep.setText("Volver");
        btnVolverRecep.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVolverRecep.setPreferredSize(new java.awt.Dimension(60, 30));
        btnVolverRecep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverRecepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRecept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolverRecep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolverRecep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(105, 205, 243));
        jSeparator1.setForeground(new java.awt.Color(105, 205, 243));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(105, 205, 243));
        jLabel1.setText("Recepción de Productos:");

        jSeparator2.setBackground(new java.awt.Color(105, 205, 243));
        jSeparator2.setForeground(new java.awt.Color(105, 205, 243));

        btnGenerar.setBackground(new java.awt.Color(105, 205, 243));
        btnGenerar.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setText("Generar PDF");
        btnGenerar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(105, 205, 243));
        jLabel2.setText("Número Orden de Compra: ");

        lblCode.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnVer.setBackground(new java.awt.Color(105, 205, 243));
        btnVer.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        btnVer.setForeground(new java.awt.Color(255, 255, 255));
        btnVer.setText("Visualizar");
        btnVer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        btnExportar.setBackground(new java.awt.Color(105, 205, 243));
        btnExportar.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        btnExportar.setForeground(new java.awt.Color(255, 255, 255));
        btnExportar.setText("Exportar");
        btnExportar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBarCode))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 9, Short.MAX_VALUE)))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 830, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverRecepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverRecepActionPerformed
        sesionEmpleado se = new sesionEmpleado();
        se.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverRecepActionPerformed

    private void rdbAprobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAprobActionPerformed
        estado="aprobado";
    }//GEN-LAST:event_rdbAprobActionPerformed

    private void rdbRechazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbRechazaActionPerformed
        estado="rechazado";
    }//GEN-LAST:event_rdbRechazaActionPerformed

    private void rdbPendiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPendiActionPerformed
        estado="pendiente";
    }//GEN-LAST:event_rdbPendiActionPerformed

    private void tablaOcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOcMouseClicked
        btnRecept.setText("Editar");
        
        int fila = tablaOc.rowAtPoint(evt.getPoint());
        id_registro = Integer.parseInt(tablaOc.getValueAt(fila, 0).toString());
        String estado = tablaOc.getValueAt(fila, 1).toString();
        
        if(estado.equals("aprobado")){
            rdbAprob.setSelected(true);
        }
        if(estado.equals("rechazado")){
            rdbRechaza.setSelected(true);
        }
        if(estado.equals("pendiente")){
            rdbPendi.setSelected(true);
        }
    }//GEN-LAST:event_tablaOcMouseClicked

    private void btnReceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceptActionPerformed
        try {
            Statement st = con.conectar().createStatement();
            String query = "UPDATE ORDEN_PEDIDO SET ESTADO = '"+estado+"' WHERE ID_ORDEN = "+id_registro+"";
            st.executeQuery(query);
            mostrar("");
            msj.mensajeModificado();
        } catch (SQLException ex) {
            Logger.getLogger(RecepcionarProd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReceptActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        try{
           JasperReport reporte = JasperCompileManager.compileReport("reportOC.jrxml");
           JasperPrint print = JasperFillManager.fillReport(reporte, null, con.conectar());
           JasperViewer.viewReport(print);
       }catch (Exception e){
           System.out.print(e.getMessage());
            } 
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        Barcode barcode = null;
        if (txtBarCode.getText().length()==0) {
                msj.mensajeCampoVacio();
            }
        try {
               barcode = BarcodeFactory.createCode39(txtBarCode.getText(), true);
        } catch (Exception e) {
        }
        barcode.setDrawingText(false);
        
        barcode.setBarWidth(2);
        barcode.setBarHeight(60);
        
        BufferedImage image = new BufferedImage(300, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        
        try {
            barcode.draw(g, 5, 20);
        } catch (Exception e) {
            
        }
        ImageIcon icon = new ImageIcon(image);
        lblCode.setIcon(icon);
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        Barcode barcode = null;
        if (txtBarCode.getText().length()==0) {
                msj.mensajeCampoVacio();
            }
        try {
               barcode = BarcodeFactory.createCode39(txtBarCode.getText(), true);
        } catch (Exception e) {
        }
        barcode.setDrawingText(false);
        
        barcode.setBarWidth(2);
        barcode.setBarHeight(60);
        
        try {
            FileOutputStream fos = new FileOutputStream("D:/Proyectos Java/CentroOdontologico/bar/etiqueta1.png");
            try {
                BarcodeImageHandler.writePNG(barcode, fos);
            } catch (OutputException ex) {
                Logger.getLogger(RecepcionarProd.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecepcionarProd.class.getName()).log(Level.SEVERE, null, ex);
        }
        int dialogButton = 0;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Está seguro que desea guardar el código de barra?","Warning",dialogButton);
    }//GEN-LAST:event_btnExportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnRecept;
    private javax.swing.JButton btnVer;
    private javax.swing.JButton btnVolverRecep;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblTotal;
    public static javax.swing.JRadioButton rdbAprob;
    public static javax.swing.JRadioButton rdbPendi;
    public static javax.swing.JRadioButton rdbRechaza;
    private javax.swing.JTable tablaOc;
    private javax.swing.JFormattedTextField txtBarCode;
    // End of variables declaration//GEN-END:variables

}
