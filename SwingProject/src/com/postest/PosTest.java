package com.postest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.Color;

public class PosTest extends JFrame implements ItemListener  {

	private JPanel contentPane;
	private JButton btnNewButton_6_1;
	private JButton btnNewButton_6_1_1;
	private JButton btnNewButton_6_1_2;
	private JButton btnNewButton_6_1_3;
	
	private JTextField textField;
	String[] menu = {
			"아메리카노","ICE아메리카노","카페라떼","ICE카페라떼",
			"카페모카","카푸치노","바닐라라떼","ICE바닐라라떼",
			"녹차라떼","아이스티","자몽에이드","청포도에이드",
			"딸기스무디","블루베리스무디","레몬티","유자차"};
	int[] price = {
			1500,1800,2500,2500,
			3000,3000,3500,3500,
			3500,2500,3500,3500,
			4000,4000,3000,3000};
	private JPanel p1;
	private JCheckBox cb1;
	private JCheckBox cb2;
	private JPanel panel_1;
	private JTable table;
	private JPanel panel;
	private JTable table_1;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PosTest frame = new PosTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PosTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton_6_1());
		contentPane.add(getBtnNewButton_6_1_1());
		contentPane.add(getBtnNewButton_6_1_2());
		contentPane.add(getBtnNewButton_6_1_3());
		contentPane.add(getTextField());
		contentPane.add(getP1());
		contentPane.add(getPanel_1());
		contentPane.add(getPanel());
	}
	private JButton getBtnNewButton_6_1() {
		if (btnNewButton_6_1 == null) {
			btnNewButton_6_1 = new JButton("쿠폰");
			btnNewButton_6_1.setBackground(new Color(255, 228, 225));
			btnNewButton_6_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_6_1.setBounds(293, 428, 87, 36);
		}
		return btnNewButton_6_1;
	}
	private JButton getBtnNewButton_6_1_1() {
		if (btnNewButton_6_1_1 == null) {
			btnNewButton_6_1_1 = new JButton("선택취소");
			btnNewButton_6_1_1.setBounds(382, 428, 87, 36);
		}
		return btnNewButton_6_1_1;
	}
	private JButton getBtnNewButton_6_1_2() {
		if (btnNewButton_6_1_2 == null) {
			btnNewButton_6_1_2 = new JButton("전체취소");
			btnNewButton_6_1_2.setBounds(470, 428, 87, 36);
			btnNewButton_6_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
		}
		return btnNewButton_6_1_2;
	}
	private JButton getBtnNewButton_6_1_3() {
		if (btnNewButton_6_1_3 == null) {
			btnNewButton_6_1_3 = new JButton("결제");
			btnNewButton_6_1_3.setBounds(558, 428, 87, 36);
		}
		return btnNewButton_6_1_3;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(28, 412, 224, 37);
			textField.setColumns(10);
		}
		return textField;
	}
	private JPanel getP1() {
		if (p1 == null) {
			p1 = new JPanel();
			p1.setBounds(293, 369, 372, 49);
			p1.setLayout(new GridLayout(0, 2, 0, 0));
			p1.add(getCb1());
			p1.add(getCb2());
		}
		return p1;
	}
	private JCheckBox getCb1() {
		if (cb1 == null) {
			cb1 = new JCheckBox("휘핑 추가");
			
		}
		return cb1;
	}
	private JCheckBox getCb2() {
		if (cb2 == null) {
			cb2 = new JCheckBox("시럽 추가");
		}
		return cb2;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(22, 20, 230, 371);
			panel_1.setLayout(new GridLayout(1, 0, 0, 0));
			panel_1.add(getTable_1());
		}
		return panel_1;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox cb = (JCheckBox) e.getSource();

		if(cb1.isSelected()) {
			JButton MBtn = (JButton)e.getSource();
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			//m.addRow(new Object[]{menu[index],count,price[index]});
			m.addRow(new Object[] {cb1,"","500원"});
			
		}else if(cb1.isSelected()) {
			JButton MBtn = (JButton)e.getSource();
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			m.addRow(new Object[] {cb2,"","500원"});
		}
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(293, 20, 372, 339);
			panel.add(getBtnNewButton());
			panel.add(getTable());
		}
		return panel;
	}
	private JTable getTable_1() {
		if (table_1 == null) {
			table_1 = new JTable();
		}
		return table_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton.setBackground(Color.PINK);
		}
		return btnNewButton;
	}
}
