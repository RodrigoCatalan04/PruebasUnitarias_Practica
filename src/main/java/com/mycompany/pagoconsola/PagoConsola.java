package com.mycompany.pagoconsola;

import java.util.Scanner;

public class PagoConsola {

    public enum Servicio { AGUA, LUZ, INTERNET }
    public enum MedioPago { TARJETA, YAPE, PLIN }


    public static Servicio elegirServicio(int opcion) {
        return switch (opcion) {
            case 1 -> Servicio.AGUA;
            case 2 -> Servicio.LUZ;
            case 3 -> Servicio.INTERNET;
            default -> Servicio.AGUA;
        };
    }

    public static boolean validarDNI(String dni) {
        return dni != null && dni.matches("\\d{8}");
    }

    public static MedioPago elegirMedioPago(int opcion) {
        return switch (opcion) {
            case 1 -> MedioPago.TARJETA;
            case 2 -> MedioPago.YAPE;
            case 3 -> MedioPago.PLIN;
            default -> MedioPago.TARJETA;
        };
    }

    public static double calcularTotal(double monto, MedioPago medio) {
        if (medio == MedioPago.YAPE || medio == MedioPago.PLIN) {
            return monto * 0.90; // 10% de descuento
        }
        return monto;
    }

    public static boolean validarPin(String pin) {
        return pin != null && pin.matches("\\d{4}");
    }

    public static String leerPinOculto(Scanner sc, int longitud) {
        String input = sc.nextLine();
        StringBuilder pin = new StringBuilder();

        for (int i = 0; i < input.length() && pin.length() < longitud; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                pin.append(c);
                System.out.print("*");
            }
        }
        return pin.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Elegir servicio
        System.out.println("Seleccione el servicio:");
        System.out.println("1. Agua\n2. Luz\n3. Internet");
        System.out.print("Opción (1-3): ");
        Servicio servicio = elegirServicio(sc.nextInt());
        sc.nextLine();

        // Validar DNI
        System.out.print("Ingrese DNI (8 dígitos): ");
        String dni = sc.nextLine();
        while (!validarDNI(dni)) {
            System.out.print("DNI inválido. Intente de nuevo: ");
            dni = sc.nextLine();
        }
        //Monto
        System.out.print("Ingrese el monto a pagar: S/ ");
        double monto = sc.nextDouble();
        sc.nextLine();

        //Medio de pago
        System.out.println("Seleccione el medio de pago:");
        System.out.println("1. Tarjeta\n2. Yape\n3. Plin");
        System.out.print("Opción (1-3): ");
        MedioPago medio = elegirMedioPago(sc.nextInt());
        sc.nextLine();

        double total = calcularTotal(monto, medio);

        //Validar PIN si es billetera digital
        if (medio == MedioPago.YAPE || medio == MedioPago.PLIN) {
            System.out.print("Ingrese PIN de 4 dígitos: ");
            String pin = leerPinOculto(sc, 4);

            while (!validarPin(pin)) {
                System.out.print("\nPIN inválido. Intente nuevamente: ");
                pin = leerPinOculto(sc, 4);
            }
            System.out.println("\nPago exitoso.");
        } else {
            System.out.println("Pago exitoso con tarjeta.");
        }

        // Imprimir recibo
        System.out.println("\n--- RECIBO ---");
        System.out.println("Servicio: " + servicio);
        System.out.println("DNI: " + dni);
        System.out.println("Medio: " + medio);
        System.out.printf("Monto pagado: S/ %.2f\n", total);

        if (total != monto) {
            System.out.printf("Descuento aplicado: S/ %.2f\n", monto - total);
        }
    }
}
