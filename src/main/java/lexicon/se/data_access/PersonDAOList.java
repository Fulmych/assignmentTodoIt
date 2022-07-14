package lexicon.se.data_access;

import lexicon.se.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOList implements PersonDAO{
    List<Person> people = new ArrayList<>();

    @Override
    public Person persist(Person person) {
        people.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        return (Person) people.stream().filter(person -> person.getId() == id);
    }

    @Override
    public Person findByEmail(String email) {
        return (Person) people.stream().filter(person -> person.getEmail().equalsIgnoreCase(email));
    }

    @Override
    public List<Person> findAll() {
        return people;
    }

    @Override
    public void remove(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
