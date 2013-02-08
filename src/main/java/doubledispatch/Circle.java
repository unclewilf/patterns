package doubledispatch;

public class Circle implements Shape {

    @Override
    public String printOn(Printer printer) {
        return printer.printCircle(this);
    }

}
