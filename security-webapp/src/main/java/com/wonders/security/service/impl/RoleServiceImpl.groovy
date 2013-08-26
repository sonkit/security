package com.wonders.security.service.impl

import javax.inject.Inject

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.wonders.security.entity.Resource
import com.wonders.security.entity.Role
import com.wonders.security.repository.RescRepository
import com.wonders.security.repository.RoleRepository
import com.wonders.security.service.RoleService

@Service('roleService')
@Transactional
class RoleServiceImpl implements RoleService {

	@Inject
	RoleRepository roleRepository

	@Inject
	RescRepository rescRepository

	@Override
	Role maintainRoleResc(long roleId, long... rescIds) {

		def role = roleRepository.findOne(roleId)

		if (role) {
			
			def rescs = (List<Resource>) rescRepository.findAll(rescIds as List)
			
			rescs.each { resc ->
				
				if (!role.rescs.contains(resc)) {
					role.rescs << resc
				}
				
			}

			def iter = role.rescs.iterator()
			while (iter.hasNext()) {

				def resc = iter.next()

				if (!rescs.contains(resc)) {

					iter.remove()
				}
			}
		}

		role
	}
}
