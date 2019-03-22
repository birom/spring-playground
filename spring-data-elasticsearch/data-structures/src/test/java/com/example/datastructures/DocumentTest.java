package com.example.datastructures;


import static com.example.datastructures.domain.FavouriteItem.FAVOURITE_ITEM_DOCUMENT_TYPE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.List;

import com.example.datastructures.domain.FavouriteItem;
import com.example.datastructures.domain.FavouriteItemRepository;
import com.example.datastructures.domain.JobAdvertisement;
import com.example.datastructures.domain.JobAdvertisementRepository;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.join.query.JoinQueryBuilders;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentTest {

    @Autowired
    private JobAdvertisementRepository jobAdvertisementRepository;

    @Autowired
    private FavouriteItemRepository favouriteItemRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Before
    public void setUp() throws Exception {
        elasticsearchTemplate.deleteIndex(FavouriteItem.class);
        elasticsearchTemplate.deleteIndex(JobAdvertisement.class);

        elasticsearchTemplate.createIndex(JobAdvertisement.class);
        elasticsearchTemplate.createIndex(FavouriteItem.class);
        elasticsearchTemplate.putMapping(FavouriteItem.class);
    }

    @Test
    public void testDocumentIndex() {
        JobAdvertisement jobAdvertisement1 = new JobAdvertisement().setId("1").setTitle("cook").setDescription("steak");
        JobAdvertisement jobAdvertisement2 = new JobAdvertisement().setId("2").setTitle("cook").setDescription("pizza");
        JobAdvertisement jobAdvertisement3 = new JobAdvertisement().setId("3").setTitle("cook").setDescription("vegetarian");
        JobAdvertisement jobAdvertisement4 = new JobAdvertisement().setId("4").setTitle("developer").setDescription("java");
        JobAdvertisement jobAdvertisement5 = new JobAdvertisement().setId("5").setTitle("bartender").setDescription("cool");

        this.jobAdvertisementRepository.index(jobAdvertisement1);
        this.jobAdvertisementRepository.index(jobAdvertisement2);
        this.jobAdvertisementRepository.index(jobAdvertisement3);
        this.jobAdvertisementRepository.index(jobAdvertisement4);
        this.jobAdvertisementRepository.index(jobAdvertisement5);

        FavouriteItem favouriteItem1 = new FavouriteItem().setId("1").setNote("interesting").setParentId("3");
        FavouriteItem favouriteItem2 = new FavouriteItem().setId("2").setNote("interesting").setParentId("5");

        this.favouriteItemRepository.index(favouriteItem1);
        this.favouriteItemRepository.index(favouriteItem2);

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
            .withQuery(QueryBuilders.matchQuery("title", "cook"))
            .withFilter(JoinQueryBuilders.hasChildQuery(FAVOURITE_ITEM_DOCUMENT_TYPE, QueryBuilders.matchQuery("note", "interesting"), ScoreMode.None))
            .build();

        List<String> jobAdvertisementIdList = this.elasticsearchTemplate.queryForIds(searchQuery);
        assertThat(jobAdvertisementIdList, is(notNullValue()));
        assertThat(jobAdvertisementIdList, is(hasSize(1)));
        assertThat(jobAdvertisementIdList.get(0), is("3"));
    }
}
