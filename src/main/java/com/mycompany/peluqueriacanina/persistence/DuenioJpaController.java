package com.mycompany.peluqueriacanina.persistence;

import com.mycompany.peluqueriacanina.logic.Duenio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DuenioJpaController {

    private EntityManagerFactory emf = null;

    public DuenioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public DuenioJpaController() {
        emf = Persistence.createEntityManagerFactory("peluqueriaCaninaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Duenio duenio) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(duenio);
        em.getTransaction().commit();
        em.close();
    }

    public Duenio findDuenio(int id) {
        EntityManager em = getEntityManager();
        Duenio duenio = em.find(Duenio.class, id);
        em.close();
        return duenio;
    }

    public List<Duenio> findDuenioEntities() {
        EntityManager em = getEntityManager();
        List<Duenio> duenios = em.createQuery("SELECT d FROM Duenio d", Duenio.class).getResultList();
        em.close();
        return duenios;
    }

    public void edit(Duenio duenio) throws Exception {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(duenio);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(int id) throws Exception {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Duenio duenio = em.find(Duenio.class, id);
        if (duenio != null) {
            em.remove(duenio);
        }
        em.getTransaction().commit();
        em.close();
    }
}
