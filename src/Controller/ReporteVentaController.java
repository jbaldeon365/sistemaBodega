/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Views.ReporteVentas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author eldia
 */
public class ReporteVentaController {
    private ReporteVentas reporteventas;

    public ReporteVentaController(ReporteVentas reporteventas) {
        this.reporteventas = reporteventas;
    }
    
    public void ReporteVenta(){
        String fechaInicio = reporteventas.txtFechaInicio.getText();
        String fechaFin = reporteventas.txtFechaFin.getText();
        float resultado = 0;
        try {
            String url = "jdbc:mysql://localhost/proyectobodegapoo2";
            String user = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(url, user, password);
            
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT SUM(importeTotal) FROM ventadetalle WHERE fechaVenta BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"'");
            
            registro.next();
            resultado = registro.getFloat("SUM(importeTotal)");
            
            conexion.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        reporteventas.txtResultados.setText("Las ganancias entre " + fechaInicio + " y " + fechaFin + "\n es de S/." + resultado);
    }
    
}
