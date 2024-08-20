package ar.edu.unju.fi.poo2024.tp1.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	private List<Libro> libros = new ArrayList();
	
	
	
	public void agregarLibro( Libro libro) {
		libros.add(libro);
	}
	
	public void prestarLibro( String isbn) {
		for(Libro libro : libros) {
			if(libro.getIsbn().equals(isbn) && libro.getEstado() == 'D') {
				libro.setEstado('P');
				return;
			}
			else {
				System.out.println("El libro no se encuentra disponible.");
			}
		}
	}
	
	public Libro buscarLibroPorIsbn(String isbn) {
		for(Libro libro : libros) {
			if(libro.getIsbn().equals(isbn)) {
				return libro;
			}
		}
		return null;
	}
	
	public void aumentarPrecio(double porcentaje) {
        for (Libro libro : libros) {
            if (libro.getEstado() == 'D') {
                double nuevoPrecio = libro.getPrecio() * (1 + porcentaje / 100);
                libro.setPrecio(nuevoPrecio);
            }
        }
    }
	
	 public void listarLibrosPrestadosPorAutor(String autor) {
	        double sumaPrecios = 0;
	        for (Libro libro : libros) {
	            if (libro.getAutor().equals(autor) && libro.getEstado() == 'P') {
	                System.out.println(libro.getTitulo());
	                sumaPrecios += libro.getPrecio();
	            }
	        }
	        System.out.println("Suma total de precios: " + sumaPrecios);
	    }

	    public Libro libroMasAntiguoDisponible() {
	        Libro libroAntiguo = null;
	        for (Libro libro : libros) {
	            if (libro.getEstado() == 'D') {
	                if (libroAntiguo == null || libro.getAnioPublicacion() < libroAntiguo.getAnioPublicacion()) {
	                    libroAntiguo = libro;
	                }
	            }
	        }
	        return libroAntiguo;
	    }

}
