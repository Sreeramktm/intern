package main_task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnected() {
        Connection connection=null;
        try{
        connection= DriverManager.getConnection("jdbc:postgresql://localhost/employee","postgres","12345678"); }
        catch (SQLException e){
            e.printStackTrace();
        }

        return connection;
    }
}
