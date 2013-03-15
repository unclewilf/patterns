package adapter;

import java.util.Map;

public interface Validation {

    String COUNTRY_REGEX_FAILED = "countryRegex";

    boolean hasErrors();

    Map<String, String> validate();

    FormErrorMessages errorMessages();
}
