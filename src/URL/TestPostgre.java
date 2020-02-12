package URL;

import javafx.scene.chart.ScatterChart;
import org.postgresql.util.PSQLException;

import java.sql.*;

public class TestPostgre {
    public static void main(String[] args) throws SQLException {
        String dbURL = "jdbc:postgresql://localhost/employee";
        String username = "postgres";
        String password = "12345678";
        try{
        Connection conn = DriverManager.getConnection(dbURL, username, password);
            PreparedStatement preparedStatement=conn.prepareStatement("select e.emp_id as employee_id,e.name as employee_name,e.age,we.dept_name,ww.desg_name,ee.name as reporting_manager_name from reporting r right join employee_data e on e.emp_id=r.empl_id inner join department we on e.dept_id = we.dept_id inner join designation ww on e.desg_id = ww.desg_id left join employee_data ee on ee.emp_id = r.manager_id");
            ResultSet result=preparedStatement.executeQuery();
            while(result.next()){
                System.out.println(result.getInt(1)+" \t"+result.getString(2)+" \t"+result.getInt(3)+" \t"+result.getString(4)+" \t"+result.getString(5)+" \t"+result.getString(6));
            }
//            if(conn!=null) {
//            System.out.println("Success");
//        }
        } catch (Exception e) {
            System.err.println("Exception caught"+e.getMessage());
        }
    }
}
