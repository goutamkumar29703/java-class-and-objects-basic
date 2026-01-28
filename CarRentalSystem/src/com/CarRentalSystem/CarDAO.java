package database;

import models.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CarDAO {
    
   
    public List<Car> getAvailableCarsByCategory(String category) {
        List<Car> cars = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
           
            connection = DatabaseConnection.getConnection();
            
            
            String sql = "SELECT * FROM cars WHERE category = ? AND status = 'Available'";
            statement = connection.prepareStatement(sql);
            statement.setString(1, category);  
            resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {
                Car car = new Car(
                    resultSet.getString("plate_no"),
                    resultSet.getString("model"),
                    resultSet.getString("category"),
                    resultSet.getDouble("rate_per_day"),
                    resultSet.getString("status")
                );
                cars.add(car);  
            }
            
        } catch (SQLException e) {
            System.out.println("✗ Error fetching cars from database!");
            e.printStackTrace();
            
        } finally {
            
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) DatabaseConnection.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return cars;
    }
    
    
    public boolean rentCar(String plateNo) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DatabaseConnection.getConnection();
            
            
            String sql = "UPDATE cars SET status = 'Rented' WHERE plate_no = ? AND status = 'Available'";
            statement = connection.prepareStatement(sql);
            statement.setString(1, plateNo);
            
            
            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("✓ Car rented successfully!");
                return true;
            } else {
                System.out.println("✗ Car not available or doesn't exist!");
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("✗ Error renting car!");
            e.printStackTrace();
            return false;
            
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) DatabaseConnection.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
   
    public boolean returnCar(String plateNo) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DatabaseConnection.getConnection();
            
           
            String sql = "UPDATE cars SET status = 'Available' WHERE plate_no = ? AND status = 'Rented'";
            statement = connection.prepareStatement(sql);
            statement.setString(1, plateNo);
            
            
            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("✓ Car returned successfully!");
                return true;
            } else {
                System.out.println("✗ Car is not currently rented or doesn't exist!");
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("✗ Error returning car!");
            e.printStackTrace();
            return false;
            
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) DatabaseConnection.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public Car getCarByPlateNo(String plateNo) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Car car = null;
        
        try {
            connection = DatabaseConnection.getConnection();
            
           
            String sql = "SELECT * FROM cars WHERE plate_no = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, plateNo);
            

            resultSet = statement.executeQuery();
            
            
            if (resultSet.next()) {
                car = new Car(
                    resultSet.getString("plate_no"),
                    resultSet.getString("model"),
                    resultSet.getString("category"),
                    resultSet.getDouble("rate_per_day"),
                    resultSet.getString("status")
                );
            }
            
        } catch (SQLException e) {
            System.out.println("✗ Error fetching car details!");
            e.printStackTrace();
            
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) DatabaseConnection.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return car;
    }
}
