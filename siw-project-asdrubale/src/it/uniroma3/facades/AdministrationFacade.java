package it.uniroma3.facades;

import java.util.List;

import it.uniroma3.model.Admin;
import it.uniroma3.model.Customer;
import it.uniroma3.model.Order;
import it.uniroma3.model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "aFacade")
public class AdministrationFacade {

	@PersistenceContext(unitName = "unit-asdrubale")
	private EntityManager em;

	public AdministrationFacade() {
	}

	public Admin adminLogin(String username, String password) {

		Admin admin;
		try {
			admin = (Admin) this.em.createNamedQuery("findByUsername")
					.setParameter("paramUsername", username).getSingleResult();
			if (!admin.getPassword().equals(password)) {
				throw new Exception();
			}
		} catch (Exception e) {
			admin = null;
		}
		return admin;

	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {

		return (List<Customer>) this.em.createNamedQuery("findAllCustomers")
				.getResultList();

	}
	
	/**
	 * 
	 * @return ordini in attesa di essere evasi
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getAllPendingOrders() {
        
		return (List<Order>)this.em.createNamedQuery("findAllPendingOrders").getResultList();
		
	}
    
	/** 
	 * 
	 * @return ordini che sono stati evasi
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getAllDoneOrders() {

		return (List<Order>)this.em.createNamedQuery("findAllDoneOrders").getResultList();
		
	}
	
	/**
	 * 
	 * @return ordini che non sono stati chiusi
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getAllSuspendedOrders() {

		return (List<Order>)this.em.createNamedQuery("findAllSuspendedOrders").getResultList();
		
	}	
    
	/**
	 * 
	 * @return tutti gli ordini
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		
		return (List<Order>)this.em.createNamedQuery("findAllOrders").getResultList();

	}

	public void createNewProduct(Product newProduct) {

		this.em.persist(newProduct);

	}

	public void createNewCustomer(Customer customer) {

		this.em.persist(customer);

	}

	public Product getProduct(Long id) {

		return this.em.find(Product.class, id);

	}

	public Customer getCustomer(Long id) {

		return this.em.find(Customer.class, id);
	}

	public void deleteProduct(Long id) {

		this.em.remove(this.getProduct(id));

	}

	public void deleteCustomer(Long id) {

		this.em.remove(this.getCustomer(id));
	}

	public void updateProduct(Product product) {

		this.em.merge(product);

	}

	public void updateCustomer(Customer customer) {

		this.em.merge(customer);

	}

}
