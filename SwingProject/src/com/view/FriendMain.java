package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Friend;
import com.model.FriendDAOImpl;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FriendMain extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tfName;
	private JTextField tfPhone;
	private JTextField tfAddr;
	private JButton btnView;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JSplitPane splitPane_1;
	private JScrollPane scrollPane;
	private JTextArea ta;
	private JPanel panel_1;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JLabel lblNewLabel_5;
	private JTextField tfBirth;
	private JTextField tfNum;
	FriendDAOImpl dao = new FriendDAOImpl();
	private JComboBox jcb;
	//JTextField[] tf = new JTextField[6];
	
	private void clearText() {
		tfName.setText("");
		tfPhone.setText("");
		tfAddr.setText("");
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendMain frame = new FriendMain();
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
	
	
	
	public FriendMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(450);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblNewLabel_1());
			panel.add(getLblNewLabel_2());
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_3());
			panel.add(getTfName());
			panel.add(getTfPhone());
			panel.add(getTfAddr());
			panel.add(getBtnView());
			panel.add(getBtnInsert());
			panel.add(getBtnUpdate());
			panel.add(getBtnDelete());
			panel.add(getLblNewLabel_5());
			panel.add(getTfBirth());
			panel.add(getTfNum());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 13));
			lblNewLabel.setBounds(32, 30, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("생일");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 13));
			lblNewLabel_1.setBounds(32, 96, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("전화번호");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 13));
			lblNewLabel_2.setBounds(32, 170, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("주소");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 13));
			lblNewLabel_3.setBounds(32, 246, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(146, 30, 152, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBounds(146, 167, 152, 21);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}
	
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setBounds(146, 243, 188, 21);
			tfAddr.setColumns(10);
		}
		return tfAddr;
	}
	
	
	
	
	
	// 전체보기 
	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("전체보기");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ta.setText("");
					ArrayList<Friend> arr = dao.friendView();
					for(Friend f:arr) {
						ta.append("번호 : "+f.getNum()+"\n");
						ta.append("이름 : "+f.getName()+"\n");
						ta.append("생일 : "+f.getBirth()+"\n");
						ta.append("전화번호 : "+f.getPhone()+"\n");
						ta.append("주소 : "+f.getAddr()+"\n\n");
					}					
				}
			});
			btnView.setActionCommand("전체보기");
			btnView.setBounds(32, 311, 97, 23);
		}
		return btnView;
	}
	
	//추가 
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("친구등록");
			btnInsert.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent arg0) {
					Friend f = new Friend();
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setPhone(tfPhone.getText());
					f.setAddr(tfAddr.getText());
					dao.friendInsert(f);
					btnView.doClick();
					clearText();
				}
			});
			
			btnInsert.setBounds(200, 311, 97, 23);
		}
		return btnInsert;
	}
	
	// 수정
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정하기");
		
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Friend f = new Friend();
					f.setNum(Integer.parseInt(tfNum.getText()));
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setPhone(tfPhone.getText());
					f.setAddr(tfAddr.getText());
					dao.friendUpdate(f);
					btnView.doClick();
					clearText();
				}
			});
			
			btnUpdate.setBounds(32, 393, 97, 23);
		}
		return btnUpdate;
	}
	
	//  삭제
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제하기");
			btnDelete.addActionListener(new ActionListener() {
				
		public void actionPerformed(ActionEvent e) {
			int num = Integer.parseInt(tfNum.getText());		
			dao.friendDelete(num);
			btnView.doClick();		
			clearText();
			}
		});

			btnDelete.setBounds(200, 393, 97, 23);
		}
		return btnDelete;
	}
	
	
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setDividerSize(2);
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setDividerLocation(300);
		}
		return splitPane_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTa());
		}
		return scrollPane;
	}
	private JTextArea getTa() {
		if (ta == null) {
			ta = new JTextArea();
			ta.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					int num=Integer.parseInt(ta.getSelectedText().trim());
					
					Friend f =dao.friendDetail(num);
					tfNum.setText(num+"");
					tfName.setText(f.getName());
					tfBirth.setText(f.getBirth());
					tfPhone.setText(f.getPhone());
					tfAddr.setText(f.getAddr());
				}
			});
		}
		return ta;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getTfSearch());
			panel_1.add(getBtnSearch());
			panel_1.add(getJcb());
		}
		return panel_1;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(158, 62, 137, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	
	// ★ 검색 
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				int idx = jcb.getSelectedIndex();
				String key="";
				if(idx==1) {
					key="name";
				}else if(idx==2) {
					key="addr";
			}			
			ArrayList<Friend> arr = dao.friendSearch(key, tfSearch.getText());
			for(Friend f:arr) {
				ta.append("번호 : "+f.getNum()+"\n");
				ta.append("이름 : "+f.getName()+"\n");
				ta.append("생일 : "+f.getBirth()+"\n");
				ta.append("전화번호 : "+f.getPhone()+"\n");
				ta.append("주소 : "+f.getAddr()+"\n\n");
			}	
		}
	});
			btnSearch.setBounds(307, 61, 97, 23);
		}
		return btnSearch;
	}
	
	
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("번호");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_5.setBounds(32, 355, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setColumns(10);
			tfBirth.setBounds(146, 94, 152, 21);
		}
		return tfBirth;
	}
	private JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.setColumns(10);
			tfNum.setBounds(146, 353, 152, 21);
		}
		return tfNum;
	}
	private JComboBox getJcb() {
		if (jcb == null) {
			jcb = new JComboBox();
			jcb.setModel(new DefaultComboBoxModel(new String[] {"선택..","이름","주소"}));
			jcb.setBounds(47, 62, 97, 21);
		}
		return jcb;
	}
}
