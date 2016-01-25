package edu.eci.myorder.calculator;

import edu.eci.myorder.model.Orden;
import edu.eci.myorder.model.Plato;



public class CalculadorCuentaConIva {

	public int calcularCosto(Orden o) {
		int total=0;
		for (Plato p:o.getPlatos()){
			total+=p.getPrecio()*(1.16);
		}
		return total;
	}
        
}
