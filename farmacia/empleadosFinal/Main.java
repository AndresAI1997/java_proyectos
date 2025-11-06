package empleadosFinal;

public class Main {
	public static void main(String[] args) {
		

	Empleado e1 = new Empleado("Juan", new CalculadorDeSueldoFijo(1000));
	
	Empleado e2 = new Empleado("Pedro", 
			new CalculadorCompuesto(
					new CalculadorDeSueldoFijo(500), 
					new CalculadorPorComision(1000, 0.1)));
	System.out.println(e1.getSueldo());
	System.out.println(e2.getSueldo());
	
	e1.setCalculador(new CalculadorCompuesto(
							new CalculadorDeSueldoFijo(5000),
							new CalculadorPorHoraExtras(10, 20)));
	
	System.out.println(e1.getSueldo());
	}
}
