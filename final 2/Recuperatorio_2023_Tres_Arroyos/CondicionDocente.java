public class CondicionDocente {
    private int docentesMin;

    public CondicionDocente(int docentesMin){
        this.docentesMin = docentesMin;
    }

    public boolean cumple(ElementoEducativo e){
        return e.getDocentes().size() > docentesMin;
    }
}
