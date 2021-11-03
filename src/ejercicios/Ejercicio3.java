package ejercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import us.lsi.common.Files2;
import us.lsi.common.IntegerSet;
import us.lsi.common.Preconditions;

public class Ejercicio3 {

	public static IntegerSet ejercicio3(List<Integer> lista, Integer a, Integer b) {
		IntegerSet res = IntegerSet.empty();
		return ejercicio3(lista, a, b, res, 0);
	}
	
	public static IntegerSet ejercicio3(List<Integer> lista, Integer a, Integer b, IntegerSet res, Integer cum){
		Integer puntero = binarySearch(lista, a);
		if(binarySearch(lista, b)==-1 || binarySearch(lista, a)==-1) {
			return res;
		}
		
		if(lista.get(puntero + cum)==b-1) {
			res.add(lista.get(puntero + cum));
		}
		else {
			res.add(lista.get(puntero + cum));
			ejercicio3(lista, a, b, res, cum-1);
		}
		return res;
	}
	
	public static <E extends Comparable<? super E>> int binarySearch(List<E> lista, E key){
		Comparator<E> ord = Comparator.naturalOrder();
		return bSearch(lista,0,lista.size(),key,ord);	
	}
	
	private static <E> int bSearch(List<E> lista, int i,int j, E key, Comparator<? super E> ord){
		Preconditions.checkArgument(j>=i);
		int r;
		int k;
		if(j-i == 0){
			r = -1;
		}else{
			k = (i+j)/2;
			int r1 = ord.compare(key,lista.get(k));
			if(r1==0){
				r = k;
			}else if(r1>0){
				r = bSearch(lista,i,k,key,ord);
			}else{
				r = bSearch(lista,k+1,j,key,ord);
			}
		}
		return r;
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
