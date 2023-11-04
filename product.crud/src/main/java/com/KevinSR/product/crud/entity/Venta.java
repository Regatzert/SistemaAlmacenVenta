package com.KevinSR.product.crud.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdVenta;
    @Column(name = "IdUsuario")
    private Integer IdUsuario; 
    @Column(name = "IdProducto")   
    private Integer IdProducto; 
    @Column(name = "Cantidad")
    private Integer Cantidad;
    @Column(name = "FVenta")
    private LocalDate FVenta;

    public Venta() {}

    public Venta(Integer idUsuario, Integer idProducto, Integer cantidad, LocalDate fVenta) {
        super();
        IdUsuario = idUsuario;
        IdProducto = idProducto;
        Cantidad = cantidad;
        FVenta = fVenta;
    }

    public Integer getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(Integer idVenta) {
        IdVenta = idVenta;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer idProducto) {
        IdProducto = idProducto;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        Cantidad = cantidad;
    }

    public LocalDate getFVenta() {
        return FVenta;
    }

    public void setFVenta(LocalDate fVenta) {
        FVenta = fVenta;
    }

    
}
