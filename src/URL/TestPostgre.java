package URL;

import javafx.scene.chart.ScatterChart;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestPostgre {
    public static void main(String[] args) throws SQLException {
        String dbURL = "jdbc:postgresql://localhost/postgres";
        String username = "postgres";
        String password = "12345678";
        try{
        Connection conn = DriverManager.getConnection(dbURL, username, password);
        if(conn!=null) {
            System.out.println("Success");
        }
        } catch (Exception e) {
            System.err.println("Exception caught"+e.getMessage());
        }
    }
}
