package VIAJES;

import java.time.LocalDate;

public class EscapadaRomantica extends Paquete {
    // Paquete para parejas (2 pasajeros).

    private static final String NOMBRE = "Escapada romantica";
    private static final int PASAJEROS_PAREJA = 2;

    public EscapadaRomantica(
            String identificador,
            String ciudadOrigen,
            String ciudadDestino,
            LocalDate fechaInicio,
            LocalDate fechaFin,
            LocalDate fechaPago,
            double costo) {
        super(NOMBRE, identificador, ciudadOrigen, ciudadDestino,
                fechaInicio, fechaFin, fechaPago, costo, PASAJEROS_PAREJA);
    }

    public void agregarPalabraClave(String palabraClave) {
        if (palabraClave != null && !palabraClave.isEmpty()
                && !palabrasClaveInternas().contains(palabraClave)) {
            palabrasClaveInternas().add(palabraClave);
        }
    }
}
