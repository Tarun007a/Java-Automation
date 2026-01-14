package Assisment4;

import java.sql.*;

public class CreateInsertStudents{
    public static void main(String[] args){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb",
                    "root",
                    "root"
            );
            Statement st = connection.createStatement();

            st.execute(
                    "CREATE TABLE IF NOT EXISTS Students(" +
                            "id INT PRIMARY KEY," +
                            "name VARCHAR(50)," +
                            "branch VARCHAR(20)," +
                            "percentage DOUBLE," +
                            "semester INT," +
                            "year INT)"
            );

            st.executeUpdate(
                    "INSERT INTO Students VALUES" +
                            "(1,'Amit','CSE',75,7,2022)," +
                            "(2,'Rahul','EC',80,7,2023)," +
                            "(3,'Aman','AIML',90,8,2022)"
            );

            System.out.println("Table Created and Records Inserted");
            connection.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
