package ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Files2;
import us.lsi.common.IntegerSet;

public class Ejercicio3 {

	public static IntegerSet ejercicio3(List<Integer> lista, Integer a, Integer b) {
		IntegerSet res = IntegerSet.empty();
		return ejercicio3(lista, a, b, res, 0, lista.size()-1);
	}
	
	public static IntegerSet ejercicio3(List<Integer> lista, Integer a, Integer b, IntegerSet res, Integer bot, Integer top){
		if(top - bot == 0) {
			res.add(lista.get(bot));
		}
		else {
			int mid = (bot + top)/2;
			if (lista.get(mid)>=a && lista.get(mid)<b) {
				
				 res.add(lista.get(mid));
				 return ejercicio3(lista, a, b, res, bot+1, top);
				 }
			else if (b<lista.get(mid)) {
				 return ejercicio3(lista, a, b, res, mid+1, top);
				 } 
			else if(a>=lista.get(mid)){
				 return ejercicio3(lista, a, b, res, mid+1, top);
				 }
				 
		}
		return res;
	}
	
	public static List<List<Integer>> lector3lista(String ruta) {
		List<List<Integer>> res = new ArrayList<>();
		List<String> fichero = Files2.linesFromFile(ruta);
		for(String l:fichero) {
			String[] array1 = l.split("#");
			String [] array2 = array1[0].split(",");
			List<Integer> aux = new ArrayList<>();
			for (int i = 0; i < array2.length; i++) {
				aux.add(Integer.parseInt(array2[i]));
			}
			res.add(aux);
		}
		return res;
	}
	
	public static List<List<Integer>> lector3Rango(String ruta){
		List<List<Integer>> res = new ArrayList<>();
		List<String> fichero = Files2.linesFromFile(ruta);
		for(String l:fichero) {
			String[] array1 = l.split("#");
			String [] array2 = array1[1].split(",");
			List<Integer> aux = new ArrayList<>();
			for (int i = 0; i < array2.length; i++) {
				aux.add(Integer.parseInt(array2[i]));
			}
			res.add(aux);
		}
		return res;
	}
}
