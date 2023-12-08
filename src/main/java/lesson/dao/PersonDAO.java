package lesson.dao;

import lesson.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    // создаем список Person, который будет являться БД
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Ivan"));
        people.add(new Person(++PEOPLE_COUNT, "Dima"));
        people.add(new Person(++PEOPLE_COUNT, "Vadim"));
        people.add(new Person(++PEOPLE_COUNT, "Maxim"));
    }

    public List<Person> index() {
        return people;
    }

    public Person showById(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
