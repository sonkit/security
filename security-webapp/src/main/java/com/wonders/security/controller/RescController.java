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
import com.wonders.security.entity.Resource;
import com.wonders.security.repository.RescRepository;

@Controller
@RequestMapping("rescs")
public class RescController extends AbstractCrudController<Resource, Long> {

	@Inject
	private RescRepository rescRepository;

	@Override
	protected MyRepository<Resource, Long> getRepository() {
		return rescRepository;
	}

	@RequestMapping(value = "findByParentId", method = RequestMethod.GET)
	@ResponseBody
	List<Resource> findByParentId(@RequestParam("node") long parentId,
			Boolean checkedTree) {

		List<Resource> rescs = rescRepository.findByParentId(parentId);
		
		if (checkedTree != null && checkedTree == Boolean.TRUE) {
			for (Resource r : rescs) {
				r.setChecked(Boolean.FALSE);
			}
			return rescs;
		}

		return rescs;
	}

	@RequestMapping(value = "findByRoleId", method = RequestMethod.GET)
	@ResponseBody
	List<Resource> findByRoleId(long roleId) {
		return rescRepository.findByRoleId(roleId);
	}

}
