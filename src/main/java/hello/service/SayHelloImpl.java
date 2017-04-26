package hello.service;

import hello.context.settings.PeopleSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author renatomoitinho
 */
@Service
public class SayHelloImpl implements SayHello {

    private static final Logger logger = LoggerFactory.getLogger(SayHelloImpl.class);

    private final PeopleSettings peopleSettings;

    @Autowired
    public SayHelloImpl(PeopleSettings peopleSettings) {
        this.peopleSettings = peopleSettings;
    }

    @Override
    public Map<String, String> say() {

        logger.info("Say Hello invoiced...");
        return Collections.singletonMap("Name", peopleSettings.getName());
    }

    @Override
    public Map<String, String> say(Integer v) {

        logger.info("say hello invoiced with param {}" , v);
        Map<String, String> map = new HashMap<>();
        map.putAll(say());
        map.put("key", v.toString());

        return map;
    }

    @Override
    public Map<String, String> say(Integer v, Integer w) {

        logger.info("say hello invoiced with param {} {}" , v, w);
        Map<String, String> map = new HashMap<>();
        map.putAll(say(v));
        map.put("key2", w.toString());

        return map;
    }
}
