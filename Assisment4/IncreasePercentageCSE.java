package Assisment4;

import java.sql.*;

public class IncreasePercentageCSE{
    public static void main(String[] args){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "root"
            );

            Statement st = connection.createStatement();

            int rows = st.executeUpdate("UPDATE Students SET percentage = percentage + (percentage * 0.05) " +  "WHERE branch='CSE'");
            System.out.println(rows + " Records Updated");

            connection.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

