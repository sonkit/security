package com.wonders.security.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "findByParentId", method = RequestMethod.GET)
	protected @ResponseBody
	List<Organization> findByParentId(@RequestParam("node") long parentId) {
		return orgaRepository.findByParentId(parentId);
	}

}
