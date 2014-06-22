package it.uniroma3.controller;

import it.uniroma3.facades.AdministrationFacade;
import it.uniroma3.facades.ClientsFacade;
import it.uniroma3.model.Address;
import it.uniroma3.model.Customer;
import it.uniroma3.model.Order;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CustomerController {

	@EJB(name = "aFacade")
	private AdministrationFacade administrationFacade;

	@EJB(name = "cFacade")
	private ClientsFacade clientsFacade;

	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private Date dataNascita;
	private Customer customer;
	private Address address;
	private Integer pendingOrders;
	private List<Customer> allCustomers;
	private Integer sizeOfCustomers;

	// Indirizzo

	private Long addressId;
	private String strada;
	private String citta;
	private String stato;
	private String paese;
	private String cap;

	// Ordine corrente (ne viene creato uno nuovo ad ogni login del cliente ma
	// non viene persistito fino alla conferma)

	private Order ordineCorrente;

	// Metodi Cliente

	public String customerLogin() {

		this.customer = this.clientsFacade.customerLogin(this.email,
				this.password);
		if (this.customer != null) {
			this.ordineCorrente = new Order();
			return "customerProfile";
		} else {
			this.email = this.password = null;
			return "index";
		}

	}

	public String customerLogout() {

		this.flushSession();
		return "index";

	}

	// Metodi Amministrazione

	public String goToAdminCustomersList() {

		retrieveAllCustomers();
		return "adminCustomersList";

	}

	public String goToAdminCustomerDetails() {

		return "adminCustomerDetails";

	}

	public String goToAdminNewCustomer() {

		this.flushSession();
		return "adminNewCustomer";

	}

	public String adminCreateNewCustomer() {

		this.address = new Address(this.strada, this.citta, this.stato,
				this.paese, this.cap);
		this.customer = new Customer(this.nome, this.cognome, this.email,
				this.password);
		this.customer.setDataNascita(this.dataNascita);
		this.customer.setIndirizzo(this.address);
		this.administrationFacade.createNewCustomer(this.customer);
		return "adminCustomerDetails";

	}

	public String goToAdminUpdateCustomer() {

		this.setPropertyFromCustomer();
		return "adminUpdateCustomer";

	}

	public String adminUpdateCustomer() {

		this.setCustomerFromProperty();
		this.administrationFacade.updateCustomer(this.customer);
		return this.goToAdminCustomerDetails();

	}

	public String adminDeleteCustomer() {

		this.administrationFacade.deleteCustomer(this.id);
		return this.goToAdminCustomersList();

	}

	// Metodi privati

	/**
	 * 
	 */
	private void retrieveAllCustomers() {
		this.allCustomers = this.administrationFacade.getAllCustomers();
		this.sizeOfCustomers = this.allCustomers.size();
	}

	/**
	 * A partire dalle proprietà crea un nuovo customer con indirizzo annesso
	 */
	private void setCustomerFromProperty() {

		this.customer.setNome(this.nome);
		this.customer.setCognome(this.cognome);
		this.customer.setEmail(this.email);
		this.customer.setPassword(this.password);
		this.customer.setDataNascita(this.dataNascita);

		this.address.setStrada(this.strada);
		this.address.setCitta(this.citta);
		this.address.setPaese(this.paese);
		this.address.setStato(this.stato);
		this.address.setCap(this.cap);

	}

	/**
	 * A partire dal customer imposta le proprietà correnti
	 */
	private void setPropertyFromCustomer() {

		this.nome = this.customer.getNome();
		this.cognome = this.customer.getCognome();
		this.email = this.customer.getEmail();
		this.password = this.customer.getPassword();
		this.dataNascita = customer.getDataNascita();

		this.address = this.customer.getIndirizzo();

		this.strada = this.address.getStrada();
		this.citta = this.address.getCitta();
		this.paese = this.address.getPaese();
		this.stato = this.address.getStato();
		this.cap = this.address.getCap();

	}

	/**
	 * Questo metodo svuota la sessione questo serve quando l'admin vuole
	 * inserire un nuovo cliente o quando un cliente esce dal profilo
	 * 
	 */
	private void flushSession() {

		this.customer = null;
		this.nome = null;
		this.cognome = null;
		this.email = null;
		this.password = null;
		this.dataNascita = null;
		this.address = null;
		this.strada = null;
		this.citta = null;
		this.stato = null;
		this.paese = null;
		this.cap = null;

	}

	// Setters and Getters

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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome
	 *            the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

	/**
	 * @return the dataNascita
	 */
	public Date getDataNascita() {
		return dataNascita;
	}

	/**
	 * @param dataNascita
	 *            the dataNascita to set
	 */
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the pendingOrders
	 */
	public Integer getPendingOrders() {
		return pendingOrders;
	}

	/**
	 * @param pendingOrders
	 *            the pendingOrders to set
	 */
	public void setPendingOrders(Integer pendingOrders) {
		this.pendingOrders = pendingOrders;
	}

	/**
	 * @return the allCustomers
	 */
	public List<Customer> getAllCustomers() {
		return allCustomers;
	}

	/**
	 * @param allCustomers
	 *            the allCustomers to set
	 */
	public void setAllCustomers(List<Customer> allCustomers) {
		this.allCustomers = allCustomers;
	}

	/**
	 * @return the sizeOfCustomers
	 */
	public Integer getSizeOfCustomers() {
		return sizeOfCustomers;
	}

	/**
	 * @param sizeOfCustomers
	 *            the sizeOfCustomers to set
	 */
	public void setSizeOfCustomers(Integer sizeOfCustomers) {
		this.sizeOfCustomers = sizeOfCustomers;
	}

	/**
	 * @return the addressId
	 */
	public Long getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId
	 *            the addressId to set
	 */
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the strada
	 */
	public String getStrada() {
		return strada;
	}

	/**
	 * @param strada
	 *            the strada to set
	 */
	public void setStrada(String strada) {
		this.strada = strada;
	}

	/**
	 * @return the citta
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * @param citta
	 *            the citta to set
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}

	/**
	 * @return the stato
	 */
	public String getStato() {
		return stato;
	}

	/**
	 * @param stato
	 *            the stato to set
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/**
	 * @return the paese
	 */
	public String getPaese() {
		return paese;
	}

	/**
	 * @param paese
	 *            the paese to set
	 */
	public void setPaese(String paese) {
		this.paese = paese;
	}

	/**
	 * @return the cap
	 */
	public String getCap() {
		return cap;
	}

	/**
	 * @param cap
	 *            the cap to set
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}

	/**
	 * @return the ordineCorrente
	 */
	public Order getOrdineCorrente() {
		return ordineCorrente;
	}

	/**
	 * @param ordineCorrente
	 *            the ordineCorrente to set
	 */
	public void setOrdineCorrente(Order ordineCorrente) {
		this.ordineCorrente = ordineCorrente;
	}

}
