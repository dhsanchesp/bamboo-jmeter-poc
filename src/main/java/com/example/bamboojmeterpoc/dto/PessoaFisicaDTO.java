package com.example.bamboojmeterpoc.dto;

import com.example.bamboojmeterpoc.domain.PessoaFisica;
import com.example.bamboojmeterpoc.enums.TipoPessoaEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaFisicaDTO implements IPessoaResponse {

    private String nome;
    private String cpf;

    @Override public String getTipoPessoa() {
        return TipoPessoaEnum.PF.name();
    }

    public static PessoaFisicaDTO toDto(final PessoaFisica pessoaFisica) {
        return PessoaFisicaDTO.builder()
                        .nome(pessoaFisica.getNome())
                        .cpf(pessoaFisica.getCpf())
                        .build();
    }
}
