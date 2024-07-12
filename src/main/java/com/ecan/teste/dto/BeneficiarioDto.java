package com.ecan.teste.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

public record BeneficiarioDto(

        @NotBlank
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String nome,

        @Pattern(regexp = "\\d{11}", message = "O telefone deve conter exatamente 11 números")
        String telefone,

        @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "A data de nascimento deve estar no formato yyyy-MM-dd")
        String dataNascimento,

        List<DocumentoDto> documentoDto

) {
}
