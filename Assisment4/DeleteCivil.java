package Assisment4;

import java.sql.*;

public class DeleteCivil{
    public static void main(String[] args){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "root"
            );

            Statement st = connection.createStatement();

            int rows = st.executeUpdate("DELETE FROM Students WHERE year=2024 AND branch='Civil'");

            System.out.println(rows + " Records Deleted");

            connection.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

