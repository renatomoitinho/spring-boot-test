package hello.context.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author renatomoitinho
 */
@Component
@ConfigurationProperties(prefix = "people")
public class PeopleSettings {

    private String age;
    private String name;

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
