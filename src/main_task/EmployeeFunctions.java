package main_task;

import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

public class EmployeeFunctions {
    static LinkedList<EmployeeData> emp = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    Connection conn = DBConnection.getConnected();

    public void dashBoard() throws SQLException {
        System.out.println("1.Display all records");
        System.out.println("3.Display Employee tree");
        System.out.println("4.Summary");
        System.out.println("5. Employee reporting to");
        System.out.println("9.To exit");
        String choice = scanner.next();
        switch (choice) {
            case "1":
                displayRecords();
                break;
            case "3":
                employeeTree();
                break;
            case "4":
                findSummary();
                break;
            case "5":
                printReport();
                break;
            case "9":
                System.out.println("Thank You!");
                System.exit(0);
                break;
            case "7":
                sqlToLinkedList();
                System.out.println(emp.get(1).getAge());
        }
    }

    private void displayRecords() {
        try {
            System.out.printf("%2s%5s%14s%20s%15s%25s\n", "ID", "NAME", "AGE", "DESIGNATION", "DEPARTMENT", "REPORTING MANAGER");
            for (EmployeeData employeeData : emp) {
                System.out.printf("%2d%15s%2d%20s%15s%25s\n", employeeData.getId(), employeeData.getName(), employeeData.getAge(), employeeData.getDept(), employeeData.getDesignation(), employeeData.getReportinigto());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sqlToLinkedList() {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select e.emp_id as employee_id,e.name as employee_name,e.age,we.dept_name,ww.desg_name,ee.name as reporting_manager_name from reporting r right join employee_data e on e.emp_id=r.empl_id inner join department we on e.dept_id = we.dept_id inner join designation ww on e.desg_id = ww.desg_id left join employee_data ee on ee.emp_id = r.manager_id");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                emp.add(new EmployeeData(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5), result.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private void employeeTree() throws SQLException {
        System.out.println("Enter the name of Employee");
        String name_emp = scanner.next();
        int isnamepresent = find(name_emp);
        if(isnamepresent>0) {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select e.name from employee_data e join designation d on e.desg_id = d.desg_id and d.desg_name = 'CEO';");
            String ceo = "";
            while (rset.next()) {
                ceo = rset.getString(1);
            }
            String q = name_emp;
            while (!(q.equals(ceo))) {
                name_emp += "->";
                rset = stmt.executeQuery("select ee.name from employee_data ee inner join reporting r on ee.emp_id=r.manager_id inner join employee_data e on e.emp_id = r.empl_id and e.name='" + q + "';");
                while (rset.next()) {
                    name_emp += rset.getString(1);
                    q = rset.getString(1);
                }
            }
            System.out.print(name_emp);
        }
        else{System.out.println("enter the correct name");}
    }

    private int find(String name) throws SQLException {
        int ans=0;
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("select distinct 1 from employee_data where name = '"+name+"';");
        while(rset.next()){
            ans=rset.getInt(1);
        }
        return ans;
    }
    private void findSummary() throws SQLException {
        System.out.println("Enter 1 for department summary");
        System.out.println("Enter 2 for designation summary");
        System.out.println("Enter 3 for reporting to summary");
        String choice=scanner.next();
        String table_name="",col_name="",id="";
        if(choice.equals("1")){
            table_name="department";
            col_name = "dept_name";
            id="dept_id";
        }
        else if(choice.equals("2")){
            table_name="designation";
            col_name = "desg_name";
            id="desg_id";
        }
        Statement stmt = conn.createStatement();
        ResultSet rset=null;
        if (choice.equals("3")){
            rset=stmt.executeQuery("select e.name ,count(e.name) from employee_data e right join reporting r on e.emp_id=r.manager_id group by e.name;");
        }
        else{
            rset = stmt.executeQuery("select "+col_name+","+"count("+col_name+") from "+table_name+" left join employee_data on "+table_name+"."+id+" = employee_data.dept_id group by "+col_name);
        }
   while (rset.next()){
       System.out.println(rset.getString(1)+rset.getInt(2));
   }
    }
    private void printReport() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rset=stmt.executeQuery("select e.name,ee.name from reporting r inner join employee_data e on e.emp_id=r.empl_id inner join employee_data ee on ee.emp_id=r.manager_id");
        while(rset.next()){
            System.out.println(rset.getString(1)+" is reporting to "+rset.getString(2));
        }
    }
}

