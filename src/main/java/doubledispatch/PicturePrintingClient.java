package doubledispatch;

import java.util.ArrayList;
import java.util.List;

public class PicturePrintingClient {

    private InkjetPrinter inkjetPrinter = new InkjetPrinter();

    public List<String> printPicture(Shape... shapes) {
        List<String> results = new ArrayList<String>();
        for (Shape shape : shapes) {
            results.add(shape.printOn(inkjetPrinter));
        }
        return results;
    }

}
