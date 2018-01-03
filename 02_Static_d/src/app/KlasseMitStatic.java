package app;

public class KlasseMitStatic {
	
  
	public static final int MAX =100;  // Konstante 
	//final -> kann nicht mehr verändert
	
	
	public static String statischeVariable;  //Klassenvariable -> null
	
	
	public KlasseMitStatic() {
		System.out.println("Konstuktor...");
	}
	
	static{
		System.out.println("statischer Initialisierer -> statischer Konstruktor" );
	}
	
	
	public static void statischeMethode(){// Klassenmethode
		System.out.println("statischeMethode...");
	}
	
	public void dynamischeMethode(){//Objekt-Methode
		System.out.println("dynamischeMethode...");
	}

}
