package fluent.fluentbean;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PersonTest {

    @Test
    public void createPersonWithAllParameters() throws Exception {
        long timeBefore = System.currentTimeMillis();
        Person person = new Person().firstName("Reginald").lastName("Hunter").aged(41).inActive();
        long timeAfter = System.currentTimeMillis();
        System.out.println("Total time: " + (timeAfter - timeBefore));

        assertEquals("Reginald Hunter", person.isNamed());
        assertEquals(41, person.isAged());
        assertFalse(person.isActive());
    }

}
