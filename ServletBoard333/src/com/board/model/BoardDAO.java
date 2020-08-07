package com.board.model;

import java.util.ArrayList;

public interface BoardDAO {
	//�߰�
	public void boardSave(BoardDTO board);
	//��ü����
	public ArrayList<BoardDTO> boardList(String field, String word,int startRow, int endRow);
	//�󼼺���
	public BoardDTO boardfindById(int num);
	//����
	public void boardUpdate(BoardDTO board);
	//����
	public int boardDelete(int num);
	//����-�˻�x
	public int boardCount();
	//����-�˻�
	public int boardCount(String field, String word);

}