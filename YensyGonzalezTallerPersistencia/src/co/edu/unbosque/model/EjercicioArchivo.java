package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.EjemploFile;

public class EjercicioArchivo{
	
	public void gestionarArchivoCadena() {
		
		EjemploFile archivo = new EjemploFile();
		
		archivo.leerArchivo();
		
//		archivo.imprimirDatos();
		
		archivo.processPayroll();
		
	}
	
}



