package viajes.filtros;

import java.time.LocalDate;

import VIAJES.Paquete;

public class FiltroFechaPagoIgualA extends Filtro {
    // Filtra por fecha de pago exacta.

    private LocalDate fecha;

    public FiltroFechaPagoIgualA(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean cumple(Paquete paquete) {
        return fecha != null && fecha.equals(paquete.getFechaPago());
    }
}
