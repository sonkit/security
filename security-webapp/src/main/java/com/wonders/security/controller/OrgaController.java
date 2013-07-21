package com.wonders.security.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wonders.security.core.controller.AbstractCrudController;
import com.wonders.security.core.repository.MyRepository;
import com.wonders.security.entity.Organization;
import com.wonders.security.repository.OrgaRepository;

@Controller
@RequestMapping("orgas")
public class OrgaController extends AbstractCrudController<Organization, Long> {
	
	@Inject
	private OrgaRepository orgaRepository;

	@Override
	protected MyRepository<Organization, Long> getRepository() {
		return orgaRepository;
	}

}
