package Tp2;

import java.util.Queue;
import java.util.LinkedList;



public class MyQueue {
	
	private Queue<Object> cola = new LinkedList<>();	
	
  public boolean isEmpty() {
	  return cola.isEmpty();
	}

	public MyQueue add( Object  cargo ) {
		cola.offer(cargo);
		return this;
	}

	public Object take() {
		return cola.poll();
	}

	public Object head() {
		if (!cola.isEmpty()) {
			return cola.element();
		}
		return null;
	}

	public int size() {
		cola.size();
		return 0;
	}
	
	public Object devuelveUltimoElemento() {
		Object ultimoElemento = null;
		
		for (Object elemento : cola) {
            ultimoElemento = elemento;
        }
		
		if (ultimoElemento != null) {
			return ultimoElemento;
		}
		return null;
	}
	
	//public boolean worksFIFO() {
		
	//}

}