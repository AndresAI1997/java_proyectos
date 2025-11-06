import java.util.ArrayList;

public class Curso extends ElementoEducativo{

    private double precio;
    private ArrayList<String> docentes;
    private ArrayList<String> palabrasClave;

    public Curso(String nombre, double precio){
        super(nombre);
        this.precio = precio;
        docentes = new ArrayList<>();
        palabrasClave = new ArrayList<>();
    }
    public void addPlabraClave(String p){
        if(!palabrasClave.contains(p)){
            palabrasClave.add(p);
        }
    }
    public double getPrecio() {
        return precio;
    }

    public ArrayList<String> getDocentes() {
        return new ArrayList<>(docentes);
    }


    public ArrayList<String> getPalabrasClave() {
        return new ArrayList<>(palabrasClave);
    }

    public int getCantidadCursos(){
        return 1;
    }

    public Curso getCopia(){
        Curso copia = getCascaron();
        for(String d: docentes){
            copia.addDocente(d);
        }
        for(String p: palabrasClave){
            copia.addPlabraClave(p);
        }

        return copia;
    }
    public Curso getCascaron(){
        return new Curso(getNombre(), precio);
    }

    public void addDocente(String d){
        docentes.add(d);
    }

    public Curso cursoMasCaro(){
        return this;
    }


    public ArrayList<ElementoEducativo> buscarCurso(Filtro f){
        ArrayList<ElementoEducativo> salida = new ArrayList<>();
        if(f.cumple(this)){
            salida.add(this);
        }
        return salida;
    }
}
