package it.uniroma3.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Provider {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=8, unique=true)
	private String partitaIva;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;
	
	@ManyToMany
	private Map<String, Product> products;
	
	public Provider() { this.products = new HashMap<>(); }
	
	/**
	 * Aggiunge un prodotto a questo provider
	 * @param p prodotto da aggiungere
	 */
	public void addProduct(Product p) {
		this.products.put(p.getCode(), p);
	}

	/**
	 * @return the partitaIva
	 */
	public String getPartitaIva() {
		return partitaIva;
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
	 * @param partitaIva the partitaIva to set
	 */
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	/**
	 * @return the indirizzo
	 */
	public Address getIndirizzo() {
		return address;
	}

	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(Address indirizzo) {
		this.address = indirizzo;
	}	

}
