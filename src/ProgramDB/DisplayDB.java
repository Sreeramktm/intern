package ProgramDB;

import java.sql.*;
public class DisplayDB {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("Select distinct id,name from demotable");
            while(rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
        System.out.println("Is connection closed : "+connection.isClosed());
    }
}
