package services;

import com.systemdesign.gissystem.model.DriverLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;


// https://github.com/spring-projects/spring-data-examples/blob/main/redis/example/src/test/java/example/springdata/redis/commands/GeoOperationsTests.java
@Service
public class MarketService {

    private final GeoOperations geoOperations;

    @Autowired
    public MarketService(RedisTemplate redisClient) {
        this.geoOperations = redisClient.opsForGeo();
    }

    public boolean syncLocation(UUID userId, double latitude, double longitude, boolean driverMode){
        Point point = new Point(latitude, longitude);
        geoOperations.add("Sicily", point, "Arigento");
        return false;
    }

    public List<DriverLocation> destination(UUID userId, double pickLat, double pickLong, double dropLat, double dropLong){
        return Collections.emptyList();
    }
}
