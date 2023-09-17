package queue;

public class EmptySlot extends Slots {
	public static String isempty = "Queue is empty";
	public Object getObject() {	throw new Error(isempty); }
	public boolean estavacio() {	return true;  }
}
