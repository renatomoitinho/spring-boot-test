package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World Funcinou!!!" + env.getProperty("people.name");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
