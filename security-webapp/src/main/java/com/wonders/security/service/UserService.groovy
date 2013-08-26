package com.wonders.security.service

import org.springframework.security.core.userdetails.UserDetailsService

import com.wonders.security.entity.User

interface UserService extends UserDetailsService {

	void modifyPassword(long userId, String password)

	User removeRolesFromUser(long userId, long... roleIds)

	User addRolesToUser(long userId, long... roleIds)

}
 