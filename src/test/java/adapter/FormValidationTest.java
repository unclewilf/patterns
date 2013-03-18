package adapter;

import org.apache.sling.api.resource.ValueMap;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FormValidationTest {

    public static final String INVALID_REGEX_COUNTRY = "INVALID COUNTRY";
    public static final String FAKE_COUNTRY_INVALID_MESSAGE = "Fake Country Invalid Message";

    private ValueMap valueMap = mock(ValueMap.class);

    @Test
    public void countryWithInvalidRegex() throws Exception {
        when(valueMap.get(SlingFormErrorMessages.COUNTRY_REGEX_INVALID, String.class)).thenReturn(FAKE_COUNTRY_INVALID_MESSAGE);

        Country country = new Country();
        country.setCountry(INVALID_REGEX_COUNTRY);
        FormValidation formValidation = new FormValidation(createFormWithCountry(country), new SlingFormErrorMessages(valueMap));

        assertThat(formValidation.hasErrors(), equalTo(true));
        assertThat(formValidation.validate().get(SlingFormErrorMessages.COUNTRY_REGEX_INVALID), equalTo(FAKE_COUNTRY_INVALID_MESSAGE));
    }

    private Payment createFormWithCountry(final Country country) {
        return new Payment() {
            @Override
            public Validation getValidation() {
                return null;
            }

            @Override
            public Country getCountry() {
                return country;
            }
        };
    }
}