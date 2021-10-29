package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.lsi.common.Files2;

public class Ejercicio4 {

//	fn = 2*fn-1 + 4*fn-2 + 6*fn-3
//			f2 = 6, f1 = 4, f0 = 2
	
	
	public static long ejercicio4It(long n) {
		long tercero = 6;
		long segundo = 4;
		long primero = 2;
		long temporal1 = 2;
		long temporal2 = 4;
		int i = 0;
		while(i<n) {
			temporal1 = primero;
			temporal2 = segundo;
			primero = segundo;
			segundo = tercero;
			tercero = 2*tercero + 4*temporal2 + 6*temporal1;
			i++;
		}
		return primero;
	}
	
	public static long ejercicio4RecNoMem(Integer n, long cum) {
		if(n == 2) {
			return 6;
		}
		else if(n == 1) {
			return 4;
		}
		else if(n == 0) {
			return 2;
		}
		else {
			cum += 2*ejercicio4RecNoMem(n-1, cum) + 4*ejercicio4RecNoMem(n-2, cum) + 6*ejercicio4RecNoMem(n-3, cum);
		}
		return cum;
	}
	
	public static long ejercicio4RecMem(Integer n) {
		Map<Integer, Long> mem = new HashMap<Integer, Long>();
		return ejercicio4RecMem(n, mem);
	}
	
	public static long ejercicio4RecMem(Integer n, Map<Integer, Long> mem) {
		Long cum = null;
		
		if(mem.containsKey(n)) {
			cum = mem.get(n);
		}
		if(n == 2) {
			cum = (long) 6;
			mem.put(n, cum);
		}
		else if(n == 1) {
			cum = (long) 4;
			mem.put(n, cum);
		}
		else if(n == 0) {
			cum = (long) 2;
			mem.put(n, cum);
		}
		else {
			cum = 2*ejercicio4RecMem(n-1, mem) + 4*ejercicio4RecMem(n-2, mem) + 6*ejercicio4RecMem(n-3, mem);
			mem.put(n, cum);
		}
		return cum;
	}
	
	public static List<Integer> lector4(String ruta){
		List<Integer> res = new ArrayList<>();
		List<String> fichero = Files2.linesFromFile(ruta);
		for(String l:fichero) {
			res.add(Integer.parseInt(l.split("=")[1]));
		}
		return res;
	}
}
