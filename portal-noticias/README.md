# Portal Noticias

Mini‑portal de noticias en Java que modela noticias, secciones y grupos con filtros de búsqueda y un servicio para completar palabras clave sin romper encapsulamiento.

## Requisitos
- Java 11+ (recomendado Java 17)

## Estructura principal
- `portal.noticias.ComponentePortal`: contrato común (categoría, palabras clave) para tratar Noticias/Secciones/Grupos de forma homogénea.
- `portal.noticias.Noticia` (abstracta): título, contenido, autor, categoría y lista de palabras clave (encapsuladas). Subclases:
  - `NoticiaGenerica`: comportamiento base.
  - `NoticiaDeportiva`: autor fijo “Ernesto Cherq” y categoría “Deportes”.
  - `NoticiaPatrocinada`: siempre cumple cualquier filtro de búsqueda.
- `portal.noticias.UnionNotis` (abstracta): base para unir componentes. Almacena inmutablemente una lista de `ComponentePortal`, agrega palabras clave únicas y permite derivar categoría por posición 1‑based.
  - `Secciones` (abstracta): base para secciones.
    - `SeccionGenerica`: usa el comportamiento por defecto.
    - `SeccionUltimoMomento`: categoría fija “ultimo momento”; palabras clave ordenadas alfabéticamente y limitadas a 5.
    - `SeccionQatar2022`: categoría fija “qatar2022”; devuelve top 3 palabras clave.
  - `Grupos`: agrupador similar a sección, con categoría derivada por posición.
- `portal.noticias.filtros`:
  - `Filtro` (abstracta), `FiltroAND`, `FiltroNOT`.
  - Filtros concretos: `FiltroCategoriaIgualA`, `FiltroAutorIgualA`, `FiltroTituloContiene`, `FiltroContenidoContiene`, `FiltroContienePalabraClave`.
- `portal.noticias.BuscadorNoticias`: aplana la jerarquía y aplica un `Filtro`, devolviendo `List<Noticia>` inmutable, sin duplicados por título.
- `portal.noticias.ServicioPalabrasClave`: agrega palabras clave a una noticia (devuelve nueva instancia, preservando la subclase) usando un `Filtro` como condición.
- `portal.noticias.Main`: ejemplos de creación, filtrado y uso del servicio.

## Compilar y ejecutar (CLI)
Desde PowerShell/Terminal en Windows:
```powershell
cd portal-noticias\src
mkdir ..\out
javac -d ..\out -encoding UTF-8 portal/noticias/*.java portal/noticias/filtros/*.java
java -cp ..\out portal.noticias.Main
```

Desde bash:
```bash
cd portal-noticias/src
mkdir -p ../out
javac -d ../out -encoding UTF-8 portal/noticias/*.java portal/noticias/filtros/*.java
java -cp ../out portal.noticias.Main
```

## Uso rápido
Filtrar noticias dentro de una lista de componentes y deduplicar por título:
```java
List<ComponentePortal> universo = List.of(seccion, grupo);
Filtro filtro = new FiltroCategoriaIgualA("Deportes");
List<Noticia> res = BuscadorNoticias.buscar(universo, filtro); // lista inmutable
```

Agregar palabras clave según condiciones reutilizando filtros existentes:
```java
Noticia n = new NoticiaGenerica("T", "contenido con Fútbol y android", "Autor", "Deportes", List.of());
n = ServicioPalabrasClave.agregarSi(n, new FiltroContenidoContiene("Fútbol"), "deportes");
n = ServicioPalabrasClave.agregarSi(n, new FiltroContenidoContiene("android"), "móviles");
```

## Encapsulamiento y reglas
- Las listas expuestas (`getPalabrasClave()`, `getComponentes()`, resultados de búsqueda) son inmutables.
- `ServicioPalabrasClave` nunca muta la noticia original: devuelve una nueva instancia del mismo tipo concreto.
- `NoticiaPatrocinada` sobrescribe la evaluación de filtro y siempre se incluye en resultados.
- `BuscadorNoticias` elimina duplicados por título para evitar repeticiones por pertenecer a múltiples secciones/grupos.

## VS Code
- Incluye configuración en `.vscode/` para reconocer `portal-noticias/src` y una entrada de ejecución:
  - Ejecutar desde “Run and Debug” → “Portal Noticias: Main”
  - O abrir `Main.java` y usar “Run”.

## Rutas útiles
- Clase principal: `portal-noticias/src/portal/noticias/Main.java`
- Configuración VS Code: `.vscode/launch.json`
