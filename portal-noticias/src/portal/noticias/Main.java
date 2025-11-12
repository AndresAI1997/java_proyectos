package portal.noticias;

import java.util.List;

import portal.noticias.filtros.Filtro;
import portal.noticias.filtros.FiltroAND;
import portal.noticias.filtros.FiltroAutorIgualA;
import portal.noticias.filtros.FiltroCategoriaIgualA;
import portal.noticias.filtros.FiltroContenidoContiene;
import portal.noticias.filtros.FiltroTituloContiene;

/**
 * Ejemplos de uso del portal: creación de noticias/secciones,
 * aplicación de filtros y uso del servicio de palabras clave.
 */
public class Main {
    public static void main(String[] args) {
        // Noticias base
        Noticia n1 = new NoticiaGenerica(
            "Final Liga", "El partido terminó 2-1 con gol en el final", "Autor 1", "Deportes",
            List.of("fútbol", "liga", "final", "gol", "VAR")
        );

        Noticia n2 = new NoticiaGenerica(
            "Nuevo Smartphone", "Se lanza un smartphone con IA avanzada", "Autor 2", "Tecnología",
            List.of("software", "IA", "android")
        );

        Noticia nd = new NoticiaDeportiva(
            "Entrenamiento selección", "La selección entrena de cara a la copa", 
            List.of("selección", "qatar2022", "entrenamiento")
        );

        Noticia np = new NoticiaPatrocinada(
            "Compra ahora", "Ofertas imperdibles por tiempo limitado", "Publicidad", "Ads",
            List.of("promo", "descuento", "oferta")
        );

        // Completar palabras clave con el servicio (ejemplos)
        // Si el contenido contiene "Fútbol" -> agrega "deportes"
        n1 = ServicioPalabrasClave.agregarSi(n1, new FiltroContenidoContiene("Fútbol"), "deportes");
        // Si el contenido contiene "iphone" o "android" -> agrega "móviles"
        n2 = ServicioPalabrasClave.agregarSi(n2, new FiltroContenidoContiene("iphone"), "móviles");
        n2 = ServicioPalabrasClave.agregarSi(n2, new FiltroContenidoContiene("android"), "móviles");
        // Si el título contiene "heridos" -> agrega "policiales" y "urgente"
        n1 = ServicioPalabrasClave.agregarSi(n1, new FiltroTituloContiene("heridos"), "policiales", "urgente");

        // Ejemplo pedido: contenido "final de futbol" agrega "futbol" y "torneo"
        Noticia n3 = new NoticiaGenerica(
            "Final del torneo", "Se jugó la final de futbol en el estadio principal", "Autor 3", "Deportes",
            List.of()
        );
        n3 = ServicioPalabrasClave.agregarSi(n3, new FiltroContenidoContiene("final de futbol"), "futbol");
        n3 = ServicioPalabrasClave.agregarSi(n3, new FiltroContenidoContiene("final de futbol"), "torneo");
        System.out.println("n3 palabras clave por contenido: " + n3.getPalabrasClave());

        // Secciones específicas
        Secciones seccionDep = new SeccionGenerica("Sección Deportes", n1, nd);
        seccionDep.setPosicionCategoria(1); // tomará categoría del primer componente

        Secciones ultimoMomento = new SeccionUltimoMomento("Último Momento", n1, n2, nd, np);
        Secciones qatar = new SeccionQatar2022("Qatar 2022", n1, nd, n2);

        // Grupo/portada
        Grupos portada = new Grupos("Portada", seccionDep, ultimoMomento, qatar);
        portada.setPosicionCategoria(1);

        // Imprimir ejemplos de categorías y palabras clave
        System.out.println("Sección Último Momento - Categoría: " + ultimoMomento.getCategoria());
        System.out.println("Sección Último Momento - Palabras clave (top 5): " + ultimoMomento.getPalabrasClave());

        System.out.println("Sección Qatar2022 - Categoría: " + qatar.getCategoria());
        System.out.println("Sección Qatar2022 - Palabras clave (top 3): " + qatar.getPalabrasClave());

        System.out.println("Portada - Categoría por posición: " + portada.getCategoria());

        // Preparar universo de búsqueda (mezcla de componentes)
        List<ComponentePortal> universo = List.of(seccionDep, ultimoMomento, qatar, portada);

        // Filtros de ejemplo
        Filtro fDeportes = new FiltroCategoriaIgualA("Deportes");
        Filtro fTituloFinal = new FiltroTituloContiene("Final");
        Filtro fAutorErnesto = new FiltroAutorIgualA("Ernesto Cherq");
        Filtro fContenidoSmartphone = new FiltroContenidoContiene("smartphone");

        // Búsquedas y resultados
        System.out.println("\nFiltro: categoria=Deportes AND titulo contiene 'Final'");
        imprimirResultados(BuscadorNoticias.buscar(universo, new FiltroAND(fDeportes, fTituloFinal)));

        System.out.println("\nFiltro: autor=Ernesto Cherq (NoticiaDeportiva) ");
        imprimirResultados(BuscadorNoticias.buscar(universo, fAutorErnesto));

        System.out.println("\nFiltro: contenido contiene 'smartphone' (case-insensitive)");
        imprimirResultados(BuscadorNoticias.buscar(universo, fContenidoSmartphone));

        System.out.println("\nNota: NoticiaPatrocinada siempre cumple cualquier filtro (se incluye siempre)");
        imprimirResultados(BuscadorNoticias.buscar(universo, fDeportes));
    }

    private static void imprimirResultados(List<Noticia> noticias) {
        if (noticias.isEmpty()) {
            System.out.println("- (sin resultados)");
            return;
        }
        for (Noticia n : noticias) {
            System.out.println("- " + n.getTitulo() + " | " + n.getCategoria() + " | " + n.getAutor());
        }
    }
}
