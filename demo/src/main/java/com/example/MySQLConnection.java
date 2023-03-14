package demo.src.main.java.com.example;
import java.sql.*;

public class MySQLConnection {
    public static void main(String[] args) {
        // MySQL database information
        String url = "";
        String user = "";
        String password = "";
        
        // Connection object
        Connection con = null;
        
        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Open a connection
            con = DriverManager.getConnection(url, user, password);
            
            // Check if connection is successful
            if (con != null) {
                System.out.println("Connected to MySQL database!");
            }
            Statement statement = con.createStatement();
            String sql = "select * from tb_user";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                String userid = resultSet.getString(1);
                int passwd = resultSet.getInt(2);
                String farmName = resultSet.getString(5);

                System.out.println("userID:"+userid+","+"password:"+passwd+"==>"+farmName);
            }
            
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        } finally {
            try {
                // Close connection
                con.close();
                System.out.println("DisConnected!!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}