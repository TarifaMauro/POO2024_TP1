package ar.edu.unju.fi.poo2024.tp1.ejercicio1;

import java.util.Scanner;

public class ContadorDeCadenasEspecial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la longitud de la cadena: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la cadena: ");
        String s = scanner.nextLine();

        // Validar longitud
        if (s.length() != n) {
            System.out.println("Error: La longitud de la cadena no coincide con el valor dado.");
            scanner.close();
        }

        // Validar que la cadena contenga solo letras minúsculas
        if (!validarCadena(s)) {
            System.out.println("Error: La cadena debe contener solo letras minúsculas.");
            scanner.close();
        }

        // Contar y mostrar el número de subcadenas especiales
        System.out.println("Número de subcadenas especiales: " + substringCount(n, s));

        // Mostrar todas las subcadenas especiales
        System.out.println("Subcadenas especiales:");
        substring(n, s);

        scanner.close();
    }

    // Método para validar que la cadena solo contenga letras minúsculas
    private static boolean validarCadena(String s) {
        for (char c : s.toCharArray()) {
            if (c < 'a' || c > 'z') {
                return false;
            }
        }
        return true;
    }

    // Método principal para contar subcadenas especiales
    public static int substringCount(int n, String s) {
        int contador = 0;

        // Recorre todas las subcadenas posibles
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (esEspecial(substring)) {
                    contador++;
                }
            }
        }

        return contador;
    }

    // Método para mostrar todas las subcadenas especiales
    public static void substring(int n, String s) {
        // Recorre todas las subcadenas posibles
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subcadena = s.substring(i, j);
                if (esEspecial(subcadena)) {
                    System.out.println("{" + subcadena + "}");
                }
            }
        }
    }

    // Método para verificar si una subcadena es especial
    private static boolean esEspecial(String substring) {
        int longitud = substring.length();

        if (longitud == 1) {
            return true; // Todas las subcadenas de longitud 1 son especiales
        }

        // Verificar si todos los caracteres son iguales
        boolean igual = true;
        char primerCaracter = substring.charAt(0);
        for (int i = 1; i < longitud; i++) {
            if (substring.charAt(i) != primerCaracter) {
                igual = false;
                break;
            }
        }
        if (igual) {
            return true;
        }

        // Verificar si es un palíndromo con todos los caracteres iguales excepto el del medio
        if (longitud % 2 == 1) { // Longitud impar
            int medio = longitud / 2;
            boolean especialPalindromo = true;
            for (int i = 0; i < medio; i++) {
                if (substring.charAt(i) != substring.charAt(longitud - 1 - i)) {
                    especialPalindromo = false;
                    break;
                }
            }
            // También debe ser que todos los caracteres excepto el del medio sean iguales
            if (especialPalindromo) {
                char caracterIzquierdo = substring.charAt(0);
                char caracterDerecho = substring.charAt(longitud - 1);
                for (int i = 0; i < medio; i++) {
                    if (substring.charAt(i) != caracterIzquierdo || substring.charAt(longitud - 1 - i) != caracterDerecho) {
                        return false;
                    }
                }
                return true;
            }
        }

        return false;
    }
}