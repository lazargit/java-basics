package myobserver;

import java.util.Observable;
import java.util.Observer;

public class Beobachter2 implements Observer{

	@Override
	public void update(Observable o, Object obj) {
		Data data = (Data) o;
		System.out.println("Observer2: "+data.counter+obj);
		
	}

}
