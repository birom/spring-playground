package com.example.demo.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
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

        jobAdvertisement.setJobContent(new JobContent());
        jobAdvertisement.getJobContent().setLocation(new Location());

        jobAdvertisement.getJobContent().getLocation().setCity("city-1");
        jobAdvertisement.getJobContent().getLocation().setPostalCode("PLZ-1");
        jobAdvertisement.getJobContent().getLocation().setRemarks("remark-1");

        jobAdvertisement.getJobContent().setOccupations(new ArrayList<>());

        Occupation occupation1 = new Occupation();
        occupation1.setAvamCode("avamCode-1");
        occupation1.setSbn3Code("sbn3Code-1");
        occupation1.setSbn5Code("sbn5Code-1");
        jobAdvertisement.getJobContent().getOccupations().add(occupation1);

        Occupation occupation2 = new Occupation();
        occupation2.setAvamCode("avamCode-2");
        occupation2.setSbn3Code("sbn3Code-3");
        occupation2.setSbn5Code("sbn5Code-4");
        jobAdvertisement.getJobContent().getOccupations().add(occupation2);

        entityManager.persist(jobAdvertisement);
        entityManager.flush();

        // when
        List<JobAdvertisement> found = jobAdvertisementRepository.findAll();

        // then
        assertThat(found).size().isEqualTo(1);
        assertThat(found.get(0).getJobContent()).isNotNull();
        assertThat(found.get(0).getJobContent().getLocation()).isNotNull();
        assertThat(found.get(0).getJobContent().getLocation().getCity()).isEqualToIgnoringCase("city-1");

        assertThat(found.get(0).getJobContent().getOccupations()).size().isEqualTo(2);
        assertThat(found.get(0).getJobContent().getOccupations().get(0).getAvamCode()).isEqualTo("avamCode-1");
        assertThat(found.get(0).getJobContent().getOccupations().get(1).getAvamCode()).isEqualTo("avamCode-2");
    }
}
