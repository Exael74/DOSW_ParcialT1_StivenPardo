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



3. Identifique 5 requerimientos del sistema y clasifíquelos en funcionales (3) y
no funcionales (2). Garantice que al menos un requerimiento funcional
seleccionado utilice uno o los dos patrones identificados. (Añadirlo al
README.md)

    Requerimientos Funcionales:

        1. Integración Unificada de Múltiples Proveedores de Pago:
            El sistema debe integrar diferentes proveedores de pago (PayU, ePayco, Stripe, Banco PSE) que tienen APIs y formatos de respuesta distintos, unificándolos bajo una interfaz común para el sistema ECI.
            Relación con el Patrón: Utiliza el patrón Adapter para convertir las interfaces incompatibles de cada proveedor a una interfaz unificada que entienda el sistema interno.

        2. Selección Automática de Proveedor según Reglas de Negocio:
            El sistema debe crear automáticamente el proveedor de pago correcto basándose en las restricciones del negocio (USD solo con Stripe, PSE solo con Banco PSE, otros medios con PayU o ePayco).
            Relación con el Patrón: Utiliza el patrón Abstract Factory para crear la familia correcta de objetos procesadores de pago según las reglas establecidas.

        3. Validación de Datos de Pago:
            Solo se deben aceptar pagos mayores a $5,000 COP y correos institucionales terminados en @escuelaing.edu.co o @mail.escuelaing.edu.co.


    Requerimientos No Funcionales:

        Rendimiento:
        El sistema debe responder en un máximo de 3 segundos para el 95% de las transacciones y soportar 200 pagos concurrentes.

        Diseño de Interfaz:
        La aplicación web debe ser responsive, usar los colores institucionales (naranja y rosado) y la tipografía Poppins.




Del listado anterior, seleccione los 2 requerimientos funcionales más importantes del sistema y desarrolle un diagrama de casos de uso con su
respectiva historia de usuario. Garantiza que al menos un requerimiento funcional seleccionado utilice un patrón identificado. 

    Los dos mas importantes son: Procesar pago institucional y Gestionar multiples proveedores de pago
    
    Diagramas de casos de uso:
    ![alt text](image-1.png)


    Historia de Usuario para el procesamiento de los pagos 
        El usuario ingresa sus datos de pago
        El sistema valida el correo institucional y monto mínimo
        El sistema selecciona automáticamente el proveedor según las reglas (Abstract Factory)
        El sistema adapta la solicitud al formato del proveedor seleccionado (Adapter)
        Se procesa el pago y se retorna respuesta unificada


    Historia de Usuario para la gestion de diferentes proveedores de pago:
    El administrador configura un nuevo proveedor
    El sistema crea el adapter correspondiente para el nuevo proveedor
    La factory se actualiza para incluir las reglas del nuevo proveedor
    El sistema continúa funcionando sin modificar el código existente
