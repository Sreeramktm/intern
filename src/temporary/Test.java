package temporary;

class Test<G>
{
    // An object of type T is declared
    G obj;
    Test(G obj) { this.obj = obj; } // constructor
    public G getObject() { return this.obj; }
}
