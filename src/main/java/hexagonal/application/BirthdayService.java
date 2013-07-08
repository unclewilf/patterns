package hexagonal.application;

import org.joda.time.DateTime;

public interface BirthdayService {
    void emailSentToEmployeesWithBirthday(DateTime today);
}
