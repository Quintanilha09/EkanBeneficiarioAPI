package com.ecan.teste.exception;

public class BeneficiarioNotFoundException extends RuntimeException{

    public BeneficiarioNotFoundException(String message) {
        super(message);
    }

    public BeneficiarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
