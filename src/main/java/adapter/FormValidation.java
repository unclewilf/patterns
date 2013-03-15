package adapter;

import java.util.HashMap;
import java.util.Map;

public class FormValidation implements Validation {

    private Form form;
    private FormErrorMessages errorMessages;

    public FormValidation(Form form, FormErrorMessages errorMessages) {
        this.form = form;
        this.errorMessages = errorMessages;
    }

    @Override
    public boolean hasErrors() {
        return validate().isEmpty();
    }

    @Override
    public Map<String, String> validate() {
        Map<String, String> errors = new HashMap<String, String>();
        return errors;
    }

    @Override
    public FormErrorMessages errorMessages() {
        return errorMessages;
    }
}
