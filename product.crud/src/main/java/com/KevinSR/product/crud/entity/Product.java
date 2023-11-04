package com.KevinSR.product.crud.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdProducto;
    @Column(name = "Codigo")
    private Integer Codigo;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "FVencimiento")
    private Date FVencimiento;
    @Column(name = "Precio")
    private Double Precio;
    @Column(name = "Laboratorio")
    private String Laboratiorio;
    @Column(name = "Lote")
    private String Lote;
    @Column(name = "Cantidad")
    private Integer Cantidad;
    @Column(name = "Activo")
    private Boolean Activo;

    public Product() {}

    public Product( Integer codigo, String nombre, Date fVencimiento, Double precio,
            String laboratiorio, String lote, Integer cantidad, Boolean activo) {
        super();
        Codigo = codigo;
        Nombre = nombre;
        FVencimiento = fVencimiento;
        Precio = precio;
        Laboratiorio = laboratiorio;
        Lote = lote;
        Cantidad = cantidad;
        Activo = activo;
    }

    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer idProducto) {
        IdProducto = idProducto;
    } 
    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Date getFVencimiento() {
        return FVencimiento;
    }

    public void setFVencimiento(Date fVencimiento) {
        FVencimiento = fVencimiento;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public String getLaboratiorio() {
        return Laboratiorio;
    }

    public void setLaboratiorio(String laboratiorio) {
        Laboratiorio = laboratiorio;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String lote) {
        Lote = lote;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        Cantidad = cantidad;
    }

    public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean activo) {
        Activo = activo;
    }

    
    
    
}
