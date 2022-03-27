package com.systemdesign.gissystem;

import com.systemdesign.gissystem.model.DriverHashLocation;
import com.systemdesign.gissystem.model.DriverLocation;
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
    @Bean(name = "driverHashLocation")
    public ClientCache createDriverHashLocationCache(@Qualifier("cacheClient") IgniteClient client) {
        ClientCache<String, DriverHashLocation> locations = client.getOrCreateCache("driverHashLocation");
        locations.withExpirePolicy(new CreatedExpiryPolicy(new Duration(TimeUnit.SECONDS, 30)));

        return locations;
    }

    @Bean(name = "driverLocation")
    public ClientCache createDriverLocationCache(@Qualifier("cacheClient") IgniteClient client) {
        ClientCache<String, DriverLocation> locations = client.getOrCreateCache("driverLocation");
        locations.withExpirePolicy(new CreatedExpiryPolicy(new Duration(TimeUnit.SECONDS, 30)));
        return locations;
    }


}
