import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//dated 14feb 2021 by Abhinash Rath
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

public class ReturnBook extends javax.swing.JFrame {

	protected static ReturnBook frame;
	private JTextField bookId;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ReturnBook ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	ReturnBook(){
		
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
        createdatabase.setText("Return Book");
        
        ImageIcon icon_returnbook =  new ImageIcon(".\\Images\\returnbook.png");
        
        JLabel lblNewLabel = new JLabel(icon_returnbook);
        
        bookId = new JTextField();
        bookId.setColumns(10);
        //returning book
        JButton return_book = new JButton("Return Book");
        return_book.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String bookid=bookId.getText();
				int i = IssueBooksql.returnbook(bookid);
				if(i>0) {
					JOptionPane.showMessageDialog(ReturnBook.this,"Book returned successfully!");
				}
				else {
					JOptionPane.showMessageDialog(ReturnBook.this,"Book not returned");
				}
				
				
			}});
        
        JButton main_menu = new JButton("Main Menu");
        main_menu.setIcon(new ImageIcon(".\\Images\\mainmenu.png"));
        main_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Admin.main(new String[]{});
				frame.dispose();
			}});
		
        JLabel hint = new JLabel("Enter Book Id and then click the button");
		
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(main_menu)
        					.addPreferredGap(ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
        					.addComponent(createdatabase)
        					.addGap(384))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        					.addGap(457))))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(348)
        			.addComponent(bookId, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(return_book)
        			.addContainerGap(377, Short.MAX_VALUE))
        			.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                			.addContainerGap(440, Short.MAX_VALUE)
                			.addComponent(hint, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
                			.addGap(397))
        );
        
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(main_menu)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(createdatabase)
        					.addGap(44)
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
        					.addGap(29)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(bookId, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        						.addComponent(return_book))))
        		
        			.addGap(63)
        			.addComponent(hint)
        			.addContainerGap(198, Short.MAX_VALUE))
           
        );
        getContentPane().setLayout(layout);
	}
//dated 14feb 2021 by Abhinash Rath
}
