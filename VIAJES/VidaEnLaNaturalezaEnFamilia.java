package VIAJES;

import java.time.LocalDate;
public class VidaEnLaNaturalezaEnFamilia extends Paquete {
    // Paquete familiar en entornos naturales.

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
        super(NOMBRE, identificador, ciudadOrigen, ciudadDestino,
                fechaInicio, fechaFin, fechaPago, costo, cantidadIntegrantes);
    }

    public int getCantidadIntegrantes() {
        return getCantidadPasajeros();
    }
}
