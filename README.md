#Escuela Colombiana de Ingeniería
#Arquitecturas de Software - ARSW
###Taller – Principio de Inversión de dependencias, Contenedores Livianos e Inyección de dependencias.

####Parte II. Calculadora de Cuentas.

El siguiente, es el modelo de una aplicación usada para registrar los pedidos del restaurante “Sopas & Sopas”, y generar las facturas 
con el total a pagar una vez los clientes solicitan la cuenta. En este modelo, el manejador de órdenes delega el cálculo del total a 
la clase ‘CalculadorCuentaConIva‘, el cual realiza el cálculo haciendo la sumatoria del costo de cada plato de la orden y agregándole 
el gravamen del IVA, simplemente incrementando el total en un 16%, ya que los precios de los platos no incluyen IVA.

![img](https://cloud.githubusercontent.com/assets/16710111/12588019/c5292f26-c424-11e5-97d3-5f9f618dfc61.png)

Como esta herramienta ha sido tan exitosa, los administradores de muchos otros restaurantes han solicitado una licencia para su uso. 
Sin embargo, las reglas de negocio de estos restaurantes varían ligeramente respecto a las manejadas en “El mesón de la abuela“:

-	En algunos restaurantes los precios de los platos ya incluyen el IVA.
-	En otros restaurantes los precios ya incluyen el IVA, y además cobran el servicio del 10% sobre el total de la factura.
-	En otros casos sí se cobra el IVA, pero teniendo en cuenta que:
    -	Algunos restaurantes cobran un porcentaje estándar sobre todos los platos (como lo hace “Sopas & Sopas“), que por ahora es del 16%.
    - Otros restaurantes manejan dos porcentajes diferentes, dependiendo de si se trata de bebidas (cuyo gravamen es, por lo general del 
      10%), o de platos corrientes (por lo general, 16%). Eso significa que, para este tipo de restaurantes, el IVA no se aplica a la 
      totalidad del a cuenta, sino que se debe aplicar de forma diferencial a las bebidas y al resto de platos.

Es evidente que para dar cumplimiento a estos requerimientos (y a las nuevas variantes que puedan surgir), el software tal como está, no 
está listo. Algunas alternativas para cumplir con la demanda de diferentes versiones del software serían:

-	Crear N copias de la aplicación, y a cada copia modificarle lo que respecta al cálculo de la cuenta.
-	Parametrizar a la aplicación para poder definirle el esquema de facturación a manejar. Luego, ajustar el código para que maneje una 
  compleja estructura de ‘if/else‘ anidados, para determinar cómo hacer los cálculos dependiendo del tipo de aplicación.
-	**Aplicar el principio de Inversión de Dependencias, e incorporar un Contenedor Liviano que permita incorporar la Inyección de Dependencias.**

Plantee una nueva versión del modelo, de manera que:

-	El manejador de ordenes no quede acoplado con ningún tipo de calculador de cuenta concreto (en su código no se debe hacer referencia a 
  IVAs, propinas, etc.).
-	El calculador de cuentas que use IVA no quede acoplado a ninguna de las variantes de esquema de cobro (gravamen aplicado a la totalidad 
  de la cuenta, o de forma diferencial a bebidas y platos). **Para esto, haga que a este tipo de calculador de cuentas se le inyecte en tiempo 
  de ejecución un Bean encargado de calcular el gravamen que se le debe aplicar a un determinado producto (recuerde aplicar acá el principio 
  de inversión de dependencias).**
-	Se permita la incorporación de nuevos esquemas cálculo de cuentas, o nuevas variantes de gravámenes diferenciales.

Haga la implementación del modelo planteado. La prueba que se realizará para verificar la validez del modelo y su implementación consistirá 
en que, con sólo cambiar la configuración del contenedor liviano (Spring), y sin hacer ningún cambio en el código, se puedan tener (en principio) 
cuatro versiones de la aplicación:

-	Una que calcule el total de la cuenta, asumiendo que el IVA está incluido.
-	Una que calcule el total de la cuenta agregando un 10% de servicio.
-	Una que calcule el total de la cuenta aplicando el IVA a toda la cuenta.
-	Una que calcule el total de la cuenta aplicando el IVA de forma diferencial (un porcentaje para las bebidas, y otro para los platos).

Para la implementación tenga en cuenta:

-	Evitar tener constantes dentro de los ‘Beans’ desarrollados (por ejemplo, los porcentajes). Dichos valores deberían también inyectarse, de 
  manera que sean fácilmente ajustables.
