package temporary;

import java.io.Serializable;

public class ExampleLogger implements Serializable {
    private int id;
    private String name;
    private int age;
    private String dept;
    private String designation;
    ExampleLogger(int id,String name,int age,String dept,String designation){
        this.id=id;
        this.name=name;
        this.age=age;
        this.dept=dept;
        this.designation=designation;
    }
    public String toString(){
        return "Id : "+id+"\nName : "+name+"\nAge : "+age+"\nDept. : "+dept+"\nDesignation : "+designation+"\n";
    }
}
