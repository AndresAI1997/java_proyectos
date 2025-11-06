public class CondicionTienePalabra extends Filtro {
    private String palabra;

    public CondicionTienePalabra(String palabra){
        this.palabra = palabra;
    }

    public boolean cumple(ElementoEducativo e){
        return e.getPalabrasClave().contains(palabra);
    }
}
