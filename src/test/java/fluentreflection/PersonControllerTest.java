package fluentreflection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @Mock
    private Person person;

    private FluentPersonFactory factory;

    private PersonController personController = new PersonController();

    @Before
    public void setUp() throws Exception {
        factory = mock(FluentPersonFactory.class, new AnswerWithSelf(FluentPersonFactory.class));
        personController.setFluentPersonFactory(factory);
    }

    @Test
    public void stubbedFactory() {
        when(factory.create()).thenReturn(person);
        when(person.isNamed()).thenReturn("ANY NAME");
        assertEquals("ANY NAME", personController.handle());
    }

}
