package temporary;
import employee_main.EmployeeDetails;

import java.io.*;

public class JavaFileExample {
    public static void main(String args[]){
        ExampleLogger one=new ExampleLogger(10,"Ram",35,"Mdm","MTS");
        ExampleLogger two=new ExampleLogger(2,"Guru",40,"Mdm","MTS");
        //File open=new File("hello.txt");
        String open = "hello.txt";
        try{
            FileOutputStream file_out=new FileOutputStream(open);
            ObjectOutputStream out=new ObjectOutputStream(file_out);
            out.writeObject(one);
            out.writeObject(two);
            out.close();
            file_out.close();
            System.out.println("Done");
            FileInputStream file_in=new FileInputStream(open);
            ObjectInputStream in=new ObjectInputStream(file_in);
            ExampleLogger temp1=(ExampleLogger) in.readObject();
            ExampleLogger temp2=(ExampleLogger)in.readObject();
            System.out.println(temp1.toString());
            System.out.println(temp2.toString());
        }
        catch (FileNotFoundException ex){
            System.out.println("File not Found");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
