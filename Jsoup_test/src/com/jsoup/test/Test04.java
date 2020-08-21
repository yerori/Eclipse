package com.jsoup.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test04 {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=%ED%99%98%EC%9C%A8").get();

			Elements table = doc.select("table.rate_table_info");
			Elements tr = table.select("tbody tr");
			
			
		for(int i=1; i<tr.size();i++) {
			String title = tr.get(i).select("th a").text();
			String price = tr.get(i).select("td").first().text(); //한 줄 내 여러개 td 중 하나만 뽑기
			System.out.println(title+" ==> "+price);
		}
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
