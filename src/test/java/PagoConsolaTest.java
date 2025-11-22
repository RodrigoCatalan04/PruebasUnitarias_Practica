package com.mycompany.pagoconsola;

import org.junit.jupiter.api.*;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class PagoConsolaTest {

    @BeforeAll
    public static void initAll() {
        System.out.println("\n[INICIO DE PRUEBAS UNITARIAS]\n");
    }

    @AfterAll
    public static void endAll() {
        System.out.println("\n[FIN DE PRUEBAS UNITARIAS]\n");
    }

    @BeforeEach
    public void setUp() {
        System.out.println(" -> Ejecutando prueba...");
    }

    @AfterEach
    public void tearDown() {
        System.out.println(" -> Prueba finalizada.\n");
    }

    @Test
    public void testElegirServicioAgua() {
        assertEquals(PagoConsola.Servicio.AGUA, PagoConsola.elegirServicio(1));
    }

    @Test
    public void testDNIValido() {
        assertTrue(PagoConsola.validarDNI("12345678"));
    }

    @Test
    public void testDNICaracteresInvalidos() {
        assertFalse(PagoConsola.validarDNI("abc12345"));
    }

    @Test
    public void testDNILongitudIncorrecta() {
        assertFalse(PagoConsola.validarDNI("1234"));
    }

    @Test
    public void testDNINull() {
        assertFalse(PagoConsola.validarDNI(null));
    }

    @Test
    public void testElegirMedioPagoYape() {
        assertEquals(PagoConsola.MedioPago.YAPE, PagoConsola.elegirMedioPago(2));
    }

    @Test
    public void testElegirMedioPagoDefault() {
        assertEquals(PagoConsola.MedioPago.TARJETA, PagoConsola.elegirMedioPago(99));
    }

    @Test
    public void testDescuentoYape() {
        assertEquals(90.0, PagoConsola.calcularTotal(100.0, PagoConsola.MedioPago.YAPE));
    }

    @Test
    public void testSinDescuentoTarjeta() {
        assertEquals(200, PagoConsola.calcularTotal(200.0, PagoConsola.MedioPago.TARJETA));
    }

    @Test
    public void testPinValido() {
        assertTrue(PagoConsola.validarPin("1234"));
    }

    @Test
    public void testPinInvalidoconLetras() {
        assertFalse(PagoConsola.validarPin("ab12"));
    }

    @Test
    public void testPinLongitudIncorrecta() {
        assertFalse(PagoConsola.validarPin("123"));
    }


}
