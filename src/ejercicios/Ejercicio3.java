package ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Files2;

public class Ejercicio3 {

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
