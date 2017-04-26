package hello;

import hello.context.settings.PeopleSettings;
import hello.service.SayHello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.InfoEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableCaching
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private SayHello sayHello;

    @Autowired
    private InfoEndpoint info;

    @PostConstruct
    public void logSomething() {
        logger.info("Sample info Message");
        logger.debug("Sample Trace Message");
    }

    @RequestMapping("/")
    @ResponseBody
    public Map<String, String> home() {
        return sayHello.say();
    }

    @RequestMapping("/get/{v}")
    @ResponseBody
    public Map<String, String> home(@PathVariable("v") Integer v) {
        return sayHello.say(v);
    }

    @RequestMapping("/get/{v}/{w}")
    @ResponseBody
    public Map<String, String> home(@PathVariable("v") Integer v, @PathVariable("w") Integer w) {
        return sayHello.say(v, w);
    }

    @RequestMapping("/about")
    public Map<String, Object> about() {
        logger.info("about ...");
        return info.invoke();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
