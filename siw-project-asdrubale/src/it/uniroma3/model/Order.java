package it.uniroma3.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NamedQueries({
		@NamedQuery(name = "findAllOrders", query = "select o from Order o"),
		@NamedQuery(name = "findAllPendingOrders", query = "select o from Order o where o.dataEvasione = null AND o.dataChiusura <> null"),
		@NamedQuery(name = "findAllSuspendedOrders", query = "select o from Order o where o.dataEvasione = null AND o.dataChiusura = null"),
		@NamedQuery(name = "findAllPendingOrders", query = "select o from Order o where o.dataEvasione = null AND o.dataChiusura <> null AND o.cliente = :paramCustomer"),
		@NamedQuery(name = "findAllDoneOrders", query = "select o from Order o where o.dataEvasione <> null AND o.dataApertura <> null AND o.dataChiusura <> null") })
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataApertura;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataChiusura;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEvasione;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE })
	@JoinColumn(name = "orders_id")
	private List<OrderLine> lineeOrdine;

	@ManyToOne
	private Customer cliente;

	public Order() {

		this.dataApertura = new Date();
		this.lineeOrdine = new LinkedList<>();

	}

	/**
	 * Aggiunge una nuova riga d'ordine relativa ad un prodotto
	 * 
	 * @param p
	 *            è prodotto da aggiungere
	 * @param q
	 *            è la quantità di prodotto
	 */
	public void addOrderLine(Product p, int q) {
		Iterator<OrderLine> iterator = this.lineeOrdine.iterator();
		boolean exist = false;
		OrderLine ol;
		while (!this.lineeOrdine.isEmpty() && iterator.hasNext() && !exist) {
			ol = iterator.next();
			if (ol.getP().getCode() == p.getCode()) { // Se i codici coincidono
				ol.setQuantita(ol.getQuantita() + q);
				exist = true;
			}
		}
		if (!exist) {
			ol = new OrderLine();
			ol.setP(p);
			ol.setQuantita(q);
			this.lineeOrdine.add(ol);
		}
	}

	/**
	 * @return the cliente
	 */
	public Customer getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Customer cliente) {
		this.cliente = cliente;
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
	 * @return the dataApertura
	 */
	public Date getDataApertura() {
		return dataApertura;
	}

	/**
	 * @param dataApertura
	 *            the dataApertura to set
	 */
	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
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
	 * @param lineeOrdine the lineeOrdine to set
	 */
	public void setLineeOrdine(List<OrderLine> lineeOrdine) {
		this.lineeOrdine = lineeOrdine;
	}	

}
