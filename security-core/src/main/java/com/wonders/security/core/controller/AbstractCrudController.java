package com.wonders.security.core.controller;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wonders.security.core.repository.MyRepository;

public abstract class AbstractCrudController<T, ID extends Serializable> {

	protected abstract MyRepository<T, ID> getRepository();
	
	@RequestMapping(method = RequestMethod.GET)
	protected @ResponseBody
	Page<T> findAll(@RequestParam Map<String, String> params, Pageable pageable) {
		return getRepository().findAll(getFilters(params), pageable);
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
		MyRepository<T, ID> repository = getRepository();
		repository.delete(repository.findOne(id));
	}
	
	@RequestMapping(value = "isPropertyUnique", method = RequestMethod.GET)
	protected @ResponseBody
	Map<String, Boolean> isPropertyUnique(String propertyName, String value) {
		boolean unique = getRepository().isPropertyUnique(propertyName, value);
		if (unique) {
			return Collections.singletonMap("unique", Boolean.TRUE);
		}
		return Collections.singletonMap("unique", Boolean.FALSE);
	}
	
	private Map<?, ?> getFilters(Map<String, String> params) {
		Map<String, String> filters = new TreeMap<String, String>();
		for (String key : params.keySet()) {
			if (key.startsWith("search_")) {
				String name = key.substring(key.indexOf("_") + 1);
				String value = params.get(key);
				try {
					value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException e) {}
				filters.put(name, value);
			}
		}
		return filters;
	}

}
