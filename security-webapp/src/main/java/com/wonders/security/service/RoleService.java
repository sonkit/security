package com.wonders.security.service;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public Role addRescsToRole(Long roleId, Long... rescIds) {
		
		Role role = roleRepository.findOne(roleId);
		
		if (role != null) {
			
			List<Resource> rescs = (ArrayList<Resource>) rescRepository
					.findAll(Arrays.asList(rescIds));
			
			role.getRescs().addAll(rescs);
		}
		
		return role;
	}
	
	public Role removeRescsFromRole(Long roleId, Long... rescIds) {
		
		Role role = roleRepository.findOne(roleId);
		
		if (role != null) {
			
			List<Resource> rescs = (ArrayList<Resource>) rescRepository
					.findAll(Arrays.asList(rescIds));
			
			role.getRescs().removeAll(rescs);
		}
		
		return role;
	}

}
