package adapter;

public class FormValidation implements Validation {

    private Form form;

    public FormValidation(Form form) {
        this.form = form;
    }

    @Override
    public boolean hasErrors() {
        return false;
    }
}
