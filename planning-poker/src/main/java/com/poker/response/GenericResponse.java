package com.poker.response;

public class GenericResponse {

    private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "GenericResponse [msg=" + msg + "]";
	}
    
    

}
