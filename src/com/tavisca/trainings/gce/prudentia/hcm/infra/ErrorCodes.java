package com.tavisca.trainings.gce.prudentia.hcm.infra;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodes {
    private static ErrorCodes instance;
    private Map<Integer, String> errorCodeToMessageMap;

    private ErrorCodes() {
        errorCodeToMessageMap = new HashMap<>();
    }

    public ErrorCodes getInstance() {
        if (instance == null)
            instance = new ErrorCodes();
        return instance;
    }

    public String getErrorMessage(int errorCode) {
        String errorMessage = errorCodeToMessageMap.get(errorCode);
        return errorMessage != null ? errorMessage : "Unknown error";
    }
}
