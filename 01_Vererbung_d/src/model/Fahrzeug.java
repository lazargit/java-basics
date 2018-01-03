package model;
//Oberklasse
public class Fahrzeug {
	private String farbe;
	

	
	public Fahrzeug(String farbe) {
		//super();// kann weg, wird automatisch aufgerufen (hier super-Object)
		this.setFarbe(farbe);
	}

	public void fahre() {
		System.out.println("Fahrzeug.fahre()");
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}
	
	
	
}
