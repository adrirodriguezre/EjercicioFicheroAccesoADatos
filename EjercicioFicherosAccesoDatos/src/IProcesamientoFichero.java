import java.util.ArrayList;

public interface IProcesamientoFichero {

	public ArrayList <Libro> leerFichero(String ruta);
	public void guardarFichero(ArrayList<Libro>arrayLibros);
}



