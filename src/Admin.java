import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
//dated 14feb 2021 by Abhinash Rath
public class Admin extends javax.swing.JFrame{
	
	
	static Admin frame;

	public static void main(String[] args) {
		// @ abhinash
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Admin() {
//dated 14feb 2021 by Abhinash Rath
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
         
         JLabel Admin_home = new javax.swing.JLabel();
         Admin_home.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); 
         Admin_home.setForeground(new java.awt.Color(0,0,0));
         Admin_home.setText("Admin Home");
         
         //dated 14feb 2021 by Abhinash Rath
         
// making icons of icon images by kushal kanti mehta dated 12 febuary 2021
         
         ImageIcon icon_allbooks =  new ImageIcon(".\\Images\\allbooks.png");
         ImageIcon icon_issuedbooks =  new ImageIcon(".\\Images\\issuedbooks.png");
         ImageIcon icon_issuebooks =  new ImageIcon(".\\Images\\issuebook.png");
         ImageIcon icon_removebook =  new ImageIcon(".\\Images\\removebook.png");
         ImageIcon icon_adduser =  new ImageIcon(".\\Images\\adduser.png");
         ImageIcon icon_viewuser =  new ImageIcon(".\\Images\\userinfo.png");
         ImageIcon icon_createdatabase =  new ImageIcon(".\\Images\\database.png");
         ImageIcon icon_returnbook =  new ImageIcon(".\\Images\\returnbook.png");
         
         // JButtons creation by kushal kanti mehta dated 12 febuary 2021
         JButton allbooks = new JButton("All Books",icon_allbooks);
         allbooks.setVerticalTextPosition(AbstractButton.BOTTOM);
         allbooks.setHorizontalTextPosition(AbstractButton.CENTER);
         
         // all books button
         allbooks.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				AllBooks.main(new String[]{});
 				frame.dispose();
 			}});
         //dated 14feb 2021 by Abhinash Rath
         // issued books button
         JButton issued_books = new JButton("Issued Books",icon_issuedbooks);
         issued_books.setVerticalTextPosition(AbstractButton.BOTTOM);
         issued_books.setHorizontalTextPosition(AbstractButton.CENTER);
         
         issued_books.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				IssuedBooks.main(new String[]{});
 				frame.dispose();
 			}});
         //dated 14feb 2021 by Abhinash Rath
         
         JButton add_book = new JButton("Add Book",icon_issuebooks);
         add_book.setVerticalTextPosition(AbstractButton.BOTTOM);
         add_book.setHorizontalTextPosition(AbstractButton.CENTER);
         
         add_book.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 			// @ abhinash
 				AddBook.main(new String[]{});
 				frame.dispose();
 			}});//dated 14feb 2021 by Abhinash Rath
         
         JButton remove_book = new JButton("Remove Book",icon_removebook);
         remove_book.setVerticalTextPosition(AbstractButton.BOTTOM);
         remove_book.setHorizontalTextPosition(AbstractButton.CENTER);
         
         remove_book.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 			// @ abhinash
 				RemoveBook.main(new String[]{});
 				frame.dispose();
 			}});//dated 14feb 2021 by Abhinash Rath
         
         JButton adduser = new JButton("Add User",icon_adduser );
         adduser.setVerticalTextPosition(SwingConstants.BOTTOM);
         adduser.setHorizontalTextPosition(SwingConstants.CENTER);
         
        adduser.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				AddUser.main(new String[]{});
 				frame.dispose();
 			}});
         
         JButton viewuser = new JButton("View User", icon_viewuser);
         viewuser.setVerticalTextPosition(SwingConstants.BOTTOM);
         viewuser.setHorizontalTextPosition(SwingConstants.CENTER);
         
         viewuser.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				ViewUser.main(new String[]{});
 				frame.dispose();
 			}});//dated 14feb 2021 by Abhinash Rath
         
         JButton database = new JButton("Database", icon_createdatabase);
         database.setVerticalTextPosition(SwingConstants.BOTTOM);
         database.setHorizontalTextPosition(SwingConstants.CENTER);
         
        database.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// @ abhinash
				Database.main(new String[]{});
				frame.dispose();
			}});//dated 14feb 2021 by Abhinash Rath
         
         JButton returnbook = new JButton("Return Book", icon_returnbook);
         returnbook.setVerticalTextPosition(SwingConstants.BOTTOM);
         returnbook.setHorizontalTextPosition(SwingConstants.CENTER);
         
         returnbook.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				ReturnBook.main(new String[]{});
 				frame.dispose();
 			}});//dated 14feb 2021 by Abhinash Rath
         
         JButton logout = new JButton("Log Out");
         logout.setIcon(new ImageIcon(".\\Images\\logout.png"));
         logout.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) {
  			// @ abhinash
  				Login.main(new String[]{});
  				frame.dispose();
  			}});
         //dated 14feb 2021 by Abhinash Rath
         
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         layout.setHorizontalGroup(
         	layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(layout.createSequentialGroup()
         			.addContainerGap(627, Short.MAX_VALUE)
         			.addComponent(Admin_home)
         			.addGap(347)
         			.addComponent(logout)
         			.addContainerGap())
         		.addGroup(layout.createSequentialGroup()
         			.addGap(100)
         			.addGroup(layout.createParallelGroup(Alignment.LEADING)
         				.addGroup(layout.createSequentialGroup()
         					.addComponent(adduser, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
         					.addGap(100)
         					.addComponent(viewuser, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
         					.addGap(100)
         					.addComponent(returnbook, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
         					.addGap(100)
         					.addComponent(database, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
         				.addGroup(layout.createSequentialGroup()
         					.addComponent(allbooks, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
         					.addGap(100)
         					.addComponent(issued_books, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
         					.addGap(100)
         					.addComponent(add_book, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
         					.addGap(100)
         					.addComponent(remove_book, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
         );
         layout.setVerticalGroup(
         	layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(layout.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(layout.createParallelGroup(Alignment.LEADING)
         				.addGroup(layout.createSequentialGroup()
         					.addComponent(logout)
         					.addContainerGap())
         				.addGroup(layout.createSequentialGroup()
         					.addComponent(Admin_home)
         					.addGap(42)
         					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
         						.addComponent(allbooks, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
         						.addComponent(issued_books, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
         						.addComponent(add_book, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
         						.addComponent(remove_book, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
         					.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
         					.addGroup(layout.createParallelGroup(Alignment.LEADING)
         						.addComponent(adduser, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
         						.addComponent(viewuser, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
         						.addComponent(returnbook, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
         						.addComponent(database, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
         					.addGap(44))))
         );
 		
 		  getContentPane().setLayout(layout);
 		 
	}
}
//dated 14feb 2021 by Abhinash Rath