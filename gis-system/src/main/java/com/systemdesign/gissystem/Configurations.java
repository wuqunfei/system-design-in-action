package com.systemdesign.gissystem;

import com.systemdesign.gissystem.model.Location;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class Configurations {

    @Bean
    public ClientConfiguration getIgniteConfiguration() {
        ClientConfiguration cfg = new ClientConfiguration();
        cfg.setAddresses("127.0.0.1:10800");
        cfg.setTcpNoDelay(false);
        cfg.setTimeout(2000);
        return cfg;
    }


    @Bean(name = "cacheClient")
    public IgniteClient getIgniteClient(ClientConfiguration cfg) {
        IgniteClient igniteClient = Ignition.startClient(cfg);
        return igniteClient;
    }

    /**
     *
     * @param client, only need 30 seconds to persist user information
     * @return cache
     */
    @Bean(name = "locations")
    public ClientCache createLocationCache(@Qualifier("cacheClient") IgniteClient client) {
        ClientCache<String, Location> locations = client.getOrCreateCache("locations");
        locations.withExpirePolicy(new CreatedExpiryPolicy(new Duration(TimeUnit.SECONDS, 30)));
        return locations;
    }


}
