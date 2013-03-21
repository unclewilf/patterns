package validator;

import org.apache.sling.api.SlingHttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class PaymentDetails {

    private Country country;

    private List<ValidationError> validationErrors = new ArrayList<ValidationError>();

    public PaymentDetails(PaymentDetailsValidationMessages validationMessages) {
        this.country = new Country(validationMessages);
    }

    public PaymentDetails(SlingHttpServletRequest request, PaymentDetailsValidationMessages validationMessages) {
        this.country = new Country(request.getParameter(Country.COUNTRY_FIELD), validationMessages);
    }

    public Country getCountry() {
        return country;
    }

    public List<ValidationError> validate() {
        validationErrors.addAll(country.validate());
        return validationErrors;
    }
}
