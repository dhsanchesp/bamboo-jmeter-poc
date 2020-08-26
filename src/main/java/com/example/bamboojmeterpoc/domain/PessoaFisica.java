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
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica implements Serializable {

    private static final long serialVersionUID = 5432538824062831073L;

    @Id
    @Column(name = "cpf", length = 100, nullable = false)
    private String cpf;
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
}
