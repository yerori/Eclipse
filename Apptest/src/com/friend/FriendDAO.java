package com.friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FriendDAO {

	
	//추�?
	public void friendInsert(Friend f);
		
	//?��체보�?
	public ArrayList<Friend>friendView();
	//?��?��보기
	public Friend friendDetail(int num);
	//?��?��?���?
	public void friendUpdate(Friend f);
	//?��?��?���?
	public void friendDelete(int num);
	//�??��?���?
	public ArrayList<Friend>friendSearch(String key, String word);
	
}
