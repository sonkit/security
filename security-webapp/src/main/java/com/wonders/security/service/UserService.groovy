package com.wonders.security.service

import javax.inject.Inject

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.wonders.security.entity.Role
import com.wonders.security.entity.User
import com.wonders.security.repository.RoleRepository
import com.wonders.security.repository.UserRepository

@Service
@Transactional
class UserService {

	@Inject
	UserRepository userRepository

	@Inject
	RoleRepository roleRepository

	User modifyPassword(long userId, String newPassword) {

		def user = userRepository.findOne(userId)

		if (user) {
			user.password = newPassword
		}

		user
	}

	User addRolesToUser(long userId, long... roleIds) {

		def user = userRepository.findOne(userId)

		if (user) {

			def roles = (List<Role>) roleRepository.findAll(roleIds as List)

			user.roles.addAll(roles)
		}

		user
	}

	User removeRolesFromUser(long userId, long... roleIds) {

		def user = userRepository.findOne(userId)

		if (user) {

			def roles = (List<Role>) roleRepository.findAll(roleIds as List)

			user.roles.removeAll(roles)
		}

		user
	}
}
