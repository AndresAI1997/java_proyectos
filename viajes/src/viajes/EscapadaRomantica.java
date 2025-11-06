package viajes;

import java.time.LocalDate;
import java.util.List;
public class EscapadaRomantica extends Paquete {

    private static final String NOMBRE = "Escapada romántica";
    private static final int PASAJEROS_PAREJA = 2;

    public EscapadaRomantica(
            String identificador,
            String ciudadOrigen,
            String ciudadDestino,
            LocalDate fechaInicio,
            LocalDate fechaFin,
            LocalDate fechaPago,
            double costo) {
        setNombre(NOMBRE);
        setIdentificador(identificador);
        setCiudadOrigen(ciudadOrigen);
        setCiudadDestino(ciudadDestino);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setFechaPago(fechaPago);
        setCosto(costo);
        setCantidadPasajeros(PASAJEROS_PAREJA);
        agregarDestino(ciudadDestino);
    }

    public void agregarPalabraClave(String palabraClave) {
        if (palabraClave != null && !palabraClave.isEmpty()) {
            List<String> palabras = palabrasClaveInternas();
            if (!palabras.contains(palabraClave)) {
                palabras.add(palabraClave);
            }
        }
    }
}
