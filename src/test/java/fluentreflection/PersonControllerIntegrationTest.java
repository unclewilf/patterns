package fluentreflection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-config.xml"})
public class PersonControllerIntegrationTest {

    @Autowired
    private PersonController personController;

    @Test
    public void name() throws Exception {
        assertEquals("uncle bob", personController.handle());
    }

}
