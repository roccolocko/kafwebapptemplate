package com.kaf.example.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="[Product]")
public class Product implements java.io.Serializable {

	/**
	 * Generado automaticamente
	 */
	private static final long serialVersionUID = 3862559697587362547L;
	
	private Long idProduct;
	private String name;
	
	private String Description;
	private Unit unit;
	
	@Column(name="Description")
	public String getDescription() {
		return Description;
	}
	@Id
	@Column(name="IdProduct",nullable=false,unique=true,insertable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdProduct() {
		return idProduct;
	}
	
	@Column(name="Name")
	public String getName() {
		return name;
	}
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdUnit", nullable=true, updatable=false)
	public Unit getUnit() {
		return unit;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	

}
