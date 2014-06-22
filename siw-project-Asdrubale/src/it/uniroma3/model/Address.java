package it.uniroma3.model;

import javax.persistence.*;

@Entity
public class Address {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String strada;
	
	@Column(nullable=false)
	private String citta;
	
	@Column(nullable=false)
	private String stato;
	
	@Column(nullable=false)
	private String paese;
	
	@Column(nullable=false)
	private String cap;
	
	public Address() { }
	
	public Address(String strada, String citta, String stato, String paese, String cap) {
		
		this.strada = strada;
		this.citta = citta;
		this.stato = stato;
		this.paese = paese;
		this.cap = cap;
		
	}
	
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
	 * @return the strada
	 */
	public String getStrada() {
		return strada;
	}

	/**
	 * @param strada the strada to set
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
	 * @param citta the citta to set
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
	 * @param stato the stato to set
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
	 * @param paese the paese to set
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
	 * @param cap the cap to set
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}	

}
