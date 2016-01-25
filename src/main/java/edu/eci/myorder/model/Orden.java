package edu.eci.myorder.model;

import java.util.LinkedList;
import java.util.List;

public class Orden {

	List<Plato> platos;

	public Orden() {
		platos=new LinkedList<Plato>();
	}
	
	public void agregarPlato(Plato p){
		platos.add(p);
	}
	
	public List<Plato> getPlatos(){
		return platos;
	}
	
	public String toString(){
		return platos.toString();
	}
	
}
