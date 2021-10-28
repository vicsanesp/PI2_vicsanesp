package ejercicios;


public class Ejercicio5 {

//	hacer iterativo, y recursivo con y sin memoria de: 
//			a + b^2 + 2*c, a<3 Ã³ b<3 Ã³ c<3
//
//g(a,b,c)  g(a-1, b/2, c/2) + g(a-3, b/3, c/3),    a es multiplo de b
//
//			g(a/3, b-3, c-3) + g(a/2, b-2, c-2), eoc
	
//	public static Integer ejercicio5It(Integer a, Integer b, Integer c) {
//		Integer res = 0;
//		Integer[][][] g = null;
//		if(a<3 || b<3 || c<3) {
//			res = a + b*b + 2*c;
//		}
//		if(a%b == 0) {
//			res = g[a-1][b/2][c/2] + g[a-3][b/3][c/3];
//		}
//		else {
//			res = g[a/3][b-3][c-3] + g[a/2][b-2][c-2];
//		}
//		return res;
//	}
	
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
		Integer[][][] mem = null;
		return ejercicio5RecMem(a,b,c, mem);
	}
	
	public static Integer ejercicio5RecMem(Integer a, Integer b, Integer c, Integer[][][] mem) {
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
}
