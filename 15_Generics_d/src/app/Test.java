package app;

import java.util.HashMap;
import java.util.List;

import javafx.geometry.Rectangle2D;

public class Test {
	

	public static void main(String[] args) {
		
		Punkt<Integer> p1 = new Punkt<Integer>(10, 3);
		
		//p1.setX(22.3); geht nicht!
		
		Punkt<Double> p2 = new Punkt<Double>(20.4,33D);
		
		//p2.setX(20); geht nicht
		
		p2.setX(22.6);
		
		
		// Punkt<String> ppp; geht nicht mehr ->  <T extends Number>
		
		MultiGen<String, Integer,Double > m = new MultiGen<>("aaa", 56, 2.6);
		
		
		// NICHT so schön :-)
		// HashMap -> Schlüssel : Integer, Wert ein  HashMap? 
		HashMap<Integer,HashMap<Integer, String>> map = new HashMap<>();
		
		HashMap<Integer, String> map2 = new HashMap<>();
		map.put(12, map2 );
		
		Punkt<?> p3 = new Punkt<>(3, 5.6) ; // ? unbekannter Typ, danach unveränderbar 
		//p3.setX(4); das geht jetzt nicht mehr
		Class<?> c = Rectangle2D.class;// Reflection kommt noch
	
		
	}

}
