package filesystem;

public class Main {
    public static void main(String[] args) {
        Carpeta raiz = new Carpeta("\\");

        Carpeta tudai = new Carpeta("Tudai");
        Carpeta primero = new Carpeta("1er anio");
        raiz.addElemento(tudai);
        tudai.addElemento(primero);

        Archivo calendario = new Archivo("Calendario.pdf", 500.5);
        tudai.addElemento(calendario);

        Carpeta prog2 = new Carpeta("Prog2");
        primero.addElemento(prog2);

        Archivo parcial =  new Archivo("Parcial.doc", 100);
        Archivo recu = new Archivo("Recuperatorio.pdf", 800);
        prog2.addElemento(parcial);
        prog2.addElemento(recu);

        System.out.println("Tamanio de la raiz "+raiz.getTamanio());
        System.out.println("Tamanio de Prog2 "+prog2.getTamanio());
        System.out.println("Cantidad de elementos de la raiz "+raiz.cantElementos());




        Comprimido examenesViejos = new Comprimido("examenes.zip",0.5);

        Archivo parcial2 =  new Archivo("Parcial2.doc", 400);
        Archivo recu2 = new Archivo("Recuperatorio2.pdf", 600);
        examenesViejos.addElemento(parcial2);
        examenesViejos.addElemento(recu2);

        prog2.addElemento(examenesViejos);

        System.out.println(prog2.getTamanio());

        AccesoDirecto linkAProg2 = new AccesoDirecto(prog2);
        System.out.println(linkAProg2);

        System.out.println(raiz);

        System.out.println("Archivos de tamnio menor a 500 ordenados por el orden natural (alfabetico)");
        System.out.println(raiz.buscar(new FiltroTamanio(500), null));
        System.out.println("Archivos cuyo nombre contenga r, ordenado por tamanio");
        System.out.println(raiz.buscar(new FiltroNombre("r"), new ComparadorTamanio()));
        System.out.println("Archivos de tamanio MAYOR o igual a 500, ordenados por tamaño descendente");
        System.out.println(raiz.buscar(
                new FiltroNOT(new FiltroTamanio(500)), new ComparadorTamanio().reversed()));

    }
}