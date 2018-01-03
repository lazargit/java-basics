package myobserver;

public class Test {

	public static void main(String[] args) {
		Data data = new Data();
		Beobachter b = new Beobachter();
		Beobachter2 b2 = new Beobachter2();
		data.addObserver(b);
		data.addObserver(b2);
		
		
		
		
		data.test();
	}

}
