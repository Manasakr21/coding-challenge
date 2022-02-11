package com.poker.exception;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(
                             final String errorMessage
    ) {
        super(errorMessage);
    }

    public PokerExceptionTypeEnum getExceptionType() {
        return PokerExceptionTypeEnum.RESOURCE_NOT_FOUND;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
