package com.postest;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PosPanel extends JPanel {
	JButton[] MBtn = new JButton[16];
	String[] menu = {
			"아메리카노","ICE아메리카노","카페라떼","ICE카페라떼","카페모카",
			"카푸치노","바닐라라떼","ICE바닐라라떼","녹차라떼","아이스티",
			"자몽에이드","청포도에이드","딸기스무디","블루베리스무디","레몬티","자몽티"};
	int[] price = {
			3500,4000,4500,5000,5000,5000,
			5000,5500,5500,5500,4000,
			5500,6000,5500,6000,5000,5000};
	
	JTextField tf =new JTextField(30);
	JButton[] SBtn = new JButton[4];
	String[] Str = {"쿠폰","선택취소","전체취소","결제"};
	String[] ColName = {"메뉴", "수량","가격"};
	String [][] Data;
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	
	class Screen extends JPanel{
		Screen(){
			setBackground(Color.CYAN);
			DefaultTableModel m =(DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("kopub돋움체", Font.BOLD, 15));
			add(new JScrollPane(table));
		}
	}
	
	class MenuBtn extends JPanel{
		MenuBtn(){
			setLayout(new GridLayout(6,3,3,3));
			setBackground(Color.white);
			for(int i=0;i<MBtn.length;i++) {
				MBtn[i]=new JButton(menu[i]);
				add(MBtn[i]);
			}		
		}
	}
	
	
	class StrBtn extends JPanel{
		StrBtn(){
			setLayout(new GridLayout(1,4,3,3));
			setBackground(Color.white);
			
			for(int i=0;i<Str.length;i++) {
				SBtn[i]=new JButton(Str[i]);
				add(SBtn[i]);
			}
		}
	}
	
	public PosPanel() {
		setLayout(null);
		setBackground(Color.WHITE);
		MenuBtn mbtn = new MenuBtn();
		StrBtn sbtn = new StrBtn();
		Screen sc = new Screen();
		
		// 금액란
		tf.setSize(450,70);
		tf.setLocation(50,480);
		add(tf);
		
		sc.setSize(500,500);
		sc.setLocation(25,20);
		add(sc);
		
		mbtn.setSize(400,430);
		mbtn.setLocation(530,480);
		add(sbtn);
		
		//메뉴추가
		for(int i=0; i<MBtn.length; i++) {
			final int index = i;
			MBtn[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)table.getModel();
					m.addRow(new Object[] {menu[index],count,price[index]});
					
				}				
			});
		}
		
		//쿠폰
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				table.setValueAt(0,  table.getSelectedRow(),2);				
			}			
		});	
			
		
		//선택 취소
		SBtn[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.removeRow(table.getSelectedRow());				
			}			
		});
			
		
		//전체 취소
		SBtn[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				tf.setText("");				
			}			
		});
		
		
		// 결제버튼
		SBtn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				int rowcount = table.getRowCount();
				int sum=0;
				for(int i=0; i<rowcount; i++) {
				}
				tf.setText("총 금액 : "+sum+"");		
				tf.setFont(new Font("kopub돋움체", Font.BOLD, 40));
			}			
		});
		
		
		
		
	}
}
