package employee_main;

public class EmployeeDetails {
    private int id;
    private String name;
    private int age;
    private String designation;
    private String dept;
    private String reportinigto;
    public EmployeeDetails(int id,String name,int age,String designation,String dept,String reportingto) {
        this.id = id;
        this.name=name;
        this.age=age;
        this.designation=designation;
        this.dept=dept;
        this.reportinigto=reportingto;
    }
        public int getId () {
            return id;
        }

        public void setId ( int id){
            this.id = id;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }


        public String getDesignation () {
            return designation;
        }

        public void setDesignation (String designation){
            this.designation = designation;
        }
        public int getAge () {
            return age;
        }

        public void setAge ( int age){
            this.age = age;
        }

        public String getDept () {
            return dept;
        }

        public void setDept (String dept){
            this.dept = dept;
        }

        public String getReportinigto () {
            return reportinigto;
        }

        public void setReportinigto (String reportinigto){
            this.reportinigto = reportinigto;
        }

}
