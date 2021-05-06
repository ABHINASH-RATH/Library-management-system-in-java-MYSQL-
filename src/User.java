import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//dated 14feb 2021 by Abhinash Rath
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class User extends javax.swing.JFrame {

	

	protected static User frame;

	public static void main(String[] strings) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	public User() {
		
		
		
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
         
         JLabel user_home = new javax.swing.JLabel();
         user_home.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); 
         user_home.setForeground(new java.awt.Color(0,0,0));
         user_home.setText("User Home");
         
         // making icons of icon images by kushal kanti mehta dated 12 febuary 2021
         
         ImageIcon icon_allbooks =  new ImageIcon(".\\Images\\allbooks.png");
         ImageIcon icon_issuedbooks =  new ImageIcon(".\\Images\\issuedbooks.png");
         ImageIcon icon_issuebooks =  new ImageIcon(".\\Images\\issuebook.png");
         ImageIcon icon_userinfo =  new ImageIcon(".\\Images\\userinfo.png");
         
         // JButtons creation by kushal kanti mehta dated 12 febuary 2021
         JButton allbooks = new JButton("All Books",icon_allbooks);
         allbooks.setVerticalTextPosition(AbstractButton.BOTTOM);
         allbooks.setHorizontalTextPosition(AbstractButton.CENTER);
     
         
         allbooks.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				AllBooks.main(new String[]{});
 				frame.dispose();
 			}});
         
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
         
         
         JButton issue_book = new JButton("Issue Book",icon_issuebooks);
         issue_book.setVerticalTextPosition(AbstractButton.BOTTOM);
         issue_book.setHorizontalTextPosition(AbstractButton.CENTER);

         issue_book.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				IssueBook.main(new String[]{});
 				frame.dispose();
 			}});
         
         JButton logout = new JButton("Log Out");
         logout.setIcon(new ImageIcon(".\\Images\\logout.png"));
         logout.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) {
  				// TODO Auto-generated method stub
  				Login.main(new String[]{});
  				frame.dispose();
  			}});
         
         
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         layout.setHorizontalGroup(
         	layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(layout.createSequentialGroup()
         			.addGap(125)
         			.addComponent(allbooks, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
         			.addGap(125)
         			.addComponent(issued_books, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
         			.addGap(125)
         			.addComponent(issue_book, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
         			.addContainerGap(370, Short.MAX_VALUE))
         		.addGroup(layout.createSequentialGroup()
         			.addContainerGap(688, Short.MAX_VALUE)
         			.addComponent(user_home)
         			.addGap(347)
         			.addComponent(logout)
         			.addContainerGap())
         );
         layout.setVerticalGroup(
         	layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(layout.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(layout.createParallelGroup(Alignment.LEADING)
         				.addComponent(logout)
         				.addGroup(layout.createSequentialGroup()
         					.addComponent(user_home)
         					.addGap(130)
         					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
         						.addComponent(allbooks, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
         						.addComponent(issued_books, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
         						.addComponent(issue_book, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))))
         			.addContainerGap(200, Short.MAX_VALUE))
         );
 		
 		  getContentPane().setLayout(layout);
 		//dated 14feb 2021 by Abhinash Rath
 		  
 		 

 		
	}

	
	
}
