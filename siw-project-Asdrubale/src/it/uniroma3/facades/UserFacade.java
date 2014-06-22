package it.uniroma3.facades;

import it.uniroma3.model.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

// Questa facade offre dei metodi per utenti non registrati

@Stateless(name="uFacade")
public class UserFacade {
	
	@PersistenceContext(unitName="unit-asdrubale")
	private EntityManager em;		
	
	public UserFacade() { }
	
	@SuppressWarnings("unchecked")
	public List<Product> retrieveAllProducts() {
		
		return em.createNamedQuery("findAllProducts").getResultList();
		
	}
	
	public Product getProductById(Long id) {
		
		return em.find(Product.class, id);
		
	}
	
}
