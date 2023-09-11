package queue3;

public abstract class Elements {
	static Elements WithElements = new WithElements();
	static Elements WithOutElements = new WithOutElements();
	
	public abstract boolean vacio();
	public abstract Elements agregar( Object  cargo );
	public abstract Elements saca();
	public abstract Object cabecera();
	public abstract int tamaño();

}
