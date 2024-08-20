package ar.edu.unju.fi.poo2024.tp1.ejercicio2;

public class Libro {
	private String isbn;
	private String titulo;
	private String autor;
	private int anioPublicacion;
	private double precio;
	private char estado; // 'D': Disponible ; 'P': Prestado.
	/**
	 * @param isbn
	 * @param titulo
	 * @param autor
	 * @param anioPublicacion
	 * @param precio
	 * @param estado
	 */
	public Libro(String isbn, String titulo, String autor, int anioPublicacion, double precio, char estado) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.precio = precio;
		this.estado = 'D'; // Estado disponible por defecto
	}
	
	//Metodos Getters y Setters
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAnioPublicacion() {
		return anioPublicacion;
	}
	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
