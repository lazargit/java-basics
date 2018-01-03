package app;


// B muss ein ZahlenTyp sein
public class MultiGen<A, B extends Number, C> {
	
	private A a;
	private B b;
	private C c;
	public MultiGen(A a, B b, C c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	
	

}
