package com.wonders.security.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

import com.wonders.security.core.repository.MyRepository
import com.wonders.security.entity.Organization
import com.wonders.security.entity.User

interface UserRepository extends MyRepository<User, Long> {
	
	@Modifying
	@Query('update User u set u.password = :password where u.id = :userId')
	void modifyPassword(@Param('userId') long userId, @Param('password') String password)
	
	@Query('select count(u) from User u where u.loginName = :loginName')
	long isLoginNameUnique(@Param('loginName') String loginName)
	
	List<User> findByOrga(Organization orga)
	
}
