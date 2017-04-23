package org.itst.service;


import org.itst.domain.CouncilMember;

public interface CouncilMemberService {
	public CouncilMember getCouncilMemberById(String id);
	public String getCouncilMembersJsonByPage(int pageSize,int pageNow);
	public String getCouncilMemberByKeyWord(String key,int pageSize,int pageNow);
	public void addCouncilMember(CouncilMember councilMember);
	public void updateCouncilMember(CouncilMember councilMember);
	public void deleteCouncilMemberById(String id);
}
