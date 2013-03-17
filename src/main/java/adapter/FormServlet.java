package adapter;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import javax.servlet.ServletException;
import java.io.IOException;

public class FormServlet extends SlingAllMethodsServlet {

    public static final String FROM_URL = "fromURL";

    @Override
    protected void doPost(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws ServletException, IOException {
        Form form = getForm(req);
        Validation validation = form.getValidation();
        if (!validation.hasErrors()) {
            getFormSession().save(form);
            resp.sendRedirect(req.getParameter(FROM_URL));
        }
    }

    protected Form getForm(SlingHttpServletRequest request) {
        return new SlingHttpRequestForm(request);
    }

    protected FormSession getFormSession() {
        return new FormSession() {
            @Override
            public void save(Form form) {
                //do nothing
            }
        };
    }
}
