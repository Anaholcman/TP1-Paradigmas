package queue3;

import java.util.ArrayList;
import java.util.List;

public class WithElements extends Elements{
	private List<Object> cola = new ArrayList<>();
	
	@Override
	public boolean vacio() {	return false;	}

	@Override
	public Elements agregar(Object cargo) {
		cola.add(cargo);
		return this;
	}

	@Override
	public Elements saca() {
		cola.remove(0);
		Elements newcola = new WithOutElements();
		for (Object cargo:cola) {
			newcola.agregar(cargo);
		}
		return newcola;
//		if (this.tamaño()==1) {
//			return new WithOutElements();
//		}
//		cola.remove(0);
//		return this;
	}

	@Override
	public Object cabecera() {	return cola.get(0);	}

	@Override
	public int tamaño() {		return cola.size();	}
}