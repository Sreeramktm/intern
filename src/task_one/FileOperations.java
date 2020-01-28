package task_one;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOperations {
   FileDetails fd=new FileDetails();
    static String dir="C:\\Users\\sreeram-pt3552\\Documents\\";
    private final String begin="1";
    Scanner scanner=new Scanner(System.in);
    public void fileChanger(){
        System.out.println("Welcome to File Changer\n");
        System.out.println("Enter the source File\n");
        fd.setInput_file(scanner.next());
        boolean check_in=checkFile(fd.getInput_file());
        System.out.println("Enter the file name for destination\n");
        fd.setOutput_file(scanner.next());
        try {
        if(!(fd.getOutput_file().equals(fd.getInput_file()))) {
                boolean check_out = checkFile(fd.getOutput_file());
                if((check_in) && (!check_out)){
                    copySource2Destination(fd.getInput_file(), fd.getOutput_file());
                    System.out.println("Copy Successfull"); }
                else if (!check_in && !check_out){
                    throw new FileException("Source file is missing"); }
                else if (check_in && check_out){
                    throw new FileException("Destination file is already present"); }}
        else{
                System.out.println("Input and Output Files are same\n" + "Starting from first.......\n");
                fileChanger(); } }
        catch (FileException ex){
            System.out.println(ex.getMessage());
            proceedOperation(); } }

    private void proceedOperation(){
        System.out.print("Enter 1 to proceed from the beginning\n"+"Enter 2 to quit\n");
        if(scanner.next().equals(begin)) { fileChanger(); }
        else { System.exit(0); } }

   private  boolean checkFile(String a) {
       return new File(dir+a).exists(); }

    private void copySource2Destination(String input_file,String output_file){
        FileInputStream in=null;
        FileOutputStream out=null;
        try{
            in= new FileInputStream(new File(dir+input_file));
            out=new FileOutputStream(new File(dir+output_file));
        int i;
        while((i=in.read())!=-1){
            out.write(i);
        }
        }
        catch (FileNotFoundException e){ e.printStackTrace();
        } catch (IOException e) { e.printStackTrace(); }
        finally {
            try {
                in.close();
            } catch (IOException e) { e.printStackTrace(); }
            try {
                out.close();
            } catch (IOException e) { e.printStackTrace(); } } }
}
