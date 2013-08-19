package com.kaf.example.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Index;



@Entity
@Table(name="[User]")
public class User implements java.io.Serializable{
	
	/**
	 * Generado automaticamente
	 */
	private static final long serialVersionUID = -6470049766095857618L;
	
	private Long idUser;
	private String username;
	private String password;
	private Set<Role> roles = new HashSet<Role>(0);

	@Id
	@Column(name="IdUser",nullable=false,unique=true,insertable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdUser() {
		return idUser;
	}
	
	@Column(name="Username")
	public String getUsername() {
		return username;
	}

	@Column(name="Password")
	public String getPassword() {
		return password;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="UserRole",joinColumns=@JoinColumn(name="IdUser"),
		inverseJoinColumns=@JoinColumn(name="IdRole"))
	public Set<Role> getRoles() {
		return roles;
	}
	

	
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
