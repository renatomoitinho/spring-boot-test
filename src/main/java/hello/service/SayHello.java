package hello.service;

import org.springframework.cache.annotation.Cacheable;

import java.util.Map;

/**
 * @author renatomoitinho
 */
public interface SayHello {
    @Cacheable("sayHello")
    Map<String, String> say();

    @Cacheable(value = "sayHello", key = "#v")
    Map<String, String> say(Integer v);

    @Cacheable(value = "sayHello", key = "{#v, #w}")
    Map<String, String> say(Integer v, Integer w);
}
