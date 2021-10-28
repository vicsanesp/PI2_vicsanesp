package ejercicios;

import java.util.ArrayList;
import java.util.List;


import us.lsi.common.Files2;
import us.lsi.common.Matrix;

public class Ejercicio2 {

//	Dada una matriz de nxn cadena de caracteres (con n=2^m; siendo m un número entero
//	mayor que 0), devolver una lista de cadenas de caracteres que incluya las cadenas de
//	longitud 4 que se forman uniendo las 4 cadenas de las 4 esquinas de la matriz principal,
//	y de cada una de sus 4 submatrices, y así sucesivamente hasta llegar a una matriz de 2x2.
//	El orden en el que se unen las cadenas de las esquinas es: superior izquierda, superior
//	derecha, inferior izquierda, e inferior derecha
	
	public static List<String> ejercicio2(Matrix<String> keanuReeves){
		return ejercicio2(keanuReeves, new ArrayList<String>());
	}
	
	public static List<String> ejercicio2(Matrix<String> keanuReeves, List<String> res){
		if (keanuReeves.nc()==2) {
			String aux = "";
			aux += keanuReeves.corners().get(0) + keanuReeves.corners().get(1) + keanuReeves.corners().get(2) + keanuReeves.corners().get(3);
			res.add(aux);
			return res;
		} else {	
			String aux = "";
			aux += keanuReeves.corners().get(0) + keanuReeves.corners().get(1) + keanuReeves.corners().get(2) + keanuReeves.corners().get(3);
			res.add(aux);
			for (int i = 0; i < keanuReeves.corners().size(); i++) {
				ejercicio2(keanuReeves.view(i), res);
			}
			return res;
		}
	}
	
	public static Matrix<String> lector2(String ruta){
		List<String> fichero = Files2.linesFromFile(ruta);
		int dimension = fichero.size();
		String[][] keanuReeves = new String[dimension][dimension];
		for (int i = 0; i < fichero.size(); i++) {
			for (int j = 0; j < fichero.get(i).split(" ").length; j++) {
				
					keanuReeves[i][j] = fichero.get(i).split(" ")[j];
			}
		}
		Matrix<String> keanu = Matrix.of(keanuReeves);
		return keanu;
	}
}
