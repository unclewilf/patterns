package adapter;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import javax.servlet.ServletException;
import java.io.IOException;

public class PaymentFormServlet extends SlingAllMethodsServlet {

    public static final String FROM_URL = "fromURL";

    @Override
    protected void doPost(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws ServletException, IOException {
        Payment payment = getForm(req);
        Validation validation = payment.getValidation();
        if (!validation.hasErrors()) {
            getFormSession().save(payment);
            resp.sendRedirect(req.getParameter(FROM_URL));
        }
    }

    protected Payment getForm(SlingHttpServletRequest request) {
        return new SlingHttpRequestPayment(request);
    }

    protected FormSession getFormSession() {
        return new FormSession() {
            @Override
            public void save(Payment payment) {
                //do nothing
            }
        };
    }
}
