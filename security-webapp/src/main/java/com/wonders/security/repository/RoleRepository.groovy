package com.wonders.security.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

import com.wonders.security.core.repository.MyRepository
import com.wonders.security.entity.Role

interface RoleRepository extends MyRepository<Role, Long> {
	
	@Query("select u.roles from User u where u.id = :userId")
	List<Role> findByUserId(@Param("userId") Long userId)
	
}
