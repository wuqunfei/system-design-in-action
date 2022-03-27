package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


// https://github.com/spring-projects/spring-data-examples/blob/main/redis/example/src/test/java/example/springdata/redis/commands/GeoOperationsTests.java
@Service
public class MarketService {

    private final GeoOperations geoOperations;

    @Autowired
    public MarketService(RedisTemplate redisClient) {
        this.geoOperations = redisClient.opsForGeo();
    }

    public boolean syncGeoLocation(Long driverId, double latitude, double longitude){
        Point point = new Point(latitude, longitude);
        geoOperations.add("Sicily", point, "Arigento");
        return false;
    }
}
