package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

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
	
	//record necesario para la version iterativa
	private static record tripla( Integer a, Integer b, Integer c) {
		public static tripla of(Integer a, Integer b, Integer c) {
			return new tripla(a, b, c);
		}
	}
	
	public static String ejercicio1It(Integer a, Integer b, Integer c) {
		//Memoria para guardar los valores para i, j y k
		Map<tripla, String> res = Map2.empty();
		//Acumulador
		String cum = "";
		//triple for pues necesitamos contruir la solucion desde abajo, y por tanto necesitamos 3 variables i, j, k 
		//que tomaran los valores hasta a, b y c
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				for (int k = 0; k <= c; k++) {
					if(i<3 && j<3 && k<3) {
						//metemos en el acumulador el primer caso base
						cum ="(" + Integer.toString(i*j*k) + ")";
					}
					else if(i<5 || j<5 || k<5) {
						//metemos en el acumulador el segundo caso base
						cum ="(" + Integer.toString(i+j+k) + ")";
					}
					else if(i%2 == 0 && j%2 == 0 && k%2 == 0) {
						//construimos la solucion con nuestra solucion guardada
						cum = Integer.toString(i*j*k) + res.get(tripla.of(i/2, j-2, k/2));
					}
					else {
						cum = Integer.toString(i+j+k) + res.get(tripla.of(i/3, j-3, k/3));
					}
					//guardamos la solucion
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
		//Seguimos tal cual la recursividad que se indica en el enunciado
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
		//Seguimos tal cual la recursividad que se indica en el enunciado
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
	
	//record necesario para la version funcional
	private static record IntegerRecord(Integer a, Integer b, Integer c, String res) {
		public static IntegerRecord of(Integer a, Integer b, Integer c, String res) {
			return new IntegerRecord(a, b, c, res);
		}
		
		//nuestro next() es basicamente nuestro ejercicio recursivo con ligeras diferencias
		public IntegerRecord next() {
			
			String cum = "";
			IntegerRecord aux = null;
			
			if (a < 3 && b < 3 && c < 3) {
				cum ="(" + Integer.toString(a*b*c) + ")";
				cum = res + "(" + Integer.toString(a*b*c) + ")";
				aux = IntegerRecord.of(a, b, c, cum);
				
			} else if (a < 5 || b < 5 || c < 5) {
				
				cum = res + "(" + Integer.toString(a+b+c) + ")";
				aux = IntegerRecord.of(a, b, c, cum);
				
			} else if (a%2==0 && b%2==0 && c%2==0) {
				
				cum = res + Integer.toString(a*b*c);
				aux = IntegerRecord.of(a/2, b-2, c/2, cum);
				
			} else {
				
				cum = res + Integer.toString(a+b+c);
				aux = IntegerRecord.of(a/3, b-3, c/3, cum);
				
			}
			
			return aux;
			
		}
		
	}
	
	public static String ejercicio1Fun(Integer a, Integer b, Integer c) {
		IntegerRecord inicial = IntegerRecord.of(a, b, c, "");
		Predicate<IntegerRecord> p = x -> ((x.a() < 3 && x.b() < 3 && x.c() < 3) || (x.a() < 5 || x.b() < 5 || x.c() < 5));
		Stream<IntegerRecord> stream = Stream.iterate(inicial, x -> x.next());
		Optional<IntegerRecord> op = stream.filter(x -> p.test(x) && x.res().contains(")")).findFirst();
		return op.get().res();
		
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
