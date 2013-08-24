package com.wonders.security.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Entity implementation class for Entity: User
 * 
 */
@Entity
@Table(name = "sec_user")
public class User extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 8964444941371902286L;
	
	@NotNull
	private String username;
	
	@NotNull
	@Column(unique = true)
	private String loginName;
	
	@NotNull
	private String password;
	
	private String userCard;
	
	private String phone;
	
	private String fax;
	
	@NotNull
	private String sex;
	
	@NotNull
	@ManyToOne(optional = false)
	private Organization orga;
	
	@ManyToMany
	@JoinTable(name = "sec_user_role", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<Role>();
	
	@ManyToMany
	@JoinTable(name = "sec_user_resc", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "resc_id")
	)
	private Set<Resource> rescs = new HashSet<Resource>();

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserCard() {
		return this.userCard;
	}

	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Organization getOrga() {
		return orga;
	}

	public void setOrga(Organization orga) {
		this.orga = orga;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Resource> getRescs() {
		return rescs;
	}

	public void setRescs(Set<Resource> rescs) {
		this.rescs = rescs;
	}

}
