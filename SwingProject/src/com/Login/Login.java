package com.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JFrame f;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField text;
	private JButton button;
	private JPasswordField passwordField;
	private JPasswordField value;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setTitle("Login");
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getText());
		contentPane.add(getButton());
		contentPane.add(getPasswordField());
		contentPane.add(getValue());
				
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디 :");
			lblNewLabel.setFont(new Font("KoPub돋움체 Bold", Font.PLAIN, 15));
			lblNewLabel.setBounds(40, 52, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("비밀번호");
			lblNewLabel_1.setFont(new Font("KoPub돋움체 Bold", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(40, 116, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getText() {
		if (text == null) {
			text = new JTextField();
			text.setBounds(109, 49, 116, 21);
			text.setColumns(10);
		}
		return text;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("로그인");
			button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = "gu2144";
				String pw = "dpvkf2";
		
			if(id.equals(text.getText())&&pw.equals(value.getText())) {
				JOptionPane.showMessageDialog(null, "success");
						
			}else {
				JOptionPane.showMessageDialog(null, "fail");
					
			}
					
		}
	});
			button.setFont(new Font("KoPub돋움체 Bold", Font.PLAIN, 15));
			button.setBounds(88, 158, 100, 21);
		}
		return button;
	}
				/*	String data = "사용자 : "+text.getText();
					data += ", 비밀번호 : "+new String(value.getPassword());
					JOptionPane.showMessageDialog(f, data);
				}
			});
			button.setFont(new Font("KoPub돋움체 Bold", Font.PLAIN, 15));
			button.setBounds(88, 158, 100, 21);*/
	
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(109, 49, 116, 21);
		}
		return passwordField;
	}
	private JPasswordField getValue() {
		if (value == null) {
			value = new JPasswordField();
			value.setBounds(109, 113, 116, 21);
		}
		return value;
	}
	
	
	
	
}
