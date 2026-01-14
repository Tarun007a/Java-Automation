package Assisment4;

import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb",
                    "root",
                    "root"
            );

            if(connection != null){
                System.out.println("Connection Successful");
            }

            connection.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
