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
public class InventarioController {

    public List<Inventario> consultaInventario(){
        List<Inventario> listaInventario = new ArrayList<Inventario>();
        try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT Lote, nombreCategoria, inventario.nombreProducto, fechaCaducidad, cantidadProducto FROM inventario inner join producto on inventario.nombreProducto = producto.nombreProducto");
            
            while (registro.next()) {                
                Inventario inventario = new Inventario(registro.getInt("cantidadProducto"), registro.getString("nombreCategoria"), registro.getString("nombreProducto"), registro.getString("fechaCaducidad"), registro.getString("Lote"));
                listaInventario.add(inventario);
            }
            conexion.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaInventario;
    }
    
    public float calculoValorTotal(String tipoProducto, String nombreProducto){
        float suma =0;
        try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT cantidadProducto, precio FROM inventario inner join producto on inventario.nombreProducto = producto.nombreProducto"
                    + " WHERE nombreCategoria LIKE '%" + tipoProducto + "%' AND inventario.nombreProducto LIKE '%" + nombreProducto + "%'");
            
            
            while (registro.next()) {                
                suma += (float)(registro.getInt("cantidadProducto") * registro.getFloat("precio"));
            }
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suma;
    }
    
    public List<String> rellenarTipoProducto(){
        List<String> lista = new ArrayList<String>();
        try {
            
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT * FROM categoriaproducto");
            
            lista.add("");
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
            
            lista.add("");
            while (registro.next()) {                
                lista.add(registro.getString("nombreProducto"));
            }
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<Inventario> buscarInventario(String tipoProducto, String nombreProducto){
        List<Inventario> listaInventario = new ArrayList<Inventario>();
        try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT Lote, nombreCategoria, inventario.nombreProducto, fechaCaducidad, cantidadProducto FROM inventario "
                    + "INNER JOIN producto ON inventario.nombreProducto = producto.nombreProducto WHERE nombreCategoria LIKE '%" + tipoProducto + "%' AND inventario.nombreProducto LIKE '%" + nombreProducto + "%'" );
            
            while (registro.next()) {                
                Inventario inventario = new Inventario(registro.getInt("cantidadProducto"), registro.getString("nombreCategoria"), registro.getString("nombreProducto"), registro.getString("fechaCaducidad"), registro.getString("Lote"));
                listaInventario.add(inventario);
            }
            conexion.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaInventario;
    }
}
