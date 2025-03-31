package com.bridgelabz.employeepayroll;

import java.sql.*;

public class EmployeePayroll {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String password = "Noddy2003";

        try(Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT gender, COUNT(*) AS employee_count, SUM(basic_pay) AS total_salary, AVG(basic_pay) AS average_salary, MIN(basic_pay) AS min_salary, MAX(basic_pay) AS max_salary FROM employee_payroll GROUP BY gender";
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(query);

            while (resultSet.next()) {
                String gender = resultSet.getString("gender");
                int employeeCount = resultSet.getInt("employee_count");
                double totalSalary = resultSet.getDouble("total_salary");
                double averageSalary = resultSet.getDouble("average_salary");
                double minSalary = resultSet.getDouble("min_salary");
                double maxSalary = resultSet.getDouble("max_salary");

                System.out.println("Gender: " + gender);
                System.out.println("Employee Count: " + employeeCount);
                System.out.println("Total Salary: " + totalSalary);
                System.out.println("Average Salary: " + averageSalary);
                System.out.println("Minimum Salary: " + minSalary);
                System.out.println("Maximum Salary: " + maxSalary);
                System.out.println("--------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
