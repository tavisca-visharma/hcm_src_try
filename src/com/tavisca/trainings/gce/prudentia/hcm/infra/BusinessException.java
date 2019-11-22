package com.tavisca.trainings.gce.prudentia.hcm.infra;

public class BusinessException extends Exception {
    private int code;
    private String cause;

    public BusinessException(int code, String cause) {
        super(code + " - " + cause);
        this.code = code;
        this.cause = cause;
    }
}
