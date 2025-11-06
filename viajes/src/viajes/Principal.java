package viajes;

import java.time.LocalDate;
import java.util.List;

import viajes.comparadores.ComparadorPaquete;
import viajes.filtros.Filtro;
import viajes.filtros.FiltroAND;
import viajes.filtros.FiltroCostoMayorA;
import viajes.filtros.FiltroDestinoIgualA;

public class Principal {

    public static void main(String[] args) {
        AgenciaViajes agencia = new AgenciaViajes();

        Cliente cliente = new Cliente(
                "Ana",
                "Pérez",
                12345678,
                List.of("Madrid", "Bariloche"),
                List.of("montaña", "invierno"));

        agencia.agregarCliente(cliente);

        EscapadaRomantica escapadaRomantica = new EscapadaRomantica(
                "ROM-001",
                "Buenos Aires",
                "Realicó",
                LocalDate.of(2024, 2, 16),
                LocalDate.of(2024, 2, 18),
                LocalDate.of(2024, 1, 31),
                450000);

        escapadaRomantica.agregarPalabraClave("romántico");
        escapadaRomantica.agregarPalabraClave("fin de semana");

        agencia.agregarPaquete(escapadaRomantica);

        EscapadaRomantica escapadaCancun = new EscapadaRomantica(
                "ROM-002",
                "Córdoba",
                "Cancún",
                LocalDate.of(2024, 6, 1),
                LocalDate.of(2024, 6, 8),
                null,
                520000);

        agencia.agregarPaquete(escapadaCancun);

        EscapadaRomantica escapadaMayo = new EscapadaRomantica(
                "ROM-003",
                "Rosario",
                "Cancún",
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

        PaqueteSuperviaje superviajePatagonia = new PaqueteSuperviaje("SUP-001", 4, paqueteFamilia);
        superviajePatagonia.agregarPaquete(paqueteFamiliaSur);

        agencia.agregarPaquete(superviajePatagonia);

        System.out.println("Clientes registrados: " + agencia.getClientes());
        System.out.println("Paquetes disponibles: " + agencia.getPaquetes());
        System.out.println("Costo Superviaje Patagonia: $" + superviajePatagonia.getCosto());
        System.out.println("Fecha de pago acordada Superviaje: " + superviajePatagonia.getFechaPago());

        List<Paquete> destinoCancun = agencia.listarPaquetesPorDestinoOrdenados("Cancún");
        System.out.println("Paquetes a Cancún: " + destinoCancun);

        List<Paquete> costosos = agencia.listarPaquetesConCostoMayorA(100000);
        System.out.println("Paquetes con costo mayor a 100000: " + costosos);

        List<Paquete> pagoMayo = agencia.listarPaquetesConFechaPago(LocalDate.of(2022, 5, 25));
        System.out.println("Paquetes con pago el 25/05/2022: " + pagoMayo);

        Filtro filtroCancun = new FiltroDestinoIgualA("Cancún");
        Filtro filtroCostoso = new FiltroCostoMayorA(500000);
        Filtro filtroCombinado = new FiltroAND(filtroCancun, filtroCostoso);
        List<Paquete> resultadoPersonalizado = agencia.buscarPaquetes(
                filtroCombinado,
                new ComparadorPaquete(
                        Paquete::getCosto,
                        new ComparadorPaquete(Paquete::getIdentificador)));
        System.out.println("Paquetes Cancún costosos ordenados por costo: " + resultadoPersonalizado);
    }
}
