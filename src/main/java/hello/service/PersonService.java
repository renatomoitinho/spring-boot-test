package hello.service;

import hello.model.Person;
import hello.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonQuery getLike(String like) {
        return proxify(like, PersonQuery.class);
    }

    public Map<String, Person> getLikeMap(String like) {
        return personRepository.getAsLike(like);
    }

    public List<Person> geAllLikeMap() {
        return personRepository.getAll();
    }

    private PersonQuery proxify(final String key, final Class<PersonQuery> clazz) {
        Object obj = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{clazz}, (proxy, method, args) -> {

            Map<String, Person> personMap = personRepository.getAsLike(key);

            return Optional.ofNullable(personMap.get(args[0])).orElse((Person) args[1]);
        });

        return clazz.cast(obj);

    }


    public interface PersonQuery {
        Person get(String name, Person def);
    }


}

