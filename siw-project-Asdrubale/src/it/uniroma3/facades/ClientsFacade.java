package it.uniroma3.facades;

import java.util.List;

import it.uniroma3.model.Customer;
import it.uniroma3.model.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "cFacade")
public class ClientsFacade {

	@PersistenceContext(unitName = "unit-asdrubale")
	private EntityManager em;

	public Customer customerLogin(String username, String password) {

		Customer customer;
		try {
			customer = (Customer) this.em.createNamedQuery("findByEmail")
					.setParameter("paramEmail", username).getSingleResult();
			if (!customer.getPassword().equals(password)) {
				throw new Exception();
			}
		} catch (Exception e) {
			customer = null;
		}
		return customer;

	}	
	
	/**
	 * 
	 * @return ordini in attesa di essere evasi di un certo cliente
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getAllPendingOrdersOf(Customer customer) {

		return (List<Order>)this.em.createNamedQuery("findAllPendingOrders").setParameter("paramCustomer", customer.getId());
		
	}

}
