package hello.repository;


import hello.model.Person;

import java.util.Map;

public interface PersonRepository {

    Person get(String name);

    Map<String, Person> getAsLike(String query);

}
