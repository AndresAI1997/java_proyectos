package viajes;

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

    private List<Cliente> clientes;
    private List<Paquete> paquetes;

    public AgenciaViajes() {
        clientes = new ArrayList<>();
        paquetes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    public Cliente buscarClientePorDni(int dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                return cliente;
            }
        }
        return null;
    }

    public void agregarPaquete(Paquete paquete) {
        if (!paquetes.contains(paquete)) {
            paquetes.add(paquete);
        }
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
