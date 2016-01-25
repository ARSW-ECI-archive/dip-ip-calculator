package edu.eci.myorder;

import edu.eci.myorder.model.ExcepcionManejadorOrdenes;
import edu.eci.myorder.model.Orden;
import edu.eci.myorder.model.Plato;

//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.ApplicationContext;

public class Test {

    public static void main(String[] args) throws ExcepcionManejadorOrdenes {

        ManejadorOrdenes mo=new ManejadorOrdenes();

        generarOrdenes(mo);

        imprimirFactura(mo, 0);

    }

    public static void imprimirFactura(ManejadorOrdenes mo,int n) throws ExcepcionManejadorOrdenes{
        System.out.println("FACTURA DE COMPRA");
        for (Plato p:mo.consultarOrden(n).getPlatos()){
                System.out.println(p.getNombre()+"......."+p.getPrecio());
        }
        System.out.println("TOTAL:\t\t\t"+mo.calcularTotalOrden(n));		
    }

    public static void generarOrdenes(ManejadorOrdenes mo){

            Orden o=new Orden();
            o.agregarPlato(new Plato("pizza",7500));
            o.agregarPlato(new Plato("gaseosa",3900));
            o.agregarPlato(new Plato("hamburguesa",8000));
            o.agregarPlato(new Plato("gaseosa 350",200));

            mo.registrarOrden(o);

            o=new Orden();

            o.agregarPlato(new Plato("pizza",7500));
            o.agregarPlato(new Plato("pizza",7500));
            o.agregarPlato(new Plato("pizza",7500));
            o.agregarPlato(new Plato("gaseosa litro",4000));

            mo.registrarOrden(o);

    }
	
}
