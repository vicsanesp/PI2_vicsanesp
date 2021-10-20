package ejercicios;

import java.util.List;


import us.lsi.common.Files2;

public class Ejercicio2 {

//	Dada una matriz de nxn cadena de caracteres (con n=2^m; siendo m un número entero
//	mayor que 0), devolver una lista de cadenas de caracteres que incluya las cadenas de
//	longitud 4 que se forman uniendo las 4 cadenas de las 4 esquinas de la matriz principal,
//	y de cada una de sus 4 submatrices, y así sucesivamente hasta llegar a una matriz de 2x2.
//	El orden en el que se unen las cadenas de las esquinas es: superior izquierda, superior
//	derecha, inferior izquierda, e inferior derecha
	
//Por si acaso cambian el fichero	
//	public static String[][] lector2(String ruta){
//		List<String> fichero = Files2.linesFromFile(ruta);
//		int dimension = fichero.size();
//		String[][] keanuReeves = new String[dimension][dimension];
//		for (int i = 0; i < fichero.size(); i++) {
//			for (int j = 0; j < fichero.get(i).split("_").length; j++) {
//				keanuReeves[i][j] = fichero.get(i).split("_")[j];
//			}
//		}
//		return keanuReeves;
//	}
	
	public static String[][] lector2(String ruta){
		List<String> fichero = Files2.linesFromFile(ruta);
		int dimension = fichero.size();
		String[][] keanuReeves = new String[dimension][dimension];
		for (int i = 0; i < fichero.size(); i++) {
			for (int j = 0; j < fichero.get(i).split("_").length; j++) {
				if(fichero.get(i).endsWith("_")) {
					Integer longitud = fichero.get(i).length();
					keanuReeves[i][j] = fichero.get(i).substring(0, longitud-1).split("_")[j];
				}
				else {
					keanuReeves[i][j] = fichero.get(i).split("_")[j];
				}
			}
		}
		return keanuReeves;
	}
}
