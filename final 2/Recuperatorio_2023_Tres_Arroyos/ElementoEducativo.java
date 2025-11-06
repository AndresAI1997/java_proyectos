import java.util.ArrayList;

abstract public class ElementoEducativo {
    private String nombre;
    
    public ElementoEducativo(String nombre){
        this.nombre = nombre;
    }

    abstract public double getPrecio();
    abstract public ArrayList<String> getDocentes();
    abstract public ArrayList<String> getPalabrasClave();
    abstract public int getCantidadHorasCatedra();
    abstract public int getCantidadCursos();
    abstract public int getTipo();
    abstract public Curso cursoMasCaro();
    abstract ArrayList<ElementoEducativo> buscarCurso(Filtro f);


    public String getNombre(){
        return nombre;
    }
}  
