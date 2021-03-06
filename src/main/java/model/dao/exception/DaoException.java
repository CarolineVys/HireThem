package model.dao.exception;

import exception.ProjectException;

public class DaoException extends ProjectException {
    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Exception maskedException) {
        super(message, maskedException);
    }
}
