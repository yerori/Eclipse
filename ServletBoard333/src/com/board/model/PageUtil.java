package com.board.model;

public class PageUtil {
	private int currentPage;
	private int endPage;
	private int startPage;
	private int totPage;
	private int pageBlock;
	private String field;
	private String word;
	
	public String getField() {
		return field == null ? "" : field.trim();
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getWord() {
		return word == null ? "" : word.trim();
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
}
