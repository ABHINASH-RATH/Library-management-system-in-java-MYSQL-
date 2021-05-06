import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class Login extends javax.swing.JFrame {
	static Login frame;
	private JPanel contentPane;
	private JTextField admin_username_input;
	private JPasswordField admin_password_input;
	private JTextField user_username_input;
	private JPasswordField user_password_input;
	
	//dated 14feb 2021 by Abhinash Rath
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//dated 14feb 2021 by Abhinash Rath
	
	public Login() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(200,100,1100,621);
		Dimension min = new Dimension(1100,621);
	    Image img = Toolkit.getDefaultToolkit().getImage(".\\Images\\Libraryiter.jpg");
	
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
		    
	          
		      JLabel programname = new javax.swing.JLabel();
		      
		      programname.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); 
		      programname.setForeground(new java.awt.Color(255,255,255));
		      programname.setText("Simple Library Management System");
		      
		      JLabel admin_Login = new JLabel("Admin Login");
		      admin_Login.setForeground(Color.WHITE);
		      admin_Login.setFont(new Font("Tahoma", Font.PLAIN, 22));
		      
		      JLabel admin_username = new JLabel("Username");
		      admin_username.setForeground(Color.WHITE);
		      admin_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		      
		      JLabel admin_password = new JLabel("Password");
		      admin_password.setForeground(Color.WHITE);
		      admin_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		      
		      admin_username_input = new JTextField();
		      admin_username_input.setColumns(10);
		      
		      admin_password_input = new JPasswordField();
		      
		      JButton admin_login = new JButton("Login");
		      admin_login.setForeground(Color.BLUE);
		      
		      //login admin
		      admin_login.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					String name=admin_username_input.getText();
					
					String password=String.valueOf(admin_password_input.getPassword());
					
					if(name.equals("admin")&&password.equals("admin123")){
						Admin.main(new String[]{});
						frame.dispose();
					}else{
						JOptionPane.showMessageDialog(Login.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
						admin_username_input.setText("");
						admin_password_input.setText("");
					}
					}
				});
		      
		      JLabel User_Login = new JLabel("User Login");
		      User_Login.setForeground(Color.WHITE);
		      User_Login.setFont(new Font("Tahoma", Font.PLAIN, 22));
		      
		      JLabel User_username = new JLabel("Username");
		      User_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		      User_username.setForeground(Color.WHITE);
		      
		      JLabel user_password = new JLabel("Password");
		      user_password.setForeground(Color.WHITE);
		      user_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		      
		      user_username_input = new JTextField();
		      user_username_input.setColumns(10);
		      
		      user_password_input = new JPasswordField();
		      
		      JButton user_login = new JButton("Login");
		      user_login.setForeground(Color.BLUE);
		      
		      //login user
		      user_login.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
                    String name=user_username_input.getText();
					String password=String.valueOf(user_password_input.getPassword());
					if(Usersql.validate(name, password)){		
					User.main(new String[]{});
						frame.dispose();
					}else{
						JOptionPane.showMessageDialog(Login.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
						user_username_input.setText("");
						user_password_input.setText("");
					}
				}
		    	  
		      });
		      
              
		      
		      
		      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		      layout.setHorizontalGroup(
		      	layout.createParallelGroup(Alignment.LEADING)
		      		.addGroup(layout.createSequentialGroup()
		      			.addGroup(layout.createParallelGroup(Alignment.LEADING)
		      				.addGroup(layout.createSequentialGroup()
		      					.addGap(115)
		      					.addGroup(layout.createParallelGroup(Alignment.LEADING)
		      						.addComponent(admin_username, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
		      						.addGroup(layout.createSequentialGroup()
		      							.addComponent(admin_password, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
		      							.addGap(23)))
		      					.addGap(18)
		      					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
		      						.addComponent(admin_password_input, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
		      						.addComponent(admin_username_input, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
		      					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
		      						.addGroup(layout.createSequentialGroup()
		      							.addGap(253)
		      							.addComponent(User_username, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		      						.addGroup(layout.createSequentialGroup()
		      							.addPreferredGap(ComponentPlacement.RELATED)
		      							.addComponent(user_password)))
		      					.addGap(32)
		      					.addGroup(layout.createParallelGroup(Alignment.LEADING)
		      						.addGroup(layout.createSequentialGroup()
		      							.addComponent(user_password_input, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
		      							.addGap(2))
		      						.addComponent(user_username_input, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
		      				.addGroup(layout.createSequentialGroup()
		      					.addGap(214)
		      					.addComponent(admin_login)
		      					.addPreferredGap(ComponentPlacement.RELATED, 415, Short.MAX_VALUE)
		      					.addComponent(user_login)
		      					.addGap(106))
		      				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
		      					.addGroup(layout.createSequentialGroup()
		      						.addGap(192)
		      						.addComponent(admin_Login, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
		      						.addGap(365)
		      						.addComponent(User_Login, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		      					.addGroup(layout.createSequentialGroup()
		      						.addGap(250)
		      						.addComponent(programname))))
		      			.addGap(387))
		      );
		      layout.setVerticalGroup(
		      	layout.createParallelGroup(Alignment.LEADING)
		      		.addGroup(layout.createSequentialGroup()
		      			.addGap(220)
		      			.addComponent(programname)
		      			.addGap(70)
		      			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		      				.addComponent(admin_Login, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
		      				.addComponent(User_Login))
		      			.addGap(18)
		      			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		      				.addComponent(admin_username, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
		      				.addGroup(layout.createSequentialGroup()
		      					.addGap(6)
		      					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		      						.addComponent(admin_username_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		      						.addComponent(User_username)
		      						.addComponent(user_username_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		      			.addGap(26)
		      			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		      				.addComponent(admin_password, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
		      				.addGroup(layout.createSequentialGroup()
		      					.addGap(5)
		      					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		      						.addComponent(admin_password_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		      						.addComponent(user_password)
		      						.addComponent(user_password_input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		      			.addGap(27)
		      			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		      				.addComponent(admin_login)
		      				.addComponent(user_login))
		      			.addGap(87))
		      );
		        getContentPane().setLayout(layout);

		   //dated 14feb 2021 by Abhinash Rath
	}
}
