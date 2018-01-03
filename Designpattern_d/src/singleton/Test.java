package singleton;

public class Test {

	public static void main(String[] args) {
		//Singleton s = new Singleton();

		Singleton s = Singleton.getInstance();
		s.methode();
	}

}
