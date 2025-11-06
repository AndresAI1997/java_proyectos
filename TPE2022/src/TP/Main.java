package TP;

import java.util.ArrayList;
import java.util.Comparator;
import TP.Comparadores.*;
import TP.Divisiones;

public class Main {

	public static void main(String[] args) {
		Comparator<Integer> compara = new ComparadorInt();
		Listavinculada<Integer> lista = new Listavinculada<Integer>(compara, false);
		lista.insertar(1);
		lista.insertar(2);
		lista.insertar(3);
		lista.eliminarOcurrencia(2);
		lista.invertirOrden();
		lista.insertar(2);
		lista.insertar(4);
		lista.insertar(0);
		lista.invertirOrden();
		System.out.println(lista.toString());
		Comparator<Alumno> comparador = new Comparadoralumno();
		Listavinculada<Alumno> listalumno = new Listavinculada<Alumno>(comparador, false);
		listalumno.insertar(new Alumno("juan", 234, 23, "perez"));
		listalumno.insertar(new Alumno("juan", 234, 23, "fernandez"));
		listalumno.insertar(new Alumno("juan", 234, 31, "perez"));
		listalumno.insertar(new Alumno("juan", 23453, 23, "perez"));
		listalumno.invertirOrden();
		Listavinculada<Alumno> listalumno1 = new Listavinculada<Alumno>(comparador, false);
		listalumno1.insertar(new Alumno("juancito", 2343, 18, "martinez"));
		Comparator<Divisiones> comparadorg = new ComparadorDivisiones();
		Listavinculada<Divisiones> listauni = new Listavinculada<Divisiones>(comparadorg, false);
		listauni.insertar(new Divisiones("exactas", null, listalumno));
		System.out.println(listauni.toString());
	}
}
