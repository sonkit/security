package com.wonders.security.service.impl

import javax.inject.Inject

import org.springframework.security.core.userdetails.User as SecurityUser
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.wonders.security.entity.User
import com.wonders.security.repository.RoleRepository
import com.wonders.security.repository.UserRepository
import com.wonders.security.service.UserService

@Service('userService')
@Transactional
class UserServiceImpl implements UserService {

	@Inject
	UserRepository userRepository

	@Inject
	RoleRepository roleRepository
	
	@Override
	UserDetails loadUserByUsername(String username) 
		throws UsernameNotFoundException  {
		
		def user = userRepository.findByLoginName(username)
		
		if (!user) {
			throw new UsernameNotFoundException("用户名[$username]的用户不存在!!")
		}
		
		new SecurityUser(user.loginName, user.password, []);
	}

	@Override
	void modifyPassword(long userId, String password) {
		userRepository.modifyPassword(userId, password)
	}

	@Override
	User addRolesToUser(long userId, long... roleIds) {

		def user = userRepository.findOne(userId)

		if (user) {

			def roles = roleRepository.findAll(roleIds as List)

			user.roles.addAll(roles)
		}

		user
	}

	@Override
	User removeRolesFromUser(long userId, long... roleIds) {

		def user = userRepository.findOne(userId)

		if (user) {

			def roles = roleRepository.findAll(roleIds as List)

			user.roles.removeAll(roles)
		}

		user
	}
	
}
