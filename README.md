# DOSW_ParcialT1_StivenPardo

#STIVEN ESNEIDER PARDO GUTIERREZ, GRUPO 2

Evidencia de cuenta figma creada correctamente 
![alt text](image.png) 

1. Realice el diagrama de contexto con las generalidades de su sistema.
(Añadirlo al README.md)
    Diagrama de contexto
    ![alt text](image-1.png)
    en el diagrama de contexto identificamos como es que cada uno de los actores interactuan entre si para el correcto funcionamiento del sistema


2. Identifique 2 patrones de diseño que puedan aplicarse al caso de estudio,
especificando por cada uno:
a. Nombre del Patrón
b. Tipo de patrón (creacional, estructural o de comportamiento).
c. Justificación de la decisión.

    1. Patrón: Adapter
        Tipo de patrón: Estructural
        Justificación: Cada proveedor de pago (PayU, ePayco, Stripe, Banco PSE) tiene su propia API y formato de datos. El patrón Adapter permite que estas interfaces incompatibles trabajen con el sistema ECI sin modificar el código de los proveedores externos. Esto es esencial para unificar las respuestas en el formato institucional requerido y garantizar que el sistema interno no dependa de ninguna implementación específica de proveedor.

    2. Patrón: Abstract Factory
        Tipo de patrón: Creacional
        Justificación: El sistema debe crear diferentes objetos de proveedores según las reglas de negocio específicas (USD solo con Stripe, PSE solo con Banco PSE, etc.). Abstract Factory permite crear familias de objetos relacionados (procesadores de pago) sin especificar las clases concretas, respetando las restricciones del caso de estudio. Además, facilita agregar nuevos proveedores en el futuro sin modificar el código existente, cumpliendo con el principio abierto/cerrado.
