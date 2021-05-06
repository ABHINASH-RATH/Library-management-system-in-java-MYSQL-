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
//dated 14feb 2021 by Abhinash Rath
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
import javax.swing.JTable;
//dated 14feb 2021 by Abhinash Rath
public class ViewUser extends javax.swing.JFrame {

	protected static ViewUser frame;
	private JTable table;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ViewUser() {
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
        
//dated 14feb 2021 by Abhinash Rath
        
        JLabel users = new JLabel("View Users");
        users.setFont(new Font("Tahoma", Font.PLAIN, 22));
        //dated 14feb 2021 by Abhinash Rath
        JButton main_menu = new JButton("Main Menu");
        main_menu.setIcon(new ImageIcon(".\\Images\\mainmenu.png"));
        main_menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Admin.main(new String[]{});
				frame.dispose();
			}});//dated 14feb 2021 by Abhinash Rath
        
        JScrollPane scrollPane = new JScrollPane();
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(main_menu)
        			.addPreferredGap(ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
        			.addComponent(users, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
        			.addGap(500))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1058, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(62, Short.MAX_VALUE))
        );//dated 14feb 2021 by Abhinash Rath
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(users)
        				.addComponent(main_menu))
        			.addGap(47)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(59, Short.MAX_VALUE))
        );//dated 14feb 2021 by Abhinash Rath
        
        // fetching data for table
        String data[][]=null;
		String column[]=null;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM issuedbooks",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			//dated 14feb 2021 by Abhinash Rath
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
			con.close();//dated 14feb 2021 by Abhinash Rath
		}catch(Exception e){System.out.println(e);}
		//inserting data to table
		table = new JTable(data,column);
		//setting table to scrollview
        scrollPane.setViewportView(table);
        
        
        getContentPane().setLayout(groupLayout);
        
	}
//dated 14feb 2021 by Abhinash Rath
}
