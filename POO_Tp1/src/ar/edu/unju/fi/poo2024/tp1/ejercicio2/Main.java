package ar.edu.unju.fi.poo2024.tp1.ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	preCargarLibros();
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    prestarLibro();
                    break;
                case 3:
                    buscarLibroPorIsbn();
                    break;
                case 4:
                    aumentarPrecio();
                    break;
                case 5:
                    listarLibrosPrestadosPorAutor();
                    break;
                case 6:
                    mostrarLibroMasAntiguoDisponible();
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println(" ************* Menú de Biblioteca: ***********");
        System.out.println("1. Agregar libro");
        System.out.println("2. Prestar libro");
        System.out.println("3. Buscar libro por ISBN");
        System.out.println("4. Aumentar precio de libros disponibles");
        System.out.println("5. Listar libros prestados por autor");
        System.out.println("6. Mostrar libro más antiguo disponible");
        System.out.println("7. Salir");
    }

    private static int leerOpcion() {
        int opcion = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Ingrese su opción: ");
                opcion = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
                scanner.next();
            }
        }
        return opcion;
    }

    private static void agregarLibro() {
        scanner.nextLine();
        try {
            System.out.print("Ingrese ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Ingrese título: ");
            String titulo = scanner.nextLine();
            System.out.print("Ingrese autor: ");
            String autor = scanner.nextLine();
            int anioPublicacion = leerAnio();
            System.out.print("Ingrese precio: ");
            double precio = scanner.nextDouble();
            char estado = ' ';
            Libro libro = new Libro(isbn, titulo, autor, anioPublicacion, precio, estado);
            biblioteca.agregarLibro(libro);
            System.out.println("Libro agregado exitosamente.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. El precio debe ser un número.");
            scanner.next();
        }
    }
    
    private static void preCargarLibros() {
        biblioteca.agregarLibro(new Libro("9780060883287", "Cien años de soledad", "Gabriel García Márquez", 1967, 15.99, 'D'));
        biblioteca.agregarLibro(new Libro("9788491050201", "Don Quijote de la Mancha", "Miguel de Cervantes", 1605, 12.99, 'D'));
        biblioteca.agregarLibro(new Libro("9780061120084", "Matar a un ruiseñor", "Harper Lee", 1960, 10.99, 'P'));
        biblioteca.agregarLibro(new Libro("9780451524935", "1984", "George Orwell", 1949, 9.99, 'D'));
        biblioteca.agregarLibro(new Libro("9780486284736", "Orgullo y prejuicio", "Jane Austen", 1813, 7.99, 'D'));
        biblioteca.agregarLibro(new Libro("9780743273565", "El gran Gatsby", "F. Scott Fitzgerald", 1925, 10.49, 'P'));
        biblioteca.agregarLibro(new Libro("9781853260010", "Cumbres borrascosas", "Emily Brontë", 1847, 8.99, 'D'));
    }

    private static void prestarLibro() {
        scanner.nextLine();
        System.out.print("Ingrese ISBN del libro a prestar: ");
        String isbn = scanner.nextLine();
        biblioteca.prestarLibro(isbn);
    }

    private static void buscarLibroPorIsbn() {
        scanner.nextLine();
        System.out.print("Ingrese ISBN del libro a buscar: ");
        String isbn = scanner.nextLine();
        Libro libro = biblioteca.buscarLibroPorIsbn(isbn);
        if (libro != null) {
            System.out.println(libro.getTitulo());
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void aumentarPrecio() {
        try {
            System.out.print("Ingrese porcentaje de aumento: ");
            double porcentaje = scanner.nextDouble();
            if (porcentaje < 0) {
                System.out.println("El porcentaje no puede ser negativo.");
                return;
            }
            biblioteca.aumentarPrecio(porcentaje);
            System.out.println("Precios actualizados exitosamente.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. El porcentaje debe ser un número.");
            scanner.next();
        }
    }

    private static void listarLibrosPrestadosPorAutor() {
        scanner.nextLine();
        System.out.print("Ingrese autor: ");
        String autor = scanner.nextLine();
        biblioteca.listarLibrosPrestadosPorAutor(autor);
    }

    private static void mostrarLibroMasAntiguoDisponible() {
        Libro libroAntiguo = biblioteca.libroMasAntiguoDisponible();
        if (libroAntiguo != null) {
            System.out.println("Libro más antiguo disponible:");
            System.out.println(libroAntiguo.getTitulo() +" : "+ libroAntiguo.getAutor());
        } else {
            System.out.println("No hay libros disponibles.");
        }
    }

    private static int leerAnio() {
        int anio = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Ingrese año de publicación (1900-2023): ");
                anio = scanner.nextInt();
                if (anio >= 1900 && anio <= 2023) {
                    valido = true;
                } else {
                    System.out.println("Año fuera del rango. Debe estar entre 1900 y 2023.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.next();
            }
        }
        return anio;
    }
}