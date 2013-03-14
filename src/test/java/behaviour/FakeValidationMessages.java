package behaviour;

class FakeValidationMessages implements ValidationMessages {

    public static final String EMAIL_MISSING = "EMAIL_MISSING";
    public static final String EMAIL_INVALID = "EMAIL_INVALID";

    @Override
    public String getEmailMissing() {
        return EMAIL_MISSING;
    }

    @Override
    public String getEmailInvalid() {
        return EMAIL_INVALID;
    }
}
