package com.system.desgin.yelp.configuration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@Configuration
public class IndexConfiguration {
    @Bean
    public RestHighLevelClient getClient() {
        String localhost = "localhost:9200";
        ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo(localhost).
                withBasicAuth("elastic", "B4DHHAn3BLAsSO_BB0UC").build();
        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate(RestHighLevelClient client) {
        return new ElasticsearchRestTemplate(client);
    }
}
