package org.itst.service.impl;

import org.itst.dao.InvnoMapper;
import org.itst.domain.Invno;
import org.itst.service.InvnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class InvnoServiceImpl implements InvnoService{
	@Autowired
	private InvnoMapper mapper;
	public Invno getInvnoByName(String name) {
		
		return mapper.getInvnoByName(name);
	}
}
