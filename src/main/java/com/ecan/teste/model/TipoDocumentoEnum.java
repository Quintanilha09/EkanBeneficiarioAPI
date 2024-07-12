package com.ecan.teste.model;

public enum TipoDocumentoEnum {

    CPF,
    CNPJ,
    RG,
    PASSAPORTE;

    @Override
    public String toString() {
        return name();
    }
}
