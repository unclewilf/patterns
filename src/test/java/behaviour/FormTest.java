package behaviour;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FormTest {

    private Form form = new Form();

    @Before
    public void setUp() throws Exception {
        form.setValidationMessages(new FakeValidationMessages());
    }

    @Test
    public void noValidationErrors() throws Exception {
        form.setEmail("test@example.com");
        assertThat(form.validate().hasErrors(), is(false));
    }

    @Test
    public void emailMissing() throws Exception {
        form.setEmail("");
        ValidationInfo validationInfo = form.validate();
        assertThat(validationInfo.hasErrors(), is(true));
        assertThat(validationInfo.getErrors().get(form.EMAIL_KEY), equalTo(FakeValidationMessages.EMAIL_MISSING));
    }

    @Test
    public void emailEmpty() throws Exception {
        form.setEmail(null);
        ValidationInfo validationInfo = form.validate();
        assertThat(validationInfo.hasErrors(), is(true));
        assertThat(validationInfo.getErrors().get(form.EMAIL_KEY), equalTo(FakeValidationMessages.EMAIL_MISSING));
    }

    @Test
    public void emailIsInvalid() throws Exception {
        form.setEmail("invalidemail");
        ValidationInfo validationInfo = form.validate();
        assertThat(validationInfo.hasErrors(), is(true));
        assertThat(validationInfo.getErrors().get(form.EMAIL_KEY), equalTo(FakeValidationMessages.EMAIL_INVALID));
    }
}

