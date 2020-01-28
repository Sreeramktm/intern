package temporary;

public class PrivateConstructorExample {
    static PrivateConstructorExample obj;
    public String a="Hello";
    private PrivateConstructorExample(){}
    public static PrivateConstructorExample getInstance() {
        if (obj == null) {
            obj = new PrivateConstructorExample();
        }
        return obj;
    }
}
