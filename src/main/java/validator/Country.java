package validator;

import java.util.ArrayList;
import java.util.List;

public class Country implements Validator {

    protected static final String COUNTRY_FIELD = "country";
    public static final String COUNTRY_REGEX = "^[a-z]*$";

    private CountryValidationMessages validationMessages;

    private String country;

    public Country(CountryValidationMessages validationMessages) {
        this.validationMessages = validationMessages;
    }

    public Country(String country, CountryValidationMessages validationMessages) {
        this.country = country;
        this.validationMessages = validationMessages;
    }

    public String getCode() {
        return country;
    }

    @Override
    public List<ValidationRule> getValidationRules() {
        List<ValidationRule> validationRules = new ArrayList<ValidationRule>();
        validationRules.add(new ValidationRule(ValidationRuleType.REGEX, COUNTRY_REGEX, validationMessages.getCountryInvalidRegex()));
        return validationRules;
    }

    @Override
    public List<ValidationError> validate() {
        List<ValidationError> validationErrors = new ArrayList<ValidationError>();
        if (!country.matches(COUNTRY_REGEX)) {
            validationErrors.add(new ValidationError(COUNTRY_FIELD, validationMessages.getCountryInvalidRegex()));
        }
        return validationErrors;
    }
}
