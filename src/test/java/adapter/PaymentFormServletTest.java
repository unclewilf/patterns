package adapter;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PaymentFormServletTest {

    public static final String FAKE_FROM_URL = "/FROM/URL";

    private SlingHttpServletRequest request = mock(SlingHttpServletRequest.class);
    private SlingHttpServletResponse response = mock(SlingHttpServletResponse.class);
    private Payment payment = mock(Payment.class);
    private FormSession formSession = mock(FormSession.class);
    private Validation validation = mock(Validation.class);

    private PaymentFormServlet servlet;

    @Before
    public void setUp() throws Exception {
        servlet = new PaymentFormServlet(){
            @Override
            protected Payment getForm(SlingHttpServletRequest request) {
                return payment;
            }

            @Override
            protected FormSession getFormSession() {
                return formSession;
            }
        };
    }

    @Test
    public void formFailsValidation_redirectsToOriginalLocationWithErrorsInSession() throws Exception {
        when(request.getParameter(PaymentFormServlet.FROM_URL)).thenReturn(FAKE_FROM_URL);
        when(payment.getValidation()).thenReturn(validation);
        when(validation.hasErrors()).thenReturn(false);

        servlet.doPost(request, response);

        verify(formSession).save(payment);
        verify(response).sendRedirect(FAKE_FROM_URL);
    }

}
