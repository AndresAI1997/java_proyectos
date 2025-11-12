package VIAJES;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Paquete {
    // Clase base abstracta para paquetes de viaje.

    protected String nombre;
    protected String identificador;
    protected String ciudadOrigen;
    protected String ciudadDestino;
    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
    protected LocalDate fechaPago;
    protected double costo;
    protected int cantidadPasajeros;
    private final List<String> destinos = new ArrayList<>();
    private final List<String> palabrasClave = new ArrayList<>();

    protected Paquete() {
    }

   

    protected Paquete(
            String nombre,
            String identificador,
            String ciudadOrigen,
            String ciudadDestino,
            LocalDate fechaInicio,
            LocalDate fechaFin,
            LocalDate fechaPago,
            double costo,
            int cantidadPasajeros) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaPago = fechaPago;
        this.costo = costo;
        this.cantidadPasajeros = cantidadPasajeros;
        if (ciudadDestino != null) {
            agregarDestino(ciudadDestino);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public double getCosto() {
        return costo;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public List<String> getDestinos() {
        return new ArrayList<>(destinos);
    }

    public void agregarDestino(String destino) {
        if (destino != null && !destino.isEmpty() && !destinos.contains(destino)) {
            destinos.add(destino);
        }
    }

    public List<String> getPalabrasClave() {
        return new ArrayList<>(palabrasClave);
    }

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

    protected List<String> destinosInternos() {
        return destinos;
    }

    protected List<String> palabrasClaveInternas() {
        return palabrasClave;
    }

    // Eliminados setters para evitar modificaciones individuales después de construir
}
