/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.mycompany.pagoconsola.PasswordValidator;
import org.junit.jupiter.api.*;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author rodri
 */
public class PasswordValidatorTest {
    @BeforeAll
    public static void IniciarPrueba(){
        System.out.println("\n[INICIO DE PRUEBAS UNITARIAS PC2]\n");
    }
    @AfterAll
    public static void endAll() {
        System.out.println("\n[FIN DE PRUEBAS UNITARIAS PC2]\n");
    }

    @Test
    public void testPasswordNull() {
        assertThrows(IllegalArgumentException.class, () -> PasswordValidator.isValid(null));
    }
    @Test
    public void testPasswordValido() {
        assertTrue(PasswordValidator.isValid("Secure123!"));
    }
    @Test
    public void testPasswordInvalido() {
        assertFalse(PasswordValidator.isValid("nosecura"));
    }
    @Test
    public void testPassword8caracteres() {
        assertFalse(PasswordValidator.isValid("Pass12*"));
    }
    @Test
    public void testPasswordsinMayusculas() {
        assertFalse(PasswordValidator.isValid("password123*"));
    }
    @Test
    public void testPasswordsinnumeros() {
        assertFalse(PasswordValidator.isValid("PasswordSecure!"));
    }
    //Nuevas Pruebas Unitarias
    @Test
    public void testPasswordVacio() {
        assertThrows(IllegalArgumentException.class, () -> PasswordValidator.isValid(""));
    }
    @Test
    public void testPasswordLargo() {
        String largo = new String(new char[65]).replace('\0', 'a'); 
        assertFalse(PasswordValidator.isValid(largo));
    }
    @Test
    public void testPasswordConEspacio() {
        assertTrue(PasswordValidator.isValid("Pass 123!"));
    }

   }
