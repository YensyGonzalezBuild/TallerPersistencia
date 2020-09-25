package co.edu.unbosque.model.persistence;

import java.io.*;

public class EjemploFile {

	private String dataRoute = "./data/";

	private String[] documents;

	private String[] names;

	private double[] salaries;

	public void leerArchivo() {

		String line = "";

		File f = new File(this.dataRoute+"datosPrincipales.csv");

		try {

			FileReader fr = new FileReader(f);

			BufferedReader br = new BufferedReader(fr);

			line = br.readLine();

//			System.out.println(line);

			documents = new String[26];

			names = new String[26];

			salaries = new double[26];

			int i = 0;

			while (line != null) {
				line = br.readLine();

				if (line != null) {

					String[] data = line.split(";");

					documents[i] = data[0].trim();

					names[i] = data[1].trim();

					salaries[i] = Double.parseDouble(data[2].trim());

					i++;

				}

			}

			fr.close();
		} catch (IOException e) {
			System.out.print(e);
		}
	}

	public void processPayroll() {
		
		String payslipEntry;
		
		double netSalary;
			
		double taxRate=0;
		
		String fileName ="";
		
		for(int n = 0; n < this.documents.length; n++) {
			
			if (this.salaries[n] <= 2000) {taxRate = 0.10; fileName="interns";}

			if (this.salaries[n] > 5000) {taxRate = 0.20; fileName="managers";}

			if (this.salaries[n] >= 2000 || this.salaries[n] <= 5000) {taxRate = 0.15; fileName="employees";}
			
			netSalary = this.salaries[n] - (this.salaries[n] * taxRate);
			
			payslipEntry = this.documents[n].trim()+", "+netSalary+",";
			
			System.out.println(payslipEntry);
			
			this.generatePayslips(payslipEntry, fileName);
			
		}


	}

	public boolean generatePayslips(String entry, String fileName) {

		File f = new File(this.dataRoute+fileName+".txt");
		
		try {
			
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(entry);
			
			fw.close();
			
		} catch (IOException e) {
			
			System.out.println(e);
			
			return false;
		
		} 
		
		return true;

	}

	public void imprimirDatos() {

		for (int e = 0; e < 26; e++) {

			System.out.print("document: ");

			System.out.println(documents[e]);

			System.out.print("name: ");

			System.out.println(names[e]);

			System.out.print("salary: ");

			System.out.println(salaries[e]);

			System.out.println("-------------");

		}
	}

}
