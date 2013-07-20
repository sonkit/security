package com.wonders.security.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.ManyToOne;
import static javax.persistence.FetchType.LAZY;

/**
 * Entity implementation class for Entity: Organization
 * 
 */
@Entity
@Table(name = "sec_orga")
public class Organization extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 3689173688484489873L;

	private String name;
	
	private String code;
	
	private String districtCode;
	
	private String orgaType;
	
	private String address;
	
	private String description;
	
	@ManyToOne(fetch = LAZY)
	private Organization parent;

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

	public Organization getParent() {
		return parent;
	}

	public void setParent(Organization parent) {
		this.parent = parent;
	}

}
