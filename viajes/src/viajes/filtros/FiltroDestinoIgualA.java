package viajes.filtros;

import java.util.Objects;

import viajes.Paquete;

public class FiltroDestinoIgualA extends Filtro {

    private String destino;

    public FiltroDestinoIgualA(String destino) {
        this.destino = destino;
    }

    @Override
    public boolean cumple(Paquete paquete) {
        return Objects.equals(destino, paquete.getCiudadDestino());
    }
}
