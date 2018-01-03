package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/*
 * Interface-Benutzung Variante 2 (Anonym)
 */
public class Test2 {

	public static void main(String[] args) {

		Rennbahn r = new Rennbahn();

		r.fahreAlles(new IFahrzeug() { // Anonymer Typ

			@Override
			public void fahre() {
				System.out.println("Fahrzeug fährt");

			}
		});

		
		// Java8 Lambda bei Interface mit einer Methode
		r.fahreAlles( () -> System.out.println("Fahrzeug fährt") );
		
		
		/// ein weiteres Beispiel JavaFX Button
		
		Button b = new Button();
		b.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				
			}
		});
		// hier wieder Java 8 Syntax
		b.setOnAction((e)->{ 
			// hier die Anweisung
		});
		

	}

}
