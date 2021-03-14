package com.thorben.janssen.sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.After;
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
    public void testTheTest(){
        System.out.println("It is Working!");
    }



//    @Test
    public void testSample() {
        log.info("==== testSample ====");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        ChessPlayer player = new ChessPlayer();
//        player.setFirstName("Thorben");
//        player.setLastName("Janssen");
//        em.persist(player);
//
        em.getTransaction().commit();
        em.close();



        // validate that player got persisted
        log.info("==== Test Assertions ====");
//        assertThat(player.getId()).isNotNull();
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//        assertThat(em.find(ChessPlayer.class, player.getId())).isNotNull();
        em.getTransaction().commit();
        em.close();
    }
}
