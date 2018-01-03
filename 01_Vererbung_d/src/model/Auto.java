package model;

public class Auto extends Fahrzeug {

	private int geschwindigkeit;
	

	public Auto(String farbe) {
		super(farbe);
		// hier kommt evtl. noch mehr 
		
	}

	public Auto(String farbe, int geschwindigkeit) {
		this(farbe);  // Auto-Konstruktor mit einem Parameter
		this.geschwindigkeit = geschwindigkeit;
	}

	@Override
	public void fahre() {// überschreiben der Methode
		System.out.println("Auto fährt...");
	}

	
	public int getGeschwindigkeit() {
		return geschwindigkeit;
	}
	
	public void setGeschwindigkeit(int geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}
}
