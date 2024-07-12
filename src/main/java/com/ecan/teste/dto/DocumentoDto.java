package com.ecan.teste.dto;

import com.ecan.teste.model.TipoDocumentoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DocumentoDto(

        @NotBlank
        TipoDocumentoEnum tipoDocumento,

        @Size(max = 50, message = "O documento pode ter no máximo 50 caracteres")
        String descricao

) {
}
