package com.friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FriendDAO {

	
	//ì¶”ê?
	public void friendInsert(Friend f);
		
	//? „ì²´ë³´ê¸?
	public ArrayList<Friend>friendView();
	//?ƒ?„¸ë³´ê¸°
	public Friend friendDetail(int num);
	//?ˆ˜? •?•˜ê¸?
	public void friendUpdate(Friend f);
	//?‚­? œ?•˜ê¸?
	public void friendDelete(int num);
	//ê²??ƒ‰?•˜ê¸?
	public ArrayList<Friend>friendSearch(String key, String word);
	
}
