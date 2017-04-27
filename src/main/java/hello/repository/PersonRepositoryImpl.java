package hello.repository;

import hello.model.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final List<Person> persons = new ArrayList<>();

    @PostConstruct
    public void init() throws URISyntaxException, IOException {
        Pattern pattern = Pattern.compile("(\\w+)\\s(\\w+)");
        URL url = getClass().getResource("/names");
        try (BufferedReader io = Files.newBufferedReader(Paths.get(url.toURI()))) {
            String line;
            while ((line = io.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    persons.add(new Person(matcher.group(1), matcher.group(2)));
                }
            }
        }
    }

    @Override
    public Person get(String name) {
        return persons.stream().filter((p)-> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    @Override
    @Cacheable(value = "person" , key = "#query")
    public Map<String, Person> getAsLike(String query) {
        System.out.println( "invoiced map " + query );

        return persons.stream().filter((p)-> p.getName().contains(query)).collect(Collectors.toMap(Person::getName, Function.identity()));
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }


}
