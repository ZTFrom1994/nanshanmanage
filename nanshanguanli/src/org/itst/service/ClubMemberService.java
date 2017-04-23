package org.itst.service;

import org.itst.domain.ClubMember;

public interface ClubMemberService {
	public ClubMember getClubMemberById(String id);
	public void addClubMember(ClubMember student); 
	public void updateClubMember(ClubMember student);
	public String getClubMembersJsonByPage(int pageSize,int pageNow);
	public String getClubMembersJsonBykeyWord(String key,int pageSize,int pageNow);
	public void deleteClubMemberById(String id);
}
