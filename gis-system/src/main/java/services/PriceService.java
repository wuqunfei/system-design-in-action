package services;

import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.IgniteClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.cache.expiry.CreatedExpiryPolicy;

@Service
public class PriceService {
    Logger logger = LoggerFactory.getLogger(PriceService.class);
    private IgniteClient cacheClient;

    @Autowired
    public PriceService(IgniteClient cacheClient) {
        this.cacheClient = cacheClient;
    }
}
