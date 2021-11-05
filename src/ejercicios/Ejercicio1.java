package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import us.lsi.common.Files2;
import us.lsi.common.Map2;

public class Ejercicio1 {

//	Dada la siguiente definiciÃƒÂ³n recursiva de la funciÃƒÂ³n f (que toma como entrada 3
//	nÃƒÂºmeros enteros positivos y devuelve una cadena):
//	  "(" + toString(a*b*c) + ")", a<3 and b<3 and c<3
//	  
//	  "(" + toString(a+b+c) + ")", a<5 or b<5 or c<5
//f(a,b,c)=
//	  toString(a*b*c) + f(a/2, b-2, c/2) a es par and b es par and c es par
//	  
//	  toString(a+b+c) + f(a/3, b-3, c/3) en otro caso
//	siendo + un operador que representa la concatenaciÃƒÂ³n de cadenas, y toString(i) un mÃƒÂ©todo
//	que devuelve una cadena a partir de un entero. Al llevar a cabo la implementaciÃƒÂ³n, para
//	el tratamiento de cadenas se recomienda hacer uso de String.format.
	
	private static record tripla( Integer a, Integer b, Integer c) {
		public static tripla of(Integer a, Integer b, Integer c) {
			return new tripla(a, b, c);
		}
	}
	
	public static String ejercicio1It(Integer a, Integer b, Integer c) {
		Map<tripla, String> res = Map2.empty();
		String cum = "";
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				for (int k = 0; k <= c; k++) {
					if(i<3 && j<3 && k<3) {
						cum ="(" + Integer.toString(i*j*k) + ")";
					}
					else if(i<5 || j<5 || k<5) {
						cum ="(" + Integer.toString(i+j+k) + ")";
					}
					else if(i%2 == 0 && j%2 == 0 && k%2 == 0) {
						cum = Integer.toString(i*j*k) + res.get(tripla.of(i/2, j-2, k/2));
					}
					else {
						cum = Integer.toString(i+j+k) + res.get(tripla.of(i/3, j-3, k/3));
					}
					res.put(tripla.of(i, j, k), cum);
				}
			}
		}
		return res.get(tripla.of(a, b, c));
	}
	
	public static String ejercicio1RecFin(Integer a, Integer b, Integer c) {
		return ejercicio1RecFin(a, b, c, "");
	}
	public static String ejercicio1RecFin(Integer a, Integer b, Integer c, String cum) {
		if(a<3 && b<3 && c<3) {
			cum +="(" + Integer.toString(a*b*c) + ")";
		}
		else if(a<5 || b<5 || c<5) {
			cum +="(" + Integer.toString(a+b+c) + ")";
		}
		else if(a%2 == 0 && b%2 == 0 && c%2 == 0) {
			cum += ejercicio1RecFin(a/2, b-2, c/2, Integer.toString(a*b*c));//
		}
		else {
			cum += ejercicio1RecFin(a/3, b-3, c/3, Integer.toString(a+b+c));//
		}
		return cum;
	}
	
	public static String ejercicio1RecNoFin(Integer a, Integer b, Integer c, String cum) {
		if(a<3 && b<3 && c<3) {
			cum ="(" + Integer.toString(a*b*c) + ")";
		}
		else if(a<5 || b<5 || c<5) {
			cum ="(" + Integer.toString(a+b+c) + ")";
		}
		else if(a%2 == 0 && b%2 == 0 && c%2 == 0) {
			cum = Integer.toString(a*b*c) + ejercicio1RecNoFin(a/2, b-2, c/2, cum);
		}
		else {
			cum = Integer.toString(a+b+c) + ejercicio1RecNoFin(a/3, b-3, c/3, cum);
		}
		return cum;
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
