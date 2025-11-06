package filesystem;

import java.util.ArrayList;
import java.util.Comparator;

public class Archivo extends ElementoSA{

    private double tamanio;

    public Archivo(String nombre, double tamanio) {
        super(nombre);
        setTamanio(tamanio);
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public double getTamanio() {
        return tamanio;
    }

    @Override
    /**
     * Retorna una lista con un elemento, si el archivo
     * cumple con la condición o una lista vacía en caso
     * contrario
     */
    public ArrayList<Archivo> buscar(Filtro condicion, Comparator<ElementoSA> orden) {
        ArrayList<Archivo> resultado =  new ArrayList<>();
        if (condicion.cumple(this))
            resultado.add(this);
        return resultado;
    }

    @Override
    public String toString() {
        return super.toString()
                +" ("+this.getTamanio()+" Kb)";
    }
}
