package validator;

import java.util.List;

public interface PaymentDetailsValidator {
    List<ValidationRule> getPaymentDetailsValidationRules();

    List<ValidationError> validateForPaymentDetails();
}
