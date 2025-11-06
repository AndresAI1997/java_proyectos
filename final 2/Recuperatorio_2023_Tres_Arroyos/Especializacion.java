import java.util.ArrayList;

public class Especializacion extends ElementoEducativo {

    protected ArrayList<ElementoEducativo> especializacion;
    private int resta;
    private int topeDescuento;

    public Especializacion(String nombre, int resta, int topeDescuento){
        super(nombre);
        this.resta = resta;
        this.topeDescuento = topeDescuento;
        especializacion = new ArrayList<>();
    }

    public int getCantidadHorasCatedra(){
        int totalHoras = 0;
        for(ElementoEducativo e: especializacion){
            totalHoras += e.getCantidadHorasCatedra();
        }

        return totalHoras;
    }
    public int getCantidadCursos(){
        int totalCursos = 0;
        for(ElementoEducativo e: especializacion){
            totalCursos += e.getCantidadCursos();
        }

        return totalCursos;
    }
    public double getPrecio(){// El valor del descuento no puede superar el valor del 50% del producot original
        //Recorro cada elemento de la lista, por cada elemento voy a..
            // Sumo al total += precio del elemento
        // Si el descuento es mayor al 50% original
            //Retorno el total con 50%
        // Si no, retorno total menos el descuento
        double total = 0;
        for(ElementoEducativo e: especializacion){
            total += e.getPrecio();
        }
        if(aplicarDescuento(total) > topeDescuento(total)){
            return total - topeDescuento(total);
        }else{
            return total - aplicarDescuento(total);
        }
    }

    public double aplicarDescuento(double t){
        return t*resta/100;
    }

    public double topeDescuento(double t){
        return t/topeDescuento;
    }
    public ArrayList<String> getDocentes(){
        ArrayList<String> salida = new ArrayList<>();
        for(ElementoEducativo e: especializacion){
            for(int i = 0; i < e.getDocentes().size(); i++){
                String docente = e.getDocentes().get(i);
                if(!salida.contains(docente)){
                    salida.add(docente);
                }
            }
        }
        return salida;
    }

    public ArrayList<ElementoEducativo> buscarCurso(Filtro f){
        ArrayList<ElementoEducativo> salida = new ArrayList<>();
        for(ElementoEducativo e: especializacion){
            salida.addAll(e.buscarCurso(f));
        }
        return salida;
    }
    public ArrayList<String> getPalabrasClave(){
        ArrayList<String> salida = new ArrayList<>();
        for(ElementoEducativo e: especializacion){
            for(int i = 0; i < e.getPalabrasClave().size(); i++){
                String palabraclave = e.getPalabrasClave().get(i);
                if(!salida.contains(palabraclave)){
                    salida.add(palabraclave);
                }
            }
        }
        return salida;
    }

    public void addEspecializacion(ElementoEducativo e, Filtro f){
        if(f.cumple(e)){
            especializacion.add(e);
        }
    }
    public Curso cursoMasCaro(){
        // Creo una copia de curso
        //Recorro la lista de elementos, por cada curso voy a 
            //Si el valor del curso actual, es valorMaximo
            // Valormaximo se vuelve el valor del curso
            // Curso copia se vuelve el curso
        Curso cursoMasCaro = null; // Creo el objeto de tipo curso auxiliar donde voy a almacenar el curso 
        double valorMaximo = 0;
        for(ElementoEducativo e: especializacion){ // Recorro la lista de elementos completa
            ElementoEducativo hijo = e.cursoMasCaro(); // Como no se de que tipo de dato se trata, lo almanaceno en un ElementoEducativo
            Curso cursoMasCaroDelHijo = hijo.cursoMasCaro(); // Recursivo, si es de tipo Especializacion se llama a si mismo, si es de tipo Curso, se alamacena el objeto dentro de la variable
            double valorCursoCaroHijo = cursoMasCaroDelHijo.getPrecio(); //le pregunto a la variable su precio
            if(valorCursoCaroHijo > valorMaximo){ // Si el precio del Curso es mayor, voy a..
                valorMaximo = valorCursoCaroHijo; // Almacenar el precio como futuro parametro
                cursoMasCaro = cursoMasCaroDelHijo; // Alamacenar el objeto Curso en mi variable Aux de tipo Curso
            }
            }
            return cursoMasCaro;
        }
        
    }


