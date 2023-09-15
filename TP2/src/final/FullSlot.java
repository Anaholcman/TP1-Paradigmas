package queue4;

public class FullSlot extends Slots{
	public Object cargo;
	public FullSlot(Object cargo) {	this.cargo = cargo; }
	
	public Object ishead() {  return this.cargo; }
	public boolean estavacio() {  return false; }
}