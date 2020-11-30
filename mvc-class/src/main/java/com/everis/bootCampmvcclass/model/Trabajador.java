package com.everis.bootCampmvcclass.model;

import javax.persistence.*;

@Entity
public class Trabajador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido1")
	private String apellido1;
	@Column(name = "apellido2")
	private String apellido2;
	@Column(name = "edad")
	private int edad;
	@Column(name = "dni")
	private String dni;
	
	public Trabajador() {
		super();
	}
	
	public Trabajador(String nombre, String apellido1, String apellido2, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.dni = dni;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

}
