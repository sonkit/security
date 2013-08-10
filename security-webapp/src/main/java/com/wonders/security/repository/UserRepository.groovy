package com.wonders.security.repository

import com.wonders.security.core.repository.MyRepository
import com.wonders.security.entity.Organization
import com.wonders.security.entity.User

public interface UserRepository extends MyRepository<User, Long> {
	
	List<User> findByOrga(Organization orga)

}
