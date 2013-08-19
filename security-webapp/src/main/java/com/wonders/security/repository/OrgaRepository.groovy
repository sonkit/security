package com.wonders.security.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

import com.wonders.security.core.repository.MyRepository
import com.wonders.security.entity.Organization

interface OrgaRepository extends MyRepository<Organization, Long> {
	
	@Query('select distinct(o) from Organization o left join fetch o.children where o.parent.id = :parentId')
	List<Organization> findByParentId(@Param('parentId') Long parentId)

}