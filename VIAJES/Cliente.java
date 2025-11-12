package VIAJES;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    // Datos del cliente y sus preferencias.

    private String nombre;
    private String apellido;
    private int dni;
    private List<String> lugaresVisitados;
    private List<String> preferencias;

  
    public Cliente(String nombre, String apellido, int dni, List<String> lugaresVisitados, List<String> preferencias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.lugaresVisitados = new ArrayList<>(lugaresVisitados);
        this.preferencias = new ArrayList<>(preferencias);
    }

    public int getDni() {
        return this.dni;
    }

}
