package com.jsoup.test;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test01 {

	public static void main(String[] args) {
		try {							// 내가 접속하고자 하는 인터넷 주소
			Document doc = Jsoup.connect("https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&sq=&o=&q=%EC%98%81%ED%99%94").get();
							//jsoup : 페이지 소스 가져오는 기능
			//	System.out.println(doc);
			Elements movie_list = doc.select("ol.movie_list li");
			Elements titleContainer = movie_list.select("div.info_tit a"); 
			//	System.out.println(movie_list); //ol 내 li 정보만 출력
			//	System.out.println(titleContainer); //div 내 a태그
			
			Elements rateContainer = movie_list.select("em.rate");
		
			ArrayList<Movie> arr = new ArrayList<>();
		
		for(int i=0; i<titleContainer.size();i++) { //elements 갯수만큼 돌리되, 글자만 출력
			Movie movie = new Movie();
			String title = titleContainer.get(i).text();
			String rate = rateContainer.get(i).text();
			movie.setTitle(title);
			movie.setRate(rate);
			arr.add(movie);
			
		}
		for(Movie movie : arr) {
			System.out.println("제목 : "+movie.getTitle());
			System.out.println("평점 : "+movie.getRate());
		
		}
		System.out.println("------------------------");
		for(int i=0; i<rateContainer.size();i++) {
			System.out.println(rateContainer.get(i).text());
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
