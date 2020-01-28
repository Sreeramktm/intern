package employee_main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args){
        EmployeeFunctions e1=new EmployeeFunctions();
        List <EmployeeDetails> list=new LinkedList<>();
        list.add(new EmployeeDetails(1,"Sreeram",45,"CEO","Mgmt.",null));
        list.add(new EmployeeDetails(1,"Sreeram",45,"CEO","Mgmt.",null));
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().equals("Sreeram")){
        System.out.println(list.get(i).getId());break;}}
    }
}
