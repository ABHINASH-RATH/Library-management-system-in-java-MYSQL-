import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class IssuedBooks extends javax.swing.JFrame {

	protected static IssuedBooks frame;
	private JTable table;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new IssuedBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public IssuedBooks() {
		
        
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
	      setMinimumSize(min);//dated 14feb 2021 by Abhinash Rath
        pack();
    	
        JLabel issued_books = new JLabel("Issued Books");
        issued_books.setFont(new Font("Tahoma", Font.PLAIN, 22));
        
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
        JScrollPane scrollPane = new JScrollPane();
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1059, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(main_menu)
        					.addPreferredGap(ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
        					.addComponent(issued_books)
        					.addGap(486))))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(issued_books)
        				.addComponent(main_menu))
        			.addGap(47)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(59, Short.MAX_VALUE))
        );//dated 14feb 2021 by Abhinash Rath
        
        // Fetching DATA FOR TABLES
        String data[][]=null;
		String column[]=null;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM issuedbooks",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		//setting data to tables
		table = new JTable(data,column);
		
        scrollPane.setViewportView(table);
        //dated 14feb 2021 by Abhinash Rath
        
        getContentPane().setLayout(groupLayout);
       //dated 14feb 2021 by Abhinash Rath
	}
}
