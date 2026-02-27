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

    En este caso podriamos hacer uso de algunos de los patrondes  de diseño como lo vendrian siendo 
        1. Patrón: Strategy
        Comportamiento.
        Justificación:
        El caso de estudio requiere que el sistema permita cambiar de proveedor de pagos sin modificar el código principal del proceso de pago. El patrón Strategy es ideal para este caso, porque permite definir en este caso, diferentes proveedores de pago y mantenerlos en clases separadas, haciendo que sean intercambiables sin afectar el cliente que los utiliza. Esto nos va a permitir extensibilidad en el codigo y cumplir con el principio de abierto / cerrado

        2. Patrón: Factory Method
        Creacional.
        Justificación:
        Dado que cada proveedor de pago tiene diferentes campos obligatorios y formatos, el patrón Factory Method puede ser utilizado para encapsular la lógica de creación de objetos de proveedores. Esto permite que el sistema cree instancias de proveedores específicos según el medio de pago o la moneda sin que el código principal deba preocuparse por los detalles de implementación, esto asegurando que como mencionan los requisitos del sistema este no deba cambiar o ser modificado.



3. Identifique 5 requerimientos del sistema y clasifíquelos en funcionales (3) y
no funcionales (2). Garantice que al menos un requerimiento funcional
seleccionado utilice uno o los dos patrones identificados. (Añadirlo al
README.md)

    Requerimientos Funcionales:

        Centralización de Proveedores de Pago:
        Tenemos que el sistema debe dejar gestiuonar los pagos online para los servicios institucionales (bootcamps, certificados academicos, eventos, etc.) se debe de usar un unico sistema centralizado.

        Relación con el Patrón: 
        Utiliza el patrón Strategy para permitir cambiar de proveedor de pago sin modificar el código principal.

        Validación de Pagos:
        Solo se deben aceptar pagos mayores a $5,000 COP y correos institucionales terminados en @escuelaing.edu.co o @mail.escuelaing.edu.co.

        Unificación de Respuestas:
        El sistema debe unificar las respuestas de los proveedores en un formato único institucional, ignorando campos adicionales y devolviendo "PENDIENTE" en caso de fallos.



    Requerimientos No Funcionales:

        Rendimiento:
        El sistema debe responder en un máximo de 3 segundos para el 95% de las transacciones y soportar 200 pagos concurrentes.

        Diseño de Interfaz:
        La aplicación web debe ser responsive, usar los colores institucionales (naranja y rosado) y la tipografía Poppins.