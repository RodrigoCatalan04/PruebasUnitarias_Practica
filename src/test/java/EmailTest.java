/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.mycompany.pagoconsola.Email;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    @Test
    public void CorreoVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            Email.isValidEmail("");
        });
    }

    @Test
    public void CorreoSinArroba() {
        assertFalse(Email.isValidEmail("usuario.gmail.com"));
    }

    @Test
    public void CorreoSinDominioValido() {
        assertFalse(Email.isValidEmail("usuario@com"));
    }

    @Test
    public void CorreoValido() {
        assertTrue(Email.isValidEmail("cliente123@tienda.com"));
    }

    @Test
    public void CorreoNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Email.isValidEmail(null);});
        
   
    }
    @Test
    public void LongitudMenorSeis() {
        assertFalse(Email.isValidEmail("a@b.p"));
    }
    //Nuevas Pruebas Unitarias
    @Test
    public void testLocalEmpiezaConPunto() {
        assertFalse(Email.isValidEmail(".usuario@gmail.com"));
    }
    @Test
    public void testLocalTerminaConPunto() {
        assertFalse(Email.isValidEmail("usuario.@gmail.com"));
    }
    @Test
    public void testLocalPuntosConsecutivos() {
        assertFalse(Email.isValidEmail("usu..ario@gmail.com"));
    }
    @Test
    public void testLocalCaracteresInvalidos() {
        assertFalse(Email.isValidEmail("usu*ario@gmail.com"));
    }
    @Test
    public void testLocalVacio() {
        assertFalse(Email.isValidEmail("@gmail.com"));
    }
    @Test
    public void testDominioParteMuyCorta() {
        assertFalse(Email.isValidEmail("usuario@a.com"));
    }

    @Test
    public void testDominioCaracteresInvalidos() {
        assertFalse(Email.isValidEmail("usuario@gm*il.com"));
    }

    @Test
    public void testExtensionInvalida() {
        assertFalse(Email.isValidEmail("usuario@gmail.123")); 
        assertFalse(Email.isValidEmail("usuario@gmail.c"));   
    }
    @Test
    public void testDobleArroba() {
        assertFalse(Email.isValidEmail("usuario@@gmail.com"));
    }
    @Test
    public void testCorreoMuyLargo() {
        String largo = "a".repeat(250) + "@g.com";
        assertFalse(Email.isValidEmail(largo));
    }
}
