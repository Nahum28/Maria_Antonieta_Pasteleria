package com.ma.beans;

import java.time.LocalDate;
import java.util.Date;

public class Trabajador {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaContratacion;
    private int edad;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}
	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

    // Getters y Setters
    
}
