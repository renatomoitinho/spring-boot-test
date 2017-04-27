package hello.repository;


import hello.model.Person;

import java.util.List;
import java.util.Map;

public interface PersonRepository {

    Person get(String name);

    Map<String, Person> getAsLike(String query);

    List<Person> getAll();

}
