package com.example.datastructures.config;

import org.elasticsearch.client.Client;

import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@Configuration
@EnableConfigurationProperties(ElasticsearchProperties.class)
public class ElasticsearchConfig {

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client client) {
        return new ElasticsearchTemplate(client);
    }
}
