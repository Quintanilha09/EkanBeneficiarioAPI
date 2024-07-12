package com.ecan.teste.dto;

import java.util.Date;

public record DadosListagemBeneficiario(

        String nome,
        String telefone,
        String dataNascimento,
        Date dataInclusao,
        Date dataAtualizacao

) {
}
