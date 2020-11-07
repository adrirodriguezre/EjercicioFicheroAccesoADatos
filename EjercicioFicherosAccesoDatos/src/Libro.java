import java.util.ArrayList;

public class Libro {
	
	private String titulo;
	private String editorial;
	private String autor;
	private String fechaPubli;
	private String genero;
	private ArrayList <Personajes> personajes;
	

									//GETTERS Y SETTERS
	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getEditorial() {
		return editorial;
	}



	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public String getFechaPubli() {
		return fechaPubli;
	}



	public void setFechaPubli(String fechaPubli) {
		this.fechaPubli = fechaPubli;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public ArrayList<Personajes> getPersonajes() {
		return personajes;
	}



	public void setPersonajes(ArrayList<Personajes> personajes) {
		this.personajes = personajes;
	}

	//CONSTRUCTOR
	
	public Libro(String titulo, String editorial, String autor, String fechaPubli, String genero,
			ArrayList<Personajes> personajes) {
		
		super();
		this.titulo = titulo;
		this.editorial = editorial;
		this.autor = autor;
		this.fechaPubli = fechaPubli;
		this.genero = genero;
		this.personajes = personajes;
	}
	
	public String toString() {
		
		return "Título: " + this.getTitulo() + " Editorial: " + this.getEditorial() + " Autor: " + this.getAutor() + " Fecha publicación: "
				+ this.getFechaPubli() + " Género: " + this.getGenero() + " \nPersonajes: " + this.getPersonajes();
	}

}
