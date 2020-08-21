package com.jsoup.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test03 {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://m.dhlottery.co.kr/common.do?method=main").get();
		//	Elements lottonum = doc.select("div.section_title h2");  //회차 번호 
			Elements lottoNo = doc.select("#lottoDrwNo");//회차 번호 
			
			Elements num_list=doc.select("div.prizeresult"); //한 개의 번호만 가져오면 되니까 element에 selectFirst 
			Elements num = num_list.select("div.num span"); // div.num span만 적어도 되고, span만 적어도 됨.(div내 span만이 존재하니까)
			
		for(int i=0; i<num.size();i++) {
			String number = num.get(i).text();
//			System.out.println(number);
		}
		
		for(int i=0; i<lottoNo.size();i++) {
			String lottoNum = lottoNo.get(i).text();
			System.out.println(lottoNum); //회차번호
			System.out.println(num_list.get(i).select("span").text());
		}
		
		
//		System.out.println(num.select("span").text());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
