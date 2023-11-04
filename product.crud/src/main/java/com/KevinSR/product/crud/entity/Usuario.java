package com.KevinSR.product.crud.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdUsuario;
    @Column(name = "Usuario")
    private String Usuario;
    @Column(name = "Contrasenia")
    private String Contrasenia;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "ApPaterno")
    private String ApPaterno;
    @Column(name = "ApMaterno")
    private String ApMaterno;
    @Column(name = "FNacimiento")
    private LocalDate FNacimiento;
    @Column(name = "Telefono")
    private Integer Telefono;
    @Column(name = "DocumentoIdentidad")
    private Integer DocumentoIdentidad;
    @Column(name = "Activo")
    private Boolean Activo;

    public Usuario() {}

    public Usuario( String usuario, String contrasenia, String nombre, String apPaterno,
            String apMaterno, LocalDate fNacimiento, Integer telefono, Integer documentoIdentidad, Boolean activo) {
        super();
        Usuario = usuario;
        Contrasenia = contrasenia;
        Nombre = nombre;
        ApPaterno = apPaterno;
        ApMaterno = apMaterno;
        FNacimiento = fNacimiento;
        Telefono = telefono;
        DocumentoIdentidad = documentoIdentidad;
        Activo = activo;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApPaterno() {
        return ApPaterno;
    }

    public void setApPaterno(String apPaterno) {
        ApPaterno = apPaterno;
    }

    public String getApMaterno() {
        return ApMaterno;
    }

    public void setApMaterno(String apMaterno) {
        ApMaterno = apMaterno;
    }

    public LocalDate getFNacimiento() {
        return FNacimiento;
    }

    public void setFNacimiento(LocalDate fNacimiento) {
        FNacimiento = fNacimiento;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer telefono) {
        Telefono = telefono;
    }

    public Integer getDocumentoIdentidad() {
        return DocumentoIdentidad;
    }

    public void setDocumentoIdentidad(Integer documentoIdentidad) {
        DocumentoIdentidad = documentoIdentidad;
    }

    public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean activo) {
        Activo = activo;
    }

    
}
