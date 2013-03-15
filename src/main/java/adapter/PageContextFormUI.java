package adapter;

import javax.servlet.jsp.PageContext;

public class PageContextFormUI implements FormUI {

    private PageContext pageContext;

    public PageContextFormUI(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    @Override
    public String getCountryLabel() {
        return getStringAttribute(COUNTRY_LABEL);
    }

    @Override
    public String getCountryRegex() {
        return getStringAttribute(COUNTRY_REGEX);
    }

    private String getStringAttribute(String attribute) {
        return (String) pageContext.getAttribute(attribute);
    }

}
