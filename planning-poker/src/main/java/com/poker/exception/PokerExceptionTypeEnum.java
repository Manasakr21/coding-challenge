package com.poker.exception;

/**
 * Contains exception enumerations used by VI services.
 */
public enum PokerExceptionTypeEnum {

    RESOURCE_NOT_FOUND(100),
    SERVICE_ERROR(111);

    private final int code;

    private PokerExceptionTypeEnum(
                                final int code
    ) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
