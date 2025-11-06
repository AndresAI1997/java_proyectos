package viajes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String apellido;
    private int dni;
    private List<String> lugaresVisitados;
    private List<String> preferencias;

    public Cliente(String nombre, String apellido, int dni) {
        this(nombre, apellido, dni, List.of(), List.of());
    }

    public Cliente(String nombre, String apellido, int dni, List<String> lugaresVisitados, List<String> preferencias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.lugaresVisitados = new ArrayList<>(lugaresVisitados);
        this.preferencias = new ArrayList<>(preferencias);
    }

    public int getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + dni + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cliente other = (Cliente) obj;
        return dni == other.dni;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(dni);
    }
}
