package validator;

public class ValidationRule {

    private ValidationRuleType validationRuleType;
    private String value;
    private String message;

    public ValidationRule(ValidationRuleType validationRuleType, String value, String message) {
        this.validationRuleType = validationRuleType;
        this.value = value;
        this.message = message;
    }

    public ValidationRuleType getType() {
        return validationRuleType;
    }

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
