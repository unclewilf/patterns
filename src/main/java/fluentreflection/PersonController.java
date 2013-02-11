package fluentreflection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonController {

    @Autowired
    private FluentPersonFactory fluentPersonFactory;

    public String handle() {
        Person person = fluentPersonFactory.firstName("uncle").lastName("bob").age(68).inactive().create();
        return person.isNamed();
    }

    public void setFluentPersonFactory(FluentPersonFactory fluentPersonFactory) {
        this.fluentPersonFactory = fluentPersonFactory;
    }
}
