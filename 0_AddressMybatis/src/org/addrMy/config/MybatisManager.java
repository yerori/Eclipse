package org.addrMy.config;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisManager {
	//configration.xml�о���� -> IO��ü �̿��ؼ� -> mapper�� �����ؿ��°� �� ������ ����
	
				  //sql�о���� ���ؼ� sqlsessionfactory ��ü �ʿ�
	public static SqlSessionFactory sqlMapper; //lib�ٿ� -> maven���� mybatis �ļ� jar���� �ٿ� 
	static { //static : Ŭ�������� ���� ����
	  String resource = "org/addrMy/config/Config"
	  		+ "uration.xml";	
	  Reader reader;
	  				//���� : resource -> reader -> mapper�� �ҷ���
	  	try {
	  		reader = Resources.getResourceAsReader(resource);
	  		sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		
	  	}catch (IOException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
		}	
	}
	
	public static SqlSessionFactory getSqlMapper() {
		return sqlMapper; //���� ����
	}
}
