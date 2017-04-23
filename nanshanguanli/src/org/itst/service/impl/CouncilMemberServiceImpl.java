package org.itst.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.itst.dao.CouncilMemberMapper;
import org.itst.domain.CouncilMember;
import org.itst.service.CouncilMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CouncilMemberServiceImpl implements CouncilMemberService {
	@Autowired
	private CouncilMemberMapper mapper;
	
	public void addCouncilMember(CouncilMember councilMember) {
		mapper.addCouncilMember(councilMember);
	}

	public void deleteCouncilMemberById(String id) {
		mapper.deleteCouncilMemberById(id);
	}

	public CouncilMember getCouncilMemberById(String id) {
		return mapper.getCouncilMemberById(id);
	}

	public String getCouncilMemberByKeyWord(String key, int pageSize,
			int pageNow) {
		List<CouncilMember> members = mapper.getCouncilMemberByKeyWord(key,pageSize*(pageNow-1),pageSize*pageNow);
		String res = "";
		for(CouncilMember c:members){
			res += "{\"name\":\"" + c.getName()
					+ "\",\"stuId\":\"" + c.getStuId()
					+ "\",\"fromAcademy\":\""
					+ c.getFromAcademy()
					+ "\",\"fromDepartment\":\""
					+ c.getDepartmentName()
					+ "\",\"position\":\""
					+ c.getPositionName()
					+ "\",\"phoneNumber\":\""
					+ c.getPhoneNumer() + "\",\"sex\":\""
					+ c.getSex() + "\"},";
		}
		if (!res.equals("")) {
			res = res.substring(0, res.length() - 1);
		}
		return "{\"total\":" + mapper.getKeySearchCount(key) + ",\"rows\":[" + res + "]}";
	}

	public String getCouncilMembersJsonByPage(int pageSize, int pageNow) {
		List<CouncilMember> members = mapper.getCouncilMembersByPage(pageSize*(pageNow-1),pageSize*pageNow);
		String res = "";
		for(CouncilMember c:members){
			res += "{\"name\":\"" + c.getName()
					+ "\",\"stuId\":\"" + c.getStuId()
					+ "\",\"fromAcademy\":\""
					+ c.getFromAcademy()
					+ "\",\"fromDepartment\":\""
					+ c.getDepartmentName()
					+ "\",\"position\":\""
					+ c.getPositionName()
					+ "\",\"phoneNumber\":\""
					+ c.getPhoneNumer() + "\",\"sex\":\""
					+ c.getSex() + "\"},";
		}
		if (!res.equals("")) {
			res = res.substring(0, res.length() - 1);
		}
		return "{\"total\":" + mapper.getCouncilMembersCount() + ",\"rows\":[" + res + "]}";
	}

	public void updateCouncilMember(CouncilMember councilMember) {
		mapper.updateCouncilMember(councilMember);
	}

}
