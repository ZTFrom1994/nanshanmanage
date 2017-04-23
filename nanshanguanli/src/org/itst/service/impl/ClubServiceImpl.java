package org.itst.service.impl;

import java.util.List;
import org.itst.dao.ClubMapper;
import org.itst.domain.Club;
import org.itst.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClubServiceImpl implements ClubService {
	@Autowired
	private ClubMapper mapper;
	
	public String getClubJsonByPage(int pageSize,int pageNow) {
		List<Club> clubs = mapper.getClubsByPage(pageSize*(pageNow-1),pageSize*pageNow);
		String s = "";
		for (Club c : clubs) {
			s += "{\"clubId\":\"" + c.getClubId()
			+ "\",\"clubName\":\"" + c.getClubName()
			+ "\",\"leaderName\":\"" + c.getStudent().getName()
			+ "\",\"clubBrief\":\"" + c.getClubBrief()
			+ "\",\"clubType\":\"" + c.getClubType()
			+ "\",\"leaderPhoneNum\":\"" + c.getStudent().getPhoneNumber()
			+ "\",\"leaderStuId\":\"" + c.getStudent().getStuId()
			+ "\",\"teacherName\":\"" + c.getTeacherName()
			+ "\"},";
		}
		if (!s.equals("")) {
			s = s.substring(0, s.length() - 1);
		}
		return "{\"total\":" + mapper.getClubCount() + ",\"rows\":[" + s + "]}";
	}

	public int getClubCount() {
		return 0;
	}

	public Club getClubById(String id) {
		return mapper.getClubById(id);
	}

	public String getClubJsonByKeyWord(String key ,int pageSize,int pageNow) {
		List<Club> clubs = mapper.getClubByKeyWord(key,pageSize*(pageNow-1),pageSize*pageNow);
		String s = "";
		for (Club c : clubs) {
			s += "{\"clubId\":\"" + c.getClubId()
			+ "\",\"clubName\":\"" + c.getClubName()
			+ "\",\"leaderName\":\"" + c.getStudent().getName()
			+ "\",\"clubBrief\":\"" + c.getClubBrief()
			+ "\",\"clubType\":\"" + c.getClubType()
			+ "\",\"leaderPhoneNum\":\"" + c.getStudent().getPhoneNumber()
			+ "\",\"leaderStuId\":\"" + c.getStudent().getStuId()
			+ "\",\"teacherName\":\"" + c.getTeacherName()
			+ "\"},";
		}
		if (!s.equals("")) {
			s = s.substring(0, s.length() - 1);
		}
		return "{\"total\":" + mapper.getKeySearchCount(key) + ",\"rows\":[" + s + "]}";
	}

	public void addClub(Club club) {
		mapper.addClub(club);
	}

	public void updateClub(Club club) {
		mapper.updateClub(club);
	}

	public void deleteClubById(String id) {
		mapper.deleteClubById(id);
	}
}
