package adapter;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FormServletTest {

    public static final String FROM_URL = "/FROM/URL";
    private MockHttpServletRequest request = new MockHttpServletRequest();
    private MockHttpServletResponse response = new MockHttpServletResponse();
    private FormServlet servlet;
    private Form form = mock(Form.class);
    private FormSession formSession = mock(FormSession.class);

    @Before
    public void setUp() throws Exception {
        servlet = new FormServlet(){
            @Override
            protected Form getForm(HttpServletRequest request) {
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
        request.setParameter(FormServlet.FROM_URL, FROM_URL);
        Validation validation = mock(Validation.class);

        when(form.getValidation()).thenReturn(validation);
        when(validation.hasErrors()).thenReturn(false);

        servlet.doPost(request, response);

        assertThat(response.getRedirectedUrl(), equalTo(FROM_URL));

        verify(formSession).save(form);
    }


}
