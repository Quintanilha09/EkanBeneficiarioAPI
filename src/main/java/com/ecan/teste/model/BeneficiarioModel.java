package com.ecan.teste.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "beneficiario")
public class BeneficiarioModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long beneficiarioId;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;

    @Column(name = "data_nascimento", length = 10, nullable = false)
    private String dataNascimento;

    @Column(name = "data_inclusao")
    @Temporal(TemporalType.DATE)
    private Date dataInclusao;

    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DocumentoModel> documentoModel;

    public Long getIdBeneficiario() {
        return beneficiarioId;
    }

    public void setIdBeneficiario(Long id) {
        this.beneficiarioId = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<DocumentoModel> getDocumento() {
        return documentoModel;
    }

    public void setDocumento(List<DocumentoModel> documentoModel) {
        this.documentoModel = documentoModel;
    }

}
