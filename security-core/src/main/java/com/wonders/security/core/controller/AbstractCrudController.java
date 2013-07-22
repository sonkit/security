package com.wonders.security.core.controller;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wonders.security.core.repository.MyRepository;

public abstract class AbstractCrudController<T, ID extends Serializable> {

	protected abstract MyRepository<T, ID> getRepository();

	@RequestMapping(method = RequestMethod.GET)
	protected @ResponseBody
	Page<T> findAll(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	protected @ResponseBody
	T findOne(@PathVariable ID id) {
		return getRepository().findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected @ResponseBody
	T add(@RequestBody T entity) {
		return getRepository().save(entity);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	protected @ResponseBody
	T modify(@RequestBody T entity) {
		return getRepository().save(entity);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	protected @ResponseBody
	void delete(@PathVariable ID id) {
		getRepository().delete(id);
	}

}
