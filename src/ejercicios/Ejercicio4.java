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
