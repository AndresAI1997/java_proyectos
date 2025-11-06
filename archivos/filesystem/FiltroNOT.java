package filesystem;

public class FiltroNOT extends Filtro{
    Filtro f1;

    public FiltroNOT(Filtro f1) {
        this.f1 = f1;
    }

    @Override
    public boolean |(Archivo dado) {
        return !f1.cumple(dado);
    }
}
