package ejercicios;

import java.util.Map;
import us.lsi.common.Map2;

public class Ejercicio5 {

//	hacer iterativo, y recursivo con y sin memoria de: 
//			a + b^2 + 2*c, a<3 ÃƒÂ³ b<3 ÃƒÂ³ c<3
//
//g(a,b,c)  g(a-1, b/2, c/2) + g(a-3, b/3, c/3),    a es multiplo de b
//
//			g(a/3, b-3, c-3) + g(a/2, b-2, c-2), eoc
	
	private static record tripla( Integer a, Integer b, Integer c) {
		public static tripla of(Integer a, Integer b, Integer c) {
			return new tripla(a, b, c);
		}
	}
	
	public static Integer ejercicio5It(Integer a, Integer b, Integer c) {
		Map<tripla, Integer> res = Map2.empty();
		Integer cum = null;
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				for (int k = 0; k <= c; k++) {
					if(i<3 || j<3 || k<3) {
						cum = i + j*j + 2*k;
					}
					else if(i % j == 0) {
						cum = res.get(tripla.of(i-1, j/2, k/2)) + res.get(tripla.of(i-3, j/3, k/3));
					}
					else {
						cum = res.get(tripla.of(i/3, j-3, k-3)) + res.get(tripla.of(i/2, j-2, k-2));
					}
					res.put(tripla.of(i, j, k), cum);
				}
			}
		}
		return res.get(tripla.of(a, b, c));
	}
	
	public static Integer ejercicio5RecNoMem(Integer a, Integer b, Integer c) {
		if(a<3 || b<3 || c<3) {
			return a + b*b + 2*c;
		}
		else if(a % b == 0) {
			return ejercicio5RecNoMem(a-1, b/2, c/2) + ejercicio5RecNoMem(a-3, b/3, c/3);
		}
		else {
			return ejercicio5RecNoMem(a/3, b-3, c-3) + ejercicio5RecNoMem(a/2, b-2, c-2);
		}
	}
	
	public static Integer ejercicio5RecMem(Integer a, Integer b, Integer c) {
		Map<tripla, Integer> mem = Map2.empty();
		return ejercicio5RecMem(a,b,c, mem);
	}
	
	public static Integer ejercicio5RecMem(Integer a, Integer b, Integer c, Map<tripla, Integer> mem) {
		Integer cum = null;
		tripla key = tripla.of(a, b, c);
		if(mem.containsKey(key)) {
			return mem.get(key);
		}
		else {
			if(a<3 || b<3 || c<3) {
				cum = a + b*b + 2*c;
			}
			else if(a % b == 0) {
				cum = ejercicio5RecMem(a-1, b/2, c/2, mem) + ejercicio5RecMem(a-3, b/3, c/3, mem);
			}
			else {
				cum = ejercicio5RecMem(a/3,  b-3, c-3, mem) + ejercicio5RecMem(a/2, b-2, c-2, mem);
			}
			mem.put(key, cum);
		}
		return cum;
		
	}
}
