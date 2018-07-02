package Presentacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Datos.dOrden;
import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import javax.swing.table.JTableHeader;


public class agregarProductos extends javax.swing.JFrame {
    //public static String idorden;
    public Integer totalregistros;
    public Double totalconsumo;
    private String accion = "guardar";
    int maxId, totalproductos;
    
    
    public agregarProductos() {
        initComponents();
        mostrarTabla("");
        this.setLocationRelativeTo(null);
        inhabilitar();
    }

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    void mostrarTabla(String buscar) {
        try {
            DefaultTableModel model;
            model = mostrar(buscar);

            tablalistado.setModel(model);
            lbltotalregistros.setText("Total Registros " + Integer.toString(totalregistros));
            lblconsumo.setText("Productos Totales" + totalproductos);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    
    
    //------Método Mostrar----------------------------------------------------------------------------
    
    public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       JTableHeader Theader = tablalistado.getTableHeader();
        Theader.setBackground(Color.decode("#69CDF3"));
        Theader.setForeground(Color.white);
        Theader.setFont(new Font("Calibri", Font.PLAIN, 15));
       String [] titulos = {"Nombre Producto", "Cantidad", "Id Orden de Compra"};
       
       String [] registro =new String [3];
       totalproductos=0;
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
        try {          
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "administrador", "admin");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT t2.NOMBRE, t1.CANTIDAD, t1.ID_ORDEN\n" +
                                           "FROM ORDENPRODUCTO t1\n" +
                                           "INNER JOIN PRODUCTO t2 ON t1.ID_PRODUCTO = t2.ID_PRODUCTO\n" +
                                           "WHERE t1.ID_ORDEN = " + maxId +"");
            
            
            while(rs.next()){
            registro [0]=rs.getString("NOMBRE");
            registro [1]=rs.getString("CANTIDAD");
            registro [2]=rs.getString("ID_ORDEN");
            totalregistros=totalregistros+1;
            totalproductos=totalproductos + (rs.getInt("CANTIDAD"));
            
            modelo.addRow(registro);
            
            }
    
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        return modelo;
        }
    
    
    
    
    
    //-----Metodo Ingresar Productos----------------------------------------------------------------------
    
