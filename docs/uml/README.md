# Diagramas UML

Esta carpeta debe contener los diagramas UML del proyecto exportados en formato PDF o PNG.

## Diagramas Requeridos:

- **Diagrama de Clases**: Muestra la estructura de clases del sistema
- **Diagrama de Casos de Uso**: Representa las interacciones entre actores y el sistema
- **Diagrama de Secuencia**: Muestra las interacciones entre objetos en el tiempo
- **Diagrama de Actividades**: Representa el flujo de trabajo o procesos

## Nomenclatura de Archivos:
- `diagrama_clases.pdf` o `diagrama_clases.png`
- `diagrama_casos_uso.pdf` o `diagrama_casos_uso.png`
- `diagrama_secuencia.pdf` o `diagrama_secuencia.png`
- `diagrama_actividades.pdf` o `diagrama_actividades.png`

## Herramientas Utilizadas:
- PlantUML (para la elaboración de este diagrama)

---

## Justificación del Diagrama de Clases (ECI Payment Integration Hub)

El diagrama de clases diseñado en **PlantUML** cumple a cabalidad con los requerimientos establecidos para el parcial por las siguientes razones de arquitectura y diseño, resaltando el uso de los **patrones de diseño principales: Abstract Factory y Adapter**:

1. **Centralización y Desacoplamiento del Proceso Principal:**
   El flujo de pagos está centralizado en la clase `PaymentService` (capa *APPLICATION*). Esta clase orquesta el proceso recibiendo un `PaymentRequest` y retornando un `PaymentResult`, sin depender de implementaciones concretas de los proveedores. Esto cumple con la regla de que *"el sistema interno de la Escuela NO puede depender de ninguna implementación específica"*.

2. **Aplicación de Patrones de Diseño (Adapter y Abstract Factory):**
   *   **Patrón Abstract Factory (`FACTORY & ROUTER`):** A través de `PaymentProviderFactory` y `PaymentProviderRouter`, el sistema selecciona y crea dinámicamente el proveedor externo correcto (`BancoPseProvider` o `StripeProvider`) según el medio de pago (PSE) o la moneda (USD), sin alterar la lógica central.
   *   **Patrón Adapter (`ADAPTERS`):** Las clases `StripeAdapter` y `BancoPseAdapter` implementan la interfaz común `ProviderAdapter`. Cumplen la función crítica de tomar la respuesta nativa de cada API (`ProviderRawResponse`), **ignorar campos adicionales** no deseados, y mapearla al modelo unificado. Adicionalmente, el adaptador maneja los fallos mediante el método `onFailure()`, retornando el estado `"PENDIENTE"`.

3. **Validaciones de Reglas de Negocio:**
   La clase `BusinessValidator` (capa *DOMAIN*) aísla las validaciones estrictas exigidas antes de procesar un pago. Se encarga de verificar que el monto sea mayor a $5.000 COP (constante `MIN_COP_AMOUNT`) y que los correos terminen exclusivamente en `@escuelaing.edu.co` o `@mail.escuelaing.edu.co`.

4. **Respuesta en Formato Institucional Unificado:**
   El resultado de las transacciones está fuertemente tipado en la entidad `PaymentResult`. Así se garantiza que, sin importar qué proveedor se utilizó, el sistema siempre devuelva al front-end y a la base de datos la misma estructura de información sin variaciones.

5. **Persistencia Desacoplada (Para MongoDB/AWS):**
   La separación de la capa *PERSISTENCE* a través de la interfaz `PaymentRepository` permite que el dominio desconozca los detalles de conexión. Esto facilita que, bajo la misma abstracción, se inyecte la implementación que apuntará al cluster de AWS MongoDB Atlas solicitado en el caso de estudio.