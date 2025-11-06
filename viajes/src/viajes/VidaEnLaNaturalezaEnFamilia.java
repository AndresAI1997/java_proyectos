package viajes;

import java.time.LocalDate;
public class VidaEnLaNaturalezaEnFamilia extends Paquete {

    private static final String NOMBRE = "Vida en la naturaleza en familia";

    public VidaEnLaNaturalezaEnFamilia(
            String identificador,
            String ciudadOrigen,
            String ciudadDestino,
            LocalDate fechaInicio,
            LocalDate fechaFin,
            LocalDate fechaPago,
            double costo,
            int cantidadIntegrantes) {
        setNombre(NOMBRE);
        setIdentificador(identificador);
        setCiudadOrigen(ciudadOrigen);
        setCiudadDestino(ciudadDestino);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setFechaPago(fechaPago);
        setCosto(costo);
        setCantidadPasajeros(cantidadIntegrantes);
        agregarDestino(ciudadDestino);
    }

    public int getCantidadIntegrantes() {
        return getCantidadPasajeros();
    }
}
