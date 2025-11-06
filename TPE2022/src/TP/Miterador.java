package TP;
import java.util.Iterator;

public class Miterador<T> implements Iterator<Nodo<T>> {
	Nodo<T> cursor;
	
	public Miterador(Listavinculada<T> lista){
		cursor = lista.primernodo;
	}
	
	public boolean hasNext() {
		if(cursor !=null)
		return true;
		else
			return false;
		}
	
	
		public Nodo<T> next() {
			if (cursor == null)
				return null;
			Nodo<T> valor =cursor;
			cursor =cursor.nodosig;
			return 	valor;
		}
}
