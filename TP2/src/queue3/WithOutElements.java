package queue3;

public class WithOutElements extends Elements {
	public boolean vacio() {	return true;	}

	@Override
	public Elements agregar(Object cargo) {
		return new WithElements().agregar(cargo);
	}

	@Override
	public Elements saca() {
		throw new Error("Queue is empty");
	}

	@Override
	public Object cabecera() {
		throw new Error("Queue is empty");
	}

	@Override
	public int tamaño() {
		return 0;
	}
}
