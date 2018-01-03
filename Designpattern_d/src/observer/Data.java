package observer;

import java.time.LocalDate;
import java.util.Observable;

public class Data extends Observable{
	int counter =0;
	
	public void test(){
		
		while (true) {
			try {
				counter++;
				Thread.sleep(1000);
				
				System.out.println("Observable: "+counter);
				setChanged();//Daten haben sich geändert - counter++
				//notifyObservers();// benachrichtigt Observer und "sendet" Daten
				notifyObservers(LocalDate.now());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
		}
	}

}
