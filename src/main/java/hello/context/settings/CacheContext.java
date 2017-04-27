package hello.context.settings;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author renatomoitinho
 */
@Configuration
public class CacheContext {

    public static final String SAY_CACHE = "sayHello";
    public static final String PERSON_CACHE = "person";

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(
                buildSay(),
                personCache()
        ));
        return simpleCacheManager;
    }

    private GuavaCache buildSay() {
        return new GuavaCache(SAY_CACHE, CacheBuilder
                .newBuilder()
                .expireAfterWrite(30, TimeUnit.SECONDS)
                .build(),
                false);
    }

    private GuavaCache personCache() {
        return new GuavaCache(PERSON_CACHE, CacheBuilder
                .newBuilder()
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .build(),
                false);
    }

}
