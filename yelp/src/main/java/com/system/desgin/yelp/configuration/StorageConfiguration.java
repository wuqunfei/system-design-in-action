package com.system.desgin.yelp.configuration;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfiguration {

    @Bean(name = "aws_configuration")
    public ClientConfiguration clientConfiguration(){
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        return clientConfiguration;
    }

    @Bean
    public AmazonS3Client getS3Client(){
        AmazonS3Client client = new AmazonS3Client();
        return client;
    }
}
