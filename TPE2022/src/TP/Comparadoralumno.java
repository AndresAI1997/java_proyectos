package TP;
import java.util.Comparator;

public class Comparadoralumno implements Comparator<Alumno>{

	@Override
	public int compare(Alumno a1, Alumno a2) {
		if(a1.nombre.compareTo(a2.nombre)==0) {
			if(a1.apellido.compareTo(a2.apellido)==0) {
				if(a1.DNI.compareTo(a2.DNI)==0){
					return a1.Edad.compareTo(a2.Edad);
				}
				else {
					return a1.DNI.compareTo(a2.DNI);
				}
			}
			else {
				return a1.apellido.compareTo(a2.apellido);
			}
			}
		else {
			return a1.nombre.compareTo(a2.nombre);
		}
	}
}
