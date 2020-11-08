import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ProcesamientoFicheroObjetos extends ProcesamientoFichero implements Serializable {

	@Override
	public ArrayList<Libro> leerFichero(String ruta) {
		
		
		ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
		ArrayList<Personajes> arrayPersonajes = new ArrayList<Personajes>();
		
		Libro libro1 = new Libro("Título: ","Editorial: ","Autor: ","FechaPubli: ","Género: ", arrayPersonajes);
		try {
			
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta));
			String str=(String)entrada.readObject();
			
			while (str!=null) {
				
				System.out.println(str);
				arrayLibros.add(libro1);
			}
			
			entrada.close();
			
		}catch(IOException | ClassNotFoundException e) {
			
		}
		
		
		return arrayLibros;
	}

	@Override
	public void guardarFichero(ArrayList<Libro> arrayLibros) {
		
		
	}

}
