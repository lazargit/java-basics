package app;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;




/*
 * - Klassenmethoden werden über den Klassennamen aufgerufen
 * - die anderen Methoden über Referenzen
 */
public class Test {

	/*
	 * Factory Method
	 */
	public static Parent createPanel(String p){
		if(p.equals("b")){
			return new BorderPane();
		}
		
		return new Pane();
		
	}
	
	/**
	 */
	public static void main(String[] args) {
		
		System.out.println(KlasseMitStatic.MAX);
		
		KlasseMitStatic.statischeVariable ="Hallo";
		System.out.println(KlasseMitStatic.statischeVariable);
		
		KlasseMitStatic.statischeMethode();
		
		KlasseMitStatic k = new KlasseMitStatic();// Konstruktor
		k.dynamischeMethode();
		
		k.statischeMethode();// nicht besonders schön
		
		Math.random();
		
		System.out.println(Color.CADETBLUE);
		
		Color c = new  Color(0, 0, 0, 1);
		c.brighter();
		
		BorderPane p = (BorderPane) Test.createPanel("b");		
		
		
	}

}
