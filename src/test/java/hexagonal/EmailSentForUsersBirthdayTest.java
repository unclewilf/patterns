package hexagonal;

import com.dumbster.smtp.SimpleSmtpServer;
import hexagonal.application.EmailService;
import hexagonal.application.EmployeeRepository;
import hexagonal.interfaces.FakeEmailService;
import hexagonal.interfaces.FileReadingEmployeeRepository;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EmailSentForUsersBirthdayTest {

    private EmployeeRepository repository = new FileReadingEmployeeRepository("/employees.txt");
    private EmailService emailService = new FakeEmailService();
    private SimpleSmtpServer smtpServer;

    @Before
    public void setUp() throws Exception {
        smtpServer = SimpleSmtpServer.start(8099);
    }

    @Test
    public void emailSentForUsersBirthday() throws Exception {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy/MM/dd");

        repository.employeesWithBirthdayEmailed(fmt.parseDateTime("2020/10/08"), emailService);

        assertThat(smtpServer.getReceivedEmailSize(), is(equalTo(1)));
    }

    @After
    public void tearDown() throws Exception {
        smtpServer.stop();
    }

}
