package queue3;

public class WithOutElements extends Conteiners {
	public boolean vacio() {	return true;	}
	
	public Object cabecera() {
		throw new RuntimeException( "Queue is empty");
	}

	@Override
	public Conteiners saca() {
		throw new RuntimeException( "Queue is empty");
	}

	@Override
	public int tamaño() {
		return 0;
	}
	
}

	

