package com.wonders.security.service.impl

import javax.inject.Inject

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.wonders.security.repository.UserRepository
import com.wonders.security.service.RescService

@Service('rescService')
@Transactional
class RescServiceImpl implements RescService {

	@Inject
	private UserRepository userRepository

	@Override
	long[] findRescIdsByUserId(long userId) {

		def user = userRepository.findOne(userId), rescs = new HashSet()

		if (user) {
			user.roles.each { role ->
				rescs += role.rescs
			}
		}
		
		rescs*.id as long[]
	}
}
