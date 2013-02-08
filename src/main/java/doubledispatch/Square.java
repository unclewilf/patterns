package doubledispatch;

public class Square implements Shape {

    @Override
    public String printOn(Printer printer) {
        return printer.printSquare(this);
    }

}
