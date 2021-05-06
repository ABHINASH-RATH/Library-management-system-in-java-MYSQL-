import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
//dated 14feb 2021 by Abhinash Rath
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTable;

public class AllBooks extends javax.swing.JFrame {

	protected static AllBooks frame;
	private JTable table;

	public static void main(String[] args) {
		// @ abhinash
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AllBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AllBooks(){
	
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
        
        JLabel all_books = new JLabel("All Books");
        all_books.setFont(new Font("Tahoma", Font.PLAIN, 22));
        
        JButton main_menu = new JButton("Main Menu");
        main_menu.setIcon(new ImageIcon(".\\Images\\mainmenu.png"));
        main_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Admin.main(new String[]{});
				frame.dispose();
			}});
        
        JScrollPane scrollPane = new JScrollPane();
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(main_menu)
        			.addPreferredGap(ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
        			.addComponent(all_books, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        			.addGap(517))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(all_books)
        				.addComponent(main_menu))
        			.addGap(47)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(59, Short.MAX_VALUE))
        );
        
  //dated 14feb 2021 by Abhinash Rath
        //fetching data for table in array of the book stored : at database 
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
		//inserting data to table
		table = new JTable(data,column);
		//setting table to scroll view
        scrollPane.setViewportView(table);
 
        
        getContentPane().setLayout(groupLayout); 
          //dated 14feb 2021 by Abhinash Rath
	}
}
