package adapter;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.ServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FormValidationTest {

    public static final String INVALID_REGEX_COUNTRY = "^^FAKE COUNTRY^^";

    private MockHttpServletRequest request = new MockHttpServletRequest();

    @Test
    public void postcodeWithInvalidRegex() throws Exception {
        FormValidation formValidation = new FormValidation(createFormWithCountry(INVALID_REGEX_COUNTRY), new FakeFormErrorMessages(request));
        assertThat(formValidation.hasErrors(), equalTo(true));
        assertThat(formValidation.validate().get(Validation.COUNTRY_REGEX_FAILED), equalTo(FakeFormErrorMessages.FAKE_REGEX_FAILED_MESSAGE));
    }

    private Form createFormWithCountry(final String country) {
        return new Form() {
            @Override
            public Validation getValidation() {
                return null;
            }

            @Override
            public String getCountry() {
                return country;
            }
        };
    }
}

class FakeFormErrorMessages extends FormErrorMessages {

    public static final String FAKE_REGEX_FAILED_MESSAGE = "FAKE REGEX FAILED MESSAGE";

    public FakeFormErrorMessages(ServletRequest request) {
        super(request);
    }

    @Override
    public String getRegexFailed() {
        return FAKE_REGEX_FAILED_MESSAGE;
    }
}
