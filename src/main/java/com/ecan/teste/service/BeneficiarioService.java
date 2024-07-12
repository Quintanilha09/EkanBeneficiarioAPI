package com.ecan.teste.service;

import com.ecan.teste.dto.*;
import com.ecan.teste.exception.BeneficiarioCadastroException;
import com.ecan.teste.exception.BeneficiarioException;
import com.ecan.teste.exception.BeneficiarioNotFoundException;
import com.ecan.teste.model.BeneficiarioModel;
import com.ecan.teste.model.DocumentoModel;
import com.ecan.teste.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiarioService {

    @Autowired
    BeneficiarioRepository beneficiarioRepository;

    @Transactional
    public String save(BeneficiarioModel beneficiarioModel) {
        final String SUCESSO = "Sucesso ao cadastrar beneficiário";
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
            throw new BeneficiarioCadastroException("Erro ao cadastrar beneficiario", e);
        }
        return SUCESSO;
    }

    public List<DadosListagemBeneficiario> listarTodos(Pageable paginacao) {
        try {
            Page<BeneficiarioModel> page = beneficiarioRepository.findAll(paginacao);
            return page.getContent().stream()
                    .map(beneficiarioModel -> new DadosListagemBeneficiario(
                            beneficiarioModel.getNome(),
                            beneficiarioModel.getTelefone(),
                            beneficiarioModel.getDataNascimento(),
                            beneficiarioModel.getDataInclusao(),
                            beneficiarioModel.getDataAtualizacao()
                    ))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new BeneficiarioException("Erro ao listar todos os beneficiarios", e);
        }

    }

    public List<DadosListagemDocumento> listarDocumentosPorBeneficiario(Long beneficiarioId) {
        BeneficiarioModel beneficiario = beneficiarioRepository.findById(beneficiarioId)
                .orElseThrow(() -> new BeneficiarioNotFoundException("Beneficiário não encontrado com o ID: " + beneficiarioId));
        try {
            return beneficiario.getDocumento().stream()
                    .map(documento -> new DadosListagemDocumento(
                            documento.getTipoDocumento(),
                            documento.getDescricao(),
                            documento.getDataInclusao(),
                            documento.getDataAtualizacao()
                    ))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new BeneficiarioException("Erro ao listar todos os documentos", e);
        }

    }

    @Transactional
    public String atualizarBeneficiario(Long beneficiarioId, DadosAtualizacaoBeneficiario dadosBeneficiarioAtualizacao) {
        final String SUCESSO = "Sucesso ao atualizar beneficiario";
        BeneficiarioModel beneficiario = beneficiarioRepository.findById(beneficiarioId)
                .orElseThrow(() -> new BeneficiarioNotFoundException("Beneficiário não encontrado com o ID: " + beneficiarioId));

       try {
           if (dadosBeneficiarioAtualizacao.nome() != null) {
               beneficiario.setNome(dadosBeneficiarioAtualizacao.nome());
           }
           if (dadosBeneficiarioAtualizacao.telefone() != null) {
               beneficiario.setTelefone(dadosBeneficiarioAtualizacao.telefone());
           }
           if (dadosBeneficiarioAtualizacao.dataNascimento() != null) {
               beneficiario.setDataNascimento(dadosBeneficiarioAtualizacao.dataNascimento());
           }

           beneficiario.setDataAtualizacao(new Date());

           beneficiarioRepository.save(beneficiario);

       } catch (Exception e) {
           throw new BeneficiarioException("Erro ao atualizar beneficiario", e);
       }

        return SUCESSO;
    }

    public String removerBeneficiario(Long beneficiarioId) {
        final String SUCESSO = "Sucesso ao excluir beneficiario";
        try {
            if (beneficiarioRepository.existsById(beneficiarioId)) {
                beneficiarioRepository.deleteById(beneficiarioId);
            } else {
                throw new BeneficiarioNotFoundException("Beneficiário não encontrado com o ID: " + beneficiarioId);
            }
        } catch (Exception e) {
            throw new BeneficiarioException("Erro ao excluir beneficiario", e);
        }
        return SUCESSO;
    }


}
