package fluent.fluentreflection;

import com.google.common.base.Joiner;

public class CreatePersonException extends RuntimeException {

    private static final String EXCEPTION_MESSAGE = "Each of the following missing parameters must be provided: %s.";

    public CreatePersonException(Iterable<String> params) throws CreatePersonException {
        super(String.format(EXCEPTION_MESSAGE, Joiner.on(", ").join(params)));
    }

}

