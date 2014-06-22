package it.uniroma3.controller;

import it.uniroma3.facades.AdministrationFacade;
import it.uniroma3.facades.ClientsFacade;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderLine;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class OrderController {
	
	@EJB(name = "aFacade")
	private AdministrationFacade adminFacade;

	@EJB(name = "cFacade")
	private ClientsFacade customerFacade;

	@ManagedProperty(value = "#{param.id}")
	private Long id;

	private Date dataChiusura;
	private Date dataEvasione;
	private Order ordine;
	private List<Order> allOrders;
	private int size;
	private List<OrderLine> lineeOrdine;	

	// Metodi Amministrazione

	public String goToAdminOrdersList() {

		this.retrieveAllOrders();
		return "adminOrdersList";

	}

	// Metodi Clientela

	public String goToCustomerOrdersList() {

		// TODO Solo ordini del cliente
		return "customerOrdersList";

	}

	// Metodi privati

	private void retrieveAllOrders() {
		
		this.allOrders = this.adminFacade.getAllOrders();
		this.size = this.allOrders.size();

	}

	// Getters and setters

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dataChiusura
	 */
	public Date getDataChiusura() {
		return dataChiusura;
	}

	/**
	 * @param dataChiusura
	 *            the dataChiusura to set
	 */
	public void setDataChiusura(Date dataChiusura) {
		this.dataChiusura = dataChiusura;
	}

	/**
	 * @return the dataEvasione
	 */
	public Date getDataEvasione() {
		return dataEvasione;
	}

	/**
	 * @param dataEvasione
	 *            the dataEvasione to set
	 */
	public void setDataEvasione(Date dataEvasione) {
		this.dataEvasione = dataEvasione;
	}

	/**
	 * @return the lineeOrdine
	 */
	public List<OrderLine> getLineeOrdine() {
		return lineeOrdine;
	}

	/**
	 * @param lineeOrdine
	 *            the lineeOrdine to set
	 */
	public void setLineeOrdine(List<OrderLine> lineeOrdine) {
		this.lineeOrdine = lineeOrdine;
	}

	/**
	 * @return the ordine
	 */
	public Order getOrdine() {
		return ordine;
	}

	/**
	 * @param ordine
	 *            the ordine to set
	 */
	public void setOrdine(Order ordine) {
		this.ordine = ordine;
	}

	/**
	 * @return the allOrders
	 */
	public List<Order> getAllOrders() {
		return allOrders;
	}

	/**
	 * @param allOrders
	 *            the allOrders to set
	 */
	public void setAllOrders(List<Order> allOrders) {
		this.allOrders = allOrders;
	}

}
