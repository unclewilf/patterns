package adapter;

import org.junit.Test;
import org.springframework.mock.web.MockPageContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PageContextFormUITest {

    public static final String FAKE_COUNTRY_LABEL = "FAKE COUNTRY LABEL";
    public static final String FAKE_COUNTRY_REGEX = "FAKE COUNTRY REGEX";

    @Test
    public void countryLabel() throws Exception {
        MockPageContext pageContext = new MockPageContext();
        pageContext.setAttribute(FormUI.COUNTRY_LABEL, FAKE_COUNTRY_LABEL);
        PageContextFormUI form = new PageContextFormUI(pageContext);
        assertThat(form.getCountryLabel(), equalTo(FAKE_COUNTRY_LABEL));
    }

    @Test
    public void countryRegex() throws Exception {
        MockPageContext pageContext = new MockPageContext();
        pageContext.setAttribute(FormUI.COUNTRY_REGEX, FAKE_COUNTRY_REGEX);
        PageContextFormUI form = new PageContextFormUI(pageContext);
        assertThat(form.getCountryRegex(), equalTo(FAKE_COUNTRY_REGEX));
    }

}
