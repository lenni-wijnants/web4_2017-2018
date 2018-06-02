package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Person;
import domain.Role;

public class PersonRepositoryStub implements PersonRepository {
	private Map<String, Person> persons = new HashMap<String, Person>();
	
	public PersonRepositoryStub () {

		Person jan = new Person("jan@ucll.be", "t", "Jan", "janssens", Role.USER, "male", 30);
		add(jan);
		Person lenni = new Person("lenni@ucll.be", "t", "Lenni", "Wijnants", Role.USER, "male", 24);
		add(lenni);
		Person billy = new Person("billy@ucll.be", "t", "Billy", "The Kid", Role.ADMIN, "male", 12);
		add(billy);

		jan.addFriend(billy);
		jan.addFriend(lenni);

		Person admin = new Person("admin@ucll.be", "t", "Ad", "Ministrator", Role.ADMIN, "None", 0);
		add(admin);
	}
	
	public Person get(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		return persons.get(personId);
	}
	
	public List<Person> getAll(){
		return new ArrayList<Person>(persons.values());	
	}

	public void add(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		if (persons.containsKey(person.getUserId())) {
			throw new IllegalArgumentException("User already exists");
		}
		persons.put(person.getUserId(), person);
	}
	
	public void update(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		persons.put(person.getUserId(), person);
	}
	
	public void delete(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		persons.remove(personId);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		Person person = get(email);
		
		if (person != null && person.isCorrectPassword(password)) {
			return person;
		}
		else {
			return null;
		}
	}
}
