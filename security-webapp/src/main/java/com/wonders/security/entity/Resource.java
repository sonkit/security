package com.wonders.security.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Hibernate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "sec_resc")
public class Resource extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1824225555278070623L;

	private String text;

	private String code;

	private String description;
	
	@Transient
	private Boolean leaf;
	
	@Transient
	private Long parentId;

	@ManyToOne(fetch = FetchType.LAZY)
	private Resource parent;

	@OneToMany
	private Set<Resource> children = new HashSet<Resource>();

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
	
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

}
