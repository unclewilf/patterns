package validator;

import java.util.List;

public interface Validator {

    List<ValidationRule> getValidationRules();

    List<ValidationError> validate();

}
