package com.poker.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ErrorModel implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -2740584172355592906L;
	private final int code;
    private final String message;
    private final String param;
    
   

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getParam() {
		return param;
	}

	public ErrorModel(
                      final int errorCode, final String message, final String param
    ) {
        this.code = errorCode;
        this.message = message;
        this.param = param;
    }

    @Override
    public String toString() {
        return "ErrorModel [" +
            "code=" + code +
            ", message=" + message +
            ", param=" + param +
            "]";
    }

}
