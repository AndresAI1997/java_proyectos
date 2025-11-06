package empleados;

public class Main {
	public static void main(String[] args) {
		

	Empleado e1 = new Empleado("Juan", new CalculadorDeSueldo(1000));
	
	Empleado e2 = new Empleado("Pedro", new CalculadorPorComision(500, 1000, 0.1));
	System.out.println(e1.getSueldo());
	System.out.println(e2.getSueldo());
	
	e1.setCalculador(new CalculadorPorHoraExtras(5000, 10, 20));
	System.out.println(e1.getSueldo());
	}
}
