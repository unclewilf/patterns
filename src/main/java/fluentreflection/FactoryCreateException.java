package fluentreflection;

public class FactoryCreateException extends RuntimeException{

    public FactoryCreateException() {
        super("Error creating class with factory");
    }

}
