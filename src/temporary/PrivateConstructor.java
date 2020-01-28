package temporary;

public class PrivateConstructor {
    public static void main(String args[]){
        PrivateConstructorExample obj1=PrivateConstructorExample.getInstance();
        obj1.a="Bye";
       // PrivateConstructorExample.obj=null;
        PrivateConstructorExample obj2=PrivateConstructorExample.getInstance();
        obj2.a="Hey";
        System.out.println(obj1.a+"   "+obj2.a);
    }
}
