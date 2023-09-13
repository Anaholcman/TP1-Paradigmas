package queue3;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	public List<Conteiners> cola = new ArrayList();

	public boolean isEmpty() {
		return cola.get(0).vacio();
		
	}
	
	public Queue add( Object  cargo ) {
		cola.add(new WithElements(cargo));
		return this;
	}
	
	public Object take() {
		Object cargo = cola.get(0).cabecera();
		cola.remove(0);
		return cargo;
	}
	public Object head() {
		return cola.get(0).cabecera();
	}
	public int size() {
		return cola.size()-1;
	}
	
}
