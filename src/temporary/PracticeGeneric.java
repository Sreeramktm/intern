package temporary;

public class PracticeGeneric {
    public static void main(String[] args){
        GenericExample<Integer> input1=new GenericExample<Integer>(4);
        GenericExample<String> input2=new GenericExample<String>("Sreeram");
        System.out.println(input1.getInput());
        System.out.println(input2.getInput());
    }
}
//INheritance with classes and methods
//polymorphism