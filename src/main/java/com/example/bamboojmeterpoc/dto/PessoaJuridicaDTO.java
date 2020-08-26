package com.example.bamboojmeterpoc.dto;

import com.example.bamboojmeterpoc.domain.PessoaJuridica;
import com.example.bamboojmeterpoc.enums.TipoPessoaEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaJuridicaDTO implements IPessoaResponse {

    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;

    @Override public String getTipoPessoa() {
        return TipoPessoaEnum.PJ.name();
    }

    public static PessoaJuridicaDTO toDto(final PessoaJuridica pessoaJuridica) {
        return PessoaJuridicaDTO.builder()
                        .cnpj(pessoaJuridica.getCnpj())
                        .nomeFantasia(pessoaJuridica.getNomeFantasia())
                        .razaoSocial(pessoaJuridica.getRazaoSocial())
                        .build();
    }
}
