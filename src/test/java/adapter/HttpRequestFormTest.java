package adapter;

import org.apache.sling.api.SlingHttpServletRequest;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HttpRequestFormTest {

    public static final String FAKE_COUNTRY = "FAKE COUNTRY";

    private SlingHttpServletRequest request = mock(SlingHttpServletRequest.class);

    @Test
    public void getCountryFromRequest() throws Exception {
        when(request.getAttribute(Form.COUNTRY)).thenReturn(FAKE_COUNTRY);

        SlingHttpRequestForm form = new SlingHttpRequestForm(request);
        assertThat(form.getCountry(), equalTo(FAKE_COUNTRY));
    }

}
