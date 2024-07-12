package com.ecan.teste.exception;

public class BeneficiarioException extends RuntimeException{

    public BeneficiarioException(String message) {
        super(message);
    }

    public BeneficiarioException(String message, Throwable cause) {
        super(message, cause);
    }
}
