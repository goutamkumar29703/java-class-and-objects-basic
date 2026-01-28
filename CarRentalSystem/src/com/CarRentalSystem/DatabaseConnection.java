package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    
    
    private static final String URL = "jdbc:mysql://localhost:3306/car_rental_db";
    private static final String USERNAME = "root";  
    private static final String PASSWORD = "";      
    
    
    public static Connection getConnection() {
        Connection connection = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            System.out.println("✓ Database connected successfully!");
            
        } catch (ClassNotFoundException e) {
            System.out.println("✗ Error: MySQL JDBC Driver not found!");
            System.out.println("Make sure you have added mysql-connector-java to your project.");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.out.println("✗ Error: Could not connect to database!");
            System.out.println("Check your database URL, username, and password.");
            e.printStackTrace();
        }
        
        return connection;
    }
    
    
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("✓ Database connection closed.");
            } catch (SQLException e) {
                System.out.println("✗ Error closing connection.");
                e.printStackTrace();
            }
        }
    }
}
