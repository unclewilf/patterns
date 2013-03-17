package adapter;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class FormServletTest {

    public static final String FAKE_FROM_URL = "/FROM/URL";

    private SlingHttpServletRequest request = mock(SlingHttpServletRequest.class);
    private SlingHttpServletResponse response = mock(SlingHttpServletResponse.class);
    private Form form = mock(Form.class);
    private FormSession formSession = mock(FormSession.class);
    private Validation validation = mock(Validation.class);

    private FormServlet servlet;

    @Before
    public void setUp() throws Exception {
        servlet = new FormServlet(){
            @Override
            protected Form getForm(SlingHttpServletRequest request) {
                return form;
            }

            @Override
            protected FormSession getFormSession() {
                return formSession;
            }
        };
    }

    @Test
    public void formFailsValidation_redirectsToOriginalLocationWithErrorsInSession() throws Exception {
        when(request.getParameter(FormServlet.FROM_URL)).thenReturn(FAKE_FROM_URL);
        when(form.getValidation()).thenReturn(validation);
        when(validation.hasErrors()).thenReturn(false);

        servlet.doPost(request, response);

        verify(formSession).save(form);
        verify(response).sendRedirect(FAKE_FROM_URL);
    }

}
