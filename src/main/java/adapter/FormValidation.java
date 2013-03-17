package adapter;

import java.util.HashMap;
import java.util.Map;

public class FormValidation implements Validation {

    private static final String COUNTRY_REGEX = "^[a-z]*$";

    private Form form;
    private FormErrorMessages errorMessages;

    public FormValidation(Form form, FormErrorMessages errorMessages) {
        this.form = form;
        this.errorMessages = errorMessages;
    }

    @Override
    public boolean hasErrors() {
        return validate().size() > 0;
    }

    @Override
    public Map<String, String> validate() {
        Map<String, String> errors = new HashMap<String, String>();
        if(!form.getCountry().matches(COUNTRY_REGEX)) {
            errors.put(FormErrorMessages.COUNTRY_REGEX_INVALID, errorMessages.getCountryRegexInvalid());
        }
        return errors;
    }

    @Override
    public FormErrorMessages errorMessages() {
        return errorMessages;
    }
}
