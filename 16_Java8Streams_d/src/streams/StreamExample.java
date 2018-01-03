package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		// Testdaten
		String[] namenArr = {"Max","Anton","Ilse","Maria","Ina","Maria"};
		List<String> namenList = Arrays.asList(namenArr);
		
		
		//Array und Liste zu Streams
		Stream<String> streamVomArray = Arrays.stream(namenArr);
		Stream<String> streamVonListe = namenList.stream();
		
		//------------distinct------------------------------------------------
		Stream<String> s1 = streamVonListe.distinct();// mehrfache entfernen
		//Stream zu List-----------------------------------------
		System.out.println(s1.collect(Collectors.toList()));
		
		//------------Filter----------------------------------------------
		
		List<User> users = Arrays.asList(new User("Max", 13), new User("Inge", 23), new User("Anton", 34));
		
		List<User> oldUsers = users.stream().
				filter(u -> u.getAlter() > 18). //Filter: Alter > 18
				collect(Collectors.toList());   // zurück zu Liste 
		System.out.println("Old Users: "+oldUsers);
		
		//------------Map------------------------------------------------
		
		List<String> usernames = users.stream().
				filter(u -> u.getAlter() > 18). //Filter: Alter > 18
				map(u -> u.getName()). // ab hier Stream mit Strings  User::getName
				collect(Collectors.toList()); 
		System.out.println("Usernames: "+usernames);
		
		//-----------Map 2----------------------------------------------
		
		Stream.of("a1","a2","a3")
		.map(s->s.substring(1)) // Buchsatben entfernen
		.mapToInt(Integer::valueOf)// nach int konvertieren
		.max()//Maximum ermitteln
		.ifPresent(System.out::println);//3
		
		//-----------Range--------------------------------------------
		IntStream.range(2, 7).forEach(System.out::print);//2,3,4,5,6
		System.out.println();
		//----------Reduce-------------------------------------------
		
		List<User> users2 = Arrays.asList(new User("Max", 13), new User("Inge", 23), new User("Anton", 34));
		
		User reduceUser = users2.stream()
				.reduce(  (u1, u2)->  u1.getAlter() < u2.getAlter() ? u1 :u2 )
				.get();
		System.out.println(reduceUser);
		
		
		
	}

}
