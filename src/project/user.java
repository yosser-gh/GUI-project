package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.Font;

public class user implements ActionListener {
	JFrame frame = new JFrame("FORM ");
	JLabel name = new JLabel("Name: ");
	JLabel age = new JLabel("Age: ");
	JLabel speciality = new JLabel("Speciality");
	JLabel club = new JLabel("Club");
	JTextField t1 = new JTextField(20);
	JTextField t2 = new JTextField(20);
	JComboBox<String> box1 ;
	JComboBox<String> box2 ;
	JButton b1 = new JButton("subscribe");
	JButton b2 = new JButton("Reset");
	
	
	user(){
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.setBounds(54, 187, 91, 34);
		b2.setFont(new Font("Tahoma", Font.BOLD, 13));
		b2.setBounds(176, 187, 91, 34);
		b2.setFocusable(false);
		b1.addActionListener(this);
		b2.addActionListener(this);
		String[] spec = {"IM","BDAD","MIME","CM","AV","ING","MASTER"};
		String[] clubs = {"CRI","IMC","J2I","ORENDA","SPARK","BOUBLI","TUNIVISION","RADIO","LOG"};
		box1 = new JComboBox<String>(spec);
		box1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		box1.setBounds(101, 105, 80, 19);
		box2 = new JComboBox<String>(clubs);
		box2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		box2.setBounds(101, 141, 80, 19);
		frame.getContentPane().setLayout(null);
		name.setFont(new Font("Tahoma", Font.BOLD, 12));
		name.setBounds(27, 27, 49, 16);
		
		frame.getContentPane().add(name);
		t1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		t1.setBounds(101, 24, 166, 19);
		frame.getContentPane().add(t1);
		age.setFont(new Font("Tahoma", Font.BOLD, 12));
		age.setBounds(27, 69, 40, 13);
		frame.getContentPane().add(age);
		t2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		t2.setBounds(101, 66, 166, 19);
		frame.getContentPane().add(t2);
		speciality.setFont(new Font("Tahoma", Font.BOLD, 12));
		speciality.setBounds(27, 108, 64, 13);
		frame.getContentPane().add(speciality);
		frame.getContentPane().add(box1);
		club.setFont(new Font("Tahoma", Font.BOLD, 12));
		club.setBounds(27, 144, 35, 13);
		frame.getContentPane().add(club);
		frame.getContentPane().add(box2);
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(335,308);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== b2) {
			t1.setText("");
			t2.setText("");
			box1.setSelectedIndex(0);
			box2.setSelectedIndex(0);
			
		}else if (e.getSource()==b1) {
			try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/mydb", "root", "root"
	            );
	            Statement statement = connection.createStatement();
	            String n = t1.getText();
	            String a = t2.getText();
	            String s = (String) box1.getSelectedItem();
	            String c = (String) box2.getSelectedItem();
	            int resultSet = statement.executeUpdate("insert into student(name,age,speciality,club)values('"+n+"','"+a+"','"+s+"','"+c+"')");
	            if(resultSet !=0) {
	            	JOptionPane.showMessageDialog(null,"sign up succesful...");
	            }
	            else {
	            	JOptionPane.showMessageDialog(null,"something is wrong...");
	            }
	            connection.close();
	        } catch (Exception x) {
	            System.out.println(x);
	        }
			
		}
		
	}
	

}
