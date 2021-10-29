package test;

import java.util.ArrayList;
import java.util.List;

import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;
import ejercicios.Ejercicio4;
import ejercicios.Ejercicio5;
import us.lsi.common.Matrix;

public class Test {

	public static void main(String[] args) {
		System.out.println("========================Ejercicio 1======================================");
		List<List<Integer>> ej1 = Ejercicio1.lector1("ficheros/PI2Ej1DatosEntrada.txt");
		for(List<Integer> l:ej1) {
			System.out.println("(a, b, c) = " + l);
			System.out.println("Sol. Rec. No Final: " + Ejercicio1.ejercicio1RecNoFin(l.get(0), l.get(1), l.get(2), ""));
		}
		System.out.println("========================Ejercicio 2======================================");
		Matrix<String> ej21 = Ejercicio2.lector2("ficheros/PI2Ej2DatosEntrada1.txt");
		Matrix<String> ej22 = Ejercicio2.lector2("ficheros/PI2Ej2DatosEntrada2.txt");
		System.out.println("Entrada: ");
		for (int x=0; x < ej21.nc(); x++){
	        for (int y=0; y < ej21.nf(); y++)
	              System.out.print(ej21.get(x, y)+ " | ");   
	        System.out.println("\n----------------------------------------");
		}
		for (int i = 0; i < Ejercicio2.ejercicio2(ej21, new ArrayList<String>()).size(); i++) {
			System.out.println(i+1 + ") " + Ejercicio2.ejercicio2(ej21).get(i));
		}
		
		System.out.println("Entrada: ");
		for (int x=0; x < ej22.nc(); x++){
	        for (int y=0; y < ej22.nf(); y++)
	              System.out.print(ej22.get(x, y)+ " | ");   
	        System.out.println("\n----------------------------------------");
		}
		for (int i = 0; i < Ejercicio2.ejercicio2(ej22, new ArrayList<String>()).size(); i++) {
			System.out.println(i+1 + ") " + Ejercicio2.ejercicio2(ej22).get(i));
		}	
		
		
		System.out.println("========================Ejercicio 3======================================");
		List<List<Integer>> ej3lista = Ejercicio3.lector3lista("ficheros/PI2Ej3DatosEntrada.txt");
		List<List<Integer>> ej3rango = Ejercicio3.lector3Rango("ficheros/PI2Ej3DatosEntrada.txt");
		for (int i = 0; i < ej3lista.size(); i++) {
			System.out.println("Entrada: " + ej3lista.get(i) + " Rango: [" + ej3rango.get(i).get(0) + ", " + ej3rango.get(i).get(1) + ")");
			System.out.println("Conjunto obtenido: " + Ejercicio3.ejercicio3(ej3lista.get(i), ej3rango.get(i).get(0), ej3rango.get(i).get(1)));
		}
		
		System.out.println("========================Ejercicio 4======================================");
		List<Integer> ej4 = Ejercicio4.lector4("ficheros/PI2Ej4DatosEntrada.txt");
		for (int i = 0; i < ej4.size(); i++) {
			System.out.println("Entero de entrada  = " + ej4.get(i));
			System.out.println("Sol. Rec. sin memoria: " + Ejercicio4.ejercicio4RecNoMem(ej4.get(i), 0));
			System.out.println("Sol. Rec. con memoria: " + Ejercicio4.ejercicio4RecMem(ej4.get(i)));
			System.out.println("Sol. Iterativa: " + Ejercicio4.ejercicio4It(ej4.get(i)));
		}
		
		System.out.println("========================Ejercicio 5======================================");
		List<List<Integer>> ej5 = Ejercicio1.lector1("ficheros/PI2Ej5DatosEntrada.txt");
		for(List<Integer> l:ej5) {
			System.out.println("(a, b, c) = " + l);
			System.out.println("Sol. Rec. sin memoria: " + Ejercicio5.ejercicio5RecNoMem(l.get(0), l.get(1), l.get(2)));
		}

	}

}
