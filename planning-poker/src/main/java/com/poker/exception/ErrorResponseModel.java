package com.poker.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ErrorResponseModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3061070023173817799L;
	private final List<ErrorModel> errors = new ArrayList<>();

    public ErrorResponseModel() {
    }

    public ErrorResponseModel(
                              final PokerExceptionTypeEnum code, final String message
    ) {
        addError(code, message);
    }

    public ErrorResponseModel(
                              final List<ErrorModel> errors
    ) {
        this.errors.addAll(errors);
    }

    public List<ErrorModel> getErrors() {
        return errors;
    }

    public void addError(
        final PokerExceptionTypeEnum code, final String message
    ) {
        addError(code, message, null);
    }

    public void addError(
        final PokerExceptionTypeEnum code,
        final String message,
        final String param
    ) {
        this.addError(new ErrorModel(code.getCode(), message, param));
    }

    public void addError(
        final ErrorModel error
    ) {
        this.errors.add(error);
    }

    @Override
    public String toString() {
        return "ErrorResponseModel [errors=" + errors + "]";
    }

}
