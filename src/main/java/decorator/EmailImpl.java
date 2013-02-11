package decorator;

public class EmailImpl implements Email {

    private String content;

    public EmailImpl(String content) {
        this.content = content;
    }

    @Override
    public String getContents() {
        return content;
    }

}
