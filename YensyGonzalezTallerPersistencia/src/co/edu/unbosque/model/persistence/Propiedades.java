package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Properties;

public class Propiedades {

	private Properties prop = new Properties();
	private String archivoprop = "/Users/yensy/desktop/school/2020-2/programacion/persistencia";

	public int escribirPropiedades() {
		try {
			prop.setProperty("nombreProyecto", "ArchivosTexto");
			prop.setProperty("nombreArchivo", "archivo.properties");
			prop.setProperty("nombreCodigoFuente", "Propiedades.Java");
			prop.store(new FileOutputStream(archivoprop), null);
		} 
		catch (IOException ex) {
			return -1;
		}
		return 0;
	}	

	/* continua ... */
	
	public String leerPropiedades() {
		String linea="";
		try {
			// leer el archivo de propiedades
		prop.load(new FileInputStream(archivoprop));

		// obtener las propiedades definidas
		prop.list(System.out);
		//Reading each property value
		linea += "nombre del Proyecto :" + prop.getProperty("nombreProyecto")+"\n";
		linea += "nombre del Archivo :" + prop.getProperty("nombreArchivo")+"\n";
		linea += "nombre de la Clase Java :" + prop.getProperty("nombreCodigoFuente")+"\n";
		} 
		catch (IOException ex) {
			return null;
		}
		return linea;
	}
}
