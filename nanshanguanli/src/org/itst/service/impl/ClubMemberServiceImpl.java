package org.itst.service.impl;

import java.util.List;

import org.itst.dao.ClubMemberMapper;
import org.itst.domain.Club;
import org.itst.domain.ClubMember;
import org.itst.service.ClubMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClubMemberServiceImpl implements ClubMemberService {
	@Autowired
	private ClubMemberMapper mapper;
	public void addClubMember(ClubMember student) {
		mapper.addClubMember(student);
	}

	public ClubMember getClubMemberById(String id) {
		return mapper.getClubMemberById(id);
	}

	public void updateClubMember(ClubMember student) {
		mapper.updateClubMember(student);
	}

	public String getClubMembersJsonByPage(int pageSize, int pageNow) {
		List<ClubMember> members = mapper.getClubMembersByPage(pageSize*(pageNow-1),pageSize*pageNow);
		String s = "";
		for (ClubMember m : members) {
			s += "{\"name\":\"" + m.getName()
			+ "\",\"stuId\":\"" + m.getStuId()
			+ "\",\"sex\":\"" + m.getSex()
			+ "\",\"fromAcademy\":\"" + m.getFromAcademy()
			+ "\",\"fromClubName\":\"" + m.getFromClubName()
			+ "\",\"phoneNumber\":\"" + m.getPhoneNumber()
			+ "\"},";
		}
		if (!s.equals("")) {
			s = s.substring(0, s.length() - 1);
		}
		return "{\"total\":" + mapper.getClubMembersCount() + ",\"rows\":[" + s + "]}";
	}

	public String getClubMembersJsonBykeyWord(String key,
			int pageSize, int pageNow) {
		List<ClubMember> members = mapper.getClubStudentsBykeyWord(key,pageSize*(pageNow-1),pageSize*pageNow);
		String s = "";
		for (ClubMember m : members) {
			s += "{\"name\":\"" + m.getName()
			+ "\",\"stuId\":\"" + m.getStuId()
			+ "\",\"sex\":\"" + m.getSex()
			+ "\",\"fromAcademy\":\"" + m.getFromAcademy()
			+ "\",\"fromClubName\":\"" + m.getFromClubName()
			+ "\",\"phoneNumber\":\"" + m.getPhoneNumber()
			+ "\"},";
		}
		if (!s.equals("")) {
			s = s.substring(0, s.length() - 1);
		}
		return "{\"total\":" + mapper.getKeySearchCount(key) + ",\"rows\":[" + s + "]}";
	}

	public void deleteClubMemberById(String id) {
		mapper.deleteClubMemberById(id);
	}

}
