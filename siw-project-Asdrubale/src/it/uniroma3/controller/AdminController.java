package it.uniroma3.controller;

import it.uniroma3.facades.AdministrationFacade;
import it.uniroma3.model.Admin;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AdminController {

	@EJB(beanName = "aFacade")
	private AdministrationFacade adminFacade;

	@ManagedProperty(value = "#{customerController}")
	private CustomerController customerController; // Bean injection: per
													// evitare che i dati dei
													// clienti trattati restino
													// in sessione dopo che
													// l'admin si è sloggato

	private String username;
	private String password;
	private Admin admin;

	public String adminLogin() {

		this.admin = this.adminFacade.adminLogin(this.username, this.password);
		if (this.admin != null) {
			return "adminProfile";
		} else {
			this.username = this.password = null;
			return "index";
		}

	}

	public String adminLogOut() {

		this.admin = null;
		this.password = null;
		this.username = null;
		this.customerController.customerLogout(); // E qui richiedo all'altro
													// bean di "resettarsi"
		return "index";

	}

	/**
	 * @return the customerController
	 */
	public CustomerController getCustomerController() {
		return customerController;
	}

	/**
	 * @param customerController
	 *            the customerController to set
	 */
	public void setCustomerController(CustomerController customerController) {
		this.customerController = customerController;
	}

	/**
	 * @return the admin
	 */
	public Admin getAdmin() {
		return admin;
	}

	/**
	 * @param admin
	 *            the admin to set
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
