package edu.eci.myorder;


import java.util.LinkedList;
import java.util.List;

import edu.eci.myorder.calculator.CalculadorCuentaConIva;
import edu.eci.myorder.model.Orden;
import edu.eci.myorder.model.ExcepcionManejadorOrdenes;


public class ManejadorOrdenes {
	
	List<Orden> ordenes;
	
	public ManejadorOrdenes(){
		ordenes=new LinkedList<Orden>();
	}
	
	public void registrarOrden(Orden o){
		ordenes.add(o);
	}
	
	public Orden consultarOrden(int n) throws ExcepcionManejadorOrdenes{
		if (n>=ordenes.size()) throw new ExcepcionManejadorOrdenes("Orden inexistente:");
		return ordenes.get(n);
	}
	
	public int calcularTotalOrden(int n) throws ExcepcionManejadorOrdenes{
		if (n>=ordenes.size()) throw new ExcepcionManejadorOrdenes("Orden inexistente:");
		CalculadorCuentaConIva calc=new CalculadorCuentaConIva();
		return calc.calcularCosto(ordenes.get(n));		
	}
	
	
}
