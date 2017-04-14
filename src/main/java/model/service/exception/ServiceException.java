package model.service.exception;

import exception.ProjectException;

/**
 * Created by egors.
 */
public class ServiceException extends ProjectException {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Exception maskedException) {
        super(message, maskedException);
    }

    public ServiceException(Exception e) {
        super(e);
    }

}
