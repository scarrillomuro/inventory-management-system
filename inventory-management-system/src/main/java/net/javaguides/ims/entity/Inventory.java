package net.javaguides.ims.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "inventories")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "product_name", nullable = false)
	private String productName;
	
	@Column (name = "product_cost")
	private double productCost;
	
	@Column (name = "product_unit_of_measure")
	private String productUnitOfMeasure; 
	
	@Column (name = "product_quantity")
	private double productQuantity; 
	
	@Column (name = "product_description")
	private String productDescription;
	
	
	public Inventory () {
		
	}	
	
	public Inventory(String productName, double productCost, String productUnitOfMeasure, double productQuantity,
			String productDescription) {
		super();
		this.productName = productName;
		this.productCost = productCost;
		this.productUnitOfMeasure = productUnitOfMeasure;
		this.productQuantity = productQuantity;
		this.productDescription = productDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public String getProductUnitOfMeasure() {
		return productUnitOfMeasure;
	}

	public void setProductUnitOfMeasure(String productUnitOfMeasure) {
		this.productUnitOfMeasure = productUnitOfMeasure;
	}

	public double getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(double productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	

}
