package com.example.datastructures.domain;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface FavouriteItemRepository extends ElasticsearchRepository<FavouriteItem, String> {
}
