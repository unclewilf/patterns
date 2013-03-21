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

    public static final String PAGE_CONTEXT_VALUE_MAP_PROPERTY = "properties";
    public static final String FAKE_COUNTRY_INVALID_REGEX = "Fake country invalid regex";
    public static final String GB_COUNTRY_CODE = "GB country code";
    private ValueMap valueMap = mock(ValueMap.class);
    private PaymentDetailsValidationMessages validationMessages = mock(PaymentDetailsValidationMessages.class);

    private PageContext pageContext = mock(PageContext.class);
    private SlingHttpServletRequest request = mock(SlingHttpServletRequest.class);
    private Resource resource = mock(Resource.class);

    @Before
    public void setUp() throws Exception {
        when(pageContext.getAttribute(PAGE_CONTEXT_VALUE_MAP_PROPERTY)).thenReturn(valueMap);
        when(request.getResource()).thenReturn(resource);
        when(resource.adaptTo(ValueMap.class)).thenReturn(valueMap);
    }

    @Test
    public void newFormContainsCountryWithValidationRules() throws Exception {
        when(validationMessages.getCountryInvalidRegex()).thenReturn(FAKE_COUNTRY_INVALID_REGEX);

        PaymentDetailsForm form = PaymentDetailsForm.emptyForm(pageContext, validationMessages);
        List<ValidationRule> validationRuleList = form.getPaymentDetails().getCountry().getPaymentDetailsValidationRules();
        ValidationRule validationRule = validationRuleList.get(0);

        assertThat(validationRule.getType(), equalTo(ValidationRuleType.REGEX));
        assertThat(validationRule.getValue(), equalTo(Country.COUNTRY_REGEX));
        assertThat(validationRule.getMessage(), equalTo(FAKE_COUNTRY_INVALID_REGEX));
    }

    @Test
    public void formSubmittedWithValidCountry() throws Exception {
        when(request.getParameter(PaymentDetails.COUNTRY_FIELD)).thenReturn(GB_COUNTRY_CODE);

        PaymentDetailsForm form = PaymentDetailsForm.submittedForm(request, validationMessages);
        assertThat(form.getPaymentDetails().getCountry().getCode(), equalTo(GB_COUNTRY_CODE));
        assertThat(form.getPaymentDetails().validate().isEmpty(), equalTo(true));
    }

    //    @Test
//    public void returnCountryWhenFormSubmitted() throws Exception {
//
//    }
//
//    @Test
//    public void returnAllCountryValidationRulesForJS() throws Exception {
//
//    }
//
//    @Test
//    public void returnCountryWithValidationErrors() throws Exception {
//
//
//    }


}
