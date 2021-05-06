import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Icon;

public class Database extends javax.swing.JFrame{

	protected static Database frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://127.0.0.1/3308";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Database ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//dated 14feb 2021 by Abhinash Rath
	Database(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(200,100,1100,621);
		Dimension min = new Dimension(1100,621);
		Image img = Toolkit.getDefaultToolkit().getImage(".\\Images\\background.jpg");
		
	      setContentPane(new JPanel() {
	         @Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img, 0, 0,getWidth(),getHeight(),this);
	         }
	      })
	      ;
	      setMinimumSize(min);
        pack();
         
         JLabel createdatabase = new javax.swing.JLabel();
         createdatabase.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); 
         createdatabase.setForeground(new java.awt.Color(0,0,0));
         createdatabase.setText("Database");
         
         ImageIcon icon_database =  new ImageIcon(".\\Images\\database.png");
         
         ImageIcon icon_resetdatabase =  new ImageIcon(".\\Images\\resetdatabase.png");
         
         JLabel database_image = new JLabel(icon_database);
         JLabel reset_image = new JLabel(icon_resetdatabase);
         
         JButton create_database = new JButton("Create Database");
        
         create_database.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					createdatabase();
					
					
				}
			});
         
         JButton main_menu = new JButton("Main Menu");
         main_menu.setIcon(new ImageIcon(".\\Images\\mainmenu.png"));
         main_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Admin.main(new String[]{});
				frame.dispose();
			}});
         
//dated 14feb 2021 by Abhinash Rath
         
         JButton reset_database = new JButton("Reset Database");
         reset_database.addActionListener(new ActionListener() {
     				public void actionPerformed(ActionEvent e) {
     				
     					resetdatabase();
     					
     					
     				}
     			});
		//dated 14feb 2021 by Abhinash Rath
		
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         layout.setHorizontalGroup(
         	layout.createParallelGroup(Alignment.TRAILING)
         		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
         			.addContainerGap()
         			.addComponent(main_menu)
         			.addGap(329)
         			.addComponent(createdatabase)
         			.addContainerGap(546, Short.MAX_VALUE))
         		.addGroup(layout.createSequentialGroup()
         			.addGap(217)
         			.addGroup(layout.createParallelGroup(Alignment.LEADING)
         				.addComponent(database_image, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
         				.addGroup(layout.createSequentialGroup()
         					.addGap(14)
         					.addComponent(create_database)))
         			.addPreferredGap(ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
         			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
         				.addComponent(reset_image, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
         				.addComponent(reset_database, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
         			.addGap(263))
         );
         layout.setVerticalGroup(
         	layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(layout.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(layout.createParallelGroup(Alignment.LEADING)
         				.addComponent(main_menu)
         				.addGroup(layout.createSequentialGroup()
         					.addComponent(createdatabase)
         					.addGap(51)
         					.addGroup(layout.createParallelGroup(Alignment.LEADING)
         						.addGroup(layout.createSequentialGroup()
         							.addComponent(database_image, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
         							.addGap(107)
         							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
         								.addComponent(create_database)
         								.addComponent(reset_database)))
         						.addComponent(reset_image, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))))
         			.addContainerGap(284, Short.MAX_VALUE))
         );
         getContentPane().setLayout(layout);
	}
	//creating database
	public void createdatabase() {
		//dated 14feb 2021 by Abhinash Rath

		   Connection conn = null;
		   Statement stmt = null;
		   try{

		      Class.forName("com.mysql.cj.jdbc.Driver");

		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      stmt = conn.createStatement();
		      
		      String sql = "CREATE DATABASE library";
		      stmt.executeUpdate(sql);
		      JOptionPane.showMessageDialog(Database.this, "Database has been created successfully!!!!","Message", JOptionPane.ERROR_MESSAGE);
		   }catch(SQLException se){
			   JOptionPane.showMessageDialog(Database.this, "Database already exists in system","Message", JOptionPane.ERROR_MESSAGE);
		      se.printStackTrace();
		   }catch(Exception e){

		      e.printStackTrace();
		   }finally{
		
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		  
	}
	//reseting database
	public void resetdatabase() {
		Connection conn = null;
		   Statement stmt = null;
		   try{

		      Class.forName("com.mysql.cj.jdbc.Driver");

		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      stmt = conn.createStatement();
		      String sql1 = "DROP DATABASE library";
		      stmt.executeUpdate(sql1);
		      
		      String sql2 = "CREATE DATABASE library";
		      stmt.executeUpdate(sql2);
		      JOptionPane.showMessageDialog(Database.this, "Database has been reset sucessfully","Message", JOptionPane.ERROR_MESSAGE);
		   }catch(SQLException se){
			   
		      se.printStackTrace();
		   }catch(Exception e){

		      e.printStackTrace();
		   }finally{
		
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}
	//dated 14feb 2021 by Abhinash Rath
}
