package com.example.datastructures.domain;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface JobAdvertisementRepository extends ElasticsearchRepository<JobAdvertisement, String> {
}
