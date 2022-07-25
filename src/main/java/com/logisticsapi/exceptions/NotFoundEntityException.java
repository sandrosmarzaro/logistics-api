package com.logisticsapi.exceptions;

public class NotFoundEntityException extends DomainException{
    public NotFoundEntityException(String message) {
        super(message);
    }
}
