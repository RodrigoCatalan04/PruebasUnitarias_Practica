/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pagoconsola;

/**
 *
 * @author rodri
 */
public class TextProcessor {
    public static String reverseAndCapitalize(String text) {

        // Validación de nulo o vacío o solo espacios
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede ser nulo o vacío");
        }

        // Validar límite de caracteres
        if (text.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        // 1. Eliminar espacios al inicio y final
        String trimmed = text.trim();

        // 2. Invertir el texto
        String reversed = new StringBuilder(trimmed).reverse().toString();

        // 3. Convertir a mayúsculas
        return reversed.toUpperCase();
    }
}
