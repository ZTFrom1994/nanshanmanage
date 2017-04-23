package org.itst.dao;

import java.util.List;

import org.itst.domain.CouncilMember;

public interface CouncilMemberMapper {
	public CouncilMember getCouncilMemberById(String id);
	public List<CouncilMember> getCouncilMembersByPage(int start,int end);
	public int getCouncilMembersCount();
	public int getKeySearchCount(String key);
	public List<CouncilMember> getCouncilMemberByKeyWord(String key,int start,int end);
	public void addCouncilMember(CouncilMember councilMember);
	public void updateCouncilMember(CouncilMember councilMember);
	public void deleteCouncilMemberById(String id);
}
