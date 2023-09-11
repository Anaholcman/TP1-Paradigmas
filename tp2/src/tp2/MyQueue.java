package tp2;

import java.util.Queue;
import java.util.LinkedList;



public class MyQueue {
	
	public Queue<Object> cola = new LinkedList<>();	
	
  public boolean isEmpty() {
	  return cola.isEmpty();
	}

	public MyQueue add( Object  cargo ) {
//		cola.offer(cargo);
		return this;
	}

	public Object take() {
		
		ifEmptyThenError();
		return cola.remove();
	}

	public Object head() {
	    ifEmptyThenError();
		return cola.peek();

	}

	public int size() {
		return cola.size();
	}
	
	
	private void ifEmptyThenError() throws Error {
		try {
	        cola.element();
	    } catch (Exception e) {
			throw new Error("Queue is empty");
	    }
	}
	

}
