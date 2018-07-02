package Presentacion;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class vistaProducto extends javax.swing.JFrame {
    
    public Integer totalregistros;
    
    
    public vistaProducto() {
        initComponents();
        mostrar("");
        this.setLocationRelativeTo(null);
    }
    
    void ocultar_columnas() {
        tablaProd.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaProd.getColumnModel().getColumn(0).setMinWidth(0);
        tablaProd.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    public DefaultTableModel mostrarDatos(String buscar){
       DefaultTableModel modelo;
       JTableHeader Theader = tablaProd.getTableHeader();
       Theader.setBackground(Color.decode("#69CDF3"));
       Theader.setForeground(Color.white);
       Theader.setFont(new Font("Calibri", Font.PLAIN, 15));
       String [] titulos = {"ID","Nombre","Fecha de Vencimiento","Valor","Id Marca"};
       
       String [] registro =new String [5];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "administrador", "admin");
            Statement stat = con.createStatement();
            String selectQuery = "select * from PRODUCTO where NOMBRE like '%"+ buscar + "%' order by ID_PRODUCTO desc";
            ResultSet rs=stat.executeQuery(selectQuery);
            while(rs.next()){
               registro [0]=rs.getString("ID_PRODUCTO");
               registro [1]=rs.getString("NOMBRE");
               registro [2]=rs.getString("FECHA_VENCIMIENTO");
               registro [3]=rs.getString("VALOR");
               registro [4]=rs.getString("ID_MARCA");
               
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           
        } catch (SQLException ex) {
            Logger.getLogger(agregarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
          return modelo;
    }
    
    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            modelo = mostrarDatos(buscar);

            tablaProd.setModel(modelo);
            ocultar_columnas();
            lblTotal.setText("Total Registros " + Integer.toString(totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        btnVolverListaProd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProd = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTotal.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(105, 205, 243));
        lblTotal.setText("Total");

        btnVolverListaProd.setBackground(new java.awt.Color(105, 205, 243));
        btnVolverListaProd.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnVolverListaProd.setForeground(new java.awt.Color(255, 255, 255));
        btnVolverListaProd.setText("Volver");
        btnVolverListaProd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVolverListaProd.setPreferredSize(new java.awt.Dimension(100, 25));
        btnVolverListaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverListaProdActionPerformed(evt);
            }
        });

        tablaProd.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProd.setGridColor(new java.awt.Color(105, 205, 243));
        tablaProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProdMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProd);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal)
                    .addComponent(btnVolverListaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVolverListaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverListaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverListaProdActionPerformed
        agregarProductos ap = new agregarProductos();
        ap.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverListaProdActionPerformed

    private void tablaProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProdMousePressed
        if (evt.getClickCount()==2) {
            int fila= tablaProd.getSelectedRow();
            
            String valor0, valor1, valor2, valor3, valor4;
            
            valor0=tablaProd.getValueAt(fila,0).toString();
            valor1=tablaProd.getValueAt(fila,1).toString();
            valor2=tablaProd.getValueAt(fila,2).toString();
            valor3=tablaProd.getValueAt(fila,3).toString();
            valor4=tablaProd.getValueAt(fila,4).toString();
           
            agregarProductos.txtIdProducto.setText(valor0);
            agregarProductos.txtProduct.setText(valor1);
            agregarProductos.txtFecha.setText(valor2);
            agregarProductos.txtValor.setText(valor3);
            agregarProductos.txtMarca.setText(valor4);
            
            this.setVisible(false);
            
            
            
            
        }
    }//GEN-LAST:event_tablaProdMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolverListaProd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaProd;
    // End of variables declaration//GEN-END:variables
}
