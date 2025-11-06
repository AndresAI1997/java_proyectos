package TP;

import java.util.Comparator;

public class ComparadorDivisiones implements Comparator<Divisiones> {
	Alumno alumno1;
	Alumno alumno2;

	@Override
	public int compare(Divisiones o1, Divisiones o2) {
		return o1.Nombregrupo.compareTo(o2.Nombregrupo);
	}
}
