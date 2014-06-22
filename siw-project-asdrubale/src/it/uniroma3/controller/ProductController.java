package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.facades.AdministrationFacade;
import it.uniroma3.facades.ClientsFacade;
import it.uniroma3.facades.UsersFacade;
import it.uniroma3.model.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ProductController {

	@EJB(beanName = "uFacade")
	private UsersFacade userFacade;

	@EJB(beanName = "aFacade")
	private AdministrationFacade adminFacade;

	@EJB(beanName = "cFacade")
	private ClientsFacade customerFacade;

	@ManagedProperty(value = "#{param.id}")
	private Long id;

	private String name;
	private String code;
	private Integer quantity;
	private String price;
	private String desc;
	private Product product;
	private List<Product> allProducts;
	private Integer sizeOfProducts;

	
	
	// Metodi Utente

	public String goToUserProductsList() {

		this.retrieveAllProducts();
		return "userProductsList";

	}
	
	public String goToUserProductDetails() {

		this.product = this.userFacade.getProductById(this.id);
		return "userProductDetails";

	}
	
	// Metodi Amministratore

	public String goToAdminProductsList() {

		this.retrieveAllProducts();
		return "adminProductsList";

	}
	
	public String goToAdminProductDetails() {
		
		this.product = this.userFacade.getProductById(this.id);
		return "adminProductDetails";

	}	

	public String adminCreateNewProduct() {

		this.product = new Product(this.name, Float.parseFloat(this.price),
				this.quantity, this.code.toUpperCase(), this.desc);
		this.adminFacade.createNewProduct(this.product);
		return "adminProductDetails";

	}

	
	public String adminDeleteProduct() {

		this.adminFacade.deleteProduct(this.id);
		return this.goToAdminProductsList();

	}

	public String goToAdminUpdateProduct() {
        
		this.product = this.userFacade.getProductById(this.id);
		this.setPropertyFromProduct();
		return "adminUpdateProduct";

	}	

	public String adminUpdateProduct() {
		
		this.product = this.userFacade.getProductById(this.id);
		setProductFromProperty();
		this.adminFacade.updateProduct(this.product);
		return "adminProductDetails";

	}	
	
	// Metodi privati
	
	private void retrieveAllProducts() {

		this.allProducts = this.userFacade.retrieveAllProducts();
		this.sizeOfProducts = this.allProducts.size();

	}
	
	private void setPropertyFromProduct() {
		
		this.name = this.product.getName();
		this.quantity = this.product.getQuantity();
		this.price = String.valueOf(this.product.getPrice());
		this.code = this.product.getCode();
		this.desc = this.product.getDescription();

	}
	
	private void setProductFromProperty() {

		this.product.setName(this.name);
		this.product.setPrice(Float.parseFloat(this.price));
		this.product.setQuantity(this.quantity);
		this.product.setCode(this.code.toUpperCase());
		this.product.setDescription(this.desc);

	}
	
	// Getters and setters

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
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the allProducts
	 */
	public List<Product> getAllProducts() {
		return allProducts;
	}

	/**
	 * @param allProducts the allProducts to set
	 */
	public void setAllProducts(List<Product> allProducts) {
		this.allProducts = allProducts;
	}

	/**
	 * @return the sizeOfProducts
	 */
	public Integer getSizeOfProducts() {
		return sizeOfProducts;
	}

	/**
	 * @param sizeOfProducts the sizeOfProducts to set
	 */
	public void setSizeOfProducts(Integer sizeOfProducts) {
		this.sizeOfProducts = sizeOfProducts;
	}	

}
