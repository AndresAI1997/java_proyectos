package filesystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Carpeta extends ElementoSA{
    private ArrayList<ElementoSA> elementos;

    public Carpeta(String nombre) {
        super(nombre);
        elementos = new ArrayList<>();
    }

    public void addElemento(ElementoSA nuevo){
        if (nuevo.getContenedor()!=null) {
            nuevo.getContenedor().eliminar(nuevo);
        }
        elementos.add(nuevo);
        nuevo.setContenedor(this);
    }

    private void eliminar(ElementoSA nuevo) {
        this.elementos.remove(nuevo);
    }

    public double getTamanio(){
        double tamTotal = 0.0;
        for (int i = 0; i < elementos.size(); i++) {
            tamTotal += elementos.get(i).getTamanio();
        }
        return tamTotal;
    }

    public int cantElementos(){
        int cant = super.cantElementos();
        for (int i = 0; i < elementos.size(); i++) {
            ElementoSA elemHijo = elementos.get(i);
            cant += elemHijo.cantElementos();
        }
        return cant;
    }

    public ArrayList<Archivo> buscar(Filtro condicion, Comparator<ElementoSA> orden){
        ArrayList<Archivo> resultado = new ArrayList<>();
        for (int i = 0; i < elementos.size(); i++) {
            ElementoSA elemHijo = elementos.get(i);

            //ArrayList<Archivo> resultadoParcial = elemHijo.buscar(condicion);
            //resultado.addAll(resultadoParcial);

            resultado.addAll(elemHijo.buscar(condicion, orden));

            //Si me piden que no haya repetidos
            //ArrayList<Archivo> resultadoParcial = elemHijo.buscar(condicion);
            //for (int j=0; j<resultadoParcial.size();j++)
            //    if (!resultado.contains(resultadoParcial.get(j)))
            //        resultado.add(resultadoParcial.get(j));

        }
        if (orden!=null)
            Collections.sort(resultado, orden);
        else
            Collections.sort(resultado);
        return resultado;
    }

}
