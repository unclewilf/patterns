package behaviour;

public class Form {

    public static final String EMAIL_KEY = "email";
    private final EmailValidator emailValidator = new EmailValidator(this);

    private String email;
    private ValidationMessages validationMessages;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ValidationInfo validate() {
        ValidationInfo validationInfo = new ValidationInfo();
        emailValidator.validateEmail(validationInfo);

        return validationInfo;
    }

    private void validateEmail(ValidationInfo validationInfo) {
        emailValidator.validateEmail(validationInfo);
    }

    public ValidationMessages getValidationMessages() {
        return validationMessages;
    }

    public void setValidationMessages(ValidationMessages validationMessages) {
        this.validationMessages = validationMessages;
    }
}
