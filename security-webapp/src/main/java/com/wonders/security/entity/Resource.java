package com.wonders.security.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "sec_resc")
public class Resource extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1824225555278070623L;

	private String text;

	private String code;

	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	private Resource parent;

	@OneToMany(mappedBy = "parent")
	@OrderBy("text")
	@JsonIgnore
	private Set<Resource> children;
	
	@Transient
	@JsonProperty
	private Boolean checked;
	
	public Resource() {
		
	}
	
	public Resource(Long id) {
		this.setId(id);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
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
	
	public Resource getParent() {
		return parent;
	}

	public void setParent(Resource parent) {
		this.parent = parent;
	}

	public Set<Resource> getChildren() {
		return children;
	}

	public void setChildren(Set<Resource> children) {
		this.children = children;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

}
