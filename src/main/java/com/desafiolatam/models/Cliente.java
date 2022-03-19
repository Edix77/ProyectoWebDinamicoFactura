package com.desafiolatam.models;

public class Cliente {

	
	private String nombre;
	private String empresa;
	private Integer rut;
	private String direccion;
	private String ciudad;
	private String pais;
	public Cliente() {
		super();
	}
	public Cliente(String nombre, String empresa, Integer rut, String direccion, String ciudad, String pais) {
		super();
		this.nombre = nombre;
		this.empresa = empresa;
		this.rut = rut;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.pais = pais;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Integer getRut() {
		return rut;
	}
	public void setRut(Integer rut) {
		this.rut = rut;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
}
