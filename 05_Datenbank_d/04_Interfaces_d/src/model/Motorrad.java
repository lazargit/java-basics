package model;

import java.io.Serializable;

public class Motorrad implements IFahrzeug, Serializable {

	@Override
	public void fahre() {
		System.out.println("Motorrad fährt...");
		
	}

}
