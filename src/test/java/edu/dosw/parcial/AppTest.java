package edu.dosw.parcial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase App
 * 
 * @author Stiven Pardo
 * @version 1.0.0
 */
public class AppTest {
    
    private App app;
    
    @BeforeEach
    public void setUp() {
        app = new App();
    }
    
    @Test
    @DisplayName("Test de procesamiento de mensaje válido")
    public void testProcesarMensajeValido() {
        String mensaje = "hola mundo";
        String resultado = app.procesarMensaje(mensaje);
        assertEquals("Procesado: HOLA MUNDO", resultado);
    }
    
    @Test
    @DisplayName("Test de procesamiento de mensaje nulo")
    public void testProcesarMensajeNulo() {
        String resultado = app.procesarMensaje(null);
        assertEquals("Mensaje vacío", resultado);
    }
    
    @Test
    @DisplayName("Test de procesamiento de mensaje vacío")
    public void testProcesarMensajeVacio() {
        String resultado = app.procesarMensaje("");
        assertEquals("Mensaje vacío", resultado);
    }
    
    @Test
    @DisplayName("Test de procesamiento de mensaje con espacios")
    public void testProcesarMensajeConEspacios() {
        String resultado = app.procesarMensaje("   ");
        assertEquals("Mensaje vacío", resultado);
    }
    
    @Test
    @DisplayName("Verificar que la app no sea nula")
    public void testAppNoEsNula() {
        assertNotNull(app);
    }
}