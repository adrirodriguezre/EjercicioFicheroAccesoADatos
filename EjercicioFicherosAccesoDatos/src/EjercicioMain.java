import java.io.File;
import java.util.ArrayList;

public class EjercicioMain {

	public static void main(String[] args) {
		
		ProcesamientoFicheroPlano p1= new ProcesamientoFicheroPlano();
		
		//String ruta= "C:\\Users\\PC33\\Desktop\\Personajes.txt";
		String home = System.getProperty("user.home");
		String ruta=(home + File.separator + "Desktop" + File.separator + "libros.txt");
		String rutaXML=(home + File.separator + "Desktop" + File.separator + "libros.xml");
		String rutaEscribXML=(home + File.separator + "Desktop" + File.separator + "escribirXML.xml");
	
		
		ArrayList<Libro> Prueba = new ArrayList();
		ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
		
		//Prueba=p1.leerFichero(ruta);
		//p1.guardarFichero(arrayLibros);
		
		ProcesamientoFicheroXMLDOM p2 = new ProcesamientoFicheroXMLDOM();
		//p2.leerFichero(rutaXML);
		//p2.guardarFichero(arrayLibros);

	}

}
