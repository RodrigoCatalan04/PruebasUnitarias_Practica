
import com.mycompany.pagoconsola.InventoryManager;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rodri
 */
public class InventoryManagerTest {
    @BeforeAll
    public static void IniciarPrueba(){
        System.out.println("\n[INICIO DE PRUEBAS UNITARIAS PC2]\n");
    }
    @AfterAll
    public static void endAll() {
        System.out.println("\n[FIN DE PRUEBAS UNITARIAS PC2]\n");
    }
    @Test
    public void IngresoProductoSinNombre() {
     InventoryManager manager = new InventoryManager();   
     assertThrows(IllegalArgumentException.class, () -> manager.AddItem("", 5)); 
    }
    @Test
    public void IngresoProductoLaptop() {
        InventoryManager manager = new InventoryManager();
        assertDoesNotThrow(() -> {manager.AddItem("Laptop", 5);});
    }
    @Test
    public void IngresoProductoCantidadNegativa() {
        InventoryManager manager = new InventoryManager();

         assertThrows(IllegalArgumentException.class, () -> {
            manager.AddItem("Mouse", -1);
        });
   
    }

    @Test
    public void IngresoProductoCantidadExcesiva() {
        InventoryManager manager = new InventoryManager();

        assertThrows(IllegalArgumentException.class, () -> {
            manager.AddItem("Monitor", 1001);
        });
    }

 
    @Test
    public void IngresoProductoNombreCorto() {
        InventoryManager manager = new InventoryManager();

        assertThrows(IllegalArgumentException.class, () -> {
            manager.AddItem("a", 5);});
    }


    @Test
    public void IngresoProductoNombreConEspacios() {
        InventoryManager manager = new InventoryManager();

        assertThrows(IllegalArgumentException.class, () -> {
            manager.AddItem("Laptop HP", 5); 
        });
    }
    //Nuevas Pruebas Unitarias
    @Test
    public void testNombreNull() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> {
            manager.AddItem(null, 5);
        });
    }

    @Test
    public void testNombreEspaciosBlancos() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> {
            manager.AddItem("   ", 5);});
    }

    @Test
    public void testNombreLargo() {
        InventoryManager manager = new InventoryManager();
        String nombreLargo = new String(new char[51]).replace('\0', 'a'); 
        assertThrows(IllegalArgumentException.class, () -> {
            manager.AddItem(nombreLargo, 5);});
    
    }
}
