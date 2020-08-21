package com.jsoup.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test02 {
	public static void main(String[] args) {
	try {
		Document doc = Jsoup.connect("https://search.daum.net/search?nil_suggest=btn&w=tot&DA=SBC&q=%EC%86%90%ED%9D%A5%EB%AF%BC").get();
		Elements container = doc.select("div.type_thumb_s160 dl");
		Elements title =doc.select("div.type_thumb_s160 dl dt"); 
		Elements data =  doc.select("div.type_thumb_s160 dl dd");
		
		Elements articleContainer = doc.select("div.coll_cont");
		Elements a = articleContainer.select("div.coll_cont a");
		Elements p = articleContainer.select("div.coll_cont p");
		
		
		for(int i=0; i<container.size();i++) {
			String titleText = title.get(i).text();
			String dataText = data.get(i).text();
			System.out.println(titleText + " : "+dataText);
		}
		System.out.println("----------------------------");
		for(int i=0; i<articleContainer.size();i++) {
			String aText = a.get(i).text();
			String pText = p.get(i).text();
			System.out.println(aText + pText);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
}