import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
//dated 14feb 2021 by Abhinash Rath
public class AddUser extends javax.swing.JFrame {

	protected static AddUser frame;
	private JTextField name_input;
	private JTextField email_input;
	private JTextField contact_input;
	private JPasswordField confirmpassword_input;
	private JPasswordField password_input;
	private JTextField regdno_input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//dated 14feb 2021 by Abhinash Rath
	
	public AddUser(){
		

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
        
        //creating jlabels and fields
        JLabel addUser = new javax.swing.JLabel();
        addUser.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); 
        addUser.setForeground(new java.awt.Color(0,0,0));
        addUser.setText("Add User");
        
        ImageIcon icon_user =  new ImageIcon(".\\Images\\adduser.png");

        JLabel user_image = new JLabel(icon_user);
        user_image.setBorder(null);
        
        name_input = new JTextField();
        name_input.setColumns(25);
        
        JLabel name = new JLabel("Name");
        
        JLabel email = new JLabel("Email Address");
        //dated 14feb 2021 by Abhinash Rath
        email_input = new JTextField();
        email_input.setColumns(20);
        
        JLabel contact_no = new JLabel("Contact No.");
        
        contact_input = new JTextField();
        contact_input.setColumns(20);
        
        JLabel password = new JLabel("Password");
        //dated 14feb 2021 by Abhinash Rath
        password_input = new JPasswordField();
        password_input.setColumns(10);
        
        JLabel password_confirm = new JLabel("Confrim Password");
        
        confirmpassword_input = new JPasswordField();
        confirmpassword_input.setColumns(10);
        
        JLabel regd_no = new JLabel("Registration No.");
        
        regdno_input = new JTextField();
        regdno_input.setColumns(15);
        
        JButton createuser = new JButton("Create User");
        //dated 14feb 2021 by Abhinash Rath
        createuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String regd= regdno_input.getText();
			String name=name_input.getText();
			String password1=String.valueOf(password_input.getPassword());
			String confirmpassword2=String.valueOf(confirmpassword_input.getPassword());
			String email=email_input.getText();
			String contact=contact_input.getText();
			if(password1.equals(confirmpassword2) ){
				int i=Usersql.save(regd, name, email, contact,password1);
				if(i>0){
					JOptionPane.showMessageDialog(AddUser.this,"Librarian added successfully!");
					
				}else{
					JOptionPane.showMessageDialog(AddUser.this,"Sorry, unable to save!");
				}
			}
			else {
				JOptionPane.showMessageDialog(AddUser.this,"Sorry, passwords do not match");}
			
		
			}//dated 14feb 2021 by Abhinash Rath
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        				.addGap(25)
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(regd_no, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(password_confirm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(name, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        					.addComponent(contact_no, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(email, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        					.addComponent(password, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addComponent(main_menu))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(createuser)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(regdno_input)
        						.addComponent(confirmpassword_input)
        						.addComponent(password_input)
        						.addComponent(contact_input)
        						.addComponent(email_input)
        						.addComponent(name_input, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(addUser)
        							.addGap(424))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(user_image, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
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
        					.addComponent(user_image, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(main_menu)
        					.addGap(50)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(regd_no)
        						.addComponent(regdno_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(25)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(name_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(name))
        					.addGap(25)//dated 14feb 2021 by Abhinash Rath
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(email)
        						.addComponent(email_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(25)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(contact_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(contact_no))
        					.addGap(25)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(password)
        						.addComponent(password_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(25)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(password_confirm)
        						.addComponent(confirmpassword_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        			.addGap(20)
        			.addComponent(createuser)
        			.addContainerGap(303, Short.MAX_VALUE))
        );
		
        getContentPane().setLayout(layout);
        //dated 14feb 2021 by Abhinash Rath
	}
}
