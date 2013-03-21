package adapter;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import javax.servlet.ServletException;
import java.io.IOException;

public class PaymentFormServlet extends SlingAllMethodsServlet {

    public static final String FROM_URL = "fromURL";

    @Override
    protected void doPost(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws ServletException, IOException {
        PaymentForm form = getForm(req);
//        Validation validation = form.getBooking().getValidation();
//        if (!validation.hasErrors()) {
//            getFormSession().save(form);
//            resp.sendRedirect(req.getParameter(FROM_URL));
//        }
    }

    protected PaymentForm getForm(SlingHttpServletRequest request) {
        SubmittedPaymentForm paymentForm = new SubmittedPaymentForm(new SlingHttpRequestPayment(request), new SlingPaymentFormUI(getValueMap(request), new SlingFormErrorMessages(getValueMap(request))));
        return paymentForm;
    }

    private ValueMap getValueMap(SlingHttpServletRequest request) {
        return request.getResource().adaptTo(ValueMap.class);
    }

    protected FormSession getFormSession() {
        return new FormSession() {
            @Override
            public void save(PaymentForm payment) {
            }
        };
    }
}
