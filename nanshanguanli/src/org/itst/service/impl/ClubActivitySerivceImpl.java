package org.itst.service.impl;


import java.sql.SQLException;
import java.util.List;

import org.itst.dao.ClubActivityMapper;
import org.itst.domain.Club;
import org.itst.domain.ClubActivity;
import org.itst.service.ClubActivityService;
import org.itst.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClubActivitySerivceImpl implements ClubActivityService {
	@Autowired
	private ClubActivityMapper mapper;

	public void addClubActivity(ClubActivity clubActivity) {
		mapper.addClubActivity(clubActivity);
	}

	public void deleteClubActivityById(String id) {
		mapper.deleteClubActivityById(id);
	}


	public int getClubActivitiesCount() {
		return mapper.getClubActivitiesCount();
	}

	public ClubActivity getClubActivityById(String id) {
		return mapper.getClubActivityById(id);
	}


	public int getKeySearchCount(String key) {
		return mapper.getKeySearchCount(key);
	}

	public void updateClubActivity(ClubActivity clubActivity) {
		mapper.updateClubActivity(clubActivity);
	}

	public String getClubActivitiesJsonByPage(int pageSize, int pageNow) {
		System.out.println("done!");
		List<ClubActivity> activities = mapper.getClubActivitiesByPage(pageSize * (pageNow - 1), pageSize*pageNow);
		String res = "";
		for(ClubActivity ca:activities){
			res += "{\"id\":\"" + ca.getActivityId()
			+ "\",\"name\":\"" + ca.getActivityName()
			+ "\",\"starttime\":\""
			+ ca.getActivityStartTime()
			+ "\",\"endtime\":\"" + ca.getActivityEndTime()
			+ "\",\"fromclub\":\""
			+ ca.getActivityFromClub()
			+ "\",\"leadername\":\""
			+ ca.getActivityLeaderName()
			+ "\",\"holdplace\":\""
			+ ca.getActivityHoldPlace()
			+ "\",\"form\":\"" + ca.getActivityForm()
			+ "\",\"introduction\":\""
			+ ca.getActivityIntroduction()
			+ "\",\"contact\":\"" 
			+ ca.getActivityContact()
			+ "\",\"borrowed\":\""
			+ ca.getIsBorrowed() + "\"},";
		}
			if (!res.equals("")) {
				res = res.substring(0, res.length() - 1);
			}
		return "{\"total\":" + mapper.getClubActivitiesCount() + ",\"rows\":[" + res + "]}";
	}

	public String getClubActivityJsonByKeyWord(String key, int pageSize,
			int pageNow) {
		List<ClubActivity> activities = mapper.getClubActivityByKeyWord(key, pageSize * (pageNow - 1), pageSize*pageNow);
		String res = "";
		for(ClubActivity ca:activities){
			res += "{\"id\":\"" + ca.getActivityId()
			+ "\",\"name\":\"" + ca.getActivityName()
			+ "\",\"starttime\":\""
			+ ca.getActivityStartTime()
			+ "\",\"endtime\":\"" + ca.getActivityEndTime()
			+ "\",\"fromclub\":\""
			+ ca.getActivityFromClub()
			+ "\",\"leadername\":\""
			+ ca.getActivityLeaderName()
			+ "\",\"holdplace\":\""
			+ ca.getActivityHoldPlace()
			+ "\",\"form\":\"" + ca.getActivityForm()
			+ "\",\"introduction\":\""
			+ ca.getActivityIntroduction()
			+ "\",\"contact\":\"" 
			+ ca.getActivityContact()
			+ "\",\"borrowed\":\""
			+ ca.getIsBorrowed() + "\"},";
		}
			if (!res.equals("")) {
				res = res.substring(0, res.length() - 1);
			}
		return "{\"total\":" + mapper.getKeySearchCount(key) + ",\"rows\":[" + res + "]}";
	}

	public String getActivityFormJson() {
		List<String> forms = mapper.getActivityForm();
		String sform = "";
			for(int i = 0;i < forms.size();i++){
				sform += "{\"id\":\"" + i
						+ "\",\"text\":\"" + forms.get(i)
						+ "\"},";
			}
			if (!sform.equals("")) {
				sform = sform.substring(0, sform.length() - 1);
			}
		return "[" + sform + "]";
	}
}
