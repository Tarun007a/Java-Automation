package Assisment4;

import java.sql.*;

public class DisplaySemester{
    public static void main(String[] args){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "root"
            );

            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Students WHERE semester=7 AND branch='EC'");

            while(rs.next()){
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("branch") + " " +
                                rs.getDouble("percentage") + " " +
                                rs.getInt("semester") + " " +
                                rs.getInt("year")
                );
            }

            connection.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
