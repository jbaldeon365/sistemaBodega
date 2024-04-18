/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Beans.ProductoAgregar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miky_
 */
public class ProductoAgregarController {
        private List<ProductoAgregar>lst;
    
    public ProductoAgregarController(){
        lst = new ArrayList<ProductoAgregar>();
        rellenarTipoProducto();          
    }
   //Agregar objetos al arreglo
    public void add(ProductoAgregar obj){
       lst.add(obj);
    }
   //Obtener un objeto
    public ProductoAgregar get(int indice){
        return lst.get(indice);
    }
   //Tamaño total
    public int size(){
        return lst.size();
    }
    
    
   //Eliminar objetos
    public void remove(ProductoAgregar objpro){
        lst.remove(objpro);
    }
    
    //Coorelativo - Indetity
    public int getCorrelativo(){
       if(lst.size() == 0){
         return 1;
       }else{
           return lst.get(lst.size()-1).getCodigo() + 1;
       }
    }
    
    public ProductoAgregar buscar(String nom){
     for(ProductoAgregar aux:lst)                   
         if(aux.getNombre().equalsIgnoreCase(nom))
             return aux;
    return null;
    }  
    public ProductoAgregar buscar2(String nom){
     for(int i=0;i<lst.size();i++)
         if(lst.get(i).getNombre().equalsIgnoreCase(nom))
             return lst.get(i);
    return null;
    }  
    public ProductoAgregar buscar(int cod){
     for(int i=0;i<lst.size();i++)
         if(lst.get(i).getCodigo() == cod)
             return lst.get(i);
    return null;
    }  
    
    public double getTotalPrecio(){
       double st=0;
       for(int i=0;i<lst.size();i++){
           st+=lst.get(i).getPrecio();
       }   
        return st;
    }  
    //PASAR A SQL
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
   
    public void grabarProducto(String tipoProducto, String nombreProducto, float precioTotal){
        try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            consulta.execute("INSERT INTO producto VALUES ('"+nombreProducto+"','"+tipoProducto+"',"+precioTotal+")");
            
            conexion.close();
            
        }  catch (Exception e) {
           e.printStackTrace();
        }
    }
    
    public void eliminarProducto (String nombreProducto){
        try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            consulta.execute("DELETE FROM producto WHERE nombreProducto = '" + nombreProducto + "'");
            
            conexion.close();
            
            
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
}
    /*try{
        PrintWriter pw;
        String linea;
        pw= new PrintWriter(new FileWriter("producto.txt"));
        for(int i=0;i<size();i++){
            linea=(lst.get(i).getCodigo() + ";" + 
                      lst.get(i).getNombre()+";" + 
                      lst.get(i).getPrecio() + ";" +
                      lst.get(i).getStock()
                    );
            pw.println(linea);//Agregar el registro al archivo
        }
        pw.close();
    }catch(Exception e){
        System.out.println(e.getMessage());
    }*/   
    
    //ELIMINAR CUANDO HAGAMOS LA CONEXION
    /*public void cargar(){
    try{
        BufferedReader br;
        String linea=null;
        String[] array=null;
        br = new BufferedReader(new FileReader("producto.txt"));
        while((linea = br.readLine()) != null ){
            array = linea.split(";");
            //Crear el objeto de tipo producto con los datos del archivo
            ProductoAgregar objpro =
                    new ProductoAgregar(Integer.parseInt(array[0].trim()), array[1].trim(),
                            Double.parseDouble(array[2].trim()), Integer.parseInt(array[3].trim()));
            //Agregar el objeto al ArrayList
            lst.add(objpro);
        }
        br.close();
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    }*/

