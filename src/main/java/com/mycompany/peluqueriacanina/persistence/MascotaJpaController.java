package com.mycompany.peluqueriacanina.persistence;

import com.mycompany.peluqueriacanina.logic.Mascota;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MascotaJpaController {

    private EntityManagerFactory emf = null;

    public MascotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public MascotaJpaController() {
        emf = Persistence.createEntityManagerFactory("peluqueriaCaninaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mascota mascota) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(mascota);
        em.getTransaction().commit();
        em.close();
    }

    public Mascota findMascota(int id) {
        EntityManager em = getEntityManager();
        Mascota mascota = em.find(Mascota.class, id);
        em.close();
        return mascota;
    }

    public List<Mascota> findMascotaEntities() {
        EntityManager em = getEntityManager();
        List<Mascota> mascotas = em.createQuery("SELECT m FROM Mascota m", Mascota.class).getResultList();
        em.close();
        return mascotas;
    }

    public void edit(Mascota mascota) throws Exception {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(mascota);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(int id) throws Exception {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Mascota mascota = em.find(Mascota.class, id);
        if (mascota != null) {
            em.remove(mascota);
        }
        em.getTransaction().commit();
        em.close();
    }
}
