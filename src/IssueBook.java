import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class IssueBook extends javax.swing.JFrame {

	protected static IssueBook frame;
	private JTextField bookId;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new IssueBook ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	IssueBook(){
		
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
        createdatabase.setText("Issue Book");
        
        ImageIcon icon_createdatabase =  new ImageIcon(".\\Images\\issuebook.png");
        
        JLabel lblNewLabel = new JLabel(icon_createdatabase);
        
        bookId = new JTextField();
        bookId.setColumns(10);
        
      
        
        JButton main_menu = new JButton("Main Menu");
        main_menu.setIcon(new ImageIcon(".\\Images\\mainmenu.png"));
        main_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Admin.main(new String[]{});
				frame.dispose();
			}});
        
        //creating jlabels and textfields
        JLabel bookid = new JLabel("Book Id");
        
        JLabel username = new JLabel("User Name");
        
        JLabel password = new JLabel("Password");
        
        textField = new JTextField();
        textField.setColumns(10);
        
        passwordField = new JPasswordField();
        
        
        JButton issue_book = new JButton("Issue Book");
        issue_book.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String bookcallno=bookid.getText();
				String username1=username.getText();
				String password1=String.valueOf(passwordField.getPassword());
			//validating if book and user exists
				if(IssueBooksql.checkBook2(bookcallno)) {
					JOptionPane.showMessageDialog(IssueBook.this,"Book already issued!");
				}
				else {
				if(Usersql.validate(username1,password1)) {
					
					if(IssueBooksql.checkBook(bookcallno)){
						
						String bookname =IssueBooksql.name(bookcallno);
						
						int i=IssueBooksql.save(bookcallno,bookname,username1);
						if(i>0){
							JOptionPane.showMessageDialog(IssueBook.this,"Book issued successfully!");
							
						}else{
							JOptionPane.showMessageDialog(IssueBook.this,"Sorry, unable to issue!");
						}//end of save if-else
						
						}else{
							JOptionPane.showMessageDialog(IssueBook.this,"Sorry, Callno doesn't exist!");
						}
				}
				else {
					JOptionPane.showMessageDialog(IssueBook.this,"Sorry, user doesn't exist!");
				}
				}
				}
			});
        
		
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(main_menu)
        			.addPreferredGap(ComponentPlacement.RELATED, 523, Short.MAX_VALUE)
        			.addComponent(createdatabase)
        			.addGap(384))
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(94)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(bookid, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        						.addComponent(username)
        						.addComponent(password, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
        					.addGap(20)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(textField)
        						.addComponent(bookId, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addComponent(passwordField, Alignment.TRAILING)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(161)
        					.addComponent(issue_book)))
        			.addPreferredGap(ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        			.addGap(457))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(main_menu)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(createdatabase)
        							.addGap(44)
        							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(158)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(bookid)
        						.addComponent(bookId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(username)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(password)
        						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(41)
        					.addComponent(issue_book)))
        			.addContainerGap(356, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);
	}
	//dated 14feb 2021 by Abhinash Rath
}
