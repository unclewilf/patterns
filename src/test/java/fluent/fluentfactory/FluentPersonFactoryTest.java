package fluent.fluentfactory;

import org.junit.Test;

import static fluent.fluentfactory.FluentPersonFactory.person;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class FluentPersonFactoryTest {

    @Test
    public void personCreatedWithoutName_throwsException() throws Exception {
        CreatePersonException expectedException = null;
        try {
            person().firstName("joe").age(21).active().create();
        } catch (CreatePersonException e) {
            expectedException = e;
        }
        assertNotNull(expectedException);
    }

    @Test
    public void personCreatedWithAllRequiredParameters() throws Exception {
        long timeBefore = System.currentTimeMillis();
        Person person =
                person().firstName("joe").lastName("bloggs").age(21).active().create();
        long timeAfter = System.currentTimeMillis();
        System.out.println("Total time: " + (timeAfter - timeBefore));
        assertEquals("joe bloggs", person.getFullName());
        assertEquals(21, person.getAge().intValue());
        assertTrue(person.isActive());
    }

}
