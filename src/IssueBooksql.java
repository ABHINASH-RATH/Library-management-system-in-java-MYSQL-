import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssueBooksql {
	
	//checking book exists
	public static boolean checkBook(String bookid){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM allbooks where bookid=?");
			ps.setString(1,bookid);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static boolean checkBook2(String bookid){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM issuedbooks where bookid=?");
			ps.setString(1,bookid);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}//dated 14feb 2021 by Abhinash Rath
	
	//saving book in issued book
	public static int save(String bookid,String bookname,String username){
		
		if(checktable()>0) {
			int status=0;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("INSERT INTO issuedbooks(bookid,bookname,username) values(?,?,?,)");
				ps.setString(1,bookid);
				ps.setString(2,bookname);
				ps.setString(3,username);
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
		}else {
			
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("CREATE TABLE `library`.`issuedbooks` ( `bookid` VARCHAR(30) NOT NULL , `name` VARCHAR(30) NOT NULL , `username` VARCHAR(30) NOT NULL , `userregd` VARCHAR(30) NOT NULL , UNIQUE `bookid` (`bookid`(30)), UNIQUE `regd_no` (`userregd`(30)))");
				ps.execute();
				con.close();
			}catch(Exception e){System.out.println(e);}
			//dated 14feb 2021 by Abhinash Rath
			
			
			
			
			int status=0;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("INSERT INTO issuedbooks(bookid,bookname,username) values(?,?,?,)");
				ps.setString(1,bookid);
				ps.setString(2,bookname);
				ps.setString(3,username);
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
			
		}
		
		
		//dated 14feb 2021 by Abhinash Rath
	}
	//returning book
	public static int returnbook(String bookid){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("DELETE FROM issuedbooks WHERE bookid=?");
			ps.setString(1,bookid);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}//dated 14feb 2021 by Abhinash Rath
	
	public static String name(String bookid) {
		String name1=null;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT name FROM allbooks WHERE bookid=?");
			ps.setString(1,bookid);
			ResultSet rs = ps.executeQuery();
			 name1 = rs.getString("name");
			con.close();
		}catch(Exception e){System.out.println(e);}
		return name1;
	}
	
	public static int checktable() {
		int status = 0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT count(*) FROM information_schema.TABLES WHERE (TABLE_SCHEMA = 'library') AND (TABLE_NAME = 'issuedbooks')");
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	//dated 14feb 2021 by Abhinash Rath
}
