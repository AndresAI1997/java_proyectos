package TP;

public class Nodo<T> {
	T elemento; 
	Nodo<T> nodosig;

	
	
	public Nodo(T elemento,Nodo<T> nodosig){
		this.elemento=elemento;
		this.nodosig=nodosig;
	}
}
