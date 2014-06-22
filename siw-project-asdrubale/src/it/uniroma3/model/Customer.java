package it.uniroma3.model;

import javax.persistence.*;

import java.util.*;

@Entity
// @Table(uniqueConstraints=@UniqueConstraint(columnNames={"nome", "cognome"}))
@NamedQueries({
		@NamedQuery(name = "findAllCustomers", query = "select c from Customer c"),
		@NamedQuery(name = "findByEmail", query = "select c from Customer c where c.email = :paramEmail") })
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;

	@Column(unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Temporal(TemporalType.DATE)
	private Date dataNascita;

	@Temporal(TemporalType.DATE)
	private Date dataRegistrazione;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE })
	private Address indirizzo;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = {
			CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Order> ordini;

	public Customer() {
		this.ordini = new LinkedList<>();
		this.dataRegistrazione = new Date();
	}

	public Customer(String nome, String cognome, String email, String password) {

		this();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;

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
	 * @return the dataRegistrazione
	 */
	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	/**
	 * @param dataRegistrazione
	 *            the dataRegistrazione to set
	 */
	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	/**
	 * @param l
	 *            'ordine da aggiungere
	 */
	public void addOrdine(Order ordine) {
		this.ordini.add(ordine);		
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
	 * @param cognome
	 *            the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the indirizzo
	 */
	public Address getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @param indirizzo
	 *            the indirizzo to set
	 */
	public void setIndirizzo(Address indirizzo) {
		this.indirizzo = indirizzo;
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

}
