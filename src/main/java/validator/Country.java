package validator;

import java.util.ArrayList;
import java.util.List;

public class Country implements PaymentDetailsValidator, YourNewValidatorGoesHere {

    public static final String COUNTRY_REGEX = "^[a-z]*$";

    private PaymentDetailsValidationMessages validationMessages;

    private String country;

    public Country(PaymentDetailsValidationMessages validationMessages) {
        this.validationMessages = validationMessages;
    }

    public Country(String country, PaymentDetailsValidationMessages validationMessages) {
        this.country = country;
        this.validationMessages = validationMessages;
    }

    public String getCode() {
        return country;
    }

    @Override
    public List<ValidationRule> getPaymentDetailsValidationRules() {
        List<ValidationRule> validationRules = new ArrayList<ValidationRule>();
        validationRules.add(new ValidationRule(ValidationRuleType.REGEX, COUNTRY_REGEX, validationMessages.getCountryInvalidRegex()));
        return validationRules;
    }

    @Override
    public List<ValidationError> validateForPaymentDetails() {
        return new ArrayList<ValidationError>();
    }
}
