/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pagoconsola;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rodri
 */
public class InventoryManager {
    private Map<String, Integer> inventory = new HashMap<>();

    public void AddItem(String itemName, int quantity) {
        // Validar nombre
        if (itemName == null || itemName.trim().isEmpty() 
                || itemName.length() < 2 || itemName.length() > 50 
                || itemName.contains(" ")) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }

        // Validar cantidad mínima
        if (quantity < 1) {
            throw new IllegalArgumentException("La cantidad mínima permitida es 1");
        }

        // Obtener cantidad actual (si existe)
        int currentQuantity = inventory.getOrDefault(itemName, 0);

        // Validar que no exceda 1000
        if (currentQuantity + quantity > 1000) {
            throw new IllegalArgumentException("La cantidad total no puede superar 1000");
        }

        // Actualizar inventario
        inventory.put(itemName, currentQuantity + quantity);
    }
}
