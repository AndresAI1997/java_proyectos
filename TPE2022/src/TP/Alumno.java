package TP;

import java.util.ArrayList;

public class Alumno {
	String nombre;
	String apellido;
	Integer DNI;
	Integer Edad;
	ArrayList<String> Palabrasclave;

	public Alumno(String nombre, Integer DNI, Integer Edad, String Apellido) {
		this.nombre = nombre;
		this.DNI = DNI;
		this.Edad = Edad;
		this.apellido = Apellido;
		this.Palabrasclave = new ArrayList<String>();

	}

	public void Addpalabraclave(String palabrasclave) {
		this.Palabrasclave.add(palabrasclave);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDNI() {
		return DNI;
	}

	public void setDNI(Integer DNI) {
		this.DNI = DNI;
	}

	public Integer getEdad() {
		return Edad;
	}

	public void setEdad(Integer edad) {
		Edad = edad;
	}

	public ArrayList<String> getPalabrasclave() {
		return Palabrasclave;
	}

	public void setPalabrasclave(ArrayList<String> palabrasclave) {
		Palabrasclave = palabrasclave;
	}

	public String toString() {
		return "Nombre: " + this.nombre + " Apellido: " + this.apellido + " DNI: " + this.DNI + " Edad: " + this.Edad;
	}
}
