package it.uniroma3.model;

import javax.persistence.*;

@Entity
public class OrderLine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Product p;
	
	@Column
	private Float prezzo;
	
	@Column
	private Integer quantita;	
	
	public OrderLine() { }
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the p
	 */
	public Product getP() {
		return p;
	}

	/**
	 * @param p the p to set
	 */
	public void setP(Product p) {
		this.p = p;
		this.prezzo = p.getPrice();
	}

	/**
	 * @return the prezzo
	 */
	public Float getPrezzo() {
		return prezzo;
	}

	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return the quantita
	 */
	public Integer getQuantita() {
		return quantita;
	}

	/**
	 * @param quantita the quantita to set
	 */
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}	

}
