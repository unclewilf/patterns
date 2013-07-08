package hexagonal.application;

import hexagonal.domain.Employee;
import org.joda.time.DateTime;

public interface EmployeeRepository {
    Iterable<Employee> employeesRetrieved();

    Iterable<Employee> employeesWithBirthdayEmailed(DateTime today, EmailService emailService);
}
