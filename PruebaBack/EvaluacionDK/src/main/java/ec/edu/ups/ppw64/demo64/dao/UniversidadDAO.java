package ec.edu.ups.ppw64.demo64.dao;

import java.util.List;

import ec.edu.ups.ppw64.demo64.model.Universidad;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UniversidadDAO {

	@PersistenceContext
    private EntityManager em;

	public void insert(Universidad universidad) {
		universidad = em.merge(universidad);
        em.persist(universidad);
    }
    
    public void update(Universidad universidad) {
        em.merge(universidad);
    }
    
    public void remove(int codigo) {
    	Universidad universidad = em.find(Universidad.class, codigo);
        em.remove(universidad);
    }
    
    public Universidad read(int codigo) {
    	Universidad universidad = em.find(Universidad.class, codigo);
        return universidad;
    }
    
    public List<Universidad> getAll() {
        String jpql = "SELECT c FROM universidad c";
        Query q = em.createQuery(jpql, Universidad.class);
        return q.getResultList();
    }
    
    public Universidad getProductoPorNombre(String nombre) {
        String jpql = "SELECT c FROM Universidad u WHERE c.nombre = :nombre";
        Query q = em.createQuery(jpql, Universidad.class);
        q.setParameter("nombre", nombre);
        List<Universidad> universidad = q.getResultList();
        if (universidad.size() > 0)
            return universidad.get(0);
        return null;
    }
}
