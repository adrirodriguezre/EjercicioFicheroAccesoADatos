import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class ProcesamientoFicheroPlano extends ProcesamientoFichero {
	
	public ArrayList <Libro> leerFichero(String ruta){
		
		File archivo = new File(ruta);
		ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
		ArrayList<Personajes> arrayPersonajes = new ArrayList<Personajes>();
		
		try {
			
			FileReader fr = new FileReader(archivo);
			BufferedReader contenido = new BufferedReader(fr);	//CREAMOS BUFFER DE LECTURA
			String libro;
			
	        while ((libro=contenido.readLine()) != null) {
	        	
	        	arrayPersonajes = new ArrayList<Personajes>();	//LLAMAMOS EN EL BUCLE AL ARRAYPERSONAJES PARA QUE GUARDE LOS PERSONAJES EN CADA LIBRO
	        	ArrayList<String> arrayLi = new ArrayList<>(Arrays.asList(libro.split(";"))); //CREO ESTA LISTA PARA OBTENER LOS CAMPOS DE LIBRO Y LA SEPARO CUANDO HAY ";"
	        	
	        	 Libro libro1 = new Libro("Título: ","Editorial: ","Autor: ","FechaPubli: ","Género: ", arrayPersonajes);
	             libro1.setTitulo(arrayLi.get(0));
	             libro1.setEditorial(arrayLi.get(1));
	             libro1.setAutor(arrayLi.get(2));
	             libro1.setFechaPubli(arrayLi.get(3));
	             libro1.setGenero(arrayLi.get(4));
	             arrayLibros.add(libro1);
	             
	             String personajes = arrayLi.get(5);
	             
	             if(personajes != null) { //SI EN LA POSICIÓN 5 EXISTEN DATOS ENTONCES 
	            	 
	            	 ArrayList<String> arrayPers = new ArrayList<>(Arrays.asList(personajes.split("-"))); //CREO UNA LISTA ARRAYPERS Y LA SEPARA CUANDO ENCUENTRA " - "
            	 
	            	 for(String strPers:arrayPers) { //RECORRO LA LISTA, LA SEPARO CUANDO HAY COMAS Y OBTENGO LOS CAMPOS DE PERSONAJES
	            		 
	            		ArrayList<String> arrayPersSeparado = new ArrayList<>(Arrays.asList(strPers.split(",")));
	            		Personajes p1 = new Personajes(arrayPersSeparado.get(0), arrayPersSeparado.get(1), arrayPersSeparado.get(2));
	            		arrayPersonajes.add(p1);
	            	 }
	             }
	        }
	        
	        for(Libro array: arrayLibros) { //RECORRO EL ARRAY DE LIBROS CUANDO YA ESTÁ LLENO Y HAGO QUE IMPRIMA LOS DATOS DEL MÉTODO TOSTRING DE CLASE LIBRO
	        	System.out.println(array.toString());
	        }
	        
	        contenido.close();
			
			

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrayLibros;
	}
	
	public void guardarFichero(ArrayList<Libro>arrayLibros) {
		
		
		String home = System.getProperty("user.home");
		String rutaGuardar=(home + File.separator + "Desktop" + File.separator + "librosGuardar.txt");
		String infoLibros = "";
		PrintWriter pw;
		
		for(Libro array: arrayLibros) {
				
				infoLibros = infoLibros + array.getTitulo() + " " + array.getEditorial() + " " + array.getAutor() + " " 
				+ array.getFechaPubli() + " " + array.getGenero() + " " + array.getPersonajes();
			}
		
		try {
			
			pw = new PrintWriter(rutaGuardar);
			pw.println(infoLibros);
			
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
	}

}
