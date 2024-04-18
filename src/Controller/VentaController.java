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
 * @author FERNANDO
 */
public class VentaController {
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
            
        }  catch (Exception e) {
           e.printStackTrace();
        }
        return lista;
    }
    
    public int cantidadProducto(String nombreProducto){
        int cantidad=0;
        try{
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT cantidadProducto FROM inventario WHERE nombreProducto = '"+nombreProducto+"'");
            if(registro.next() == true){
                cantidad = registro.getInt("cantidadProducto");
            }
            else{
                cantidad = 0;
            }
            conexion.close();
        }
        catch (Exception e) {
           e.printStackTrace();
        }
        return cantidad;
    }
    
    public float verPrecio(String nombreProducto){
        float precio = 0;
        try {
            
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT precio FROM producto WHERE nombreProducto LIKE '%" + nombreProducto + "%'");
            registro.next();
            precio = registro.getFloat("precio");
            conexion.close();
            
        }  catch (Exception e) {
           e.printStackTrace();
        }
        return precio;
    }
    
    public void actualizarCantidad(String nombreProducto, int nuevaCantidad){
        try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            consulta.execute("UPDATE inventario SET cantidadProducto = cantidadProducto - "+nuevaCantidad+" WHERE nombreProducto = '" + nombreProducto + "'");
            
            conexion.close();
            
        }  catch (Exception e) {
           e.printStackTrace();
        }
    }
    
    public void detalleVenta(String nombreProducto, int nuevaCantidad, float importeTotal){
        try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            consulta.execute("INSERT INTO ventadetalle VALUES (NOW(),'"+nombreProducto+"',"+nuevaCantidad+","+importeTotal+")");
            
            conexion.close();
            
        }  catch (Exception e) {
           e.printStackTrace();
        }
    }
    
    public Inventario buscarInventario(String tipoProducto, String nombreProducto){
        Inventario inventario = new Inventario();
        try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT Lote, nombreCategoria, inventario.nombreProducto, fechaCaducidad, cantidadProducto FROM inventario "
                    + "INNER JOIN producto ON inventario.nombreProducto = producto.nombreProducto WHERE nombreCategoria LIKE '" + tipoProducto + "' AND inventario.nombreProducto LIKE '%" + nombreProducto + "%'" );
            
            while (registro.next()) {                
                inventario = new Inventario(registro.getInt("cantidadProducto"), registro.getString("nombreCategoria"), registro.getString("nombreProducto"), registro.getString("fechaCaducidad"), registro.getString("Lote"));
            }
            conexion.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventario;
    }
    
    public void reporteInventario(String nombreProducto, int nuevaCantidad){
        Inventario inventario = new Inventario();
        try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            //consulta.execute("INSERT INTO reporteinventario VALUES ("+ + " ,NOW(),'"++"',"++","++")");
            
            conexion.close();
        } catch (Exception e) {
        }
    }
}
