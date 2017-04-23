package org.itst.service;

import org.itst.domain.Salt;

public interface SaltService {
	public Salt getSalt(int id);
	public void addSalt(Salt salt);
}
