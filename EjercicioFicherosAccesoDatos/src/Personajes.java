
public class Personajes {
	
	private String nombre;
	private String generoPers;
	private String importancia;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGeneroPers() {
		return generoPers;
	}

	public void setGeneroPers(String generoPers) {
		this.generoPers = generoPers;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}

	public Personajes(String nombre, String generoPers, String importancia) {
		super();
		this.nombre = nombre;
		this.generoPers = generoPers;
		this.importancia = importancia;
	}
	
	public String toString() {
		
		return " Nombre: " + this.getNombre() + " Género: " + this.getGeneroPers() + " Importancia: " + this.getImportancia();
	}
	

}
