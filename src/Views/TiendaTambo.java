/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import Controller.VentaController;
import javax.swing.table.DefaultTableModel;
import Beans.Venta;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author FERNANDO
 */
public class TiendaTambo extends javax.swing.JFrame {

    /**
     * Creates new form TiendaTambo
     */
    VentaController ventaController = new VentaController();
    //double precios [] = {8.50, 3.50, 3.70, 0.80, 2.70, 1.20, 8.50, 2.70, 27.80, 3.20};
    int cantidad = 0;
    float precio;
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<Venta> listaVentas = new ArrayList<Venta>();
    List<String> listaTipoProducto = new ArrayList<String>();
    List<String> listaNombreProducto = new ArrayList<String>();
    
    public TiendaTambo() {
        initComponents();
        DefaultComboBoxModel tipoProductoModel = new DefaultComboBoxModel();
        listaTipoProducto = ventaController.rellenarTipoProducto();
        for (int i = 0; i < listaTipoProducto.size(); i++) {
            tipoProductoModel.addElement(listaTipoProducto.get(i));
        }
        cbTipoProducto.setModel(tipoProductoModel);
        this.setTitle("TIENDA TAMBO");
        this.setLocationRelativeTo(null);
        model.addColumn("DESCRIPCION");
        model.addColumn("PRECIO");
        model.addColumn("CANTIDAD");
        model.addColumn("IMPORTE");
        actualizarTabla();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        cbTipoProducto = new javax.swing.JComboBox<>();
        spnCantidad = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblImporte = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbNombreProducto = new javax.swing.JComboBox<>();
        btnRealizarVenta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tipo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Cantidad");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Precio");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Importe");

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAgregar.setText("+");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        cbTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoProductoActionPerformed(evt);
            }
        });

        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        spnCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCantidadStateChanged(evt);
            }
        });

        tblProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Descripcion", "Precio", "Cantidad", "Importe"
            }
        ));
        jScrollPane1.setViewportView(tblProductos);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("TOTAL");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("S/ 0.00");

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPrecio.setText(" 0.00");

        lblImporte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblImporte.setText(" 0.00");

        jLabel13.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 24)); // NOI18N
        jLabel13.setText("TIENDA");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Producto");

        cbNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNombreProductoActionPerformed(evt);
            }
        });

        btnRealizarVenta.setText("Realizar Venta");
        btnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVentaActionPerformed(evt);
            }
        });

        jLabel6.setText("S/.");

        jLabel8.setText("S/.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(562, 562, 562))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbTipoProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spnCantidad))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPrecio))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblImporte)))
                                .addGap(35, 35, 35)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(55, 55, 55)
                                    .addComponent(lblTotal))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(507, 507, 507)
                                    .addComponent(btnRealizarVenta))))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTipoProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel1)
                                        .addComponent(cbNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(lblPrecio)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(lblImporte)
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRealizarVenta)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoProductoActionPerformed
        DefaultComboBoxModel nombreProductoModel = new DefaultComboBoxModel();
        listaNombreProducto = ventaController.rellenarNombreProducto(cbTipoProducto.getSelectedItem().toString());
        for (int i = 0; i < listaNombreProducto.size(); i++) {
            nombreProductoModel.addElement(listaNombreProducto.get(i));
        }
        cbNombreProducto.setModel(nombreProductoModel);
        //lblPrecio.setText(ventaController.verPrecio(cbNombreProducto.getSelectedItem().toString()));
    }//GEN-LAST:event_cbTipoProductoActionPerformed

    private void spnCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCantidadStateChanged
        
    }//GEN-LAST:event_spnCantidadStateChanged

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int cantidad = Integer.parseInt(spnCantidad.getValue().toString());
        Venta venta = new Venta();
        venta.setDescripcion(cbNombreProducto.getSelectedItem().toString());
        venta.setPrecio(Float.parseFloat(lblPrecio.getText()));
        venta.setCantidad(cantidad);
        venta.setImporte(Float.parseFloat(lblPrecio.getText())*cantidad);
        
        if(!buscarVenta(venta)){
            listaVentas.add(venta);
        }
        
        actualizarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cbNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNombreProductoActionPerformed
        // TODO add your handling code here:
        float precio = ventaController.verPrecio(cbNombreProducto.getSelectedItem().toString());
        lblPrecio.setText(Float.toString(precio));
        lblImporte.setText(Float.toString(precio));
        
        SpinnerNumberModel nm = new SpinnerNumberModel();
        if(ventaController.cantidadProducto(cbNombreProducto.getSelectedItem().toString()) > 0){
            nm.setValue(1);
            nm.setMaximum(ventaController.cantidadProducto(cbNombreProducto.getSelectedItem().toString()));
            nm.setMinimum(1);
            nm.setStepSize(1);
        }
        else{
            nm.setValue(0);
            nm.setMaximum(0);
            nm.setMinimum(0);
            nm.setStepSize(0);
        }
        spnCantidad.setModel(nm);
        calcularPrecio(precio);
    }//GEN-LAST:event_cbNombreProductoActionPerformed

    private void btnRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVentaActionPerformed
        for (int i = 0; i < listaVentas.size(); i++) {
            String nombreProducto = listaVentas.get(i).getDescripcion();
            int cantidad = listaVentas.get(i).getCantidad();
            float importe = listaVentas.get(i).getImporte();
            ventaController.actualizarCantidad(nombreProducto, cantidad);
            ventaController.detalleVenta(nombreProducto, cantidad, importe);
            
        }
        JOptionPane.showMessageDialog(null, "Venta Exitosa!!");
        listaVentas.clear();
        actualizarTabla();
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    public boolean buscarVenta(Venta nueva){
        SpinnerNumberModel spinner = (SpinnerNumberModel)spnCantidad.getModel();
        for(Venta v : listaVentas){
            if(v.getDescripcion() == nueva.getDescripcion()){
                int nuevaCantidad = v.getCantidad() + nueva.getCantidad();
                if(nuevaCantidad > Integer.parseInt(spinner.getMaximum().toString())){
                    JOptionPane.showMessageDialog(null,"Stock insuficiente");
                }
                else{
                    v.setImporte(v.getPrecio()*nuevaCantidad);
                    v.setCantidad(nuevaCantidad);
                }
                return true;
            }
        }
        return false;
    }
    
    public void calcularPrecio(float precio)
    {
        cantidad = Integer.parseInt(spnCantidad.getValue().toString());
        lblPrecio.setText(Float.toString(precio));
        float importe = (float)(precio*cantidad);
        lblImporte.setText(Float.toString(importe));
    }
    
    public void actualizarTabla() {
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        
        float total = 0;
        
        for(Venta v : listaVentas){
            Object x[] = new Object[4];
            x[0] = v.getDescripcion();
            x[1] = (v.getPrecio());
            x[2] = v.getCantidad();
            x[3] = (v.getImporte());
            total+=v.getImporte();
            model.addRow(x);
        }
        
        lblTotal.setText(Float.toString(total));
        tblProductos.setModel(model);
    }
    
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
            java.util.logging.Logger.getLogger(TiendaTambo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TiendaTambo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TiendaTambo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TiendaTambo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TiendaTambo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JComboBox<String> cbNombreProducto;
    private javax.swing.JComboBox<String> cbTipoProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImporte;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables

    
}
