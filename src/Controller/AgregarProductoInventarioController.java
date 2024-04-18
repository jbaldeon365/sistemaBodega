/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Beans.Inventario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eldia
 */
public class AgregarProductoInventarioController {
    
    public List<String> rellenarTipoProducto(){
        List<String> lista = new ArrayList<String>();
        try {
            
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT * FROM categoriaproducto");
            
            while (registro.next()) {                
                lista.add(registro.getString("nombreCategoria"));
            }
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<String> rellenarNombreProducto(String tipoProducto){
        List<String> lista = new ArrayList<String>();
        try {
            
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT nombreProducto FROM producto WHERE nombreCategoria = '" + tipoProducto + "'");
            
            while (registro.next()) {                
                lista.add(registro.getString("nombreProducto"));
            }
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void insertarProductoInventario(List<Inventario> inventario){
        try {
            
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            for (int i = 0; i < inventario.size(); i++) {
                consulta.execute("INSERT INTO inventario VALUES ('" + inventario.get(i).getLoteProducto() + "','"+ inventario.get(i).getNombreProducto()+ "',"+
                "'"+ inventario.get(i).getFechaVencimientoProducto()+"'," + inventario.get(i).getCantidadProducto()+")" );
            }
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
