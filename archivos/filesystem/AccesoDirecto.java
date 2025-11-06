package filesystem;

import java.util.ArrayList;
import java.util.Comparator;

public class AccesoDirecto extends ElementoSA{

    private static final String PREFIJO = "Acceso directo a ";
    private static final double TAMANIO = 1;
    private ElementoSA referencia;

    public AccesoDirecto(ElementoSA referencia) {
        super(PREFIJO+ referencia.getNombre());
        this.referencia = referencia;
    }

    @Override
    public double getTamanio() {
        return TAMANIO;
    }

    @Override
    public ArrayList<Archivo> buscar(Filtro condicion, Comparator<ElementoSA> orden) {
        return referencia.buscar(condicion, orden);
    }
}
