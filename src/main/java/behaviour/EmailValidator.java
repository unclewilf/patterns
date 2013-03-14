package behaviour;

import org.springframework.util.StringUtils;

public class EmailValidator {
    private final Form form;

    public EmailValidator(Form form) {
        this.form = form;
    }

    public void validateEmail(ValidationInfo validationInfo) {
        if (StringUtils.isEmpty(form.getEmail())) {
            validationInfo.addError(Form.EMAIL_KEY, form.getValidationMessages().getEmailMissing());
        } else {
            if (!form.getEmail().contains("@")) {
                validationInfo.addError(Form.EMAIL_KEY, form.getValidationMessages().getEmailInvalid());
            }
        }
    }
}