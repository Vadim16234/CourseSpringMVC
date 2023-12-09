package lesson.dao;

import lesson.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;

    public List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 14, "tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Jack", 52, "jack@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bobby", 18, "bobby@yahoo.com"));
        people.add(new Person(++PEOPLE_COUNT, "Tim", 34, "tim@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person showById(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = showById(id);

        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
