package p2Grafos;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import evalNestor.Alumno;

public class PruebaBasicaGrafos_2024_25_Retroalimentacion {

	LocalDateTime localTime = LocalDateTime.now();
	InetAddress inetAdd;
	
	static int resInteger;
	static double resDouble;
	static boolean resBoolean;
	static String operacion;

	@Test
	public void mainTest() {
		Alumno al = new Alumno();

		try {
			inetAdd = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		FileWriter file = null;
		PrintWriter pw;

		try
		{
			file = new FileWriter(al.getNombreFicheroAlumno()+"-BasicaGrafos-1.txt",true);
			pw = new PrintWriter(file);

			pw.println("Sistema: "+inetAdd.toString());
			pw.println("Fecha y hora: "+localTime.toString()+"\n");
			
			try {
				pruebaBasicaGrafos_Nodes(pw);
			} catch (Exception e) {
				e.printStackTrace();
				pw.println("Termina la prueba basica de nodos con algun error...\n"+e.getMessage()+"\n");
			}
			try {
				pruebaBasicaGrafos_Edges(pw);
			} catch (Exception e) {
				e.printStackTrace();
				pw.println("Termina la prueba basica de nodos con algun error...\n"+e.getMessage()+"\n");
			}
			try {
				pruebaBasicaGrafos_Evolucion(pw);
			} catch (Exception e) {
				e.printStackTrace();
				pw.println("Termina la prueba basica de nodos con algun error...\n"+e.getMessage()+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		} 
	}

	static public void pruebaBasicaGrafos_Nodes(PrintWriter pw){
		Graph<Integer> g=new Graph<Integer>(3);
		int linea=1;
		pw.println("Empieza la prueba basica de nodos: ");		
		pw.println("g=new Graph<Integer>(3): ");		

		try {
			operacion=" g.existsNode(1): ";
			resBoolean=g.existsNode(1);
			pw.println((linea++)+operacion+resBoolean); // No existe    1
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsNode(2): ";
			resBoolean=g.existsNode(2);
			pw.println((linea++)+operacion+resBoolean); // No existe    2
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addNode(1): ";
			resBoolean=g.addNode(1);
			pw.println((linea++)+operacion+resBoolean); // Ya existe   3
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addNode(2): ";
			resBoolean=g.addNode(2);
			pw.println((linea++)+operacion+resBoolean); // Ya existe   4
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsNode(1): ";
			resBoolean=g.existsNode(1);
			pw.println((linea++)+operacion+resBoolean); // 5
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsNode(2): ";
			resBoolean=g.existsNode(2);
			pw.println((linea++)+operacion+resBoolean); // 6
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addNode(1): ";
			resBoolean=g.addNode(1);
			pw.println((linea++)+operacion+resBoolean); // Ya existe 7
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addNode(2): ";
			resBoolean=g.addNode(2);
			pw.println((linea++)+operacion+resBoolean); // Ya existe   8
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addNode(3): ";
			resBoolean=g.addNode(3);
			pw.println((linea++)+operacion+resBoolean); // 9
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			resBoolean=g.addNode(4);
			pw.println((linea++)+" g.addNode(4): "+resBoolean);
		} catch (Exception e) {
			pw.println((linea++)+" g.addNode(4): "+e.getMessage());  // no cabe  // 10
		}

		try {
			operacion=" g.existsNode(4): ";
			resBoolean=g.existsNode(4);
			pw.println((linea++)+operacion+resBoolean); // 11
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsNode(5): ";
			resBoolean=g.existsNode(5);
			pw.println((linea++)+operacion+resBoolean); // 12
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		pw.println("Termina la prueba basica de nodos.\n");

	}
	
	static public void pruebaBasicaGrafos_Edges(PrintWriter pw){
		Graph<Integer> g=new Graph<Integer>(3);
		int linea=1;
		pw.println("Empieza la prueba basica de aristas: ");		
		pw.println("g=new Graph<Integer>(3): ");		

		try {
			operacion=" g.existsEdge(1,2): ";
			resBoolean=g.existsEdge(1,2);
			pw.println((linea++)+operacion+resBoolean); // 1  -> no existe
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			resDouble=g.getEdge(1,2);
			pw.println((linea++)+" g.getEdge(1,2) --> "+resDouble); // 2
		} catch (Exception e) {
			pw.println((linea++)+" g.getEdge(1,2) --> "+e.getMessage()); // No existe   
		}

		try {
			operacion=" g.addNode(1): ";
			resBoolean=g.addNode(1);
			pw.println((linea++)+operacion+resBoolean); // 3
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(1,2): ";
			resBoolean=g.existsEdge(1,2);
			pw.println((linea++)+operacion+resBoolean); // 4   No existe
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		try {
			resDouble=g.getEdge(1,2);
			pw.println((linea++)+" g.getEdge(1,2) --> "+resDouble); // 5
		} catch (Exception e) {
			pw.println((linea++)+" g.getEdge(1,2) --> "+e.getMessage()); // No existe   
		}

		try {
			operacion=" g.existsEdge(2,1): ";
			resBoolean=g.existsEdge(2,1);
			pw.println((linea++)+operacion+resBoolean); // 6   No existe
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		try {
			resDouble=g.getEdge(2,1);
			pw.println((linea++)+" g.getEdge(2,1) --> "+resDouble); // 7
		} catch (Exception e) {
			pw.println((linea++)+" g.getEdge(2,1) --> "+e.getMessage()); // No existe   
		}
		
		try {
			operacion=" g.addNode(2): ";
			resBoolean=g.addNode(2);
			pw.println((linea++)+operacion+resBoolean); // 8
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(1,2): ";
			resBoolean=g.existsEdge(1,2);
			pw.println((linea++)+operacion+resBoolean); // 9   No existe
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		try {
			operacion=" g.getEdge(1,2) --> ";
			resDouble=g.getEdge(1,2);
			pw.println((linea++)+operacion+resDouble); // 10  No existe
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		try {
			operacion=" g.addEdge(1,2,12.12): ";
			resBoolean=g.addEdge(1,2,12.12);
			pw.println((linea++)+operacion+resBoolean); // 11  
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		try {
			operacion=" g.addEdge(1,2,12.1212): ";
			resBoolean=g.addEdge(1,2,12.1212);
			pw.println((linea++)+operacion+resBoolean); // 12 Ya existe  
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		try {
			operacion=" g.addNode(3): ";
			resBoolean=g.addNode(3);
			pw.println((linea++)+operacion+resBoolean); // 13
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(1,3): ";
			resBoolean=g.existsEdge(1,3);
			pw.println((linea++)+operacion+resBoolean); // 14 No existe   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(3,2): ";
			resBoolean=g.existsEdge(3,2);
			pw.println((linea++)+operacion+resBoolean); // 15 No existe   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.getEdge(1,3) --> ";
			resDouble=g.getEdge(1,3);
			pw.println((linea++)+operacion+resDouble); // 16 
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		try {
			operacion=" g.getEdge(3,2) --> ";
			resDouble=g.getEdge(3,2);
			pw.println((linea++)+operacion+resDouble); // 17 
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		for (int i=1; i<=3;i++)
			for (int j=1; j<=3; j++) {
				double peso=(10*i+j+(i/10d)+(j/100d));
//				pw.println((linea++)+" g.addEdge("+i+","+j+","+i+j+"."+i+j+"): "+g.addEdge(i,j,peso)); 
				try {
					operacion=" g.addEdge("+i+","+j+","+i+j+"."+i+j+"): ";
					resBoolean=g.addEdge(i,j,peso);
					pw.println((linea++)+operacion+resBoolean); // boolean   18-26
				} catch (Exception e) {
					pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
				}
			}
		for (int i=1; i<=3;i++)
			for (int j=1; j<=3; j++) {
//				pw.println((linea++)+" g.addEdge("+i+","+j+","+i+j+"."+i+j+"): "+g.addEdge(i,j,(10*i+j))); 
				try {
					operacion=" g.addEdge("+i+","+j+","+10*i+j+"): ";
					resBoolean=g.addEdge(i,j,(10*i+j));
					pw.println((linea++)+operacion+resBoolean); // boolean   27-35
				} catch (Exception e) {
					pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
				}
			}

		for (int i=1; i<=3;i++)
			for (int j=1; j<=3; j++) {
//				pw.println((linea++)+" g.getEdge("+i+","+j+") --> "+g.getEdge(i,j)); 
				try {
					operacion=" g.getEdge("+i+","+j+") --> ";
					resDouble=g.getEdge(i,j);
					pw.println((linea++)+operacion+resDouble); // Double 36-44 
				} catch (Exception e) {
					pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
				}
			}

		pw.println("Termina la prueba basica de aristas.\n");

	}

	
	static public void pruebaBasicaGrafos_Evolucion(PrintWriter pw){
		Graph<Integer> g=new Graph<Integer>(3);
		int linea=1;
		pw.println("Empieza la prueba basica de evolucion: ");		
		try {
			operacion=" g.existsNode(1): ";
			resBoolean=g.existsNode(1);
			pw.println((linea++)+operacion+resBoolean); // 1   No existe
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsNode(2): ";
			resBoolean=g.existsNode(2);
			pw.println((linea++)+operacion+resBoolean); // 2   No existe
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addNode(1): ";
			resBoolean=g.addNode(1);
			pw.println((linea++)+operacion+resBoolean); // 3   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addNode(2): ";
			resBoolean=g.addNode(2);
			pw.println((linea++)+operacion+resBoolean); // 4   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsNode(1): ";
			resBoolean=g.existsNode(1);
			pw.println((linea++)+operacion+resBoolean); // 5   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsNode(2): ";
			resBoolean=g.existsNode(2);
			pw.println((linea++)+operacion+resBoolean); // 6   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addNode(1): ";
			resBoolean=g.addNode(1);
			pw.println((linea++)+operacion+resBoolean); // 7 ya existe   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addNode(2): ";
			resBoolean=g.addNode(2);
			pw.println((linea++)+operacion+resBoolean); // 8 ya existe   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(1,2, 1.2): ";
			resBoolean=g.addEdge(1,2, 1.2);
			pw.println((linea++)+operacion+resBoolean); // 9   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(2,1, 2.1): ";
			resBoolean=g.addEdge(2,1, 2.1);
			pw.println((linea++)+operacion+resBoolean); // 10   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(1,1, 1.1): ";
			resBoolean=g.addEdge(1,1, 1.1);
			pw.println((linea++)+operacion+resBoolean); // 11   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.getEdge(1,2) --> ";
			resDouble=g.getEdge(1,2);
			pw.println((linea++)+operacion+resDouble); // 12 
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		try {
			operacion=" g.getEdge(2,1) --> ";
			resDouble=g.getEdge(2,1);
			pw.println((linea++)+operacion+resDouble); // 13
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		pw.println((linea++)+" g.getEdge(1,1) --> "+g.getEdge(1,1)); // 14
		try {
			resDouble=g.getEdge(2,3);
			pw.println((linea++)+" g.getEdge(2,3) --> "+resDouble);
		} catch (Exception e) {
			pw.println((linea++)+" g.getEdge(2,3) --> "+e.getMessage()); // No existe  // 15   
		}
		
		try {
			operacion=" g.existsEdge(1,2): ";
			resBoolean=g.existsEdge(1,2);
			pw.println((linea++)+operacion+resBoolean); // 16 
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(2,1): ";
			resBoolean=g.existsEdge(2,1);
			pw.println((linea++)+operacion+resBoolean); // 17
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(1,1): ";
			resBoolean=g.existsEdge(1,1);
			pw.println((linea++)+operacion+resBoolean); // 18   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(2,2): ";
			resBoolean=g.existsEdge(2,2);
			pw.println((linea++)+operacion+resBoolean); // 19 No existe
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}
		
		try {
			operacion=" g.removeEdge(2,2): ";
			resBoolean=g.removeEdge(2,2);
			pw.println((linea++)+operacion+resBoolean); // 20 No existe
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(2,2,2.2): ";
			resBoolean=g.addEdge(2,2,2.2);
			pw.println((linea++)+operacion+resBoolean); // 21   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.getEdge(2,2) --> ";
			resDouble=g.getEdge(2,2);
			pw.println((linea++)+operacion+resDouble); // 22
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		try {
			operacion=" g.existsEdge(2,2): ";
			resBoolean=g.existsEdge(2,2);
			pw.println((linea++)+operacion+resBoolean); // 23   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.removeEdge(2,2): ";
			resBoolean=g.removeEdge(2,2);
			pw.println((linea++)+operacion+resBoolean); // 24   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.removeNode(3): ";
			resBoolean=g.removeNode(3);
			pw.println((linea++)+operacion+resBoolean); // 25 No existe   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addNode(3): ";
			resBoolean=g.addNode(3);
			pw.println((linea++)+operacion+resBoolean); // 26   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			resBoolean=g.addNode(4);
			pw.println((linea++)+" g.addNode(4): "+resBoolean);
		} catch (Exception e) {
			pw.println((linea++)+" g.addNode(4): "+e.getMessage());  // 27 no cabe
		}
		
		try {
			operacion=" g.getEdge(1,3) --> ";
			resDouble=g.getEdge(1,3);
			pw.println((linea++)+operacion+resDouble); // 28  No existe
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		try {
			operacion=" g.addEdge(1,3, 1.3): ";
			resBoolean=g.addEdge(1,3, 1.3);
			pw.println((linea++)+operacion+resBoolean); // 29   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(1, 3): ";
			resBoolean=g.existsEdge(1, 3);
			pw.println((linea++)+operacion+resBoolean); // 30
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.getEdge(1,3) --> ";
			resDouble=g.getEdge(1,3);
			pw.println((linea++)+operacion+resDouble); // 31
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		try {
			resDouble=g.getEdge(1,4);
			pw.println((linea++)+" g.getEdge(1,4) --> "+resDouble);
		} catch (Exception e) {
			pw.println((linea++)+" g.getEdge(1,4) --> "+e.getMessage()); // No existe  // 32   
		}
		try {
			resDouble=g.getEdge(5,1);
			pw.println((linea++)+" g.getEdge(5,1) --> "+resDouble);
		} catch (Exception e) {
			pw.println((linea++)+" g.getEdge(5,1) --> "+e.getMessage()); // No existe  // 33   
		}
		try {
			resDouble=g.getEdge(5,4);
			pw.println((linea++)+" g.getEdge(5,4) --> "+resDouble);
		} catch (Exception e) {
			pw.println((linea++)+" g.getEdge(5,4) --> "+e.getMessage()); // No existe  // 34   
		}
	
		try {
			operacion=" g.removeNode(3): ";
			resBoolean=g.removeNode(3);
			pw.println((linea++)+operacion+resBoolean); // 35   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.removeNode(3): ";
			resBoolean=g.removeNode(3);
			pw.println((linea++)+operacion+resBoolean); // 36  No existe   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(1,3): ";
			resBoolean=g.existsEdge(1,3);
			pw.println((linea++)+operacion+resBoolean); // 37  No existe   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			resDouble=g.getEdge(1,3);
			pw.println((linea++)+" g.getEdge(1,3) --> "+resDouble);
		} catch (Exception e) {
			pw.println((linea++)+" g.getEdge(1,3) --> "+e.getMessage()); // No existe  // 38   
		}

		try {
			operacion=" g.removeNode(2): ";
			resBoolean=g.removeNode(2);
			pw.println((linea++)+operacion+resBoolean); // 39
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.removeNode(2): ";
			resBoolean=g.removeNode(2);
			pw.println((linea++)+operacion+resBoolean); // 40  No existe   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(1, 1): ";
			resBoolean=g.existsEdge(1, 1);
			pw.println((linea++)+operacion+resBoolean); // 41   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.removeNode(1): ";
			resBoolean=g.removeNode(1);
			pw.println((linea++)+operacion+resBoolean); // 42   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsNode(1): ";
			resBoolean=g.existsNode(1);
			pw.println((linea++)+operacion+resBoolean); // 43   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsNode(2): ";
			resBoolean=g.existsNode(2);
			pw.println((linea++)+operacion+resBoolean); // 44   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsNode(3): ";
			resBoolean=g.existsNode(3);
			pw.println((linea++)+operacion+resBoolean); // 45   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsNode(4): ";
			resBoolean=g.existsNode(4);
			pw.println((linea++)+operacion+resBoolean); // 46
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addNode(4): ";
			resBoolean=g.addNode(4);
			pw.println((linea++)+operacion+resBoolean); // 47   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsNode(4): ";
			resBoolean=g.existsNode(4);
			pw.println((linea++)+operacion+resBoolean); // 48   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(4,4, 4.4): ";
			resBoolean=g.addEdge(4,4, 4.4);
			pw.println((linea++)+operacion+resBoolean); // 49   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(4, 4): ";
			resBoolean=g.existsEdge(4, 4);
			pw.println((linea++)+operacion+resBoolean); // 50   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.getEdge(4,4) --> ";
			resDouble=g.getEdge(4,4);
			pw.println((linea++)+operacion+resDouble); // 51
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}


		try {
			operacion=" g.removeNode(4): ";
			resBoolean=g.removeNode(4);
			pw.println((linea++)+operacion+resBoolean); // 52   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.removeNode(4): ";
			resBoolean=g.removeNode(4);
			pw.println((linea++)+operacion+resBoolean); // 53 No existe  
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(4, 4): ";
			resBoolean=g.existsEdge(4, 4);
			pw.println((linea++)+operacion+resBoolean); // 54   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		
		try {
			operacion=" g.addNode(7): ";
			resBoolean=g.addNode(7);
			pw.println((linea++)+operacion+resBoolean); // 55   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}


		try {
			operacion=" g.removeNode(2): ";
			resBoolean=g.removeNode(2);
			pw.println((linea++)+operacion+resBoolean); // 56   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.removeNode(3): ";
			resBoolean=g.removeNode(3);
			pw.println((linea++)+operacion+resBoolean); // 57   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.removeNode(4): ";
			resBoolean=g.removeNode(4);
			pw.println((linea++)+operacion+resBoolean); // 58   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(7,7): ";
			resBoolean=g.existsEdge(7,7);
			pw.println((linea++)+operacion+resBoolean); // 59   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(7,7, 7.7): ";
			resBoolean=g.addEdge(7,7, 7.7);
			pw.println((linea++)+operacion+resBoolean); // 60   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(7,7, 17.17): ";
			resBoolean=g.addEdge(7,7, 17.17);
			pw.println((linea++)+operacion+resBoolean); // 61   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.getEdge(7,7) --> ";
			resDouble=g.getEdge(7,7);
			pw.println((linea++)+operacion+resDouble); // 62
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
		}

		try {
			operacion=" g.addNode(8): ";
			resBoolean=g.addNode(8);
			pw.println((linea++)+operacion+resBoolean); // 63   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addNode(9): ";
			resBoolean=g.addNode(9);
			pw.println((linea++)+operacion+resBoolean); // 64   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}


		try {
			operacion=" g.existsEdge(7, 8): ";
			resBoolean=g.existsEdge(7, 8);
			pw.println((linea++)+operacion+resBoolean); // 65   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(8,7): ";
			resBoolean=g.existsEdge(8,7);
			pw.println((linea++)+operacion+resBoolean); // 66   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(8,8): ";
			resBoolean=g.existsEdge(8,8);
			pw.println((linea++)+operacion+resBoolean); // 67   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(8,9): ";
			resBoolean=g.existsEdge(8,9);
			pw.println((linea++)+operacion+resBoolean); // 68   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(9,8): ";
			resBoolean=g.existsEdge(9,8);
			pw.println((linea++)+operacion+resBoolean); // 69   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.existsEdge(9,9): ";
			resBoolean=g.existsEdge(9,9);
			pw.println((linea++)+operacion+resBoolean); // 70   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(7,8, 7.8): ";
			resBoolean=g.addEdge(7,8, 7.8);
			pw.println((linea++)+operacion+resBoolean); // 71   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(8,7, 8.7): ";
			resBoolean=g.addEdge(8,7, 8.7);
			pw.println((linea++)+operacion+resBoolean); // 72   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(8,8, 8.8): ";
			resBoolean=g.addEdge(8,8, 8.8);
			pw.println((linea++)+operacion+resBoolean); // 73   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(8,9, 8.9): ";
			resBoolean=g.addEdge(8,9, 8.9);
			pw.println((linea++)+operacion+resBoolean); // 74   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(9,8, 9.8): ";
			resBoolean=g.addEdge(9,8, 9.8);
			pw.println((linea++)+operacion+resBoolean); // 75   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(9,9, 9.9): ";
			resBoolean=g.addEdge(9,9, 9.9);
			pw.println((linea++)+operacion+resBoolean); // 76   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(7,9, 7.9): ";
			resBoolean=g.addEdge(7,9, 7.9);
			pw.println((linea++)+operacion+resBoolean); // 77   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.addEdge(9,7, 9.7): ";
			resBoolean=g.addEdge(9,7, 9.7);
			pw.println((linea++)+operacion+resBoolean); // 78   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

	
		for (int i=7;i<=9;i++)
			for (int j=7; j<=9;j++)
				try {
					operacion=" g.getEdge("+i+", "+j+") --> ";
					resDouble=g.getEdge(i, j);
					pw.println((linea++)+operacion+resDouble); // 79-87
				} catch (Exception e) {
					pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage()); 
				}

		try {
			operacion=" g.removeNode(7): ";
			resBoolean=g.removeNode(7);
			pw.println((linea++)+operacion+resBoolean); // 88   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.removeNode(7): ";
			resBoolean=g.removeNode(7);
			pw.println((linea++)+operacion+resBoolean); // 89   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		for (int i=7;i<=9;i++)
			for (int j=7; j<=9;j++)
				try {
					resDouble=g.getEdge(i,j);
					pw.println((linea++)+" g.getEdge("+i+", "+j+") --> "+resDouble);
				} catch (Exception e) {
					pw.println((linea++)+" g.getEdge("+i+", "+j+") --> "+e.getMessage()); // 90 al 98  
				}
		
		try {
			resBoolean=g.removeNode(null);
			pw.println((linea++)+" g.removeNode(null): "+resBoolean);
		} catch (Exception e) {
			pw.println((linea++)+" g.removeNode(null): "+e.getMessage()); // 99  
		}
		
		try {
			resBoolean=g.addNode(null);
			pw.println((linea++)+" g.addNode(null): "+resBoolean);
		} catch (Exception e) {
			pw.println((linea++)+" g.addNode(null): "+e.getMessage()); // 100  
		}
		
		try {
			operacion=" g.addNode(10): ";
			resBoolean=g.addNode(10);
			pw.println((linea++)+operacion+resBoolean); // 101   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.getEdge(8, 10) --> ";
			resDouble=g.getEdge(8, 10);
			pw.println((linea++)+operacion+resDouble); // 102   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			operacion=" g.getEdge(10, 9) --> ";
			resDouble=g.getEdge(10, 9);
			pw.println((linea++)+operacion+resDouble); // 103   
		} catch (Exception e) {
			pw.println((linea++)+operacion+" genera excepcion --> "+e.getMessage());
		}

		try {
			resBoolean=g.addNode(null);
			pw.println((linea++)+" g.addNode(null): "+resBoolean);
		} catch (Exception e) {
			pw.println((linea++)+" g.addNode(null): "+e.getMessage()); // 104  
		}
		try {
			resBoolean=g.addEdge(8,8,-8.8);
			pw.println((linea++)+" g.addEdge(8,8,-8.8): "+resBoolean);
		} catch (Exception e) {
			pw.println((linea++)+" g.addEdge(8,8,-8.8): "+e.getMessage()); // 105  
		}
		try {
			resBoolean=g.addEdge(7,8,-7.8);
			pw.println((linea++)+" g.addEdge(7,8,-7.8): "+resBoolean);
		} catch (Exception e) {
			pw.println((linea++)+" g.addEdge(7,8,-7.8): "+e.getMessage()); // 106  
		}
		try {
			resBoolean=g.addEdge(8,7,-8.7);
			pw.println((linea++)+" g.addEdge(8,7,-8.7): "+resBoolean);
		} catch (Exception e) {
			pw.println((linea++)+" g.addEdge(8,7,-8.7): "+e.getMessage()); // 107
		}
		try {
			resBoolean=g.addEdge(7,7,-7.7);
			pw.println((linea++)+" g.addEdge(7,7,-7.7): "+resBoolean);
		} catch (Exception e) {
			pw.println((linea++)+" g.addEdge(7,7,-7.7): "+e.getMessage()); // 108
		}
		
		try {
			resBoolean=g.addEdge(null,8,0.8);
			pw.println((linea++)+" g.addEdge(null,8,0.8): "+resBoolean);
		} catch (Exception e) {
			pw.println((linea++)+" g.addEdge(null,8,0.8): "+e.getMessage()); // 109
		}
		try {
			resBoolean=g.addEdge(8,null,0.8);
			pw.println((linea++)+" g.addEdge(8,null,0.8): "+resBoolean);
		} catch (Exception e) {
			pw.println((linea++)+" g.addEdge(8,null,0.8): "+e.getMessage()); // 110
		}
		try {
			resBoolean=g.addEdge(null,null,0.8);
			pw.println((linea++)+" g.addEdge(null,null,0.8): "+resBoolean);
		} catch (Exception e) {
			pw.println((linea++)+" g.addEdge(null,null,0.8): "+e.getMessage()); // 111
		}
		try {
			resDouble=g.getEdge(null,10);
			pw.println((linea++)+" g.getEdge(null,10) --> "+resDouble);
		} catch (Exception e) {
			pw.println((linea++)+" g.getEdge(null,10) --> "+e.getMessage()); // 112
		}
		try {
			resDouble=g.getEdge(10,null);
			pw.println((linea++)+" g.getEdge(10,null) --> "+resDouble);
		} catch (Exception e) {
			pw.println((linea++)+" g.getEdge(10,null) --> "+e.getMessage()); // 113
		}
		try {
			resDouble=g.getEdge(null,null);
			pw.println((linea++)+" g.getEdge(null,null) --> "+resDouble);
		} catch (Exception e) {
			pw.println((linea++)+" g.getEdge(null,null) --> "+e.getMessage()); // 114
		}
		try {
			resBoolean=g.existsNode(null);
			pw.println((linea++)+" g.existsNode(null): "+resBoolean);  // 115
		} catch (Exception e) {
			pw.println((linea++)+" g.existsNode(null) --> "+e.getMessage()); // 115
		}
		try {
			resBoolean=g.existsEdge(null,null);
			pw.println((linea++)+" g.existsEdge(null,null): "+resBoolean);  // 116
		} catch (Exception e) {
			pw.println((linea++)+" g.existsEdge(null,null) --> "+e.getMessage()); // 116
		}
		pw.println("Termina la prueba basica de evolucion.");
	}
	
}
