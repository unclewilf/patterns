package adapter;

import java.util.HashMap;
import java.util.Map;

public class FormValidation implements Validation {

    private Payment payment;
    private SlingFormErrorMessages errorMessages;

    public FormValidation(Payment payment, SlingFormErrorMessages errorMessages) {
        this.payment = payment;
        this.errorMessages = errorMessages;
    }

    @Override
    public boolean hasErrors() {
        return validate().size() > 0;
    }

    @Override
    public Map<String, String> validate() {
        Map<String, String> errors = new HashMap<String, String>();
        Country country = payment.getCountry();
        if(!country.getCountry().matches(country.getCountryRegex())) {
            errors.put(SlingFormErrorMessages.COUNTRY_REGEX_INVALID, errorMessages.getCountryRegexInvalid());
        }
        return errors;
    }

    @Override
    public FormErrorMessages errorMessages() {
        return errorMessages;
    }
}
