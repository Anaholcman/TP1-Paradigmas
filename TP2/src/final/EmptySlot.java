package queue4;

public class EmptySlot extends Slots {
	public static String isempty = "Queue is empty";
	public Object ishead() {	throw new Error(isempty); }
	public boolean estavacio() {	return true;  }
}
