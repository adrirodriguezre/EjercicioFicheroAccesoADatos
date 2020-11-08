import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioMain {

	public static void main(String[] args) {
		
		ProcesamientoFicheroPlano p1= new ProcesamientoFicheroPlano();
		ProcesamientoFicheroXMLDOM p2 = new ProcesamientoFicheroXMLDOM();
		ProcesamientoFicheroObjetos po=new ProcesamientoFicheroObjetos();
		
		//RUTAS
		String home = System.getProperty("user.home");
		String ruta=(home + File.separator + "Desktop" + File.separator + "libros.txt");
		String rutaXML=(home + File.separator + "Desktop" + File.separator + "libros.xml");
		
		Scanner entrada = new Scanner(System.in);
		
		
		System.out.println("Introduce 1 para leer fichero de texto plano:\n" + "Introduce 2 para leer fichero XML:\n" +
		"Introduce 3 para leer fichero de objetos binarios:");
		
		int x = entrada.nextInt();
		
		if(x==1) {
			
			p1.leerFichero(ruta);
			
		}else if(x==2) {
			
			p2.leerFichero(rutaXML);
			
		}else if(x==3){
			
			po.leerFichero(ruta);
			
		}else {
			
			System.out.println("Error");
		}
		
	}

}
