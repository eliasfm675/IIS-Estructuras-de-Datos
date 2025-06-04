package p1Algoritmia;

public class Algorithms {
	private static final long SLEEP_TIME = 1;

	public static void doNothing() {
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Completad con los metodos que se os pidan...
	public long factorial (int n) { // Calcula el factorial de n>=0 de forma recursiva 
		if (n<0) 

		throw new IllegalArgumentException("No permitidos parámetros negativos como "+ n); 
		
		if(n==0) {
			return 1; 
		}else {
			return n*factorial(n-1);
		}
	}
	public long fibonacci(int n) { //sucesion de fibonacci recursiva n>=0
		if(n<0) {
			throw new IllegalArgumentException("No permitidos exponentes negativos como "+ n);
		}
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
	public long pow2Iter (int n) {  // calcula 2 elevado a n de forma iterativa 

	    if (n<0) 

	throw new IllegalArgumentException("No permitidos exponentes negativos como "+ n);
	    int result=2;
	    if(n==0) {
	    	result=1;
	    }
	    if(n<=63) {
	    	for(int i=0; i<n-1; i++) {
	    		result*=2;
	    	}
	    }
		return result;
	} 
	public long pow2Rec1(int n) { //Potencia de 2^n recursiva
		if(n<0) {
			throw new IllegalArgumentException("No permitidos exponentes negativos como "+ n);
		}
		if(n==0) {
			return 1;
		}
		return 2*pow2Rec1(n-1);
	}
	public long potenciaRec (int a, int b) { // Calcula a elevado a b de forma recursiva por potencias sucesivas 

		if (a<0 || b<0) 

		throw new IllegalArgumentException("No permitido alguno de los parámetros introducido"); 
		if(b==0) {
			return 1;
		}

		if(b==1) {
			return a;
		}
		return a*potenciaRec(a, b-1);
		 

		} 

		 

		public int restoDivRec (int a, int b) {  // calcula el resto de la división a/b de forma recursiva 

		if (a<0 || b<=0) 

		throw new IllegalArgumentException("No permitido alguno de los parámetros introducido"); 

		if(a<b) {
			return a;
		}
		return restoDivRec(a-b, b);

		 

		} 

		 

		public int divEntRec (int a, int b) {  // calcula la división entera a/b de forma recursiva 

		if (a<0 || b<=0) 

		throw new IllegalArgumentException("No permitido alguno de los parámetros introducido"); 
		if(a<b) {
			return 0;
		}

		return 1+divEntRec(a-b,b) ;

		 

		} 
		public int invertirEnteroRec(int n) {  // Invierte un entero invertirEnteroRec(1234)=4321 de forma recursiva 
			if(n<1) {
				return 0;
			}
			return (int) ((n%10)* Math.pow(10, countDigits(n)-1) + invertirEnteroRec(n/10)); 

			 

			} 
		/**
		 * Auxiliar del invertirEnteroRec
		 * @param n
		 * @return
		 */
		private int countDigits(int n) {
			if(n<1) {
				return 0;
			}
			return 1+(countDigits(n/10));
		}

			 

			public String invertirStringRec(String l) { // Invierte un string de forma recursiva invertirStringRec("abc")="cba" 

			if(l.isEmpty()) {
				return l;
			}
			return invertirStringRec(l.substring(1)) + l.charAt(0);

			 

			} 

			 

			public boolean esSimetrica(int[][] m) { // Indica si es simétrica una matriz cuadrada de forma recursiva 

			return false; 

			 

			} 
			public void linear (int n) { // Algoritmo con una complejidad temporal lineal 

				if (n<0) {

				throw new IllegalArgumentException("No permitidos parámetros negativos como "+ n); 

				} 
				for(int i = 0; i<n; i++) {
					doNothing();
				}
			}
			public void quadratic(int n) { // Algoritmo con una complejidad temporal cuadrática 

				if (n<0) 

				throw new IllegalArgumentException("No permitidos parámetros negativos como "+ n); 
				for(int i = 0; i<n; i++) {
					for(int j = 0; j<n; j++) {
						doNothing();
					}
				}

				} 

					 

			public void cubic(int n) { // Algoritmo con una complejidad temporal cúbica 

				if (n<0) 

					throw new IllegalArgumentException("No permitidos parámetros negativos como "+ n); 
				for(int i = 0; i<n; i++) {
					for(int j = 0; j<n; j++) {
						for(int k=0; k<n;k++) {
							doNothing();
						}
					}
				}

					} 

					 

				public void logarithmic(int n) { // Algoritmo con una complejidad temporal logarítmica en cualquier base 

					if (n<0) 

					throw new IllegalArgumentException("No permitidos parámetros negativos como "+ n); 
					for(int i = 0; i<n; i++) {
						doNothing();
						n=n/2;
					}

					} 
				public long pow2Rec11(int n) { //método pow2Rec1 pero con el doNothing() añadido
					doNothing();
					if(n<0) {
						throw new IllegalArgumentException("No permitidos exponentes negativos como "+ n);
					}
					if(n==0) {
						return 1;
					}
					
					return 2*pow2Rec11(n-1);
				}
				public long pow2Rec2(int n) { //calcula 2 elevado a n de forma recursiva 2^n = 2^(n-1)+2^(n-1)
					doNothing();
					if(n<0) {
						throw new IllegalArgumentException("No permitidos exponentes negativos como "+ n);
					}
					if(n==0) {
						return 1;
					}
					return pow2Rec2(n-1) + pow2Rec2(n-1);
				}
				public long pow2Rec3(int n) {  //calcula 2 elevado a n de forma recursiva 2^n = 2^(n/2)*2^(n/2) si n par y *2 si es impar
					doNothing();
					if(n<0) {
						throw new IllegalArgumentException("No permitidos exponentes negativos como "+ n);
					}
					if(n==0) {
						return 1;
					}
					if(n%2==0) {
						return pow2Rec3(n/2)*pow2Rec3(n/2);
					}else {
						return 2*pow2Rec3(n/2)*pow2Rec3(n/2);
					}
					
				}
				public long pow2Rec4 (int n) {  // calcula 2 elevado a n de forma recursiva 2^n = como pow2Rec3 pero sin repetir llamada 
					doNothing();
					if (n<0) {

					throw new IllegalArgumentException("No permitidos parámetros negativos como "+ n); 
					}
					if(n==0) {
						return 1;
					}
					if(n%2==0) {
						return (long) potenciaRec((int) pow2Rec4(n/2), 2);
						
					}else {
						return (long) ((long) 2*potenciaRec((int) pow2Rec4(n/2), 2));
					}

					} 
				/**
				 * Copia del método del factorial para las mediciones de tiempo
				 * @param n
				 * @return
				 */
				public long factorial1 (int n) { // Calcula el factorial de n>=0 de forma recursiva 
					doNothing();
					if (n<0) 
					throw new IllegalArgumentException("No permitidos parámetros negativos como "+ n); 
					
					if(n==0) {
						return 1; 
					}else {
						return n*factorial1(n-1);
					}
				}
				/**
				 * Copia del método de fibonacci para las mediciones de tiempo
				 * @param n
				 * @return
				 */
				public long fibonacci1(int n) {
					doNothing();
					if(n<0) {
						throw new IllegalArgumentException("No permitidos exponentes negativos como "+ n);
					}
					if(n==0) {
						return 0;
					}
					if(n==1) {
						return 1;
					}
					return fibonacci1(n-1)+fibonacci1(n-2);
				}
				public long pow2Iter1 (int n) {  // calcula 2 elevado a n de forma iterativa 

				    if (n<0) 

				throw new IllegalArgumentException("No permitidos exponentes negativos como "+ n);
				    int result=2;
				    if(n==0) {
				    	doNothing();
				    	result=1;
				    }
				    if(n<=63) {
				    	for(int i=0; i<n-1; i++) {
				    		doNothing();
				    		result*=2;
				    	}
				    }
					return result;
				} 
				
			

			
}

			

