/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Beans.Categoria;
import Views.MantenimientoCategoriaProducto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author eldia
 */
public class MantenimientoCategoriaController {
    private MantenimientoCategoriaProducto mantenimientoCategoria;

    public MantenimientoCategoriaController(MantenimientoCategoriaProducto mantenimientoCategoria) {
        this.mantenimientoCategoria = mantenimientoCategoria;
    }
    
    public void consultaCategoria(){
        DefaultTableModel modelo = new DefaultTableModel();
        List<Categoria> listaCategoria = new ArrayList<Categoria>();
        Object[] rowdata = new Object[1];
        try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT nombreCategoria FROM categoriaproducto");
            
            while (registro.next()) {                
                Categoria categoria = new Categoria(registro.getString("nombreCategoria"));
                listaCategoria.add(categoria);
            }
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Categoria");
        for (int i = 0; i < listaCategoria.size(); i++) {
            rowdata[0] = listaCategoria.get(i).getNombreCategoria();
            modelo.addRow(rowdata);
        }
        mantenimientoCategoria.tblCategorias.setModel(modelo);
    }
    
    public String buscarCategoria(String categoria){
        String categoriabuscada = "";
        try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT nombreCategoria FROM categoriaproducto WHERE nombreCategoria = '" + categoria + "'");
            
            registro.next();
            categoriabuscada = registro.getString("nombreCategoria");
            conexion.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoriabuscada;
    }
    
    public void agregarCategoria(){
        String categoria = mantenimientoCategoria.txtNuevaCategoria.getText();
        int resp = JOptionPane.showConfirmDialog(mantenimientoCategoria, "¿Esta seguro de agregar la categoria: " + categoria + " ? ", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {
            try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            consulta.execute("INSERT INTO categoriaproducto VALUES ('" + categoria + "')");
            
            conexion.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        }  
    }
    
    public void actualizarCategoria(){
        String categoria = (String) mantenimientoCategoria.tblCategorias.getValueAt(mantenimientoCategoria.tblCategorias.getSelectedRow(), 0);
        String nuevacategoria = mantenimientoCategoria.txtActualizarCategoria.getText();
        int resp = JOptionPane.showConfirmDialog(mantenimientoCategoria, "¿Esta seguro de actualizar la categoria: " + categoria + " a " + nuevacategoria + "? ", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {
            try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            consulta.execute("UPDATE categoriaproducto SET nombreCategoria = '" + nuevacategoria + "' WHERE nombreCategoria = '" + categoria + "'");
            
            conexion.close();
            
            
            } catch (Exception e) {
            e.printStackTrace();
            }
        } else {
            
        }
        
    }
    
    public void eliminarCategoria(){
        String categoria = (String) mantenimientoCategoria.tblCategorias.getValueAt(mantenimientoCategoria.tblCategorias.getSelectedRow(), 0);
        int resp = JOptionPane.showConfirmDialog(mantenimientoCategoria, "¿Esta seguro de eliminar la categoria: " + categoria + " ? ", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {
            try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            consulta.execute("DELETE FROM categoriaproducto WHERE nombreCategoria = '" + categoria + "'");
            
            conexion.close();
            
            
            } catch (Exception e) {
            e.printStackTrace();
            }
        }
        
    }
}
