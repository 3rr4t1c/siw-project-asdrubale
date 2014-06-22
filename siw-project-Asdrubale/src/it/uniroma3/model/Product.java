package it.uniroma3.model;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllProducts", query = "select p from Product p"),
		@NamedQuery(name = "findByCode", query = "select p from Product p where p.code = :paramCode") })
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column	
	private Float price;

	@Column(nullable = false)
	private Integer quantity;

	@Column(nullable = false, unique = true)
	private String code;

	@Column(length = 2000)
	private String description;

	@ManyToMany(mappedBy = "products", cascade = { CascadeType.PERSIST })
	private List<Provider> providers;

	public Product() {		
		
		this.providers = new LinkedList<>();
		
	}

	public Product(String name, Float price, Integer quantity, String code, String description) {

		this();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.code = code;
		this.description = description;

	}

	public void addProvider(Provider prv) {

		this.providers.add(prv);

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(Object obj) {
		Product product = (Product) obj;
		return this.getCode().equals(product.getCode());
	}

	public int hashCode() {
		return this.code.hashCode();
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Product");
		sb.append("{id=").append(id);
		sb.append(", name='").append(name);
		sb.append(", price=").append(price);
		sb.append(", description='").append(description);
		sb.append(", code='").append(code);
		sb.append("}\n");
		return sb.toString();
	}

}