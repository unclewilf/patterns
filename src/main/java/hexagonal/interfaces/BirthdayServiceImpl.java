package hexagonal.interfaces;

import hexagonal.application.BirthdayService;
import hexagonal.application.EmailService;
import hexagonal.application.EmployeeRepository;
import hexagonal.domain.Employee;
import org.joda.time.DateTime;

public class BirthdayServiceImpl implements BirthdayService {

    private final EmployeeRepository repository;
    private final EmailService emailService;

    public BirthdayServiceImpl(EmployeeRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    @Override
    public void emailSentToEmployeesWithBirthday(DateTime today) {
        for (Employee employee : repository.employeesWithBirthday(today)) {
            emailService.emailSent();
        }
    }

}
