package az.atl.customer.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
