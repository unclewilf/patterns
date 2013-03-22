package validator;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import javax.servlet.jsp.PageContext;

public class PaymentDetailsForm {

    private PaymentDetails paymentDetails;
    private PaymentDetailsUI paymentDetailsUI;

    private PaymentDetailsForm(PaymentDetails paymentDetails, PaymentDetailsUI paymentDetailsUI) {
        this.paymentDetails = paymentDetails;
        this.paymentDetailsUI = paymentDetailsUI;
    }

    public static PaymentDetailsForm emptyForm(PageContext pageContext, PaymentDetailsValidationMessages validationMessages) {
        ValueMap properties = (ValueMap) pageContext.getAttribute("properties");
        PaymentDetailsUI paymentDetailsUI = new PaymentDetailsUI(properties);
        PaymentDetails paymentDetails = new PaymentDetails(validationMessages);
        return new PaymentDetailsForm(paymentDetails, paymentDetailsUI);
    }

    public static PaymentDetailsForm submittedForm(SlingHttpServletRequest request, PaymentDetailsValidationMessages validationMessages) {
        ValueMap properties = request.getResource().adaptTo(ValueMap.class);
        PaymentDetailsUI paymentDetailsUI = new PaymentDetailsUI(properties);
        PaymentDetails paymentDetails = new PaymentDetails(request, validationMessages);
        return new PaymentDetailsForm(paymentDetails, paymentDetailsUI);
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public PaymentDetailsUI getPaymentDetailsUI() {
        return paymentDetailsUI;
    }

}
