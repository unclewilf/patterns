package fluent.fluentreflection;

import org.junit.Test;

import static fluent.fluentreflection.FluentPersonFactory.person;
import static junit.framework.Assert.*;

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
        Person person =
                person().firstName("joe").lastName("bloggs").age(21).active().create();
        assertEquals("joe bloggs", person.isNamed());
        assertEquals(21, person.isAged().intValue());
        assertTrue(person.isActive());
    }

}
