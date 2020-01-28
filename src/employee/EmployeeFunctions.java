package employee;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeFunctions {
    EmployeeDetails e1=new EmployeeDetails();
    // EmployeeFunctions e2=new EmployeeFunctions();
    //setTemporaryValue();
    Scanner s=new Scanner(System.in);
    static int tempid[]={1,2,3,4,5,6,7,8,9,10};

    void printDetails(int temp[]) {
        System.out.println("ID"+"  "+"Name"+"  "+"Age"+"  "+"Designation"+"  "+"Department"+"  "+"Reporting to");
        for(int i=0;i<temp.length;i++){
            if(temp[i]>0&&temp[i]<=e1.id[e1.id.length-1]){
                System.out.println(e1.id[temp[i]-1]+"  "+e1.name[temp[i]-1]+"  "+e1.age[temp[i]-1]+"  "+e1.designation[temp[i]-1]+"  "+e1.dept[temp[i]-1]+"  "+e1.reportingto[temp[i]-1]);}
        }
    }
    //Main menu for user to enter input
    void loadMenuFunction() {

        System.out.println("Enter 1 to display");
        System.out.println("Enter 2 to search and compare");
        System.out.println("Enter 3 to see Employee tree");
        System.out.println("Enter 4 to see Employee reporting");
        System.out.println("Enter 5 to see Summary");
        System.out.println("Enter 6 to exit");
        String choice=s.next();
        //  int choice = Integer.parseInt(choicetemp);
        if(choice.equals("1")){
            printDetails(e1.id);
        }else if(choice.equals("2")){
            comparisonFunction();
        }
        else if(choice.equals("3")){
            employeeTree();
        }
        else if(choice.equals("4")){
            employeeReporting();
        }
        else if(choice.equals("5")){
            summary();
        }
        else if(choice.equals("6")){
            System.exit(0);
        }
        else{
            System.out.println("Enter the correct option"+"\n"+"Loading from first.........");
            //  System.out.println("Loading from first.........");
            loadMenuFunction();
        }
    }

    //Function for employee tree
    void employeeTree() {
        System.out.println("Enter the name of Employee");
        String name_emp=s.next();
        String q=name_emp;
        while(!(q.equals("Sreeram"))){
            //     System.out.print(name_emp+"->");
            for(int i=0;i<e1.id.length;i++){
                if(q.equals(e1.name[i])){
                    name_emp+="->";
                    name_emp+=e1.reportingto[i];
                    q=e1.reportingto[i];
                }
            }
        }
        System.out.print(name_emp);
    }
    //Function for displaying employee and for who employee is reporting to
    void employeeReporting(){
        for(int i=0;i<e1.id.length;i++){
            System.out.println(e1.name[i]+" is reporting to "+e1.reportingto[i]);
        }
    }
    //Function to perform Department summary
    void summaryDept(){
        HashMap <String,Integer> hmap=new HashMap<>();
        for(String temp_var:e1.dept){
            if(hmap.containsKey(temp_var)){
                hmap.put(temp_var, hmap.get(temp_var)+1);
            }
            else{
                hmap.put(temp_var, 1);
            }
        }
        for (Map.Entry entry : hmap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    //Function to perform Designation summary
    void summaryDesignation(){
        HashMap <String,Integer> hmap=new HashMap<>();
        for(String temp_var:e1.designation){
            if(hmap.containsKey(temp_var)){
                hmap.put(temp_var, hmap.get(temp_var)+1);
            }
            else{
                hmap.put(temp_var, 1);
            }
        }
        for (Map.Entry entry : hmap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    //Function to perform Reporting to summary
    void summaryReportingTo(){
        HashMap <String,Integer> hmap=new HashMap<>();
        for(int i=0;i<e1.reportingto.length;i++){
            String temp_var=e1.reportingto[i];
            if(temp_var.equals("--------")){continue;}
            else if(hmap.containsKey(temp_var)){
                hmap.put(temp_var, hmap.get(temp_var)+1);
            }
            else{
                hmap.put(temp_var, 1);
            }
        }
        for (Map.Entry entry : hmap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    //Function for the summary
    void summary() {
        System.out.println("Enter 1 for Department summary");
        System.out.println("Enter 2 for Designation summary");
        System.out.println("Enter 3 for Reporting to summary");
        String choice=s.next();
        if(choice.equals("1")){
            summaryDept();
        }
        else if(choice.equals("2")){
            summaryDesignation();
        }
        else if(choice.equals("3")){
            summaryReportingTo();
        }
        else{
            System.out.println("Enter the correct option"+"\n"+"Loading from first.........");
            //  System.out.println("Loading from first.........");
            loadMenuFunction();
        }

    }
    //Function for the comparison and search function
    void comparisonFunction(){
        System.out.println("Enter 1 to perform with integers"+"\n"+"Enter 2 to perform with String");
        String choice=s.next();
        if(choice.equals(("1"))){
            integerFunctions();
        }
        else if(choice.equals(("2"))){
            stringFunctions();
        }
        else{
            System.out.println("Enter the correct option"+"\n"+"Loading from first.........");
            //  System.out.println("Loading from first.........");
            loadMenuFunction();
        }
    }

    //Function to perform Integer operations within compare and search function
    void integerFunctions() {
        System.out.println("Enter 1 for lesser(<) than operation"+"\n"+"Enter 2 for greater(>) than operation");
        System.out.println("Enter 3 for not equals(!=) operation"+"\n"+"Enter 4 for equals(==) operation");
        System.out.println("Enter your choice");
        String choice=s.next();
        if(choice.equals("1")){
            System.out.println("Enter value for lesser(<) than operation");
            int less_value=s.nextInt();
            lesserThan(less_value,tempid);
            loadMenuFunction();
        }
        else if(choice.equals("2")){
            System.out.println("Enter value for greater(>) than operation");
            int gr_value=s.nextInt();
            greaterThan(gr_value,tempid);
            loadMenuFunction();
        }
        else if(choice.equals("3")){
            System.out.println("Enter value for not equals(!=) operation");
            int value=s.nextInt();
            notEqualsThan(value,tempid);
            loadMenuFunction();
        }
        else if(choice.equals("4")){
            System.out.println("Enter the value for equals operation");
            int value=s.nextInt();
            equalsThan(value,tempid);
            loadMenuFunction();
        }
        else{
            System.out.println("Enter the correct option"+"\n"+"Loading from first.........");
            //  System.out.println("Loading from first.........");
            loadMenuFunction();
        }
    }
    //Function for lesser than operation
    void lesserThan(int value,int arr[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=-1){
                if(e1.age[i]>=value){
                    tempid[i]=-1;
                }}
        }
        printDetails(tempid);
    }
    //Function for greater than operation
    void greaterThan(int value,int arr[]){
        for(int i=0;i<arr.length;i++){
            if(e1.age[i]<=value){
                tempid[i]=-1;
            }
        }
        printDetails(tempid);
    }
    //Function for Not Equals Operation
    void notEqualsThan(int value,int arr[]){
        for(int i=0;i<arr.length;i++){
            if(e1.age[i]==value){
                tempid[i]=-1;
            }
        }
        printDetails(tempid);
    }
    //Function for Equals operation
    void equalsThan(int value,int arr[]){
        for(int i=0;i<arr.length;i++){
            if(e1.age[i]!=value){
                tempid[i]=-1;
            }
        }
        printDetails(tempid);
    }
    //Function to perform String operations within compare and search function
    void stringFunctions() {
        //       System.out.println("Enter 1 for name column"+"\n"+"Enter 2 for designation column"+"\n"+"Enter 3 for department column"+"\n"+"Enter 4 for reporting to column");
        //       String choice1=s.next();
        System.out.println("Enter 1 to perform startswith operation"+"\n"+"Enter 2 to perform endswith operation");
        System.out.println("Enter 3 to perform contains operation"+"\n"+"Enter 4 to perform not contains operation");
        System.out.println("Enter 5 to perform equals operation"+"\n"+"Enter 6 to perform not equals operation");
        String choice=s.next();
        if(choice.equals("1")){
            startsWithFun();
            loadMenuFunction();
        }
        else if(choice.equals("2")){
            endsWithFun();
            loadMenuFunction();
        }
        else if(choice.equals("3")){
            containsFun();
            loadMenuFunction();
        }
        else if(choice.equals("4")){
            notContainsFun();
            loadMenuFunction();
        }
        else if(choice.equals("5")){
            equalsFun();
            loadMenuFunction();
        }
        else if(choice.equals("6")){
            notEqualsFun();
            loadMenuFunction();
        }
        else{
            System.out.println("Enter the correct option"+"\n"+"Loading from first.........");
            //  System.out.println("Loading from first.........");
            loadMenuFunction();
        }
    }
    //Function to perform starts with operation.
    void startsWithFun(){
        System.out.println("1.name"+"\n"+"2.desigantion"+"\n"+"3.department"+"\n"+"4.reporting to");
        String choice=s.next();
        if(choice.equals("1")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(temp2.equalsIgnoreCase(e1.name[i].substring(0,temp2.length())))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("2")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(temp2.equalsIgnoreCase(e1.designation[i].substring(0,temp2.length())))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("3")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(temp2.equalsIgnoreCase(e1.dept[i].substring(0,temp2.length())))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("4")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(temp2.equalsIgnoreCase(e1.reportingto[i].substring(0,temp2.length())))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else{
            System.out.println("Enter the correct option"+"\n"+"Loading from first.........");
            //  System.out.println("Loading from first.........");
            loadMenuFunction();
        }
    }
    //Function to perform ends with operation.
    void endsWithFun(){
        System.out.println("1.name"+"\n"+"2.desigantion"+"\n"+"3.department"+"\n"+"4.reporting to");
        String choice=s.next();
        if(choice.equals("1")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(e1.name[i].length()>temp2.length()){
                    if(!(temp2.equalsIgnoreCase(e1.name[i].substring(e1.name[i].length()-temp2.length(),e1.name[i].length())))){
                        tempid[i]=-1;
                    }}
            }
            printDetails(tempid);
        }
        else if(choice.equals("2")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(e1.name[i].length()>temp2.length()){
                    if(!(temp2.equalsIgnoreCase(e1.designation[i].substring(e1.designation[i].length()-temp2.length(),e1.designation[i].length())))){
                        tempid[i]=-1;
                    }}
            }
            printDetails(tempid);
        }
        else if(choice.equals("3")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(e1.name[i].length()>temp2.length()){
                    if(!(temp2.equalsIgnoreCase(e1.dept[i].substring(e1.dept[i].length()-temp2.length(),e1.dept[i].length())))){
                        tempid[i]=-1;
                    }}
            }
            printDetails(tempid);
        }
        else if(choice.equals("4")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(e1.name[i].length()>temp2.length()){
                    if(!(temp2.equalsIgnoreCase(e1.reportingto[i].substring(e1.reportingto[i].length()-temp2.length(),e1.reportingto[i].length())))){
                        tempid[i]=-1;
                    }}
            }
            printDetails(tempid);
        }
        else{
            System.out.println("Enter the correct option"+"\n"+"Loading from first.........");
            //  System.out.println("Loading from first.........");
            loadMenuFunction();
        }
    }
    //Function to perform conatins operation.
    void containsFun(){
        System.out.println("1.name"+"\n"+"2.desigantion"+"\n"+"3.department"+"\n"+"4.reporting to");
        String choice=s.next();
        if(choice.equals("1")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(e1.name[i].contains(temp2))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("2")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(e1.designation[i].contains(temp2))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("3")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(e1.dept[i].contains(temp2))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("4")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(e1.reportingto[i].contains(temp2))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
    }
    //Function to perform not conatins operation.
    void notContainsFun(){
        System.out.println("1.name"+"\n"+"2.desigantion"+"\n"+"3.department"+"\n"+"4.reporting to");
        String choice=s.next();
        if(choice.equals("1")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if((e1.name[i].contains(temp2))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("2")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if((e1.designation[i].contains(temp2))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("3")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if((e1.dept[i].contains(temp2))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("4")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if((e1.reportingto[i].contains(temp2))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else{
            System.out.println("Enter the correct option"+"\n"+"Loading from first.........");
            //  System.out.println("Loading from first.........");
            loadMenuFunction();
        }
    }
    //Function to perform equals operation.
    void equalsFun(){
        System.out.println("1.name"+"\n"+"2.desigantion"+"\n"+"3.department"+"\n"+"4.reporting to");
        String choice=s.next();
        if(choice.equals("1")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(temp2.equalsIgnoreCase(e1.name[i]))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("2")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(temp2.equalsIgnoreCase(e1.designation[i]))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("3")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(temp2.equalsIgnoreCase(e1.dept[i]))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("4")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(temp2.equalsIgnoreCase(e1.reportingto[i]))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else{
            System.out.println("Enter the correct option"+"\n"+"Loading from first.........");
            //  System.out.println("Loading from first.........");
            loadMenuFunction();
        }
    }
    //Function to perform not equals operation.
    void notEqualsFun(){
        System.out.println("1.name"+"\n"+"2.desigantion"+"\n"+"3.department"+"\n"+"4.reporting to");
        String choice=s.next();
        if(choice.equals("1")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if((temp2.equalsIgnoreCase(e1.name[i]))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("2")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(temp2.equalsIgnoreCase(e1.designation[i]))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("3")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(temp2.equalsIgnoreCase(e1.dept[i]))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else if(choice.equals("4")){
            System.out.println("Enter the String");
            String temp2=s.next();
            for(int i=0;i<tempid.length;i++){
                if(!(temp2.equalsIgnoreCase(e1.reportingto[i]))){
                    tempid[i]=-1;
                }
            }
            printDetails(tempid);
        }
        else{
            System.out.println("Enter the correct option"+"\n"+"Loading from first.........");
            //  System.out.println("Loading from first.........");
            loadMenuFunction();
        }
    }
}
