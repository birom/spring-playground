package com.example.demo.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import java.util.UUID;

import com.example.demo.repository.JobAdvertisementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JobAdvertisementTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private JobAdvertisementRepository jobAdvertisementRepository;


    @Test
    public void testSave() {
        // given
        JobAdvertisement jobAdvertisement = new JobAdvertisement();
        jobAdvertisement.setJobAdvertisementId(UUID.randomUUID().toString());
        jobAdvertisement.setFingerPrint("fingerprint-1");

        entityManager.persist(jobAdvertisement);
        entityManager.flush();

        // when
        List<JobAdvertisement> found = jobAdvertisementRepository.findAll();

        // then
        assertThat(found).size().isEqualTo(1);
    }
}