    public boolean insertar (dOrden dts){
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "administrador", "admin");
            String selectQuery =  "insert into ORDENPRODUCTO (CANTIDAD, ID_PRODUCTO, ID_ORDEN)" +
                    "values (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(selectQuery);
            pst.setInt(1, Integer.parseInt(txtCantidad.getText()));                                                                                              
            pst.setInt(2, Integer.parseInt(txtIdProducto.getText()));
            pst.setInt(3, maxId);
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
           return false;
        }
       
   }
    
   
    public void infoMessage(String message, String tittle) {
        JOptionPane.showMessageDialog(null, message, tittle, JOptionPane.INFORMATION_MESSAGE);
    }
    
    void inhabilitar(){
        txtProduct.setEnabled(false);
        txtCantidad.setEnabled(false);
        txtFecha.setEnabled(false);
        txtValor.setEnabled(false);
        txtMarca.setEnabled(false);
        btnGuardar.setEnabled(false);
        txtIdProducto.setVisible(false);
        
        txtProduct.setText("");
        txtCantidad.setText("");
        txtFecha.setText("");
        txtValor.setText("");
        txtMarca.setText("");
    }
    
    void habilitar(){
        btnGuardar.setEnabled(true);
        txtCantidad.setEnabled(true);      
        txtCantidad.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        txtIdProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtValor = new javax.swing.JFormattedTextField();
        txtMarca = new javax.swing.JTextField();
        lbltotalregistros = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtProduct = new javax.swing.JTextField();
        btnSelectProd = new javax.swing.JButton();
        lblconsumo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnVolverProd = new javax.swing.JButton();
        btnGuardarProd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(850, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnGuardar.setBackground(new java.awt.Color(105, 205, 243));
        btnGuardar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Agregar Producto");
        btnGuardar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(105, 205, 243));
        jLabel2.setText("Cantidad");

        txtCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 205, 243)));
        txtCantidad.setForeground(new java.awt.Color(105, 205, 243));
        txtCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtCantidad.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 205, 243));
        jLabel3.setText("Fecha");

        jLabel4.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(105, 205, 243));
        jLabel4.setText("Valor");

        jLabel5.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(105, 205, 243));
        jLabel5.setText("Marca");

        txtFecha.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(105, 205, 243));
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 205, 243)));

        txtValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 205, 243)));
        txtValor.setForeground(new java.awt.Color(105, 205, 243));

        txtMarca.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(105, 205, 243));
        txtMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 205, 243)));

        lbltotalregistros.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(105, 205, 243));
        lbltotalregistros.setText("Registros:");

        jLabel1.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(105, 205, 243));
        jLabel1.setText("Producto");

        txtProduct.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        txtProduct.setForeground(new java.awt.Color(105, 205, 243));
        txtProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 205, 243)));
        txtProduct.setPreferredSize(new java.awt.Dimension(4, 17));

        btnSelectProd.setBackground(new java.awt.Color(105, 205, 243));
        btnSelectProd.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnSelectProd.setForeground(new java.awt.Color(255, 255, 255));
        btnSelectProd.setText("Nuevo Producto");
        btnSelectProd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSelectProd.setPreferredSize(new java.awt.Dimension(140, 25));
        btnSelectProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectProdActionPerformed(evt);
            }
        });

        lblconsumo.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        lblconsumo.setForeground(new java.awt.Color(105, 205, 243));
        lblconsumo.setText("Total: ");

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado.setFocusable(false);
        tablalistado.setGridColor(new java.awt.Color(105, 205, 243));
        tablalistado.setRequestFocusEnabled(false);
        tablalistado.setRowSelectionAllowed(false);
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        jPanel2.setBackground(new java.awt.Color(105, 205, 243));

        jLabel6.setFont(new java.awt.Font("Aharoni", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Agregar Productos");

        btnVolverProd.setBackground(new java.awt.Color(255, 255, 255));
        btnVolverProd.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnVolverProd.setForeground(new java.awt.Color(105, 205, 243));
        btnVolverProd.setText("Volver");
        btnVolverProd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVolverProd.setPreferredSize(new java.awt.Dimension(100, 25));
        btnVolverProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 530, Short.MAX_VALUE)
                .addComponent(btnVolverProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnVolverProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnGuardarProd.setBackground(new java.awt.Color(105, 205, 243));
        btnGuardarProd.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnGuardarProd.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarProd.setText("Guardar Productos");
        btnGuardarProd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGuardarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(5, 5, 5)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3)
                                .addGap(5, 5, 5)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel4)
                                .addGap(5, 5, 5)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(5, 5, 5)
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(11, 11, 11)
                        .addComponent(btnSelectProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(lbltotalregistros)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblconsumo)
                                .addGap(98, 98, 98)))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel1))
                            .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel2))
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel3))
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4))
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel5))
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelectProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltotalregistros)
                            .addComponent(lblconsumo))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverProdActionPerformed
        generarOc go = new generarOc();
        go.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverProdActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        int fila = tablalistado.rowAtPoint(evt.getPoint());
        txtIdProducto.setText(tablalistado.getValueAt(fila, 0).toString());
        txtProduct.setText(tablalistado.getValueAt(fila, 1).toString());
        txtFecha.setText(tablalistado.getValueAt(fila, 2).toString());
        txtValor.setText(tablalistado.getValueAt(fila, 3).toString());
        txtMarca.setText(tablalistado.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnSelectProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectProdActionPerformed
        vistaProducto form = new vistaProducto();
        form.toFront();
        form.setVisible(true);
        habilitar();
    }//GEN-LAST:event_btnSelectProdActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtProduct.getText().length() == 0) {
            infoMessage("Debe seleccionar un producto", "No se detectan productos");
            btnSelectProd.requestFocus();
            return;
        }
        if (txtCantidad.getText().length() == 0 || txtCantidad.getText().equals("0")) {
            infoMessage("Debe ingresar una cantidad", "No se detectan productos");
            txtCantidad.requestFocus();
            return;
        }

        dOrden dts = new dOrden();

        dts.setCantidad(Integer.parseInt(txtCantidad.getText()));

        if(accion.equals("guardar")){
            if(insertar(dts)){
                infoMessage("Producto guardado", "Se ha insertado el producto correctamente");
                mostrarTabla("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProdActionPerformed
        int dialogButton = 0;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Está seguro que desea guardar estos productos?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            sesionEmpleado se = new sesionEmpleado();
            se.setVisible(true);
            dispose();
        }        
    }//GEN-LAST:event_btnGuardarProdActionPerformed


                                             


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarProd;
    private javax.swing.JButton btnSelectProd;
    private javax.swing.JButton btnVolverProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblconsumo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistado;
    public static javax.swing.JFormattedTextField txtCantidad;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtIdProducto;
    public static javax.swing.JTextField txtMarca;
    public static javax.swing.JTextField txtProduct;
    public static javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables



}

