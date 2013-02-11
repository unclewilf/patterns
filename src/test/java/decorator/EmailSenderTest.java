package decorator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmailSenderTest {

    private EmailSender emailSender = new EmailSender();

    @Test
    public void sendExternalEmail() throws Exception {
        Email email = new EmailImpl("the message");
        assertEquals("the message Company Disclaimer", emailSender.sendEmail(email));
    }

    @Test
    public void sendSecureEmail() throws Exception {
        Email email = new EmailImpl("the message");
        assertEquals("the message Secure", emailSender.sendSecureEmail(email));
    }

}
