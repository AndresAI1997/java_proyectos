package TP;

import java.util.ArrayList;

public class Divisiones {
	String Nombregrupo;
	ArrayList<Listavinculada<Divisiones>> grupos;
	Listavinculada<Alumno> alumnosueltos;

	public Divisiones(String nombre, ArrayList<Listavinculada<Divisiones>> grupo, Listavinculada<Alumno> primeralumno) {
		this.Nombregrupo = nombre;
		this.grupos = grupo;
		this.alumnosueltos = primeralumno;

	}

	public String toString() {
		return "Nombre: " + this.Nombregrupo + ", Alumnos: " + this.alumnosueltos.toString();
	}
}