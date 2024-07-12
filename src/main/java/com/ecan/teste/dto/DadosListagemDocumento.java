package com.ecan.teste.dto;

import com.ecan.teste.model.TipoDocumentoEnum;

import java.util.Date;

public record DadosListagemDocumento(

        TipoDocumentoEnum dipoDocumento,
        String descricao,
        Date dataInclusao,
        Date dataAtualizacao

) {
}
