package com.wonders.security.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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

	@NotNull
	private String text;

	@NotNull
	@Column(unique = true)
	private String code;

	private String districtCode;

	@NotNull
	@Enumerated(EnumType.STRING)
	private OrgaType orgaType;

	private String address;

	private String description;

	@ManyToOne(fetch = LAZY)
	private Organization parent;

	@OneToMany(mappedBy = "parent")
	@OrderBy("text")
	@JsonIgnore
	private Set<Organization> children;

	public Organization() {

	}

	public Organization(Long id) {
		this.setId(id);
	}

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

	public OrgaType getOrgaType() {
		return this.orgaType;
	}

	public void setOrgaType(OrgaType orgaType) {
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
	
	public String getIconCls() {
		return "orga-icon-cls";
	}

	public enum OrgaType {
		省级机构, 市级机构, 县级机构, 部门
	}

}
