package com.wonders.security.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wonders.security.entity.Resource;
import com.wonders.security.entity.Role;
import com.wonders.security.repository.RescRepository;
import com.wonders.security.repository.RoleRepository;

@Service
@Transactional
public class RoleService {

	@Inject
	private RoleRepository roleRepository;

	@Inject
	private RescRepository rescRepository;

	public Role maintainRoleResc(Long roleId, Long... rescIds) {

		Role role = roleRepository.findOne(roleId);

		if (role != null) {

			List<Resource> rescs = (rescIds == null) ? new ArrayList<Resource>()
					: (List<Resource>) rescRepository.findAll(Arrays.asList(rescIds));

			for (Resource resc : rescs) {

				if (!role.getRescs().contains(resc)) {

					role.getRescs().add(resc);
				}
			}

			Iterator<Resource> iter = role.getRescs().iterator();
			while (iter.hasNext()) {
				
				Resource resc = iter.next();
				
				if (!rescs.contains(resc)) {
					
					iter.remove();
				}
			}
		}

		return role;
	}

}
