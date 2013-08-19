package com.kaf.example.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="[Role]")
public class Role implements java.io.Serializable{
	
	/**
	 * Generado automaticamente
	 */
	private static final long serialVersionUID = -6470049766095857618L;
	
	private Long idRole;
	private String description;

	@Id
	@Column(name="IdRole",nullable=false,unique=true,insertable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdRole() {
		return idRole;
	}
	
	
	@Column(name="Description")
	public String getDescription() {
		return description;
	}
	
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
