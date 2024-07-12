package com.ecan.teste.controller;

import com.ecan.teste.dto.*;
import com.ecan.teste.model.BeneficiarioModel;
import com.ecan.teste.model.DocumentoModel;
import com.ecan.teste.service.BeneficiarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {

    @Autowired
    BeneficiarioService beneficiarioService;

    @Operation(summary = "Cadastra um beneficiário", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Beneficiário cadastrado com sucesso"),
            @ApiResponse(responseCode = "201", description = "Created - Beneficiário cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request - Requisição inválida, verifique os dados enviados"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error - Erro interno no servidor")
    })
    @PostMapping(value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> cadastrarBeneficiario(@RequestBody @Valid DadosSalvarBeneficiario dadosSalvarBeneficiario) {
            var beneficiarioModel = new BeneficiarioModel();
            BeanUtils.copyProperties(dadosSalvarBeneficiario, beneficiarioModel);

            if (dadosSalvarBeneficiario.dadosSalvarDocumento() != null) {
                List<DocumentoModel> listaDocumentoModel = new ArrayList<>();
                for (DadosSalvarDocumento dadosSalvarDocumento : dadosSalvarBeneficiario.dadosSalvarDocumento()) {
                    DocumentoModel documento = new DocumentoModel();
                    BeanUtils.copyProperties(dadosSalvarDocumento, documento);
                    listaDocumentoModel.add(documento);
                }
                beneficiarioModel.setDocumento(listaDocumentoModel);
            }

            String mensagem = beneficiarioService.save(beneficiarioModel);
            return ResponseEntity.ok(mensagem);
    }

    @Operation(summary = "Lista todos os beneficiários")
    @ApiResponse(responseCode = "200", description = "OK - Lista de beneficiários retornada com sucesso")
    @GetMapping("/listar")
    public ResponseEntity<List<DadosListagemBeneficiario>> listarBeneficiarios(Pageable paginacao) {
        List<DadosListagemBeneficiario> beneficiarios = beneficiarioService.listarTodos(paginacao);
        return ResponseEntity.ok(beneficiarios);
    }

    @Operation(summary = "Lista todos os documentos de um beneficiário")
    @ApiResponse(responseCode = "200", description = "OK - Lista de documentos do beneficiário retornada com sucesso")
    @GetMapping("/documentos/{id}")
    public ResponseEntity<List<DadosListagemDocumento>> listarDocumentosPorBeneficiario(@PathVariable Long id) {
        List<DadosListagemDocumento> documentos = beneficiarioService.listarDocumentosPorBeneficiario(id);
        return ResponseEntity.ok(documentos);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarBeneficiario(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoBeneficiario dadosAtualizacaoBeneficiario) {

        String mensagem = beneficiarioService.atualizarBeneficiario(id, dadosAtualizacaoBeneficiario);
        return ResponseEntity.ok(mensagem);
    }

    @Operation(summary = "Remove um beneficiário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Beneficiário removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Not Found - Beneficiário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error - Erro interno no servidor")
    })
    @DeleteMapping("/excluir/{beneficiarioId}")
    public ResponseEntity<String> removerBeneficiario(@PathVariable Long beneficiarioId) {
        String mensagem = beneficiarioService.removerBeneficiario(beneficiarioId);
        return ResponseEntity.ok(mensagem);
    }

}
