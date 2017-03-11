package hello;

import hello.context.settings.PeopleSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.InfoEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PeopleSettings peopleSettings;

    @Autowired
    private InfoEndpoint info;

    @PostConstruct
    public void logSomething() {
        logger.info("Sample info Message");
        logger.debug("Sample Trace Message");
    }

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World " + peopleSettings.getName();
    }

    @RequestMapping("/about")
    public Map<String, Object> about() {
        return info.invoke();
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
