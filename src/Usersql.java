import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//dated 14feb 2021 by Abhinash Rath
public class Usersql {
	//saving and checking if table exists
	public static int save(String regdno,String name,String email,String contact,String password){
		
		if(checktable()>0) {
			int status=0;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("INSERT INTO users(regdno,name,email,contact,password) values(?,?,?,?,?,)");
				ps.setString(1,regdno);
				ps.setString(2,name);
				ps.setString(3,email);
				ps.setString(4,contact);
				ps.setString(5,password);
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
			
		}else {
			
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("CREATE TABLE `library`.`users` ( `regdno` VARCHAR(30) NOT NULL , `name` VARCHAR(30) NOT NULL , `email` VARCHAR(30) NOT NULL , `contact` VARCHAR(30) NOT NULL , `password` VARCHAR(30) NOT NULL , UNIQUE `regd_no` (`regdno`(30)))");
				ps.execute();
				con.close();
			}catch(Exception e){System.out.println(e);}
			
			
			int status1=0;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("INSERT INTO users(regdno,name,email,contact,password) values(?,?,?,?,?,)");
				ps.setString(1,regdno);
				ps.setString(2,name);
				ps.setString(3,email);
				ps.setString(4,contact);
				ps.setString(5,password);
				status1=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status1;
			
		}
		
	}
//validating user details for login
	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM students where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	//checking table
	public static int checktable() {
		int status = 0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT count(*) FROM information_schema.TABLES WHERE (TABLE_SCHEMA = 'library') AND (TABLE_NAME = 'users')");
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	//dated 14feb 2021 by Abhinash Rath
}
