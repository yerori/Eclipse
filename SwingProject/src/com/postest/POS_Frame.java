package com.postest;

import javax.swing.JFrame;

public class POS_Frame extends JFrame {
	public POS_Frame() {
		setTitle("예리cafe POS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new PosPanel());
		
		setSize(985,660);
		setVisible(true);
	}
}
