package viajes.comparadores;

import java.util.Comparator;
import java.util.function.Function;

import viajes.Paquete;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ComparadorPaquete implements Comparator<Paquete> {

    private final Function<Paquete, Comparable> extractor;
    private final Comparator<Paquete> siguiente;

    public ComparadorPaquete(Function<Paquete, Comparable> extractor) {
        this(extractor, null);
    }

    public ComparadorPaquete(Function<Paquete, Comparable> extractor, Comparator<Paquete> siguiente) {
        this.extractor = extractor;
        this.siguiente = siguiente;
    }

    @Override
    public int compare(Paquete primero, Paquete segundo) {
        Comparable valorPrimero = extractor.apply(primero);
        Comparable valorSegundo = extractor.apply(segundo);
        if (valorPrimero == null && valorSegundo == null) {
            return siguiente == null ? 0 : siguiente.compare(primero, segundo);
        }
        if (valorPrimero == null) {
            return 1;
        }
        if (valorSegundo == null) {
            return -1;
        }
        int resultado = valorPrimero.compareTo(valorSegundo);
        if (resultado == 0 && siguiente != null) {
            return siguiente.compare(primero, segundo);
        }
        return resultado;
    }
}
