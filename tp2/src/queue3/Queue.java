package queue3;

public class Queue {
	public Elements elems= new WithOutElements();

	public boolean isEmpty() {
		return elems.vacio();
	}
	public Queue add( Object  cargo ) {
		elems = elems.agregar(cargo);
		return this;
	}
	public Object take() {
		Object cargo = elems.cabecera();
		elems = elems.saca();
		return cargo;
	}
	public Object head() {
		return elems.cabecera();
	}
	public int size() {
		return elems.tamaño();
	}
	
}
