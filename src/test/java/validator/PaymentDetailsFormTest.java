package validator;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.jsp.PageContext;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaymentDetailsFormTest {

    private ValueMap valueMap = mock(ValueMap.class);
    private PageContext pageContext = mock(PageContext.class);
    private SlingHttpServletRequest request = mock(SlingHttpServletRequest.class);
    private Resource resource = mock(Resource.class);

    public static final String PAGE_CONTEXT_VALUE_MAP_PROPERTY = "properties";
    public static final String FAKE_COUNTRY_INVALID_REGEX = "Fake country invalid regex";
    public static final String VALID_COUNTRY = "valid";
    public static final String INVALID_COUNTRY = "INVALID";

    @Before
    public void setUp() throws Exception {
        when(pageContext.getAttribute(PAGE_CONTEXT_VALUE_MAP_PROPERTY)).thenReturn(valueMap);
        when(request.getResource()).thenReturn(resource);
        when(resource.adaptTo(ValueMap.class)).thenReturn(valueMap);
    }

    @Test
    public void emptyFormContainsCountryWithValidationRules() throws Exception {
        PaymentDetailsForm form = PaymentDetailsForm.emptyForm(pageContext, new FakePaymentDetailsValidationMessages());
        List<ValidationRule> validationRuleList = form.getPaymentDetails().getCountry().getValidationRules();
        ValidationRule validationRule = validationRuleList.get(0);

        assertThat(validationRule.getType(), equalTo(ValidationRuleType.REGEX));
        assertThat(validationRule.getValue(), equalTo(Country.COUNTRY_REGEX));
        assertThat(validationRule.getMessage(), equalTo(FAKE_COUNTRY_INVALID_REGEX));
    }

    @Test
    public void formSubmittedWithValidCountry() throws Exception {
        when(request.getParameter(Country.COUNTRY_FIELD)).thenReturn(VALID_COUNTRY);

        PaymentDetailsForm form = PaymentDetailsForm.submittedForm(request, new FakePaymentDetailsValidationMessages());

        assertThat(form.getPaymentDetails().getCountry().getCode(), equalTo(VALID_COUNTRY));
        assertThat(form.getPaymentDetails().validate().isEmpty(), equalTo(true));
    }

    @Test
    public void formSubmittedWithInvalidCountryRegex() throws Exception {
        when(request.getParameter(Country.COUNTRY_FIELD)).thenReturn(INVALID_COUNTRY);

        PaymentDetailsForm form = PaymentDetailsForm.submittedForm(request, new FakePaymentDetailsValidationMessages());
        PaymentDetails paymentDetails = form.getPaymentDetails();

        assertThat(paymentDetails.getCountry().getCode(), equalTo(INVALID_COUNTRY));
        assertThat(paymentDetails.validate().get(0).getField(), equalTo(Country.COUNTRY_FIELD));
        assertThat(paymentDetails.validate().get(0).getMessage(), equalTo(FAKE_COUNTRY_INVALID_REGEX));
    }

}

class FakePaymentDetailsValidationMessages extends PaymentDetailsValidationMessages {

    @Override
    public String getCountryInvalidRegex() {
            return PaymentDetailsFormTest.FAKE_COUNTRY_INVALID_REGEX;
    }

}
