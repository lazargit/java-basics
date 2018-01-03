package dao;

import java.util.List;

import model.Person;

public class MySQLPersonDAO implements PersonDAO{

	@Override
	public List<Person> findAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean savePerson(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePerson(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePerson(int id, String fieldName, String newValue) {
		// TODO Auto-generated method stub
		return false;
	}

}
