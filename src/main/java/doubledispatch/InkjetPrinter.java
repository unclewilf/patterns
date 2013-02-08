package doubledispatch;

public class InkjetPrinter implements Printer{

    @Override
    public String printCircle(Circle circle) {
        System.out.println("Circle printed on inkjet");
        return "inkjet circle";
    }

    @Override
    public String printSquare(Square square) {
        System.out.println("Square printed on inkjet");
        return "inkjet square";
    }

}
