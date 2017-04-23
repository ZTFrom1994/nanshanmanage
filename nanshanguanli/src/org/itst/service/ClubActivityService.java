package org.itst.service;

import java.util.List;

import org.itst.domain.ClubActivity;

public interface ClubActivityService {
	public ClubActivity getClubActivityById(String id);

	public String getClubActivitiesJsonByPage(int pageSize ,int pageNow);

	public int getClubActivitiesCount();

	public int getKeySearchCount(String key);

	public String getClubActivityJsonByKeyWord(String key,int pageSize ,int pageNow);

	public void addClubActivity(ClubActivity clubActivity);

	public void updateClubActivity(ClubActivity clubActivity);

	public void deleteClubActivityById(String id);
	
	public String getActivityFormJson();
}
