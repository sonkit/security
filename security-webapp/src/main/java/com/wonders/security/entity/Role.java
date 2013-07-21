package com.wonders.security.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Entity implementation class for Entity: Role
 * 
 */
@Entity
@Table(name = "sec_role")
public class Role extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -1889052965161052638L;

	private String name;
	
	private String code;
	
	private String description;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
