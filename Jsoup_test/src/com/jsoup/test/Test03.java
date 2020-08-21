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
		//	Elements lottonum = doc.select("div.section_title h2");  //ȸ�� ��ȣ 
			Elements lottoNo = doc.select("#lottoDrwNo");//ȸ�� ��ȣ 
			
			Elements num_list=doc.select("div.prizeresult"); //�� ���� ��ȣ�� �������� �Ǵϱ� element�� selectFirst 
			Elements num = num_list.select("div.num span"); // div.num span�� ��� �ǰ�, span�� ��� ��.(div�� span���� �����ϴϱ�)
			
		for(int i=0; i<num.size();i++) {
			String number = num.get(i).text();
//			System.out.println(number);
		}
		
		for(int i=0; i<lottoNo.size();i++) {
			String lottoNum = lottoNo.get(i).text();
			System.out.println(lottoNum); //ȸ����ȣ
			System.out.println(num_list.get(i).select("span").text());
		}
		
		
//		System.out.println(num.select("span").text());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
