package com.coding.movie.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class Error implements Serializable {

    private static final long serialVersionUID = -5926114245931925376L;
    private int errorCode;
    private HttpStatus errorStatus;
    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public HttpStatus getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(HttpStatus errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
