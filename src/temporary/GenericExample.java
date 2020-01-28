package temporary;

public class GenericExample<P> {
    P input;
    GenericExample(P input){
        this.input=input;
    }
    public P getInput(){
        return this.input;
    }
}
