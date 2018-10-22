package com.zzp.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    
    private String name;

    private String descrpit;
    
    private BigDecimal price;

	public Product( ) {
		
	}
	
	public Product(String name, String desc, BigDecimal price) {
		super();
		this.name = name;
		this.descrpit = desc;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + descrpit + ", price=" + price + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescrpit() {
		return descrpit;
	}

	public void setDescrpit(String descrpit) {
		this.descrpit = descrpit;
	}

    
    
}
