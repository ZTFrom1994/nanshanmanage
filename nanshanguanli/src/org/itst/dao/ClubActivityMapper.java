package org.itst.dao;

import java.util.List;

import org.itst.domain.ClubActivity;

public interface ClubActivityMapper {
	public ClubActivity getClubActivityById(String id);
	public List<ClubActivity> getClubActivitiesByPage(int start ,int end);
	public int getClubActivitiesCount();
	public int getKeySearchCount(String key);
	public List<ClubActivity> getClubActivityByKeyWord(String key, int start,int end);
	public void addClubActivity(ClubActivity clubActivity);
	public void updateClubActivity(ClubActivity clubActivity);
	public void deleteClubActivityById(String id);
	public List<String> getActivityForm();
	
}
