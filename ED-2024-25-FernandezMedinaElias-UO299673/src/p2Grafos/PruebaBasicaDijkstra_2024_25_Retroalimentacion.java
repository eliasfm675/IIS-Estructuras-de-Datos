package p2Grafos;

import static org.junit.jupiter.api.Assertions.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import evalNestor.EvalGraph;

class PruebaBasicaDijkstra_2024_25_Retroalimentacion {
	private static final double Inf=Double.POSITIVE_INFINITY;
	private static final boolean T = true;
	private static final boolean F = false; 

	LocalDateTime localTime = LocalDateTime.now();
	InetAddress inetAdd;

	@Test
	void testInicializadoInfinito() {
		EvalGraph<Integer> gInteger;
		DijkstraDataClass dij;
		gInteger=new EvalGraph<Integer>(20,new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
				new boolean[][]{{F, T, T, T, F, F, F, F, F, F, F},
								 {F, F, F, F, T, T, F, F, F, F, F},
								 {F, F, F, F, F, F, T, T, F, F, F},
								 {F, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, T, F, F, T, T, F},
								 {T, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, F, F, T, F, F, F},
								 {T, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, F, F, F, F, T, F},
								 {T, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, F, F, F, F, F, F}},
				new double[][]{{Inf, 14 , 13 , 12 ,Inf,Inf,Inf,Inf,Inf,Inf,Inf},
								 {Inf,Inf,Inf,Inf, 11 , 10 ,Inf,Inf,Inf,Inf,Inf},
								 {Inf,Inf,Inf,Inf,Inf,Inf, 9 , 8 ,Inf,Inf,Inf},
								 {Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf},
								 {Inf,Inf,Inf,Inf,Inf, 7 ,Inf,Inf, 6 , 5 ,Inf},
								 { 4 ,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf},
								 {Inf,Inf,Inf,Inf,Inf,Inf,Inf, 3 ,Inf,Inf,Inf},
								 { 2 ,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf},
								 {Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf, 1 ,Inf},
								 { 20 ,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf},
								 {Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf}}
							 );

		
		DijkstraDataClass res[] = new DijkstraDataClass[] {
				new DijkstraDataClass(11,0,new double[]{0.0,14.0,13.0,12.0,25.0,24.0,22.0,21.0,31.0,30.0,Inf},new int[]{-1,-1,-1,-1,1,1,2,2,4,4,-1}),
				new DijkstraDataClass(11,1,new double[]{14.0,0.0,27.0,26.0,11.0,10.0,36.0,35.0,17.0,16.0,Inf},new int[]{5,-1,0,0,-1,-1,2,2,4,4,-1}),
				new DijkstraDataClass(11,2,new double[]{10.0,24.0,0.0,22.0,35.0,34.0,9.0,8.0,41.0,40.0,Inf},new int[]{7,0,-1,0,1,1,-1,-1,4,4,-1}),
				new DijkstraDataClass(11,3,new double[]{Inf,Inf,Inf,0.0,Inf,Inf,Inf,Inf,Inf,Inf,Inf},new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}),
				new DijkstraDataClass(11,4,new double[]{11.0,25.0,24.0,23.0,0.0,7.0,33.0,32.0,6.0,5.0,Inf},new int[]{5,0,0,0,-1,-1,2,2,-1,-1,-1}),
				new DijkstraDataClass(11,5,new double[]{4.0,18.0,17.0,16.0,29.0,0.0,26.0,25.0,35.0,34.0,Inf},new int[]{-1,0,0,0,1,-1,2,2,4,4,-1}),
				new DijkstraDataClass(11,6,new double[]{5.0,19.0,18.0,17.0,30.0,29.0,0.0,3.0,36.0,35.0,Inf},new int[]{7,0,0,0,1,1,-1,-1,4,4,-1}),
				new DijkstraDataClass(11,7,new double[]{2.0,16.0,15.0,14.0,27.0,26.0,24.0,0.0,33.0,32.0,Inf},new int[]{-1,0,0,0,1,1,2,-1,4,4,-1}),
				new DijkstraDataClass(11,8,new double[]{21.0,35.0,34.0,33.0,46.0,45.0,43.0,42.0,0.0,1.0,Inf},new int[]{9,0,0,0,1,1,2,2,-1,-1,-1}),
				new DijkstraDataClass(11,9,new double[]{20.0,34.0,33.0,32.0,45.0,44.0,42.0,41.0,51.0,0.0,Inf},new int[]{-1,0,0,0,1,1,2,2,4,-1,-1}),
				new DijkstraDataClass(11,10,new double[]{Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,0.0},new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}),
		};
		
		try {
			inetAdd = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			System.err.println(e1.getMessage());
		}

		System.out.println("Sistema: "+inetAdd.toString());
		System.out.println("Fecha y hora: "+localTime.toString()+"\n");
		System.out.println("Empieza prueba dijkstra sobre el grafo:\n"+gInteger.toString());

		for (int i=0; i<11;i++) {
			try {
				dij=gInteger.dijkstra(i);
				assertEquals(res[i],dij ,"Error en dijkstra("+i+"): -->\n");
			} catch (Exception e) {
				System.err.println("Ha tenido lugar alguna excepción en dijkstra("+i+"): -->\n");
				e.printStackTrace();
			}
		}
		
		try {
			assertNull(gInteger.dijkstra(null));
		} catch (Exception e) {
			System.err.println("Ha tenido lugar alguna excepción en dijkstra(null): -->\n");
			e.printStackTrace();
		}
		
		try {
			assertNull(gInteger.dijkstra(11));
		} catch (Exception e) {
			System.err.println("Ha tenido lugar alguna excepción en dijkstra(11): -->\n");
			e.printStackTrace();
		}
		
		System.out.println("Termina prueba de dijkstra inicializada con Infinito");
	}

	@Test
	void testInicializadoMenos666() {
		EvalGraph<Integer> gInteger;
		DijkstraDataClass dij;
		gInteger=new EvalGraph<Integer>(20,new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
				new boolean[][]{{F, T, T, T, F, F, F, F, F, F, F},
								 {F, F, F, F, T, T, F, F, F, F, F},
								 {F, F, F, F, F, F, T, T, F, F, F},
								 {F, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, T, F, F, T, T, F},
								 {T, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, F, F, T, F, F, F},
								 {T, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, F, F, F, F, T, F},
								 {T, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, F, F, F, F, F, F}},
				new double[][]{{-666, 14 , 13 , 12 ,-666,-666,-666,-666,-666,-666,-666},
								 {-666,-666,-666,-666, 11 , 10 ,-666,-666,-666,-666,-666},
								 {-666,-666,-666,-666,-666,-666, 9 , 8 ,-666,-666,-666},
								 {-666,-666,-666,-666,-666,-666,-666,-666,-666,-666,-666},
								 {-666,-666,-666,-666,-666, 7 ,-666,-666, 6 , 5 ,-666},
								 { 4 ,-666,-666,-666,-666,-666,-666,-666,-666,-666,-666},
								 {-666,-666,-666,-666,-666,-666,-666, 3 ,-666,-666,-666},
								 { 2 ,-666,-666,-666,-666,-666,-666,-666,-666,-666,-666},
								 {-666,-666,-666,-666,-666,-666,-666,-666,-666, 1 ,-666},
								 { 20 ,-666,-666,-666,-666,-666,-666,-666,-666,-666,-666},
								 {-666,-666,-666,-666,-666,-666,-666,-666,-666,-666,-666}}
							 );

		
		DijkstraDataClass res[] = new DijkstraDataClass[] {
				new DijkstraDataClass(11,0,new double[]{0.0,14.0,13.0,12.0,25.0,24.0,22.0,21.0,31.0,30.0,Inf},new int[]{-1,-1,-1,-1,1,1,2,2,4,4,-1}),
				new DijkstraDataClass(11,1,new double[]{14.0,0.0,27.0,26.0,11.0,10.0,36.0,35.0,17.0,16.0,Inf},new int[]{5,-1,0,0,-1,-1,2,2,4,4,-1}),
				new DijkstraDataClass(11,2,new double[]{10.0,24.0,0.0,22.0,35.0,34.0,9.0,8.0,41.0,40.0,Inf},new int[]{7,0,-1,0,1,1,-1,-1,4,4,-1}),
				new DijkstraDataClass(11,3,new double[]{Inf,Inf,Inf,0.0,Inf,Inf,Inf,Inf,Inf,Inf,Inf},new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}),
				new DijkstraDataClass(11,4,new double[]{11.0,25.0,24.0,23.0,0.0,7.0,33.0,32.0,6.0,5.0,Inf},new int[]{5,0,0,0,-1,-1,2,2,-1,-1,-1}),
				new DijkstraDataClass(11,5,new double[]{4.0,18.0,17.0,16.0,29.0,0.0,26.0,25.0,35.0,34.0,Inf},new int[]{-1,0,0,0,1,-1,2,2,4,4,-1}),
				new DijkstraDataClass(11,6,new double[]{5.0,19.0,18.0,17.0,30.0,29.0,0.0,3.0,36.0,35.0,Inf},new int[]{7,0,0,0,1,1,-1,-1,4,4,-1}),
				new DijkstraDataClass(11,7,new double[]{2.0,16.0,15.0,14.0,27.0,26.0,24.0,0.0,33.0,32.0,Inf},new int[]{-1,0,0,0,1,1,2,-1,4,4,-1}),
				new DijkstraDataClass(11,8,new double[]{21.0,35.0,34.0,33.0,46.0,45.0,43.0,42.0,0.0,1.0,Inf},new int[]{9,0,0,0,1,1,2,2,-1,-1,-1}),
				new DijkstraDataClass(11,9,new double[]{20.0,34.0,33.0,32.0,45.0,44.0,42.0,41.0,51.0,0.0,Inf},new int[]{-1,0,0,0,1,1,2,2,4,-1,-1}),
				new DijkstraDataClass(11,10,new double[]{Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,0.0},new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}),
		};
		
		try {
			inetAdd = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("Sistema: "+inetAdd.toString());
		System.out.println("Fecha y hora: "+localTime.toString()+"\n");
		System.out.println("Empieza prueba dijkstra sobre el grafo:\n"+gInteger.toString());

		for (int i=0; i<11;i++) {
			try {
				dij=gInteger.dijkstra(i);
				assertEquals(res[i],dij ,"Error en dijkstra("+i+"): -->\n");
			} catch (Exception e) {
				System.err.println("Ha tenido lugar alguna excepción en dijkstra("+i+"): -->\n");
				e.printStackTrace();
			}
		}
		
		try {
			assertNull(gInteger.dijkstra(null));
		} catch (Exception e) {
			System.err.println("Ha tenido lugar alguna excepción en dijkstra(null): -->\n");
			e.printStackTrace();
		}
		
		try {
			assertNull(gInteger.dijkstra(11));
		} catch (Exception e) {
			System.err.println("Ha tenido lugar alguna excepción en dijkstra(11): -->\n");
			e.printStackTrace();
		}
		
		System.out.println("Termina prueba de dijkstra inicializada con -666");
	}
	
	@Test
	void testInicializadoTRES() {
		EvalGraph<Integer> gInteger;
		DijkstraDataClass dij;
		gInteger=new EvalGraph<Integer>(20,new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
				new boolean[][]{{F, T, T, T, F, F, F, F, F, F, F},
								 {F, F, F, F, T, T, F, F, F, F, F},
								 {F, F, F, F, F, F, T, T, F, F, F},
								 {F, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, T, F, F, T, T, F},
								 {T, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, F, F, T, F, F, F},
								 {T, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, F, F, F, F, T, F},
								 {T, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, F, F, F, F, F, F}},
				new double[][]{{3, 14 , 13 , 12 ,3,3,3,3,3,3,3},
								 {3,3,3,3, 11 , 10 ,3,3,3,3,3},
								 {3,3,3,3,3,3, 9 , 8 ,3,3,3},
								 {3,3,3,3,3,3,3,3,3,3,3},
								 {3,3,3,3,3, 7 ,3,3, 6 , 5 ,3},
								 { 4 ,3,3,3,3,3,3,3,3,3,3},
								 {3,3,3,3,3,3,3, 3 ,3,3,3},
								 { 2 ,3,3,3,3,3,3,3,3,3,3},
								 {3,3,3,3,3,3,3,3,3, 1 ,3},
								 { 20 ,3,3,3,3,3,3,3,3,3,3},
								 {3,3,3,3,3,3,3,3,3,3,3}}
							 );

		
		DijkstraDataClass res[] = new DijkstraDataClass[] {
				new DijkstraDataClass(11,0,new double[]{0.0,14.0,13.0,12.0,25.0,24.0,22.0,21.0,31.0,30.0,Inf},new int[]{-1,-1,-1,-1,1,1,2,2,4,4,-1}),
				new DijkstraDataClass(11,1,new double[]{14.0,0.0,27.0,26.0,11.0,10.0,36.0,35.0,17.0,16.0,Inf},new int[]{5,-1,0,0,-1,-1,2,2,4,4,-1}),
				new DijkstraDataClass(11,2,new double[]{10.0,24.0,0.0,22.0,35.0,34.0,9.0,8.0,41.0,40.0,Inf},new int[]{7,0,-1,0,1,1,-1,-1,4,4,-1}),
				new DijkstraDataClass(11,3,new double[]{Inf,Inf,Inf,0.0,Inf,Inf,Inf,Inf,Inf,Inf,Inf},new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}),
				new DijkstraDataClass(11,4,new double[]{11.0,25.0,24.0,23.0,0.0,7.0,33.0,32.0,6.0,5.0,Inf},new int[]{5,0,0,0,-1,-1,2,2,-1,-1,-1}),
				new DijkstraDataClass(11,5,new double[]{4.0,18.0,17.0,16.0,29.0,0.0,26.0,25.0,35.0,34.0,Inf},new int[]{-1,0,0,0,1,-1,2,2,4,4,-1}),
				new DijkstraDataClass(11,6,new double[]{5.0,19.0,18.0,17.0,30.0,29.0,0.0,3.0,36.0,35.0,Inf},new int[]{7,0,0,0,1,1,-1,-1,4,4,-1}),
				new DijkstraDataClass(11,7,new double[]{2.0,16.0,15.0,14.0,27.0,26.0,24.0,0.0,33.0,32.0,Inf},new int[]{-1,0,0,0,1,1,2,-1,4,4,-1}),
				new DijkstraDataClass(11,8,new double[]{21.0,35.0,34.0,33.0,46.0,45.0,43.0,42.0,0.0,1.0,Inf},new int[]{9,0,0,0,1,1,2,2,-1,-1,-1}),
				new DijkstraDataClass(11,9,new double[]{20.0,34.0,33.0,32.0,45.0,44.0,42.0,41.0,51.0,0.0,Inf},new int[]{-1,0,0,0,1,1,2,2,4,-1,-1}),
				new DijkstraDataClass(11,10,new double[]{Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,0.0},new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}),
		};
		
		try {
			inetAdd = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("Sistema: "+inetAdd.toString());
		System.out.println("Fecha y hora: "+localTime.toString()+"\n");
		System.out.println("Empieza prueba dijkstra sobre el grafo:\n"+gInteger.toString());

		for (int i=0; i<11;i++) {
			try {
				dij=gInteger.dijkstra(i);
				assertEquals(res[i],dij ,"Error en dijkstra("+i+"): -->\n");
			} catch (Exception e) {
				System.err.println("Ha tenido lugar alguna excepción en dijkstra("+i+"): -->\n");
				e.printStackTrace();
			}
		}
		
		try {
			assertNull(gInteger.dijkstra(null));
		} catch (Exception e) {
			System.err.println("Ha tenido lugar alguna excepción en dijkstra(null): -->\n");
			e.printStackTrace();
		}
		
		try {
			assertNull(gInteger.dijkstra(11));
		} catch (Exception e) {
			System.err.println("Ha tenido lugar alguna excepción en dijkstra(11): -->\n");
			e.printStackTrace();
		}
		
		System.out.println("Termina prueba de dijkstra inicializada con 3");
	}
	
	@Test
	void testInicializadoCERO() {
		EvalGraph<Integer> gInteger;
		DijkstraDataClass dij;
		gInteger=new EvalGraph<Integer>(20,new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
				new boolean[][]{{F, T, T, T, F, F, F, F, F, F, F},
								 {F, F, F, F, T, T, F, F, F, F, F},
								 {F, F, F, F, F, F, T, T, F, F, F},
								 {F, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, T, F, F, T, T, F},
								 {T, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, F, F, T, F, F, F},
								 {T, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, F, F, F, F, T, F},
								 {T, F, F, F, F, F, F, F, F, F, F},
								 {F, F, F, F, F, F, F, F, F, F, F}},
				new double[][]{{3, 14 , 13 , 12 ,3,3,3,3,3,3,3},
								 {3,3,3,3, 11 , 10 ,3,3,3,3,3},
								 {3,3,3,3,3,3, 9 , 8 ,3,3,3},
								 {3,3,3,3,3,3,3,3,3,3,3},
								 {3,3,3,3,3, 7 ,3,3, 6 , 5 ,3},
								 { 4 ,3,3,3,3,3,3,3,3,3,3},
								 {3,3,3,3,3,3,3, 3 ,3,3,3},
								 { 2 ,3,3,3,3,3,3,3,3,3,3},
								 {3,3,3,3,3,3,3,3,3, 1 ,3},
								 { 20 ,3,3,3,3,3,3,3,3,3,3},
								 {3,3,3,3,3,3,3,3,3,3,3}}
							 );

		
		DijkstraDataClass res[] = new DijkstraDataClass[] {
				new DijkstraDataClass(11,0,new double[]{0.0,14.0,13.0,12.0,25.0,24.0,22.0,21.0,31.0,30.0,Inf},new int[]{-1,-1,-1,-1,1,1,2,2,4,4,-1}),
				new DijkstraDataClass(11,1,new double[]{14.0,0.0,27.0,26.0,11.0,10.0,36.0,35.0,17.0,16.0,Inf},new int[]{5,-1,0,0,-1,-1,2,2,4,4,-1}),
				new DijkstraDataClass(11,2,new double[]{10.0,24.0,0.0,22.0,35.0,34.0,9.0,8.0,41.0,40.0,Inf},new int[]{7,0,-1,0,1,1,-1,-1,4,4,-1}),
				new DijkstraDataClass(11,3,new double[]{Inf,Inf,Inf,0.0,Inf,Inf,Inf,Inf,Inf,Inf,Inf},new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}),
				new DijkstraDataClass(11,4,new double[]{11.0,25.0,24.0,23.0,0.0,7.0,33.0,32.0,6.0,5.0,Inf},new int[]{5,0,0,0,-1,-1,2,2,-1,-1,-1}),
				new DijkstraDataClass(11,5,new double[]{4.0,18.0,17.0,16.0,29.0,0.0,26.0,25.0,35.0,34.0,Inf},new int[]{-1,0,0,0,1,-1,2,2,4,4,-1}),
				new DijkstraDataClass(11,6,new double[]{5.0,19.0,18.0,17.0,30.0,29.0,0.0,3.0,36.0,35.0,Inf},new int[]{7,0,0,0,1,1,-1,-1,4,4,-1}),
				new DijkstraDataClass(11,7,new double[]{2.0,16.0,15.0,14.0,27.0,26.0,24.0,0.0,33.0,32.0,Inf},new int[]{-1,0,0,0,1,1,2,-1,4,4,-1}),
				new DijkstraDataClass(11,8,new double[]{21.0,35.0,34.0,33.0,46.0,45.0,43.0,42.0,0.0,1.0,Inf},new int[]{9,0,0,0,1,1,2,2,-1,-1,-1}),
				new DijkstraDataClass(11,9,new double[]{20.0,34.0,33.0,32.0,45.0,44.0,42.0,41.0,51.0,0.0,Inf},new int[]{-1,0,0,0,1,1,2,2,4,-1,-1}),
				new DijkstraDataClass(11,10,new double[]{Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,Inf,0.0},new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}),
		};
		
		try {
			inetAdd = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("Sistema: "+inetAdd.toString());
		System.out.println("Fecha y hora: "+localTime.toString()+"\n");
		System.out.println("Empieza prueba dijkstra sobre el grafo:\n"+gInteger.toString());

		for (int i=0; i<11;i++) {
			try {
				dij=gInteger.dijkstra(i);
				assertEquals(res[i],dij ,"Error en dijkstra("+i+"): -->\n");
			} catch (Exception e) {
				System.err.println("Ha tenido lugar alguna excepción en dijkstra("+i+"): -->\n");
				e.printStackTrace();
			}
		}
		
		try {
			assertNull(gInteger.dijkstra(null));
		} catch (Exception e) {
			System.err.println("Ha tenido lugar alguna excepción en dijkstra(null): -->\n");
			e.printStackTrace();
		}
		
		try {
			assertNull(gInteger.dijkstra(11));
		} catch (Exception e) {
			System.err.println("Ha tenido lugar alguna excepción en dijkstra(11): -->\n");
			e.printStackTrace();
		}
		
		System.out.println("Termina prueba de dijkstra inicializada con 0");
	}
	
}
