package farmacia;

public class Main {
	
	public static void main(String[] args) {
		Farmacia f = new Farmacia();
		
		Medicamento ibu = new Medicamento("Ibuprofeno", "Pfizer", 500);
		Medicamento supritos = new Medicamento("Supritos", "Roche", 2500);
		
		f.addMedicamento(ibu);
		f.addMedicamento(supritos);
		
		CondicionDeBusqueda c1 = new CondicionPorNombre("Ibu");
		CondicionDeBusqueda c2 = new CondicionPorPrecio(3000);
		
		System.out.println(f.listarMedicamentos(c1));
		System.out.println(f.listarMedicamentos(c2));
		
		//CondicionDeBusqueda and1 = new CondicionAnd(new CondicionNot(c1), 
		//		c2);
		CondicionDeBusqueda and1 = new CondicionAnd(c1, 
				c2);
		
		System.out.println(f.listarMedicamentos(
				new CondicionAnd(and1, new CondicionPorLab("Pfizer"))));
		
	}

}
