package com.ecan.teste.controller;

import com.ecan.teste.dto.BeneficiarioDto;
import com.ecan.teste.dto.DocumentoDto;
import com.ecan.teste.model.BeneficiarioModel;
import com.ecan.teste.model.DocumentoModel;
import com.ecan.teste.service.BeneficiarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class BeneficiarioController {

    @Autowired
    BeneficiarioService beneficiarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrarBeneficiario(@RequestBody BeneficiarioDto beneficiarioDto) {
            var beneficiarioModel = new BeneficiarioModel();
            BeanUtils.copyProperties(beneficiarioDto, beneficiarioModel);

            if (beneficiarioDto.documentoDto() != null) {
                Set<DocumentoModel> listaDocumentoModel = new HashSet<>();
                for (DocumentoDto documentoDto: beneficiarioDto.documentoDto()) {
                    DocumentoModel documentoModel = new DocumentoModel();
                    BeanUtils.copyProperties(documentoDto, documentoModel);
                    listaDocumentoModel.add(documentoModel);
                }
                beneficiarioModel.setDocumento(listaDocumentoModel);
            }

            beneficiarioService.save(beneficiarioModel);
            return ResponseEntity.ok().build();
    }

    @RequestMapping("/")
    public String teste() {
        return "TESTANDOOO";
    }

}
