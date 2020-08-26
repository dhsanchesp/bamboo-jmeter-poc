package com.example.bamboojmeterpoc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "tb_pessoa_juridica")
public class PessoaJuridica implements Serializable {

    private static final long serialVersionUID = -9033844555064882232L;

    @Id
    @Column(name = "cnpj", length = 100, nullable = false)
    private String cnpj;
    @Column(name = "razao_social", length = 100, nullable = false)
    private String razaoSocial;
    @Column(name = "nome_fantasia", length = 100, nullable = false)
    private String nomeFantasia;
}
