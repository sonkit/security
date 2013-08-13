package com.wonders.security.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Entity implementation class for Entity: Role
 * 
 */
@Entity
@Table(name = "sec_role")
public class Role extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -1889052965161052638L;

	@NotNull
	private String name;

	@NotNull
	private String code;

	private String description;
	
	@ManyToMany
	@JoinTable(name = "sec_role_resc", 
		joinColumns = @JoinColumn(name = "role_id"), 
		inverseJoinColumns = @JoinColumn(name = "resc_id")
	)
	private Set<Resource> rescs = new HashSet<Resource>();

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
	
	public Set<Resource> getRescs() {
		return rescs;
	}

	public void setRescs(Set<Resource> rescs) {
		this.rescs = rescs;
	}

}
