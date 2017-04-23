package org.itst.service.impl;

import org.itst.dao.SaltMapper;
import org.itst.domain.Salt;
import org.itst.service.SaltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaltServiceImpl implements SaltService {
	@Autowired
	private SaltMapper mapper;
	
	public Salt getSalt(int id) {
		return mapper.getSalt(id);
	}

	public void addSalt(Salt salt) {
		mapper.addSalt(salt);
	}
	
}
