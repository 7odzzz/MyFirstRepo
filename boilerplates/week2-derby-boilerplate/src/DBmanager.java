import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBmanager {
    

     static String connString = "jdbc:derby:db/AAST;create=true";

    static void initialize () 
    {
        try {
        Connection conn = DriverManager.getConnection(connString);
        Statement stmt = conn.createStatement();
        stmt.execute("create table users (id int , name varchar(25), password varchar(25), email varchar(25), primary key(id))");

        conn.close(); // 7y2fel el connection lama ye5als
        } catch (SQLException e) {
            System.out.println("table is already created");
        }
    }
    
    static void insert(Users user)
    {
        try {
           Connection conn = DriverManager.getConnection(connString);
           PreparedStatement pstmt = conn.prepareStatement("insert into users values(?,?,?,?)");
           pstmt.setInt(1, user.getId());
           pstmt.setString(2, user.getName());
           pstmt.setString(3, user.getEmail());
           pstmt.setString(4, user.getPassword());
        
           pstmt.execute();
           conn.close();

        } 
        catch (SQLException e) {
            System.out.println("user is inserted already " + e.getMessage());
    
        }

    }
    static void deleteUser(int id)
    {
        try {
        Connection conn = DriverManager.getConnection(connString);
        PreparedStatement pstmt = conn.prepareStatement("delete from users where id =? ");
        pstmt.setInt(1, id);
        pstmt.execute();
        conn.close();

            
        } catch (SQLException e) {
            System.out.println("user is already deleted! " + e.getMessage());
        }

    }


    static ArrayList<Users> findAllUsers()
    {
        ArrayList <Users> user = new ArrayList<>(); // fadya with 0 index
        Connection con =null ;
        
        try {
         con =DriverManager.getConnection(connString);
         Statement stmt = con.createStatement();
         ResultSet result =stmt.executeQuery("select * from users");   

         while(result.next())
         {
            int id = result.getInt("id") ;
            String name = result.getString("name");
            String email= result.getString("email");
            String password = result.getString("password");
            Users u = new Users(id, name, email, password);
            user.add(u);// we added the user to the array list`

         }
            
        }
        
        catch (SQLException e) {
            System.out.println("Error selecting users: " + e.getMessage());
         }

         finally{
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.getMessage();
                }

         }      
        return user;
    }

    static Users login (String email , String password) throws SQLException
    {
        
         Connection con =DriverManager.getConnection(connString);
            PreparedStatement pstmt = con.prepareStatement("select * from users where email= ? and password= ?");
            
            //values for the statement 
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet result = pstmt.executeQuery();
           
            if (result.next())
            {
                int id = result.getInt("id");
                String name= result.getString("name");
               Users u =new Users(id, name, email, password);
               return u ;
            }

        con.close();
        
 
        return null;
    }

    static void clearUsers() {
    try (Connection conn = DriverManager.getConnection(connString);
         Statement stmt = conn.createStatement()) {

        stmt.executeUpdate("DELETE FROM USERS");  // removes all previous data
        System.out.println("Previous users cleared. Starting fresh!");

    } catch (SQLException e) {
        System.out.println("Error clearing users: " + e.getMessage());
    }
}
}
