package edu.eci.myorder.model;

public class Plato {

	int precio;

	String nombre;

	public Plato(String nombre, int precio) {
		super();
		this.precio = precio;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getPrecio() {
		return precio;
	}
	
}
