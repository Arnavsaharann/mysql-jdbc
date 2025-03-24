package com.bridgelabz.javadatabaseconnectivitypractice;

import java.sql.*;

public class JavaDatabaseConnectivityPractice {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/AddressBook";
        String user = "root";
        String password = "Noddy2003";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection established successfully!");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Address_Book_Table");

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zip = resultSet.getString("zip");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");

                // Print the row
                System.out.println(id + ", " + firstName + ", " + lastName + ", " + address +
                        ", " + city + ", " + state + ", " + zip + ", " + phoneNumber +
                        ", " + email + ", " + name + ", " + type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
