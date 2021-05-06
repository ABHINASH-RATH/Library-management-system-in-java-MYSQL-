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

public class AddBook extends javax.swing.JFrame {

	protected static AddBook frame;
	private JTextField bookname_input;
	private JTextField authorname_input;
	private JTextField publishername_input;
	private JTextField year_input;
	private JTextField bookid_input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frame = new AddBook();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}

public AddBook(){
		

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
	      })//dated 14feb 2021 by Abhinash Rath
	      ;
	      setMinimumSize(min);
        pack();
         //creating various jlabels and text fields
        JLabel addUser = new javax.swing.JLabel();
        addUser.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); 
        addUser.setForeground(new java.awt.Color(0,0,0));
        addUser.setText("Add Book");
        //dated 14feb 2021 by Abhinash Rath
        ImageIcon icon_user =  new ImageIcon(".\\Images\\issuebook.png");
//dated 14feb 2021 by Abhinash Rath
        JLabel addbook_image = new JLabel(icon_user);
        addbook_image.setBorder(null);
        //dated 14feb 2021 by Abhinash Rath
        bookname_input = new JTextField();
        bookname_input.setColumns(25);
        
        JLabel _book = new JLabel("Name of Book");
        
        JLabel name_author = new JLabel("Name of Author");
        
        authorname_input = new JTextField();
        authorname_input.setColumns(20);
        
        JLabel publisher = new JLabel("Publisher");
        
        publishername_input = new JTextField();
        publishername_input.setColumns(20);
        
        JLabel year = new JLabel("Year");
        
        year_input = new JTextField();
        year_input.setColumns(10);
        
        JLabel book_id = new JLabel("Book Id");
        
        bookid_input = new JTextField();
        bookid_input.setColumns(15);
        
        JButton add_book = new JButton("Add Book");
        
        add_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String id_of_book= bookid_input.getText();
			String name_of_book=bookname_input.getText();
			String name_of_author=authorname_input.getText();
			String name_of_publisher=publishername_input.getText();
			String year_of_book=year_input.getText();
			int year1 =Integer.parseInt(year_of_book);
		
				int i=AddBooksql.save(id_of_book,name_of_book,name_of_author,name_of_publisher,year1);
				if(i>0){
					JOptionPane.showMessageDialog(AddBook.this,"Book added successfully!");
					
				}else{
					JOptionPane.showMessageDialog(AddBook.this,"Sorry, unable to save!");
				}
			}
	
			
		
			}
		);
        
        JButton main_menu = new JButton("Main Menu");
        main_menu.setIcon(new ImageIcon(".\\Images\\mainmenu.png"));
        main_menu.addActionListener(new ActionListener() {
//dated 14feb 2021 by Abhinash Rath

     			@Override
     			public void actionPerformed(ActionEvent e) {
     				// TODO Auto-generated method stub
     				Admin.main(new String[]{});
     				frame.dispose();
     			}});
        
        
        //dated 14feb 2021 by Abhinash Rath

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        				.addGap(25)
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(book_id, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(_book, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        					.addComponent(publisher, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(name_author, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        					.addComponent(year, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addComponent(main_menu))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(add_book)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(bookid_input)
        						.addComponent(year_input)
        						.addComponent(publishername_input)
        						.addComponent(authorname_input)
        						.addComponent(bookname_input, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(addUser)
        							.addGap(424))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(addbook_image, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
        							.addGap(94)))))
        			.addGap(298))
        );//dated 14feb 2021 by Abhinash Rath
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(addUser)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(addbook_image, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(main_menu)
        					.addGap(100)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(book_id)
        						.addComponent(bookid_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(25)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(bookname_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(_book))
        					.addGap(25)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(name_author)
        						.addComponent(authorname_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(25)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(publishername_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(publisher))
        					.addGap(25)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(year)
        						.addComponent(year_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        			.addGap(25)
        			.addComponent(add_book)
        			.addContainerGap(303, Short.MAX_VALUE))
        );
		
        getContentPane().setLayout(layout);
	}
	
	//dated 14feb 2021 by Abhinash Rath
}
