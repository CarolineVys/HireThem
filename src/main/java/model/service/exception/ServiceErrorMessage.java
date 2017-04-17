package model.service.exception;

public class ServiceErrorMessage {

    public static final String ENCTYPTION_EXCEPTION = "Unable to perform encryption";

    public static final String WRONG_PASSWORD = "Wrong email or password";

    public static final String WRONG_EMAIL = WRONG_PASSWORD;

    public static final String EMAIL_IS_REGISTERED = "User with this credentials is already registered";

    public static final String USER_NOT_FOUND = "User with this credentials does not exist";

    public static final String COOKIE_NOT_FOUND = "The cookie is not set";

}
