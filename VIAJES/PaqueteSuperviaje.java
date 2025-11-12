package VIAJES;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaqueteSuperviaje extends Paquete {
    // Agrupa paquetes y calcula totales.

    // Lista de subpaquetes que componen el superviaje
    private final List<Paquete> subpaquetes = new ArrayList<>();

    public PaqueteSuperviaje() {
        super();
    }

    public PaqueteSuperviaje(String nombre, int cantidadPasajeros,String identificador) {
        this.nombre = nombre;
        this.cantidadPasajeros = cantidadPasajeros;
        this.identificador = identificador;
    }

    public List<Paquete> getSubpaquetes() {
        return new ArrayList<>(subpaquetes);
    }

    // Carga subpaquetes: busca el primero que coincida en cantidad de pasajeros.
    // Luego agrega siguientes solo si encadenan origen/destino y mantienen misma cantidad.
    public void cargarSubpaquetes(List<Paquete> entrantes) {
        if (entrantes == null || entrantes.isEmpty()) return;

        List<Paquete> copia = new ArrayList<>();
        int pasajeros = this.getCantidadPasajeros();
        Paquete anterior = null;

        for (Paquete p : entrantes) {
            if (p == null) continue;

            if (copia.isEmpty()) {
                if (p.getCantidadPasajeros() == pasajeros) {
                    copia.add(p);
                    anterior = p;
                } // si no coincide, sigue buscando
            } else {
                boolean mismaCantidad = p.getCantidadPasajeros() == pasajeros;
                boolean encadena = anterior.getCiudadDestino() != null
                        && p.getCiudadOrigen() != null
                        && anterior.getCiudadDestino().equals(p.getCiudadOrigen());
                if (mismaCantidad && encadena) {
                    copia.add(p);
                    anterior = p;
                }
            }
        }

        subpaquetes.clear();
        subpaquetes.addAll(copia);
    }

    // Derivados desde los subpaquetes
    @Override
    public String getCiudadOrigen() {
        if (subpaquetes.isEmpty()) return null;
        return subpaquetes.get(0).getCiudadOrigen();
    }

    @Override
    public String getCiudadDestino() {
        if (subpaquetes.isEmpty()) return null;
        return subpaquetes.get(subpaquetes.size() - 1).getCiudadDestino();
    }

    @Override
    public LocalDate getFechaInicio() {
        if (subpaquetes.isEmpty()) return null;
        return subpaquetes.get(0).getFechaInicio();
    }

    @Override
    public LocalDate getFechaFin() {
        if (subpaquetes.isEmpty()) return null;
        return subpaquetes.get(subpaquetes.size() - 1).getFechaFin();
    }

    @Override
    public double getCosto() {
        double total = 0.0;
        for (Paquete p : subpaquetes) {
            if (p != null) total += p.getCosto();
        }
        return total;
    }

    @Override
    public LocalDate getFechaPago() {
        if (subpaquetes.isEmpty()) return null;
        LocalDate max = null;
        for (Paquete p : subpaquetes) {
            if (p == null) continue;
            LocalDate fp = p.getFechaPago();
            if (fp == null) return null; // si alguno es null, todo es null
            if (max == null || fp.isAfter(max)) max = fp;
        }
        return max;
    }

    @Override
    public List<String> getPalabrasClave() {
        List<String> todas = new ArrayList<>();
        for (Paquete p : subpaquetes) {
            if (p == null) continue;
            for (String palabra : p.getPalabrasClave()) {
                if (palabra != null && !todas.contains(palabra)) {
                    todas.add(palabra);
                }
            }
        }
        return todas;
    }

    @Override
    public List<String> getDestinos() {
        List<String> todos = new ArrayList<>();
        for (Paquete p : subpaquetes) {
            if (p == null) continue;
            for (String destino : p.getDestinos()) {
                if (destino != null && !todos.contains(destino)) {
                    todos.add(destino);
                }
            }
        }
        return todos;
    }

    // Evitar imprimir la lista de subpaquetes en la representación de texto
    @Override
    public String toString() {
        return String.format(
                "%s{id=%s, origen=%s, destino=%s, inicio=%s, fin=%s, pago=%s, costo=%.2f, pax=%d}",
                getNombre(),
                getIdentificador(),
                getCiudadOrigen(),
                getCiudadDestino(),
                getFechaInicio(),
                getFechaFin(),
                getFechaPago(),
                getCosto(),
                getCantidadPasajeros());
    }
    
}
