package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class admin implements ActionListener {
	JFrame frmAdmin = new JFrame("FORM ");
	JLabel speciality = new JLabel("Speciality");
	JLabel club = new JLabel("Club");
	JLabel list1 = new JLabel();
	JLabel list2 = new JLabel();
	JComboBox<String> box1 ;
	JComboBox<String> box2 ;
	JTable table2 = new JTable();
	JTable table1;
	String[] columnNames = {"Name", "Age","speciality","Club"}; 
	
	admin(){
		String[] spec = {"IM","BDAD","MIME","CM","AV","ING"};
		String[] clubs = {"CRI","IMC","J2I","ORENDA","SPARK","BOUBLI","TUNIVISION","RADIO","LOG"};
		box1 = new JComboBox<String>(spec);
		box1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		box1.setBounds(137, 34, 72, 26);
		box2 = new JComboBox<String>(clubs);
		box2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		box2.setBounds(361, 35, 80, 25);
		box1.addActionListener(this);
		box2.addActionListener(this);
		frmAdmin.getContentPane().setLayout(null);
		speciality.setFont(new Font("Tahoma", Font.BOLD, 15));
		speciality.setBounds(24, 34, 80, 26);
		frmAdmin.getContentPane().add(speciality);
		frmAdmin.getContentPane().add(box1);
		list1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list1.setVerticalAlignment(SwingConstants.TOP);
		list1.setBounds(24, 82, 189, 26);
		list1.setText("student list by speciality :");
		frmAdmin.getContentPane().add(list1);
		club.setFont(new Font("Tahoma", Font.BOLD, 15));
		club.setBounds(285, 30, 66, 35);
		frmAdmin.getContentPane().add(club);
		frmAdmin.getContentPane().add(box2);
		list2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list2.setVerticalAlignment(SwingConstants.TOP);
		list2.setText("student list by club :");
		list2.setBounds(285, 82, 145, 26);
		frmAdmin.getContentPane().add(list2);
		table2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		table2.setBackground(new Color(255, 245, 238));
		table2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table2.setModel(new DefaultTableModel(
			new Object[][] {
				{"Name", "Age", "Speciality", "Club"},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table2.setBounds(274, 118, 217, 135);
		
		frmAdmin.getContentPane().add(table2);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Name", "Age", "speciality", "Club"},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		table1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table1.setBackground(new Color(255, 245, 238));
		table1.setBounds(24, 118, 217, 135);
		frmAdmin.getContentPane().add(table1);
		frmAdmin.setTitle("ADMIN");
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.setSize(526,325);
		frmAdmin.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== box1) {
			try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/mydb", "root", "root"
	            );
	            Statement statement = connection.createStatement();
	            String s = (String) box1.getSelectedItem();
	            ResultSet resultSet = statement.executeQuery("select * from student where speciality ='"+s+"'");
	         
	            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	            table1.setModel(model);
	            model.addRow(columnNames);
	            while(resultSet.next()) {
	            	String n,a,cl;
	            	n= resultSet.getString("name");
	            	a= resultSet.getString("age");
	            	cl= resultSet.getString("club");
	            	String[] row={n,a,s,cl};
	            	model.addRow(row);
	            	}
	            
	            connection.close();
	        } catch (Exception x) {
	            System.out.println(x);
	        }

		}else if (e.getSource()==box2) {
			try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/mydb", "root", "root"
	            );
	            Statement statement = connection.createStatement();
	            String c = (String) box2.getSelectedItem();
	            ResultSet resultSet = statement.executeQuery("select * from student where club ='"+c+"'"); 
	            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	            table2.setModel(model);
	            model.addRow(columnNames);
	            while(resultSet.next()) {
	            	String n,a,sp;
	            	n= resultSet.getString("name");
	            	a= resultSet.getString("age");
	            	sp= resultSet.getString("speciality");
	            	String[] row={n,a,sp,c};
	            	model.addRow(row);
	            	
	   
	            	}
	            
	            connection.close();
	        } catch (Exception x) {
	            System.out.println(x);
	        }
			
		}
		
	}
}
