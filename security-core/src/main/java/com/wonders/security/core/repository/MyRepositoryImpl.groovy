package com.wonders.security.core.repository

import javax.persistence.EntityManager
import javax.persistence.TypedQuery
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.query.QueryUtils
import org.springframework.data.jpa.repository.support.SimpleJpaRepository

class MyRepositoryImpl<T, ID extends Serializable> 
	extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {
	
	final Class<T> domainClass
	final EntityManager entityManager
		
	public MyRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager)
		
		this.domainClass = domainClass
		this.entityManager = entityManager
	}

	@Override
	Page<T> findAll(Map params, Pageable pageable) {
		def query = getQuery(params, pageable?.sort)
		!pageable ? new PageImpl(query.resultList) : readPage(query, pageable, params)
	}
	
	private TypedQuery getQuery(Map params, Sort sort) {

		def builder = entityManager.criteriaBuilder
		def query = builder.createQuery(domainClass)

		def root = query.from(domainClass)
		query.select(root)
		
		applyParamsToCriteria(params, query)

		if (sort) {
			query.orderBy(QueryUtils.toOrders(sort, root, builder))
		}

		entityManager.createQuery(query)
	}
	
	private Page readPage(TypedQuery query, Pageable pageable, Map params) {
		
		query.firstResult = pageable.offset
		query.maxResults = pageable.pageSize
		
		def total = QueryUtils.executeCountQuery(getCountQuery(params))
		def content = total > pageable.offset ? query.resultList : []

		new PageImpl(content, pageable, total)
	}
	
	private TypedQuery getCountQuery(Map params) {
		
		def builder = entityManager.criteriaBuilder
		def query = builder.createQuery(Long.class)

		def root = query.from(domainClass)
		applyParamsToCriteria(params, query)

		if (query.distinct) {
			query.select(builder.countDistinct(root))
		} else {
			query.select(builder.count(root))
		}

		entityManager.createQuery(query)
	}
	
	private void applyParamsToCriteria(Map params, CriteriaQuery query) {
		
		def builder = entityManager.criteriaBuilder
		def root = query.roots[0]
	
		def predicates = []
		params.each { k, v ->
			
			def index = ((String) k).indexOf('_')
			def prop = ((String) k).substring(0, index)
			def oper = ((String) k).substring(index + 1)
			
			predicates << builder."$oper"(root.get(prop), v)
		}
		
		if (predicates) {
			query.where(predicates as Predicate[])
		}
	}
	
}
