package main;



import model.Auto;
import model.Fahrzeug;



public class Main {
	
	//Klassenmethode
	// als Parameter in Methoden Obertypen verwenden
	public static void m1(Fahrzeug f){
		f.fahre();
	}
	

	public static void main(String[] args) {
		Fahrzeug f = new Auto(""); /// auf der linken Seite kann ein Obertyp verwendet werden
		
		
		// Hinweis für den Compiler: zur Laufzeit steht hinter "f" ein Auto-Objekt
		f.fahre();

		
		Object a1 = new Auto(""); // Object ist Oberklasse von allen KLassen
		((Auto) a1).fahre(); // zur Laufzeit muss hinter a1 ein Auto-Objekt sein
		
		Auto a2 = new Auto("");
		
		Main.m1(a2);
	}

}
