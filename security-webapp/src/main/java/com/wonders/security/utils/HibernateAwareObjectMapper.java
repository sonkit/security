package com.wonders.security.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 900721921614859815L;
	
	public HibernateAwareObjectMapper() {
		super.registerModule(new Hibernate4Module());
	}

}
