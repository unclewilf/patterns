package doubledispatch;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PicturePrintingClientTest {

    private PicturePrintingClient picturePrintingClient = new PicturePrintingClient();

    @Test
    public void shapesPrintedCorrectly() throws Exception {
        List<String> results = picturePrintingClient.printPicture(new Square(), new Circle(), new Square());
        assertEquals("inkjet square", results.get(0));
        assertEquals("inkjet circle", results.get(1));
        assertEquals("inkjet square", results.get(2));
    }

}
