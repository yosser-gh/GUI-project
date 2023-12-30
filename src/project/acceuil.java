package project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class acceuil implements ActionListener {

	JFrame frame = new JFrame("acceuil");
	JButton b1 = new JButton("ADMIN");
	JButton b2 = new JButton("USER");
	acceuil(){
		b2.setSize(new Dimension(5, 20));
		b2.setBorderPainted(false);
		b2.setBounds(155, 106, 100, 27);
		b2.addActionListener(this);
		b2.setFont(new Font("null", Font.BOLD | Font.ITALIC, 16));
		b1.setFont(new Font("null", Font.BOLD | Font.ITALIC, 16));
		b1.setBorderPainted(false);
		b1.setBounds(23, 106, 100, 27);
		b1.addActionListener(this);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(80, 34, 111, 49);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(290,250);
		frame.setVisible(true);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== b1) {
			frame.dispose();
			admin a = new admin();
		}else if (e.getSource()==b2) {
			frame.dispose();
			user u = new user();
		}
		}
	}