package Presentacion;

import Negocios.utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Negocios.mensajes;


public class generarOc extends javax.swing.JFrame implements utilidades{
    
    String user;

    public generarOc() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private String estado;


    @Override
    public void limpiar(){
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        rdbRechaza = new javax.swing.JRadioButton();
        rdbPend = new javax.swing.JRadioButton();
        rdbAprob = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        dateOc = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVolverOc = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnAgregar.setBackground(new java.awt.Color(105, 205, 243));
        btnAgregar.setFont(new java.awt.Font("Aharoni", 0, 13)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Generar Orden de Compra");
        btnAgregar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        rdbRechaza.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbRechaza);
        rdbRechaza.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        rdbRechaza.setText("Rechazado");
        rdbRechaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbRechazaActionPerformed(evt);
            }
        });

        rdbPend.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbPend);
        rdbPend.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        rdbPend.setText("Pendiente");
        rdbPend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPendActionPerformed(evt);
            }
        });

        rdbAprob.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbAprob);
        rdbAprob.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        rdbAprob.setText("Aprobado");
        rdbAprob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAprobActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 205, 243));
        jLabel3.setText("Estado:");

        dateOc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 205, 243)));
        dateOc.setForeground(new java.awt.Color(105, 205, 243));
        dateOc.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        dateOc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOcActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(105, 205, 243));
        jLabel2.setText("Fecha:");

        jPanel2.setBackground(new java.awt.Color(105, 205, 243));

        btnVolverOc.setBackground(new java.awt.Color(255, 255, 255));
        btnVolverOc.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnVolverOc.setForeground(new java.awt.Color(105, 205, 243));
        btnVolverOc.setText("Volver");
        btnVolverOc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVolverOc.setPreferredSize(new java.awt.Dimension(100, 25));
        btnVolverOc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverOcActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Generar Orden de Compra");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolverOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolverOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(125, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(135, 135, 135))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel2)
                            .addGap(8, 8, 8))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap(12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGap(5, 5, 5)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateOc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(rdbAprob)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rdbPend)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rdbRechaza)))
                    .addGap(58, 58, 58)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbRechaza)
                    .addComponent(rdbPend)
                    .addComponent(rdbAprob)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverOcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverOcActionPerformed
        sesionEmpleado se = new sesionEmpleado();
        se.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverOcActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
            
            mensajes msj = new mensajes();
            String emp = log.empleado;           
            int maxId = 0;
            
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "administrador", "admin");
            
            String selectQuery =  "insert into ORDEN_PEDIDO( ESTADO, FECHA, ID_EMPLEADO)" +
                    "values (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(selectQuery);
            pst.setString(1, estado);
            pst.setString(2, dateOc.getEditor().getText());
            pst.setString(3, emp);
            pst.execute();
                        Statement st = con.createStatement();
			String query = "SELECT MAX(ID_ORDEN) from ORDEN_PEDIDO";
			ResultSet rs = st.executeQuery(query);
                        while(rs.next())
                        maxId=rs.getInt(1);
                msj.mensajeLogrado();
                
        agregarProductos ap = new agregarProductos();
        ap.maxId = maxId;
        ap.setVisible(true);
        dispose();
            
        } catch (Exception e) {
            msj.mensajeCampoVacio();  
        }
               
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void rdbAprobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAprobActionPerformed
        estado="aprobado";
    }//GEN-LAST:event_rdbAprobActionPerformed

    private void rdbPendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPendActionPerformed
        estado="pendiente";
    }//GEN-LAST:event_rdbPendActionPerformed

    private void rdbRechazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbRechazaActionPerformed
        estado="rechazado";
    }//GEN-LAST:event_rdbRechazaActionPerformed

    private void dateOcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOcActionPerformed
        
    }//GEN-LAST:event_dateOcActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVolverOc;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker dateOc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rdbAprob;
    private javax.swing.JRadioButton rdbPend;
    private javax.swing.JRadioButton rdbRechaza;
    // End of variables declaration//GEN-END:variables

}
