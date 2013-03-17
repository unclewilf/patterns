package adapter;

import org.apache.sling.api.resource.ValueMap;

public class FormErrorMessages {

    public static final String COUNTRY_REGEX_INVALID = "countryRegexInvalid";

    private ValueMap valueMap;

    public FormErrorMessages(ValueMap valueMap) {
        this.valueMap = valueMap;
    }

    public String getCountryRegexInvalid() {
        return valueMap.get(COUNTRY_REGEX_INVALID, String.class);
    }

}
