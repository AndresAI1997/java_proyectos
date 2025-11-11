package viajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaqueteSuperviaje extends Paquete {

    private static final String NOMBRE = "Paquete Superviaje";

    private final List<Paquete> paquetes;

    public PaqueteSuperviaje(String identificador, int cantidadPasajeros, Paquete paqueteInicial) {
        setNombre(NOMBRE);
        setIdentificador(identificador);
        setCantidadPasajeros(cantidadPasajeros);
        this.paquetes = new ArrayList<>();
        if (paqueteInicial.getCantidadPasajeros() != cantidadPasajeros) {
            throw new IllegalArgumentException(
                    "La cantidad de pasajeros del paquete inicial no coincide con la del superviaje");
        }
        if (!agregarPaquete(paqueteInicial)) {
            throw new IllegalStateException("No fue posible agregar el paquete inicial al superviaje");
        }
    }

    public List<Paquete> getPaquetes() {
        return new ArrayList<>(paquetes);
    }

    public boolean agregarPaquete(Paquete paquete) {
        if (paquete.getCantidadPasajeros() != getCantidadPasajeros()) {
            return false;
        }
        if (!paquetes.isEmpty()) {
            Paquete ultimo = paquetes.get(paquetes.size() - 1);
            if (ultimo.getCiudadDestino() == null
                    || paquete.getCiudadOrigen() == null
                    || !ultimo.getCiudadDestino().equals(paquete.getCiudadOrigen())) {
                return false;
            }
        }
        paquetes.add(paquete);
        recalcularDatos();
        return true;
    }

    private void recalcularDatos() {
        List<String> destinosInternos = destinosInternos();
        destinosInternos.clear();
        List<String> palabrasInternas = palabrasClaveInternas();
        palabrasInternas.clear();
        Paquete primero = paquetes.get(0);
        Paquete ultimo = paquetes.get(paquetes.size() - 1);
        setCiudadOrigen(primero.getCiudadOrigen());
        setFechaInicio(primero.getFechaInicio());
        setCiudadDestino(ultimo.getCiudadDestino());
        setFechaFin(ultimo.getFechaFin());

        double total = 0;
        LocalDate fechaPagoCalculada = null;
        boolean faltaFechaPago = false;
        for (Paquete paquete : paquetes) {
            total += paquete.getCosto();
            for (String destino : paquete.getDestinos()) {
                if (!destinosInternos.contains(destino)) {
                    destinosInternos.add(destino);
                }
            }
            for (String palabra : paquete.getPalabrasClave()) {
                if (!palabrasInternas.contains(palabra)) {
                    palabrasInternas.add(palabra);
                }
            }
            LocalDate pago = paquete.getFechaPago();
            if (pago == null) {
                faltaFechaPago = true;
            } else if (!faltaFechaPago && (fechaPagoCalculada == null || pago.isAfter(fechaPagoCalculada))) {
                fechaPagoCalculada = pago;
            }
        }
        setCosto(total);
        setFechaPago(faltaFechaPago ? null : fechaPagoCalculada);
    }
}
