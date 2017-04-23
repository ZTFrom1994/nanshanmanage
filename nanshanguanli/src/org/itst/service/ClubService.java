package org.itst.service;

import org.itst.domain.Club;

public interface ClubService {
	public String getClubJsonByPage(int pageSize,int pageNow); 
	public int getClubCount();
	public Club getClubById(String id);
	public String getClubJsonByKeyWord(String key,int pageSize,int pageNow);
	public void addClub(Club club);
	public void updateClub(Club club);
	public void deleteClubById(String id);
}
