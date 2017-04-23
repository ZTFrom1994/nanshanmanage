package org.itst.dao;

import org.itst.domain.Salt;

public interface SaltMapper {
	public Salt getSalt(int id);
	public void addSalt(Salt salt);
	public void deleteSaltById(String id);
}
