package com.wonders.security.repository;

import java.util.List;

import com.wonders.security.core.repository.MyRepository;
import com.wonders.security.entity.Organization;

public interface OrgaRepository extends MyRepository<Organization, Long> {
	
	List<Organization> findByParentId(long parentId);

}