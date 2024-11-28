
package com.mycompany.persistencia;

import com.mycompany.logica.Licoreria;
import com.mycompany.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class LicoreriaJpaController implements Serializable {

    public LicoreriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;        
    }
    
    public LicoreriaJpaController() {
        emf = Persistence.createEntityManagerFactory("LicoreriaPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Licoreria licoreria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(licoreria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Licoreria licoreria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            licoreria = em.merge(licoreria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = licoreria.getId();
                if (findLicoreria(id) == null) {
                    throw new NonexistentEntityException("The licoreria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Licoreria licoreria;
            try {
                licoreria = em.getReference(Licoreria.class, id);
                licoreria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The licoreria with id " + id + " no longer exists.", enfe);
            }
            em.remove(licoreria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Licoreria> findLicoreriaEntities() {
        return findLicoreriaEntities(true, -1, -1);
    }

    public List<Licoreria> findLicoreriaEntities(int maxResults, int firstResult) {
        return findLicoreriaEntities(false, maxResults, firstResult);
    }

    private List<Licoreria> findLicoreriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Licoreria.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Licoreria findLicoreria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Licoreria.class, id);
        } finally {
            em.close();
        }
    }

    public int getLicoreriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Licoreria> rt = cq.from(Licoreria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
