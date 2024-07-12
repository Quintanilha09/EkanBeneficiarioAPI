package com.ecan.teste.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoBeneficiario(
        @NotBlank
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String nome,

        @Pattern(regexp = "\\d{11}", message = "O telefone deve conter exatamente 11 números (exemplo: 11985697411")
        String telefone,

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "A data de nascimento deve estar no formato dd/MM/yyyy")
        String dataNascimento
) {

}
