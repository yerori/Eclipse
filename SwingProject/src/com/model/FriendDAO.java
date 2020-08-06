package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FriendDAO {

	
	//추가
	public void friendInsert(Friend f);
		
	//전체보기
	public ArrayList<Friend>friendView();
	//상세보기
	public Friend friendDetail(int num);
	//수정하기
	public void friendUpdate(Friend f);
	//삭제하기
	public void friendDelete(int num);
	//검색하기
	public ArrayList<Friend>friendSearch(String key, String word);
	
}
