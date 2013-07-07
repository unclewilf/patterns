package hexagonal;

import com.google.common.collect.Iterables;
import hexagonal.application.EmployeeRepository;
import hexagonal.domain.Employee;
import hexagonal.interfaces.FileReadingEmployeeRepository;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FilterEmployeesWithBirthdayTodayTest {

    private EmployeeRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = new FileReadingEmployeeRepository("/employees.txt");
    }

    @Test
    public void onlyEmployeesWithBirthdayFiltered() throws Exception {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy/MM/dd");

        Iterable<Employee> employees = repository.employeesWithBirthdayRetrieved(fmt.parseDateTime("2020/10/08"), null);

        assertThat(Iterables.size(employees), is(equalTo(1)));
    }

}
