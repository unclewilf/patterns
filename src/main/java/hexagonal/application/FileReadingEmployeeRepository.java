package hexagonal.application;

import hexagonal.adapters.EmployeeFileDateFormatter;
import hexagonal.domain.Employee;
import hexagonal.domain.EmployeeRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReadingEmployeeRepository implements EmployeeRepository {

    public static final int LAST_NAME_PART = 0;
    public static final int FIRST_NAME_PART = 1;
    public static final int DOB_PART = 2;
    public static final int EMAIL_PART = 3;
    private final String filename;

    public FileReadingEmployeeRepository(String filename) {
        this.filename = filename;
    }

    @Override
    public Iterable<Employee> employeesRetrieved() {
        List<Employee> employees = new ArrayList<Employee>();

        List<String> fileEntries = readFile();
        for (String fileEntry : fileEntries) {
            employees.add(createEmployee(fileEntry));
        }

        return employees;
    }

    private Employee createEmployee(String fileEntry) {
        String[] parts = fileEntry.split(", ");

        Employee employee = new Employee();
        employee.setLastName(parts[LAST_NAME_PART]);
        employee.setFirstName(parts[FIRST_NAME_PART]);
        employee.setDateOfBirth(new EmployeeFileDateFormatter().getDateTime(parts[DOB_PART]));
        employee.setEmail(parts[EMAIL_PART]);
        return employee;
    }

    private List<String> readFile() {
        List<String> fileEntries = new ArrayList<String>();
        try {
            InputStream stream = getClass().getResourceAsStream(filename);

            InputStreamReader isr = new InputStreamReader(stream);
            BufferedReader ir = new BufferedReader(isr);
            String line = null;
            while ((line = ir.readLine()) != null) {
                fileEntries.add(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return fileEntries;
    }

}
