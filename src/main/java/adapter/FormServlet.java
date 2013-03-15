package adapter;

import com.sun.deploy.security.SessionCertStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormServlet extends HttpServlet {

    public static final String FROM_URL = "fromURL";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Form form = getForm(req);
        if (!form.isValid()) {
            getFormSession().save(form);
            resp.sendRedirect(req.getParameter(FROM_URL));
        }
    }

    protected Form getForm(HttpServletRequest request) {
        return new HttpRequestForm(request);
    };

    protected FormSession getFormSession() {
        return new FormSession() {
            @Override
            public void save(Form form) {
                //do nothing
            }
        };
    }
}
