package URL;

public class EmployeeData {
        private int id;
        private String name;
        private int age;
        private String designation;
        private String dept;
        private String reportinigto;
//        public EmployeeData(int id,String name,int age,String designation,String dept,String reportingto) {
//            this.id = id;
//            this.name=name;
//            this.age=age;
//            this.designation=designation;
//            this.dept=dept;
//            this.reportinigto=reportingto;
//        }
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

        public String getReportingto () {
            return reportinigto;
        }

        public void setReportingto (String reportinigto){
            this.reportinigto = reportinigto;
        }


    @Override
    public java.lang.String toString() {
        return "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", age=" + this.age +
                ", designation='" + this.designation + '\'' +
                ", dept='" + this.dept + '\'' +
                ", reportinigto='" + this.reportinigto+ '\'';
    }
}


