# DOSW_ParcialT1_StivenPardo

#STIVEN ESNEIDER PARDO GUTIERREZ, GRUPO 2

Evidencia de cuenta figma creada correctamente 
![alt text](image.png)

Descomposición de Tareas - ECI Payment Integration Hub
Épica: Integración Unificada de Proveedores de Pago
Descripción de la Épica:
Como administrador del sistema ECI Payment Hub, necesito que el sistema pueda integrar múltiples proveedores de pago (PayU, ePayco, Stripe, Banco PSE) con diferentes APIs y formatos, unificándolos bajo una interfaz común para garantizar la flexibilidad y mantenibilidad del sistema.

Historia de Usuario:
Tareas de Desarrollo:
Tarea 1: Crear Interfaz Unificada de Payment Processor

    Tipo: Desarrollo
    Estimación: 2 Story Points
    Descripción: Definir la interfaz común que todos los adapters de proveedores deben implementar
    Criterios de Finalización:
    Interfaz PaymentProcessor creada con método processPayment()
    Clases PaymentRequest y PaymentResponse definidas con formato institucional
    Documentación de la interfaz completada

Tarea 2: Implementar Adapters para cada Proveedor
    Tipo: Desarrollo
    Estimación: 8 Story Points
    Descripción: Crear los adapters específicos para PayU, ePayco, Stripe y Banco PSE
    Criterios de Finalización:
    PayUAdapter implementado y probado
    ePaycoAdapter implementado y probado
    StripeAdapter implementado y probado
    BancoPSEAdapter implementado y probado
    Cada adapter convierte correctamente entre formatos

Tarea 3: Desarrollar Factory para Selección de Proveedores
    Tipo: Desarrollo
    Estimación: 5 Story Points
    Descripción: Implementar el patrón Abstract Factory para crear el proveedor correcto según reglas de negocio
    Criterios de Finalización:
    PaymentProcessorFactory abstracta creada
    ECIPaymentProcessorFactory implementada con reglas de negocio
    Validación: USD → Stripe, PSE → Banco PSE
    Pruebas unitarias de la factory completadas

Tarea 4: Implementar Unificación de Respuestas
    Tipo: Desarrollo
    Estimación: 3 Story Points
    Descripción: Asegurar que todas las respuestas se conviertan al formato institucional estándar
    Criterios de Finalización:
    Método de conversión a formato unificado implementado
    Manejo de campos adicionales (ignorar)
    Manejo de errores (retornar "PENDIENTE")
    Validación de respuesta unificada funcionando
    Tarea 5: Pruebas de Integración y Validación
    
Tipo: Testing
    Estimación: 4 Story Points
    Descripción: Crear pruebas que validen la integración completa de todos los componentes
    Criterios de Finalización:
    Pruebas de integración para cada proveedor
    Pruebas de cambio dinámico de proveedores
    Pruebas de manejo de errores y timeouts
    Cobertura de código mínima del 85%
    Total Estimado: 22 Story Points