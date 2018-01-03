package singleton;

public final class Singleton  {
	
	private static Singleton instance = null; 
	private Singleton() {// verhindert Objekterzeugung auﬂerhalb der Klasse
		// TODO Auto-generated constructor stub
	}
	
	public static Singleton getInstance(){
		
		
		if(instance==null){
			instance = new Singleton();
		}
		
		return instance;
	}
	
	
	// andere Methoden
	public void methode(){
		
	}
}
