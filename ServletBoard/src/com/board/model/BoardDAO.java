package com.board.model;

import java.util.ArrayList;

public interface BoardDAO {
	
	//�߰�
	public void boardSave(BoardDTO board);
	
	
	//��ü����
	public ArrayList<BoardDTO> boardList();

	//�󼼺���
	public BoardDTO boardfindById(int num);
	
	//����
	public void boardUpdate(BoardDTO board);
	
	//����
	public void boardDelete(int num);


	
}
