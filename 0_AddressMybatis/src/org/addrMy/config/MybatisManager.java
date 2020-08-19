package org.addrMy.config;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisManager {
	//configration.xml읽어오기 -> IO객체 이용해서 -> mapper를 리턴해오는게 이 파일의 목적
	
				  //sql읽어오기 위해서 sqlsessionfactory 객체 필요
	public static SqlSessionFactory sqlMapper; //lib다운 -> maven가서 mybatis 쳐서 jar파일 다운 
	static { //static : 클래스보다 먼저 생성
	  String resource = "org/addrMy/config/Config"
	  		+ "uration.xml";	
	  Reader reader;
	  				//순서 : resource -> reader -> mapper를 불러옴
	  	try {
	  		reader = Resources.getResourceAsReader(resource);
	  		sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		
	  	}catch (IOException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
		}	
	}
	
	public static SqlSessionFactory getSqlMapper() {
		return sqlMapper; //최종 목적
	}
}
