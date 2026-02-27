# Requisitos del Proyecto

Análisis de Requerimientos - ECI Payment Integration Hub

    RF-001: Procesar Pago Institucional
        Identificación del Requerimiento
        ID: RF-001
        Nombre: Procesar Pago Institucional
        Prioridad: Alta
        Tipo: Funcional
        Descripción
        El sistema debe permitir a los usuarios institucionales realizar pagos en línea para servicios académicos (bootcamps, certificados, eventos, cursos) validando datos institucionales y procesando el pago a través del proveedor correspondiente según las reglas de negocio establecidas.

        Actores
        Actor Principal: Estudiante/Usuario Institucional
        Actores Secundarios: Sistema de Proveedores de Pago, Base de Datos MongoDB Atlas
        Precondiciones
        El usuario debe tener un correo institucional válido (@escuelaing.edu.co o @mail.escuelaing.edu.co)
        El monto del pago debe ser mayor a $5,000 COP
        Los proveedores de pago deben estar disponibles

        Postcondiciones
        El pago es procesado exitosamente
        Se genera un registro en la base de datos
        Se retorna una respuesta en formato unificado institucional

        Flujo Principal
        El usuario ingresa información de pago (nombre, documento, correo, concepto, monto, moneda, medio de pago)
        El sistema valida que el correo termine en dominio institucional
        El sistema valida que el monto sea mayor a $5,000 COP
        El sistema selecciona automáticamente el proveedor usando Abstract Factory
        El sistema adapta la solicitud al formato del proveedor usando Adapter
        Se envía la solicitud al proveedor de pago
        El sistema unifica la respuesta al formato institucional
        Se almacena el registro del pago en MongoDB Atlas

        Flujos Alternativos
        FA-001: Si el correo no es institucional, mostrar error de validación
        FA-002: Si el monto es menor a $5,000 COP, rechazar transacción
        FA-003: Si el proveedor falla, retornar estado "PENDIENTE"

        Excepciones
        E-001: Error de conectividad con proveedor de pago
        E-002: Error de validación de datos de entrada
        E-003: Timeout en respuesta del proveedor (>3 segundos)
        RF-002: Gestionar Múltiples Proveedores de Pago


    Identificación del Requerimiento
    ID: RF-002
        Nombre: Gestionar Múltiples Proveedores de Pago
        Prioridad: Alta
        Tipo: Funcional
        Descripción
        El sistema debe integrar múltiples proveedores de pago (PayU, ePayco, Stripe, Banco PSE) con APIs diferentes, adaptándolos a una interfaz unificada que permita intercambiar proveedores sin modificar el código principal del sistema.

        Actores
        Actor Principal: Sistema ECI Payment Hub
        Actores Secundarios: PayU API, ePayco API, Stripe API, Banco PSE API

        Precondiciones
        Los proveedores de pago deben tener APIs activas
        Las credenciales de cada proveedor deben estar configuradas
        Las reglas de negocio deben estar definidas (USD→Stripe, PSE→Banco PSE)

        Postcondiciones
        La solicitud es procesada por el proveedor correcto
        La respuesta es unificada al formato institucional
        El sistema mantiene independencia de implementaciones específicas

        Flujo Principal
        El sistema recibe una solicitud de pago procesada
        El sistema determina el proveedor usando las reglas de negocio (Abstract Factory)
        Se crea el adapter correspondiente para el proveedor seleccionado
        El adapter convierte la solicitud al formato específico del proveedor
        Se envía la solicitud al API del proveedor
        El adapter recibe la respuesta del proveedor
        El adapter convierte la respuesta al formato unificado institucional
        Se retorna la respuesta unificada

        Flujos Alternativos
        FA-001: Si es moneda USD, usar obligatoriamente Stripe
        FA-002: Si el medio de pago es PSE, usar obligatoriamente Banco PSE
        FA-003: Para otros casos, seleccionar entre PayU o ePayco
        
        Excepciones
        E-001: Proveedor no disponible temporalmente
        E-002: Error en conversión de formatos
        E-003: Respuesta del proveedor en formato no esperado