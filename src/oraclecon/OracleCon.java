package oraclecon;
import java.sql.*;  
public class OracleCon {
 
    public static final String DBURL = "jdbc:oracle:thin:@localhost:1521/orcl";
    public static final String DBUSER = "HR";
    public static final String DBPASS = "aravindh_01";
 
    public static void main(String[] args) throws SQLException {
         
        // Load Oracle JDBC Driver
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
         
        // Connect to Oracle Database
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
 
        Statement statement = conn.createStatement();
 
        // Execute a SELECT query on Oracle Dummy DUAL Table. Useful for retrieving system values
        // Enables us to retrieve values as if querying from a table
        String sql= "SELECT id,name,age from emp";
        ResultSet rs=statement.executeQuery(sql);
         while(rs.next()){
         //Retrieve by column name
            int id  = rs.getInt("id");
            String first = rs.getString("name");
            int age = rs.getInt("age");
         //Display values
            System.out.print("ID: " + id);
            System.out.println(" Name: " + first);
            System.out.println(" Age: " + age);
      }
        rs.close();
        statement.close();
        conn.close();
    }
}