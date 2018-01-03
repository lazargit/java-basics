package app;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Klasse {
	
	
	/**
	 * 
	 * @param a Zahl 1
	 * @param b Zahl 2
	 * @return größere von beiden
	 */
	public int max(int a, int b){
		return a > b ? a: b;
	}
	

	/**
	 * 
	 * @param arr
	 * @return größte Zahl vom Array 
	 */
	public int max(int[] arr){
		int max=arr[0];
		
		for (int n : arr) {
			if(n > max){
				max = n;
			}
		}
		
		return max;
	}
	
	
	/**
	 * 
	 * @param n
	 */
	public void methodeMItException(int n){
		if(n==0){
			throw new IllegalArgumentException();
		}
		// hier geht es weiter....
	}
	
	
	
	/*
	 * sumuliert längere Methodenlaufzeit
	 */
	public void dauertZeit(){
		try {
			Thread.sleep(80);  // 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public JComponent createComponent(String c){
		if(c.equalsIgnoreCase("b")){
			return new JButton();
		}
		
		return new JLabel();
		
	}
}
