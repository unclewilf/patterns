package adapter;

import org.apache.sling.api.resource.ValueMap;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SlingPaymentFormUITest {

    private static final String FAKE_COUNTRY_LABEL = "FAKE COUNTRY LABEL";
    public static final String FAKE_COUNTRY_INVALID_REGEX = "Fake country invalid regex";

    private ValueMap valueMap = mock(ValueMap.class);
    private FormErrorMessages errorMessages = mock(FormErrorMessages.class);

    @Test
    public void countryLabel() throws Exception {
        when(valueMap.get(PaymentFormUI.COUNTRY_LABEL, String.class)).thenReturn(FAKE_COUNTRY_LABEL);

        SlingPaymentFormUI form = new SlingPaymentFormUI(valueMap, errorMessages);
        assertThat(form.getCountryLabel(), equalTo(FAKE_COUNTRY_LABEL));
    }

    @Test
    public void countryRegex() throws Exception {
        SlingPaymentFormUI form = new SlingPaymentFormUI(valueMap, errorMessages);
        assertThat(form.getCountryRegex(), equalTo(Country.COUNTRY_REGEX));
    }

    @Test
    public void countryRegexMessage() throws Exception {
        when(errorMessages.getCountryRegexInvalid()).thenReturn(FAKE_COUNTRY_INVALID_REGEX);

        SlingPaymentFormUI form = new SlingPaymentFormUI(valueMap, errorMessages);
        assertThat(form.getCountryRegexMessage(), equalTo(FAKE_COUNTRY_INVALID_REGEX));
    }

}
