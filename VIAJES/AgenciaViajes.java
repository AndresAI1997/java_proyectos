package VIAJES;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import viajes.comparadores.ComparadorPaquete;
import viajes.filtros.Filtro;
import viajes.filtros.FiltroCostoMayorA;
import viajes.filtros.FiltroDestinoIgualA;
import viajes.filtros.FiltroFechaPagoIgualA;

public class AgenciaViajes {
    // Gestiona clientes y búsqueda/orden de paquetes.

    private List<Cliente> clientes;
    private List<Paquete> paquetes;

    public AgenciaViajes() {
        clientes = new ArrayList<>();
        paquetes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
    if (cliente == null) return;
    if (buscarClientePorDni(cliente.getDni()) == null) {
        clientes.add(cliente);
    }
}

    public Cliente buscarClientePorDni(int dni) {
        for (Cliente c : clientes) {
            if (c.getDni() == dni) return c;
        }
        return null;
    }




    public void agregarPaquete(Paquete paquete) {
    if (paquete == null) return;
    String id = paquete.getIdentificador();
    if (id == null) return;
    for (Paquete p : paquetes) {
        if (id.equals(p.getIdentificador())) {
            return; // ya existe uno con ese identificador
        }
    }
    paquetes.add(paquete);
}

    public List<Paquete> getPaquetes() {
        return new ArrayList<>(paquetes);
    }

    public List<Paquete> buscarPaquetesPorPalabraClave(String palabraClave) {
        return paquetes.stream()
                .filter(paquete -> paquete.getPalabrasClave().contains(palabraClave))
                .collect(Collectors.toList());
    }

    public List<Paquete> listarPaquetesPorDestinoOrdenados(String destino) {
        Filtro filtroDestino = new FiltroDestinoIgualA(destino);
        Comparator<Paquete> comparador = new ComparadorPaquete(
                Paquete::getCiudadOrigen,
                new ComparadorPaquete(Paquete::getIdentificador));
        return buscarPaquetes(filtroDestino, comparador);
    }

    public List<Paquete> listarPaquetesConCostoMayorA(double minimo) {
        Filtro filtro = new FiltroCostoMayorA(minimo);
        Comparator<Paquete> comparador = new ComparadorPaquete(
                Paquete::getCosto,
                new ComparadorPaquete(
                        Paquete::getFechaPago,
                        new ComparadorPaquete(Paquete::getIdentificador)));
        return buscarPaquetes(filtro, comparador);
    }

    public List<Paquete> listarPaquetesConFechaPago(LocalDate fecha) {
        Filtro filtro = new FiltroFechaPagoIgualA(fecha);
        Comparator<Paquete> comparador = new ComparadorPaquete(
                Paquete::getCosto,
                new ComparadorPaquete(
                        Paquete::getCantidadPasajeros,
                        new ComparadorPaquete(Paquete::getIdentificador)));
        return buscarPaquetes(filtro, comparador);
    }

    public List<Paquete> buscarPaquetes(Filtro filtro, Comparator<Paquete> comparador) {
        List<Paquete> resultado = new ArrayList<>();
        for (Paquete paquete : paquetes) {
            if (filtro == null || filtro.cumple(paquete)) {
                resultado.add(paquete);
            }
        }
        if (comparador != null) {
            resultado.sort(comparador);
        }
        return resultado;
    }

    public List<Paquete> buscarPaquetes(Filtro filtro) {
        return buscarPaquetes(filtro, null);
    }
}
