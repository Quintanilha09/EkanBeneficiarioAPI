package com.ecan.teste.exception;

public class BeneficiarioCadastroException extends RuntimeException{

    public BeneficiarioCadastroException(String message) {
        super(message);
    }

    public BeneficiarioCadastroException(String message, Throwable cause) {
        super(message, cause);
    }
}
