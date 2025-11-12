package VIAJES;

import java.time.LocalDate;
import java.util.List;

import viajes.comparadores.ComparadorPaquete;
import viajes.filtros.Filtro;
import viajes.filtros.FiltroAND;
import viajes.filtros.FiltroCostoMayorA;
import viajes.filtros.FiltroDestinoIgualA;
import viajes.filtros.FiltroOrigenIgualA;
import viajes.filtros.FiltroCostoEntre;

public class main {
    // Punto de entrada para pruebas y demo.

    public static void main(String[] args) {
        AgenciaViajes agencia = new AgenciaViajes();

        Cliente cliente = new Cliente(
                "Ana",
                "Perez",
                12345678,
                List.of("Madrid", "Bariloche"),
                List.of("montaña", "invierno"));

        agencia.agregarCliente(cliente);

        EscapadaRomantica escapadaRomantica = new EscapadaRomantica(
                "ROM-001",
                "Buenos Aires",
                "Realico",
                LocalDate.of(2024, 2, 16),
                LocalDate.of(2024, 2, 18),
                LocalDate.of(2024, 1, 31),
                450000);

        escapadaRomantica.agregarPalabraClave("romántico");
        escapadaRomantica.agregarPalabraClave("fin de semana");

        agencia.agregarPaquete(escapadaRomantica);

        EscapadaRomantica escapadaCancun = new EscapadaRomantica(
                "ROM-002",
                "Cordoba",
                "Cancun",
                LocalDate.of(2024, 6, 1),
                LocalDate.of(2024, 6, 8),
                null,
                520000);

        agencia.agregarPaquete(escapadaCancun);

        EscapadaRomantica escapadaMayo = new EscapadaRomantica(
                "ROM-003",
                "El Calafate",
                "Cancun",
                LocalDate.of(2022, 5, 24),
                LocalDate.of(2022, 5, 27),
                LocalDate.of(2022, 5, 25),
                520000);

        agencia.agregarPaquete(escapadaMayo);

        VidaEnLaNaturalezaEnFamilia paqueteFamilia = new VidaEnLaNaturalezaEnFamilia(
                "VID-NAT-001",
                "Buenos Aires",
                "Villa La Angostura",
                LocalDate.of(2024, 1, 10),
                LocalDate.of(2024, 1, 20),
                LocalDate.of(2023, 12, 10),
                1850000,
                4);

        agencia.agregarPaquete(paqueteFamilia);

        VidaEnLaNaturalezaEnFamilia paqueteFamiliaSur = new VidaEnLaNaturalezaEnFamilia(
                "VID-NAT-002",
                "Villa La Angostura",
                "El Calafate",
                LocalDate.of(2024, 1, 20),
                LocalDate.of(2024, 1, 30),
                LocalDate.of(2023, 12, 20),
                2350000,
                4);

        PaqueteSuperviaje superviajePatagonia = new PaqueteSuperviaje(
                "Superviaje Patagonia", 4, "SUP-001");
        superviajePatagonia.cargarSubpaquetes(List.of(paqueteFamilia, paqueteFamiliaSur, escapadaCancun, escapadaMayo));

        agencia.agregarPaquete(superviajePatagonia);
        
        System.out.println("Costo Superviaje Patagonia: $" + superviajePatagonia.getCosto());
        System.out.println("Fecha de pago acordada Superviaje: " + superviajePatagonia.getFechaPago());

        String destinoBuscado = "Cancun"; // cambia este valor para otro destino
        List<Paquete> paquetesPorDestino = agencia.listarPaquetesPorDestinoOrdenados(destinoBuscado);
        imprimirLista("Paquetes a " + destinoBuscado, paquetesPorDestino);


        List<Paquete> costosos = agencia.listarPaquetesConCostoMayorA(100000);
        imprimirLista("Paquetes con costo mayor a 100000", costosos);

        List<Paquete> pagoMayo = agencia.listarPaquetesConFechaPago(LocalDate.of(2022, 5, 25));
        imprimirLista("Paquetes con pago el 25/05/2022", pagoMayo);

       Filtro filtrodestino = new FiltroDestinoIgualA(destinoBuscado);
        Filtro filtroCostoso = new FiltroCostoMayorA(500000);
        Filtro filtroCombinado = new FiltroAND(filtrodestino, filtroCostoso);
        List<Paquete> resultadoPersonalizado = agencia.buscarPaquetes(filtroCombinado, new ComparadorPaquete(Paquete::getCosto, new ComparadorPaquete(Paquete::getIdentificador)));
        imprimirLista("Paquetes " + destinoBuscado + " costosos ordenados por costo", resultadoPersonalizado);

        // Ejemplo con dos variables importantes: origen + costo entre
        Filtro filtroOrigen = new FiltroOrigenIgualA("Buenos Aires");
        Filtro filtroCostoEntre = new FiltroCostoEntre(1_000_000, 3_000_000);
        Filtro filtroDosVars = new FiltroAND(filtroOrigen, filtroCostoEntre);
        List<Paquete> desdeBAConCostoEntre = agencia.buscarPaquetes(filtroDosVars, new ComparadorPaquete(Paquete::getIdentificador));
        imprimirLista("Paquetes desde Buenos Aires con costo entre 1M y 3M", desdeBAConCostoEntre);

    }

    private static void imprimirLista(String titulo, List<Paquete> paquetes) {
        System.out.println(titulo + ":");
        for (Paquete p : paquetes) {
            System.out.println(" - " + p);
        }
    }
}
