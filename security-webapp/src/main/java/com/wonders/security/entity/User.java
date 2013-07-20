package com.wonders.security.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.ManyToOne;
import static javax.persistence.FetchType.LAZY;

/**
 * Entity implementation class for Entity: User
 * 
 */
@Entity
@Table(name = "sec_user")
public class User extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 8964444941371902286L;
	
	private String username;
	
	private String loginName;
	
	private String password;
	
	private String userCard;
	
	private String phone;
	
	private String fax;
	
	private String sex;
	
	@ManyToOne(fetch = LAZY, optional = false)
	private Organization orga;

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

}
