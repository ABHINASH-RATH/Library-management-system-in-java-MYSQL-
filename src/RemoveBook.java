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

public class RemoveBook extends javax.swing.JFrame {

	protected static RemoveBook frame;
	private JTextField bookId;
	
	//dated 14feb 2021 by Abhinash Rath
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RemoveBook ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//dated 14feb 2021 by Abhinash Rath


	
	RemoveBook(){
		
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
        createdatabase.setText("Remove Book");
        
        ImageIcon icon_createdatabase =  new ImageIcon(".\\Images\\removebook.png");
        
        JLabel lblNewLabel = new JLabel(icon_createdatabase);
        
        bookId = new JTextField();
        bookId.setColumns(10);
        
        JButton remove_book = new JButton("Remove Book");
        
        
        
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
       
        //removing book
        remove_book.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id_of_book= bookId.getText();
				int i=AddBooksql.removebook(id_of_book);
				if(i>0){
					JOptionPane.showMessageDialog(RemoveBook.this,"Book added successfully!");
					
				}else{
					JOptionPane.showMessageDialog(RemoveBook.this,"Sorry, unable to save!");
				}
				
			}});
		
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(main_menu)
        					.addPreferredGap(ComponentPlacement.RELATED, 403, Short.MAX_VALUE)
        					.addComponent(createdatabase)
        					.addGap(384))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        					.addGap(457))))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(348)
        			.addComponent(bookId, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(remove_book)
        			.addContainerGap(377, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(440, Short.MAX_VALUE)
        			.addComponent(hint, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
        			.addGap(397))
        );//dated 14feb 2021 by Abhinash Rath
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
        						.addComponent(remove_book))))
        			.addGap(63)
        			.addComponent(hint)
        			.addContainerGap(198, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);
	}
	//dated 14feb 2021 by Abhinash Rath
}

