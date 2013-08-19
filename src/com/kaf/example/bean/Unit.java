package com.kaf.example.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[Unit]")
public class Unit implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2437028517766373121L;
	
	private Long idUnit;
	private String description;
	
	@Id
	@Column(name="IdUnit",nullable=false,unique=true,insertable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdUnit() {
		return idUnit;
	}
	
	public void setIdUnit(Long idUnit) {
		this.idUnit = idUnit;
	}
	
	@Column(name="Description")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
