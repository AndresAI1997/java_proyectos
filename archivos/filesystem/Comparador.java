package filesystem;

import java.util.Comparator;

public abstract class Comparador implements Comparator<ElementoSA> {
    private Comparator<ElementoSA> siguienteCriterio;

    public Comparador(Comparator<ElementoSA> siguienteCriterio) {
        this.siguienteCriterio = siguienteCriterio;
    }

    public abstract int comparar(ElementoSA o1, ElementoSA o2);
    @Override
    public int compare(ElementoSA o1, ElementoSA o2) {
        int resultado = comparar(o1,o2);
        if (resultado==0 && siguienteCriterio!=null)
            return siguienteCriterio.compare(o1,o2);
        return resultado;
    }
}
