package dao;

import java.util.List;

import model.Person;

public interface PersonDAO {

	List<Person> findAllPersons();

	boolean savePerson(Person person);

	boolean deletePerson(int id);

	boolean updatePerson(int id, String fieldName, String newValue);

}