package adapter;

import java.util.Map;

public interface Validation {

    boolean hasErrors();

    Map<String, String> validate();

    FormErrorMessages errorMessages();
}
