package adapter;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HttpRequestFormTest {

    public static final String FAKE_COUNTRY = "FAKE COUNTRY";

    @Test
    public void getCountryFromRequest() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setAttribute(Form.COUNTRY, FAKE_COUNTRY);

        HttpRequestForm form = new HttpRequestForm(request);
        assertThat(form.getCountry(), equalTo(FAKE_COUNTRY));
    }

}
