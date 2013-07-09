package hexagonal;

import com.dumbster.smtp.SimpleSmtpServer;
import com.google.common.collect.Lists;
import hexagonal.application.BirthdayService;
import hexagonal.application.EmailService;
import hexagonal.application.EmployeeRepository;
import hexagonal.domain.Employee;
import hexagonal.interfaces.BirthdayServiceImpl;
import hexagonal.interfaces.FakeEmailService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmailSentForUsersBirthdayTest {

    private EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    private EmailService emailService = new FakeEmailService();
    private SimpleSmtpServer smtpServer;

    private DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy/MM/dd");
    private DateTime today = fmt.parseDateTime("2020/10/08");

    @Before
    public void setUp() throws Exception {
        smtpServer = SimpleSmtpServer.start(8099);
    }

    @Test
    public void emailSentForUsersBirthday() throws Exception {
        BirthdayService birthdayService = new BirthdayServiceImpl(employeeRepository, emailService);

        when(employeeRepository.employeesWithBirthday(today)).thenReturn(getFakeEmployees());
        birthdayService.emailSentToEmployeesWithBirthday(today);

        assertThat(smtpServer.getReceivedEmailSize(), is(equalTo(1)));
    }

    private ArrayList<Employee> getFakeEmployees() {
        Employee employee = new Employee();
        employee.setDateOfBirth(today);
        employee.setEmail("test@test.com");
        employee.setFirstName("john");
        employee.setLastName("doe");
        return Lists.newArrayList(employee);
    }

    @After
    public void tearDown() throws Exception {
        smtpServer.stop();
    }

}
