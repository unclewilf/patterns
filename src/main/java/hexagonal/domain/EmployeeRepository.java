package hexagonal.domain;

public interface EmployeeRepository {
    Iterable<Employee> employeesRetrieved();
}
