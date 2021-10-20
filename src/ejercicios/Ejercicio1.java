package ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Files2;

public class Ejercicio1 {

//	Dada la siguiente definición recursiva de la función f (que toma como entrada 3
//	números enteros positivos y devuelve una cadena):
//	  "(" + toString(a*b*c) + ")", a<3 and b<3 and c<3
//	  
//	  "(" + toString(a+b+c) + ")", a<5 or b<5 or c<5
//f(a,b,c)=
//	  toString(a*b*c) + f(a/2, b-2, c/2) a es par and b es par and c es par
//	  
//	  toString(a+b+c) + f(a/3, b-3, c/3) en otro caso
//	siendo + un operador que representa la concatenación de cadenas, y toString(i) un método
//	que devuelve una cadena a partir de un entero. Al llevar a cabo la implementación, para
//	el tratamiento de cadenas se recomienda hacer uso de String.format.
	
	public static String ejercicio1It(Integer a, Integer b, Integer c) {
		
		return null;
	}
	
	public static List<List<Integer>> lector1(String ruta){
		List<String> fichero = Files2.linesFromFile(ruta);
		List<List<Integer>> res = new ArrayList<>();
		for (String f:fichero) {
			String[] linea = f.split(",");
			List<Integer> aux = new ArrayList<>();
			for(String l:linea) {
				aux.add(Integer.parseInt(l));
			}
			res.add(aux);
		}
		return res;
	}
	
}
