/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pagoconsola;

/**
 *
 * @author rodri
 */
public class Email {
    public static boolean isValidEmail(String email) {
        // Validar nulo o vacío
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        // Validar longitud total
        if (email.length() < 6 || email.length() > 254) {
            return false;
        }

        // Debe contener solo 1 arroba
        int atIndex = email.indexOf('@');
        if (atIndex == -1 || atIndex != email.lastIndexOf('@')) {
            return false;
        }

        String local = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);

        // Validar parte local
        if (!isValidLocalPart(local)) {
            return false;
        }

        // Validar parte dominio
        return isValidDomain(domain);
    }

    private static boolean isValidLocalPart(String local) {
        // Debe tener al menos 1 caracter
        if (local.isEmpty()) return false;

        // No puede iniciar ni terminar con punto
        if (local.startsWith(".") || local.endsWith(".")) return false;

        // No permite dos puntos consecutivos
        if (local.contains("..")) return false;

        // Solo permite letras, números, punto, guion y guion bajo
        if (!local.matches("[A-Za-z0-9._-]+")) return false;

        return true;
    }

    private static boolean isValidDomain(String domain) {
        // Debe contener al menos un punto
        if (!domain.contains(".")) return false;

        // Dividir por puntos
        String[] parts = domain.split("\\.");

        // Debe haber al menos dominio + extensión
        if (parts.length < 2) return false;

        // Validar cada parte del dominio excepto la extensión final
        for (int i = 0; i < parts.length - 1; i++) {
            if (parts[i].length() < 2) return false; // Mínimo 2 caracteres
            if (!parts[i].matches("[A-Za-z0-9-]+")) return false; // Sin espacios ni especiales
        }

        // Validar extensión (última parte)
        String extension = parts[parts.length - 1];

        // Extensiones válidas: letras solamente
        if (!extension.matches("[A-Za-z]{2,}")) return false;

        return true;
    }
}
