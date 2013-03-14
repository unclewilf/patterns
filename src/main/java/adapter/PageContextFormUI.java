package adapter;

import javax.servlet.jsp.PageContext;

public class PageContextFormUI implements FormUI {

    private PageContext pageContext;

    public PageContextFormUI(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    @Override
    public String getCountryLabel() {
        return (String) pageContext.getAttribute(FormUI.COUNTRY_LABEL);
    }

    @Override
    public String getCountryRegex() {
        return (String) pageContext.getAttribute(FormUI.COUNTRY_REGEX);
    }

}
