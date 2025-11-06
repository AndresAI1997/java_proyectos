package viajes.filtros;

import java.time.LocalDate;

import viajes.Paquete;

public class FiltroFechaPagoIgualA extends Filtro {

    private LocalDate fecha;

    public FiltroFechaPagoIgualA(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean cumple(Paquete paquete) {
        return fecha != null && fecha.equals(paquete.getFechaPago());
    }
}
