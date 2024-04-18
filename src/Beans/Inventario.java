/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import java.util.Date;

/**
 *
 * @author eldia
 */
public class Inventario {
    private int cantidadProducto;
    private String tipoProducto;
    private String nombreProducto;
    private String FechaVencimientoProducto;
    private String loteProducto;

    public Inventario(int cantidadProducto, String tipoProducto, String nombreProducto, String FechaVencimientoProducto, String loteProducto) {
        this.cantidadProducto = cantidadProducto;
        this.tipoProducto = tipoProducto;
        this.nombreProducto = nombreProducto;
        this.FechaVencimientoProducto = FechaVencimientoProducto;
        this.loteProducto = loteProducto;
    }

    public Inventario() {
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFechaVencimientoProducto() {
        return FechaVencimientoProducto;
    }

    public void setFechaVencimientoProducto(String FechaVencimientoProducto) {
        this.FechaVencimientoProducto = FechaVencimientoProducto;
    }

    public String getLoteProducto() {
        return loteProducto;
    }

    public void setLoteProducto(String loteProducto) {
        this.loteProducto = loteProducto;
    }
    
}
