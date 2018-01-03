package ue_functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ue_functional.Auto.Marke;

/*
 * 
 * Übung Streams
 * Verwende map, reduce, filter, distinct, 
 * 
 * 
 */

public class UEStreams {
	


	public static void main(String[] args) {
		
		List<Auto> list= Arrays.asList(
				new Auto(200, "grün", Marke.BMW),
				new Auto(200, "grün", Marke.BMW),
				new Auto(210, "blau", Marke.MERCEDES),
				new Auto(212, "blau", Marke.MERCEDES),
				new Auto(180, "gelb", Marke.FORD),
				new Auto(220, "gelb", Marke.BMW),
				new Auto(130, "gelb", Marke.ENTE),
				new Auto(130, "braun", Marke.ENTE)
				
		);
		
	
		
		Stream<Auto> stream1 = list.stream();
		// das schnellste Auto (ein Auto-Objekt)  // -> reduce
		System.out.println("das schnellste Auto (ein Auto-Objekt):");
		// hier...
		
		
	
		// eine Liste mit allen Farben (keine doppelten Einträge)
		System.out.println("eine Liste mit allen Farben (keine doppelten):");
		// hier...

		
		System.out.println("alle Autos mit einer Geschwindigkeit ab 200:");
		Stream<Auto> stream3 = list.stream(); 
		// hier...
		
		
		// nach geschwindigkeit sortierte Liste (kleinste zuerst, keine doppelten)
		System.out.println("nach geschwindigkeit sortierte Liste (kleinste zuerst):");
		Stream<Auto> stream4 = list.stream(); 
		// hier...
	
		
		//Marken-Liste aller gelben Autos, die unter 200 fahren (nur Marken in der Liste)
		System.out.println("Marken-Liste aller gelben Autos, die unter 200 fahren (nur Marken in der Liste):");
		Stream<Auto> stream5 = list.stream();
		// hier...



		
//----------- vergleiche die Ausgabe --------------------------------------
//			das schnellste Auto:
//			Auto [geschwindigkeit=220, farbe=gelb, marke=BMW]
//			eine Liste mit allen Farben (keine doppelten):
//			[grün, blau, gelb, braun]
//			alle Autos mit einer Geschwindigkeit ab 200:
//			Auto [geschwindigkeit=200, farbe=grün, marke=BMW]
//			Auto [geschwindigkeit=200, farbe=grün, marke=BMW]
//			Auto [geschwindigkeit=210, farbe=blau, marke=MERCEDES]
//			Auto [geschwindigkeit=212, farbe=blau, marke=MERCEDES]
//			Auto [geschwindigkeit=220, farbe=gelb, marke=BMW]
//			nach geschwindigkeit sortierte Liste (kleinste zuerst):
//			Auto [geschwindigkeit=130, farbe=gelb, marke=ENTE]
//			Auto [geschwindigkeit=130, farbe=braun, marke=ENTE]
//			Auto [geschwindigkeit=180, farbe=gelb, marke=FORD]
//			Auto [geschwindigkeit=200, farbe=grün, marke=BMW]
//			Auto [geschwindigkeit=210, farbe=blau, marke=MERCEDES]
//			Auto [geschwindigkeit=212, farbe=blau, marke=MERCEDES]
//			Auto [geschwindigkeit=220, farbe=gelb, marke=BMW]
//			Marken-Liste aller gelben Autos, die unter 200 fahren (nur Marken in der Liste):
//			[FORD, ENTE]

		
	
	}

}
