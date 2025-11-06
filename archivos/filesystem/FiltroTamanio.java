package filesystem;

public class FiltroTamanio extends Filtro{
    private int tamLimite;

    public FiltroTamanio(int tamLimite) {
        this.tamLimite = tamLimite;
    }

    @Override
    public boolean cumple(Archivo dado) {
        return dado.getTamanio() < tamLimite;
    }
}
