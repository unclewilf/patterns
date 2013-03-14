package behaviour;

import java.util.HashMap;
import java.util.Map;

public class ValidationInfo {

    private Map<String, String> errors = new HashMap<String, String>();

    public boolean hasErrors() {
        return errors.size() > 0;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void addError(String key, String value) {
        errors.put(key, value);
    }
}
