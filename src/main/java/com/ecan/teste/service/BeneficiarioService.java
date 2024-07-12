package com.ecan.teste.service;

import com.ecan.teste.exception.BeneficiarioException;
import com.ecan.teste.model.BeneficiarioModel;
import com.ecan.teste.model.DocumentoModel;
import com.ecan.teste.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class BeneficiarioService {

    @Autowired
    BeneficiarioRepository beneficiarioRepository;

    @Transactional
    public void save(BeneficiarioModel beneficiarioModel) {
        try {
            Date now = new Date();
            beneficiarioModel.setDataInclusao(now);
            beneficiarioModel.setDataAtualizacao(now);

            if (beneficiarioModel.getDocumento() != null) {
                for (DocumentoModel documentoModel : beneficiarioModel.getDocumento()) {
                    documentoModel.setDataInclusao(now);
                    documentoModel.setDataAtualizacao(now);
                    documentoModel.setBeneficiario(beneficiarioModel);
                }
            }
            beneficiarioRepository.save(beneficiarioModel);
        } catch (Exception e) {
            throw new BeneficiarioException("Erro ao cadastrar beneficiario", e);
        }
    }

}
