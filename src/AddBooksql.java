import java.sql.Connection;//dated 14feb 2021 by Abhinash Rath
import java.sql.PreparedStatement;

public class AddBooksql {
	public static int save(String bookid,String name,String author,String publisher,int year){
		
		if(checktable()>0) {
			int status=0;//dated 14feb 2021 by Abhinash Rath
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("INSERT INTO allbooks(bookid,name,author,publisher,year) values(?,?,?,?,?)");
				ps.setString(1,bookid);
				ps.setString(2,name);
				ps.setString(3,author);
				ps.setString(4,publisher);
				ps.setInt(5,year);
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
		}//dated 14feb 2021 by Abhinash Rath
		
		else {
			
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("CREATE TABLE `library`.`allbooks` ( `bookid` VARCHAR(30) NOT NULL , `name` VARCHAR(30) NOT NULL , `author` VARCHAR(30) NOT NULL , `publisher` VARCHAR(30) NOT NULL , `year` INT(30) NOT NULL , UNIQUE `bookid` (`bookid`(30)))");
				ps.execute();
				con.close();
			}catch(Exception e){System.out.println(e);}
			
			int status1=0;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("INSERT INTO allbooks(bookid,name,author,publisher,year) values(?,?,?,?,?)");
				ps.setString(1,bookid);
				ps.setString(2,name);
				ps.setString(3,author);
				ps.setString(4,publisher);
				ps.setInt(5,year);
				status1=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status1;
		}
		
	}//dated 14feb 2021 by Abhinash Rath
	
	public static int removebook(String bookid){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("DELETE FROM allbooks WHERE bookid=?");
			ps.setString(1,bookid);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int checktable() {
		int status = 0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT count(*) FROM information_schema.TABLES WHERE (TABLE_SCHEMA = 'library') AND (TABLE_NAME = 'allbooks')");
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	//dated 14feb 2021 by Abhinash Rath
}
