package org.itst.dao;

import java.util.List;

import org.itst.domain.ClubMember;

public interface ClubMemberMapper {
	public ClubMember getClubMemberById(String id);
	public void addClubMember(ClubMember student); 
	public void updateClubMember(ClubMember student);
	public List<ClubMember> getClubMembersByPage(int start,int end);
	public List<ClubMember> getClubStudentsBykeyWord(String key,int start,int end);
	public int getClubMembersCount();
	public void deleteClubMemberById(String id);
	public int getKeySearchCount(String key);
}
