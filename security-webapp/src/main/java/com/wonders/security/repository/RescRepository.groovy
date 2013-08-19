package com.wonders.security.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

import com.wonders.security.core.repository.MyRepository
import com.wonders.security.entity.Resource

interface RescRepository extends MyRepository<Resource, Long> {
	
	@Query('select distinct(r) from Resource r left join fetch r.children where r.parent.id = :parentId')
	List<Resource> findByParentId(@Param('parentId') Long parentId)
	
	@Query('select r.rescs from Role r where r.id = :roleId')
	List<Resource> findByRoleId(@Param('roleId') Long roleId)

}
