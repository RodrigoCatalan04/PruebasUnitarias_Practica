/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.pagoconsola.TextProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author rodri
 */
public class TextProcessorTest {
    @Test
    public void testTextoValidoHola() {
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize("hola"));
    }

    @Test
    public void testTextoNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize(null);});
        
    
    }
    @Test
    public void testTextoExcedeLimite() {
        String textoLargo = new String(new char[1001]).replace('\0', 'a');

        assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize(textoLargo);});
    }
    @Test
    public void testTextoVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize("");});
    }
    @Test
    public void testTextoConEspacios() {
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize(" hola "));
    }
    @Test
    public void testTextoNumerico() {
        assertEquals("54321", TextProcessor.reverseAndCapitalize("12345"));
    }
    //Probando Pipeline
}
