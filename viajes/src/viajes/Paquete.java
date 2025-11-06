package viajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Paquete {

    private String nombre;
    private String identificador;
    private String ciudadOrigen;
    private String ciudadDestino;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDate fechaPago;
    private double costo;
    private int cantidadPasajeros;
    private final List<String> destinos = new ArrayList<>();
    private final List<String> palabrasClave = new ArrayList<>();

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

    protected List<String> destinosInternos() {
        return destinos;
    }

    protected List<String> palabrasClaveInternas() {
        return palabrasClave;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    protected void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    protected void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    protected void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    protected void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    protected void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    protected void setCosto(double costo) {
        this.costo = costo;
    }

    protected void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }
}
