package adapter;

import org.apache.sling.api.SlingHttpServletRequest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SlingHttpRequestFormTest {

    private static final String FAKE_COUNTRY = "FAKE COUNTRY";

    private SlingHttpServletRequest request = mock(SlingHttpServletRequest.class);

    @Test
    public void validCountry() throws Exception {
        when(request.getAttribute(Payment.COUNTRY)).thenReturn(FAKE_COUNTRY);

        SlingHttpRequestPayment form = new SlingHttpRequestPayment(request);
        assertThat(form.getCountry().getCountry(), equalTo(FAKE_COUNTRY));
        assertThat(form.getCountry().isValidForPaymentDetails().isEmpty(), equalTo(true));
    }

}
