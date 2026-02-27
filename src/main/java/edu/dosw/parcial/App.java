package edu.dosw.parcial;

/**
 * Aplicación principal para el Parcial 1 de DOSW
 * 
 * @author Stiven Pardo
 * @version 1.0.0
 */
public class App {
    
    /**
     * Método principal de la aplicación
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("¡Hola Mundo desde DOSW Parcial T1!");
        System.out.println("Aplicación desarrollada por: Stiven Pardo");
        
        App app = new App();
        app.ejecutar();
    }
    
    /**
     * Método principal de ejecución de la aplicación
     */
    public void ejecutar() {
        System.out.println("Ejecutando la aplicación...");
        // Aquí va la lógica principal de tu aplicación
    }
    
    /**
     * Método de ejemplo para demostrar funcionalidad
     * 
     * @param mensaje mensaje a procesar
     * @return mensaje procesado
     */
    public String procesarMensaje(String mensaje) {
        if (mensaje == null || mensaje.trim().isEmpty()) {
            return "Mensaje vacío";
        }
        return "Procesado: " + mensaje.toUpperCase();
    }
}