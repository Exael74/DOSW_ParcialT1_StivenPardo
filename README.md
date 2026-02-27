# DOSW_ParcialT1_StivenPardo

#STIVEN ESNEIDER PARDO GUTIERREZ, GRUPO 2

Evidencia de cuenta figma creada correctamente 
![alt text](image.png) 


Diagrama de contexto
![alt text](image-1.png)

en el diagrama de contexto identificamos como es que cada uno de los actores interactuan entre si para el correcto funcionamiento del sistema

Requerimientos del sistema: 

Informacion de la solicitud del pago 

● Nombre del pagador
● Documento
● Correo institucional
● Concepto del pago
● Monto
● Moneda (COP o USD)
● Medio de pago (Tarjeta, PSE, Transferencia)

debemos poder cambiar de proveedor sin modificar el codigo del proceso principal del pago


En este caso podriamos hacer uso de algunos de los patrondes  de diseño como lo vendrian siendo 

1. Patrón: Strategy
Comportamiento.
Justificación:
El caso de estudio requiere que el sistema permita cambiar de proveedor de pagos sin modificar el código principal del proceso de pago. El patrón Strategy es ideal para este caso, porque permite definir en este caso, diferentes proveedores de pago y mantenerlos en clases separadas, haciendo que sean intercambiables sin afectar el cliente que los utiliza. Esto nos va a permitir extensibilidad en el codigo y cumplir con el principio de abierto / cerrado

2. Patrón: Factory Method
Creacional.
Justificación:
Dado que cada proveedor de pago tiene diferentes campos obligatorios y formatos, el patrón Factory Method puede ser utilizado para encapsular la lógica de creación de objetos de proveedores. Esto permite que el sistema cree instancias de proveedores específicos según el medio de pago o la moneda sin que el código principal deba preocuparse por los detalles de implementación, esto asegurando que como mencionan los requisitos del sistema este no deba cambiar o ser modificado.

