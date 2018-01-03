package ue_functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ue_functional.Auto.Marke;

public class UEStreams_Loesung {
	
	public static Auto schnellstes(Auto a1, Auto a2){
		return a1.getGeschwindigkeit()> a2.getGeschwindigkeit()? a1:a2;
	}
	
	public static String farben(Auto a){
		return a.getFarbe();
	}

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
		// das schnellste Auto
		System.out.println("das schnellste Auto:");
		Auto schnellstesAuto =stream1.reduce(UEStreams_Loesung::schnellstes).get();
		System.out.println(schnellstesAuto);
		//stream1.close();
		
	
		// eine Liste mit allen Farben (keine doppelten Einträge)
		System.out.println("eine Liste mit allen Farben (keine doppelten):");
		Stream<Auto> stream2 = list.stream(); 
		List<String> farben = stream2.map(UEStreams_Loesung::farben).distinct(). collect(Collectors.toList());
		System.out.println(farben);
		
		
		System.out.println("alle Autos mit einer Geschwindigkeit ab 200:");
		Stream<Auto> stream3 = list.stream(); 
		stream3.filter( a -> a.getGeschwindigkeit() >= 200).forEach(System.out::println);
		
		// nach geschwindigkeit sortierte Liste (kleinste zuerst, keine doppelten)
		System.out.println("nach geschwindigkeit sortierte Liste (kleinste zuerst):");
		Stream<Auto> stream4 = list.stream(); 
		stream4.sorted((a1,a2)-> 
		a1.getGeschwindigkeit()<a2.getGeschwindigkeit()
		?-1: 1).distinct().forEach(System.out::println);
		
		//Marken-Liste aller gelben Autos, die unter 200 fahren (nur Marken in der Liste)
		System.out.println("Marken-Liste aller gelben Autos, die unter 200 fahren (nur Marken in der Liste):");
		Stream<Auto> stream5 = list.stream();
		List<Marke> li5 =stream5.
				filter( a -> a.getGeschwindigkeit() < 200).
				filter(a->a.getFarbe().equals("gelb")).
				map(a->a.getMarke()).collect(Collectors.toList());
		System.out.println(li5);
	}

}
