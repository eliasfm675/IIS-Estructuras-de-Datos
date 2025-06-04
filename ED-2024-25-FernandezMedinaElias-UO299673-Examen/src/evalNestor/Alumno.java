//  NO MODIFICAR NOMBRE DE ESTE PAQUETE
package evalNestor;

public class Alumno {
	// Poned vuestros apellidos, nombre y UO; sustituyendolos en las asignaciones de debajo...
	String nombre="Elias", // Primera en mayuscula y si es compuesto, sin espacios
			apellido1="Fernandez", // Primera en mayuscula y si es compuesto, sin espacios
			apellido2="Medina", // Primera en mayuscula y si es compuesto, sin espacios
			uo="UO299673"; // El UO en mayusculas
	
	public String getNombreFicheroAlumno(){
		return apellido1+apellido2+nombre+"-"+uo+"-2024-25";
	}

	public String email() {
		return uo+"@uniovi.es";
	}
	
}
