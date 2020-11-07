import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ProcesamientoFicheroXMLDOM extends ProcesamientoFichero{

	@Override
	public ArrayList<Libro> leerFichero(String rutaXML) {
		
		File fichero = new File(rutaXML);
		ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
		
		try {
			
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fichero);
			NodeList ListaLibro = doc.getElementsByTagName("libro"); //creo una lista que obtenga los elementos de cada libro
			
			for(int cont=0; cont < ListaLibro.getLength(); cont++) {	//creo un contador que recorra la lista de libros
				
				Node nNode = ListaLibro.item(cont);	//obtengo un libro tras otro
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {	//comprobamos que se trata de un nodo de tipo Element
					
				    Element librosElement = (Element) nNode;
				    
				    //imprime los datos de cada elemento de cada libro
				    System.out.println("\nLibro: " + librosElement.getElementsByTagName("nombre").item(0).getTextContent());
				    System.out.println("Editorial: " + librosElement.getElementsByTagName("editorial").item(0).getTextContent());
				    System.out.println("Autor: " + librosElement.getElementsByTagName("autor").item(0).getTextContent());
				    System.out.println("Fecha publicación: " + librosElement.getElementsByTagName("fechaPubli").item(0).getTextContent());
				    System.out.println("Género: " + librosElement.getElementsByTagName("genero").item(0).getTextContent());
				    
				    
				    NodeList ListaPersonajes = librosElement.getElementsByTagName("personaje");	//creo una lista que obtenga los datos de personajes
				    
				    for (int cont2=0;cont2 < ListaPersonajes.getLength(); cont2++) {	//recorremos la lista de personajes
				    	
				    	
				    	Node nNodePersonajes = ListaPersonajes.item(cont2);		//obtengo un personaje tras otro
				    	
				    	if(nNodePersonajes.getNodeType() == Node.ELEMENT_NODE) {	//comprobamos que se trata de un nodo de tipo Element
				    		
				    		Element eElementPersonajes = (Element) nNodePersonajes;
				    		
				    		//imprime los datos de cada elemento de cada personaje
				    		System.out.println("\nNombre Personaje: " + eElementPersonajes.getElementsByTagName("nombreP").item(0).getTextContent());
				    		System.out.println("Genero Personaje: " + eElementPersonajes.getElementsByTagName("generoPers").item(0).getTextContent());
				    		System.out.println("Importancia: " + eElementPersonajes.getElementsByTagName("importancia").item(0).getTextContent());
				    		
				    	}
				    	
				    }
				  
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
				return arrayLibros ;
	}

	@Override
	public void guardarFichero(ArrayList<Libro> ArrayLibro) {
		
		try {
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		    
		    //Elemento raíz
		    Document doc = docBuilder.newDocument();
		    Element librosElement = doc.createElement("libros");
		    doc.appendChild(librosElement);
		    
			//Elemento libro
		    Element libro = doc.createElement("libro");
		    librosElement.appendChild(libro);
		    
		    
		    Element nombre = doc.createElement("nombre");
		    nombre.setTextContent("Los pilares de la Tierra");
		    librosElement.appendChild(nombre);
		    
		    Element editorial = doc.createElement("editorial");
		    editorial.setTextContent("Macmillan Publishers");
		    librosElement.appendChild(editorial);
		    
		    Element autor = doc.createElement("autor");
		    autor.setTextContent("Ken Follet");
		    librosElement.appendChild(autor);
		    
		    TransformerFactory transformerFactory = TransformerFactory.newInstance();
		    Transformer transformer = transformerFactory.newTransformer();
		    DOMSource source = new DOMSource(doc);
		    String home = System.getProperty("user.home");
		    StreamResult result = new StreamResult(new File((home + File.separator + "Desktop" + File.separator + "escribirXML.xml")));
		    
		    transformer.transform(source, result);
			
		} catch (ParserConfigurationException pce) {
		      pce.printStackTrace();
	    } catch (TransformerException tfe) {
	      tfe.printStackTrace();
		      
				
	}
	
	}

}
