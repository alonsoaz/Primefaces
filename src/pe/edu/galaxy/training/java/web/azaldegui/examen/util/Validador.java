package pe.edu.galaxy.training.java.web.azaldegui.examen.util;

public class Validador {

	public static String  dni(String dni){
		if (dni==null) {
			return "El dni es requerido";
		}
		if (dni.trim().length()!=8) {
			return "El dni debe tener 8 d�gitos";
		}
		if (!dni.matches("[0-9]+")) {
			return "El dni debe contener solo d�gitos";
		}
		
		return "";
	}
}
