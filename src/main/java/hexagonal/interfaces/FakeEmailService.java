package hexagonal.interfaces;

import hexagonal.application.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class FakeEmailService implements EmailService {

    JavaMailSender mailSender = new JavaMailSenderImpl(){
        @Override
        public int getPort() {
            return 8099;
        }
    };

    @Override
    public void emailSent() {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("test@test.com");
            helper.setTo("test@test.com");
            helper.setSubject("subject of message");
            helper.setText("content of message");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(mimeMessage);
    }

}
