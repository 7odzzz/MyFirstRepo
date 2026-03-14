
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args)  {
		
		DBmanager.initialize();
		DBmanager.clearUsers();
		
		Users u1 = new Users(1,"mahmoud","mt354@gmail.com","12345kf"); 
		DBmanager.insert(u1);
		
		Users u2 = new Users(2,"mahmoud","mt54yegtt@gmail.com","12345kf"); 
		DBmanager.insert(u2);
		
		Users u3 = new Users(3,"aly","mdedewt@gmail.com","1234d3s5kf"); 
		DBmanager.insert(u3);
		
		Users u4 = new Users(4,"ziad","mdedewqedxxwwt@gmail.com","1234d3s5kf"); 
		DBmanager.insert(u4);
		
		Users u5 = new Users(5,"kenzy","mdedewffret@gmail.com","3@#31234d3s5kf"); 
		DBmanager.insert(u5);

		Users u6 = new Users(6,"amira","amirat@gmail.com","3@#31234fd3s5kf"); 
		DBmanager.insert(u6);
	
		Users u7 = new Users(7,"ahmed","irat@gmail.com","3@#31s5kf"); 
		DBmanager.insert(u7);
		
		Users u8 = new Users(8,"ahmed","irat@gmail.com","3@#31s5kf"); 
		DBmanager.insert(u8);
		
		Users u9 = new Users(9,"ahmed","irat@gmail.com","3@#31s5kf"); 
		DBmanager.insert(u9);
		
		System.out.println("users inserted successfully");

	
		DBmanager.deleteUser(2);
		DBmanager.deleteUser(3);
	    DBmanager.deleteUser(9);

		System.out.println(" user deleted successfully! " );

		ArrayList<Users> found = DBmanager.findAllUsers();
		if (found.isEmpty()) System.out.println("no users found");
		
		System.out.println(found);
		

		try {
			Users u = DBmanager.login("irat@gmail.com","3@#31s5kf");	
			System.out.println(" logged	in user: " + u);
		} 
		
		catch (SQLException e) {
			
		}
	}

}