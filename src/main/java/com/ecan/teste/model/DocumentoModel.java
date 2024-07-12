package com.ecan.teste.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "documento")
public class DocumentoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentoId;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private BeneficiarioModel beneficiario;

    @Column(name = "tipo_documento", length = 10, nullable = false)
    private TipoDocumentoEnum tipoDocumento;

    @Column(name = "descricao", length = 11, nullable = false)
    private String descricao;

    @Column(name = "data_inclusao")
    @Temporal(TemporalType.DATE)
    private Date dataInclusao;

    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;

    public Long getIdDocumento() {
        return documentoId;
    }

    public void setIdDocumento(Long idDocumento) {
        this.documentoId = idDocumento;
    }

    public BeneficiarioModel getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(BeneficiarioModel beneficiario) {
        this.beneficiario = beneficiario;
    }

    public TipoDocumentoEnum getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoEnum tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

}
