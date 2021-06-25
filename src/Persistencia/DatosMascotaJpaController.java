package Persistencia;

import Logica.DatosMascota;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DatosMascotaJpaController implements Serializable {

    public DatosMascotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public DatosMascotaJpaController() {
        emf = Persistence.createEntityManagerFactory("CargaDatosPU");
    }

    public void create(DatosMascota datosMascota) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(datosMascota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDatosMascota(datosMascota.getNumCliente()) != null) {
                throw new PreexistingEntityException("DatosMascota " + datosMascota + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DatosMascota datosMascota) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            datosMascota = em.merge(datosMascota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = datosMascota.getNumCliente();
                if (findDatosMascota(id) == null) {
                    throw new NonexistentEntityException("The datosMascota with id " + id + " no longer exists.");
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
            DatosMascota datosMascota;
            try {
                datosMascota = em.getReference(DatosMascota.class, id);
                datosMascota.getNumCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datosMascota with id " + id + " no longer exists.", enfe);
            }
            em.remove(datosMascota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DatosMascota> findDatosMascotaEntities() {
        return findDatosMascotaEntities(true, -1, -1);
    }

    public List<DatosMascota> findDatosMascotaEntities(int maxResults, int firstResult) {
        return findDatosMascotaEntities(false, maxResults, firstResult);
    }

    private List<DatosMascota> findDatosMascotaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DatosMascota.class));
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

    public DatosMascota findDatosMascota(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DatosMascota.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatosMascotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DatosMascota> rt = cq.from(DatosMascota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
