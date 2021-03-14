package com.thorben.janssen.sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thorben.janssen.sample.model.BMW;
import com.thorben.janssen.sample.model.Car;
import com.thorben.janssen.sample.model.CarInfo;
import com.thorben.janssen.sample.model.Honda;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestSample {

    Logger log = Logger.getLogger(this.getClass().getName());

    private EntityManagerFactory emf;

    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    @After
    public void close() {
        emf.close();
    }

    @Test
    public void testEntityManagerFactoryCreated() {
        Assert.assertNotNull(emf);
    }


    @Test
    public void testSample_ToAny() {
        log.info("==== testSample-ToAny ====");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Honda honda = new Honda();
        honda.setModel("h11");
        honda.setMaxPassenger(4);
        honda.setDriverName("Nikita");
        em.persist(honda);

        BMW bmw = new BMW();
        bmw.setModel("b11");
        bmw.setMaxPassenger(3);
        bmw.setDriverName("Martin");
        em.persist(bmw);

        CarInfo carInfo1 = new CarInfo();
        carInfo1.setCar(honda);
        em.persist(carInfo1);

        CarInfo carInfo2 = new CarInfo();
        carInfo2.setCar(bmw);
        em.persist(carInfo2);

        em.getTransaction().commit();
        em.close();


        // validate that player got persisted
        log.info("==== Test Assertions ====");
        assertThat(honda.getId()).isNotNull();
        assertThat(bmw.getId()).isNotNull();

        assertThat(carInfo1.getId()).isNotNull();
        assertThat(carInfo2.getId()).isNotNull();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        assertThat(em.find(Honda.class, honda.getId())).isNotNull();
        assertThat(em.find(BMW.class, bmw.getId())).isNotNull();

        assertThat(em.find(CarInfo.class, carInfo1.getId())).isNotNull();
        assertThat(em.find(CarInfo.class, carInfo2.getId())).isNotNull();

        em.getTransaction().commit();
        em.close();
    }
}
