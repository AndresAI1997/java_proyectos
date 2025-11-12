# Viajes (Java)

Aplicación simple de consola para gestionar y consultar paquetes de viaje.

## Objetivo

Modelar distintos tipos de paquetes, cargarlos en una agencia y permitir búsquedas y ordenamientos con filtros y comparadores.

## Estructura principal

- `VIAJES.Paquete` (abstracta): base de todos los paquetes.
- `VIAJES.EscapadaRomantica`: paquete para parejas (2 pasajeros).
- `VIAJES.VidaEnLaNaturalezaEnFamilia`: paquete familiar.
- `VIAJES.PaqueteSuperviaje`: agrupa subpaquetes y calcula datos agregados.
- `VIAJES.Cliente`: datos básicos del cliente.
- `VIAJES.AgenciaViajes`: guarda paquetes/clientes y permite búsquedas.
- `viajes.comparadores.ComparadorPaquete`: comparador encadenable de campos.
- `viajes.filtros.*`: filtros reutilizables y combinables (AND/NOT).

## Paquete Superviaje (composición)

- Mantiene una lista interna de subpaquetes (`List<Paquete>`).
- Carga en bloque con validaciones (`cargarSubpaquetes`):
  - Busca el primer subpaquete que coincida en cantidad de pasajeros.
  - Luego solo agrega los que encadenen destino → origen y mantengan la cantidad.
- Calcula dinámicamente a partir de subpaquetes:
  - Origen (del primero) y destino (del último).
  - Fechas inicio/fin (primero/último).
  - Costo (suma de todos).
  - Fecha de pago (la más lejana; si alguna es null, resulta null).
  - Palabras clave y destinos (unión sin repetidos).
- `toString()` no imprime la lista de subpaquetes (solo resumen).

## Búsquedas y filtros

`AgenciaViajes.buscarPaquetes(Filtro, Comparator)` permite filtrar y ordenar.

Filtros incluidos:
- `FiltroDestinoIgualA`, `FiltroOrigenIgualA`.
- `FiltroCostoMayorA`, `FiltroCostoEntre`.
- `FiltroFechaPagoIgualA`.
- Composición: `FiltroAND`, `FiltroNOT`.

Ordenamiento: `ComparadorPaquete` (encadenable por campos, soporta nulls).

## Ejecución (VS Code)

Requisitos: JDK 17+ y extensiones de Java para VS Code.

Incluye configuración lista en `.vscode`:
- Compilar: `Ctrl+Shift+B` (tarea "Compilar Java (javac)").
- Ejecutar sin depurar: `Ctrl+F5` (config "Ejecutar VIAJES.main").
- Depurar: `F5`.

## Ejecución (terminal)

Windows PowerShell:

1) Compilar:
```
javac -encoding UTF-8 -d out *.java comparadores\*.java filtros\*.java
```
2) Ejecutar:
```
java -cp out VIAJES.main
```

Git Bash / Linux / macOS:
```
javac -encoding UTF-8 -d out *.java comparadores/*.java filtros/*.java && \
java -cp out VIAJES.main
```

## Notas de diseño

- Representación de salida legible con `toString()` en `Paquete`.
- `PaqueteSuperviaje` calcula todo en base a subpaquetes y protege su lista interna con copias.
- No hay persistencia ni interfaz gráfica; es una demo de modelo + consultas.

## Cómo extender

- Agregar filtros (p. ej. por fechas entre, palabras clave).
- Incorporar `FiltroOR` para combinaciones más flexibles.
- Crear nuevos tipos de `Paquete` con sus reglas y atributos específicos.

