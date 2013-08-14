package com.wonders.security.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Organization
 * 
 */
@Entity
@Table(name = "sec_orga")
public class Organization extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 3689173688484489873L;

	private String text;
	
	private String code;
	
	private String districtCode;
	
	private String orgaType;
	
	private String address;
	
	private String description;
	
	public Organization() {
		
	}
	
	public Organization(Long id) {
		this.setId(id);
	}
	
	@Transient
	private Boolean leaf;
	
	@Transient
	private Long parentId;
	
	@ManyToOne(fetch = LAZY)
	private Organization parent;
	
	@OneToMany(mappedBy = "parent")
	@OrderBy
	@JsonIgnore
	private Set<Organization> children;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getOrgaType() {
		return this.orgaType;
	}

	public void setOrgaType(String orgaType) {
		this.orgaType = orgaType;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean isLeaf() {
		if (Hibernate.isInitialized(children)) {
			return children == null || children.isEmpty();
		}
		return null;
	}
	
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	public Organization getParent() {
		return parent;
	}

	public void setParent(Organization parent) {
		this.parent = parent;
	}

	public Set<Organization> getChildren() {
		return children;
	}

	public void setChildren(Set<Organization> children) {
		this.children = children;
	}

}
