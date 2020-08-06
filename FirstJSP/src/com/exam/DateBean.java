package com.exam;

import java.util.Calendar;

public class DateBean {
	Calendar ca = Calendar.getInstance();
	String[] arr = {"��","��","ȭ","��","��","��","��"};
	
	public String getToday() {
		String str=ca.get(Calendar.YEAR)+"�� ";
		str+=ca.get(Calendar.MONTH)+1+"�� ";
		str+=ca.get(Calendar.DATE)+"�� ";
		str+=arr[ca.get(Calendar.DAY_OF_WEEK)-1]+"����";
		return str;		
	}
	
	public String getDay() {
		StringBuilder sb = new StringBuilder();
		sb.append(ca.get(Calendar.YEAR)+"�� ");
		sb.append(ca.get(Calendar.MONTH)+"�� ");
		sb.append(ca.get(Calendar.DATE)+"�� ");
		sb.append(arr[ca.get(Calendar.DAY_OF_WEEK)-1]+"����");
		return sb.toString();		
	}
	
	
	
}
