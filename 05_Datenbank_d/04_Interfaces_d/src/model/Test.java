package model;

import java.io.Serializable;

public class Test {
	
	public void nurSerializableFahren(IFahrzeug f) {
		if(f instanceof Serializable){
			f.fahre();
		}
	}
	
	public static void test(Serializable s){
		
	}
	
	
	public static void main(String[] args) {
		
		
		
		Rennbahn r = new Rennbahn();
		
		r.fahreAlles(new Auto());
		r.fahreAlles(new Motorrad());
		test(new Motorrad()); // Serializable
		//test(new Auto());  // nicht Serializable
	}

}
