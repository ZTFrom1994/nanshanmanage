package org.itst.dao;

import java.util.List;

import org.itst.domain.Club;

public interface ClubMapper {
	public Club getClubById(String id);
	public List<Club> getClubsByPage(int start,int end);
	public int getClubCount();
	public List<Club> getClubByKeyWord(String key,int start,int end);
	public void addClub(Club club);
	public void updateClub(Club club);
	public void deleteClubById(String id);
	public int getKeySearchCount(String key);
}
