package ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Files2;

public class Ejercicio4 {

	public static List<Integer> lector4(String ruta){
		List<Integer> res = new ArrayList<>();
		List<String> fichero = Files2.linesFromFile(ruta);
		for(String l:fichero) {
			res.add(Integer.parseInt(l.split("=")[1]));
		}
		return res;
	}
}
