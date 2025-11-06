public class CondicionAnd  extends Filtro{
    private Filtro f1;
    private Filtro f2;

    public CondicionAnd(Filtro f1, Filtro f2){
        this.f1 = f1;
        this.f2 = f2;
    }

    public boolean cumple(ElementoEducativo e){
        return f1.cumple(e) && f1.cumple(e) && ;
        //                  ||
        //     !f1.cumple(e)
    }
}
