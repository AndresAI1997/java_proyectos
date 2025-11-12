package viajes.filtros;

import java.util.Objects;

import VIAJES.Paquete;

public class FiltroDestinoIgualA extends Filtro {
    // Filtra por destino exacto.

    private String destino;

    public FiltroDestinoIgualA(String destino) {
        this.destino = destino;
    }

    @Override
    public boolean cumple(Paquete paquete) {
        return Objects.equals(destino, paquete.getCiudadDestino());
    }
}
