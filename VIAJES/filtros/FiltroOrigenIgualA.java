package viajes.filtros;

import java.util.Objects;

import VIAJES.Paquete;

public class FiltroOrigenIgualA extends Filtro {
    // Filtra por origen exacto.

    private String origen;

    public FiltroOrigenIgualA(String origen) {
        this.origen = origen;
    }

    @Override
    public boolean cumple(Paquete paquete) {
        return Objects.equals(origen, paquete.getCiudadOrigen());
    }
}
