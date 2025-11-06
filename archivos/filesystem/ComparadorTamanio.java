package filesystem;

import java.util.Comparator;

public class ComparadorTamanio implements Comparator<ElementoSA> {
    @Override
    public int compare(ElementoSA o1, ElementoSA o2) {
        double resultado = o1.getTamanio() - o2.getTamanio();
        if (resultado<0)
            return -1;
        else if (resultado>0) return 1;
        else return 0;
    }
}
