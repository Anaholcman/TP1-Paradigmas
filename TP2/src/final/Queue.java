package queue4;

import java.util.LinkedList;
import java.util.List;

public class Queue {
	private List<Slots> cola = new LinkedList<>();
	public Queue() { cola.add(new EmptySlot()); }

	public Queue add( Object  cargo ) {
		cola.add( cola.size()-1 , new FullSlot(cargo) );
		return this;
	}
	
	public Object take() {
		Object head = cola.get(0). ishead();
		cola.remove(0);
		return head;
	}
	
	public boolean isEmpty() {	return cola.get(0). estavacio();	}
	public Object head() {	return cola.get(0). ishead(); }
	public int size() {	return cola.size()-1; }
}
