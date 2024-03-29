package com.cipfpmislata.modding.common.http.errors;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ErrorMessage {
    private final String message;
    private final int code;

    public ErrorMessage(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
