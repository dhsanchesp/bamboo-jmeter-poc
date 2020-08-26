package com.example.bamboojmeterpoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bamboojmeterpoc.domain.PessoaFisica;
import com.example.bamboojmeterpoc.domain.PessoaJuridica;
import com.example.bamboojmeterpoc.dto.IPessoaResponse;
import com.example.bamboojmeterpoc.dto.PessoaFisicaDTO;
import com.example.bamboojmeterpoc.dto.PessoaJuridicaDTO;
import com.example.bamboojmeterpoc.repository.PocRepository;

@Service
public class PocService {

    @Autowired
    private PocRepository repository;

    public IPessoaResponse getPessoaByCpfOuCnpj(final String cpfOuCnpj) {

        if (isPessoaFisica(cpfOuCnpj)) {
            PessoaFisica pessoaFisica = this.repository.getPessoaFisicaByCpf(cpfOuCnpj);

            return PessoaFisicaDTO.toDto(pessoaFisica);
        }

        PessoaJuridica pessoaJuridica = this.repository.getPessoaJuridicaByCnpj(cpfOuCnpj);
        return PessoaJuridicaDTO.toDto(pessoaJuridica);
    }

    private boolean isPessoaFisica(String cpfOuCnpj) {
        return cpfOuCnpj.length() == 11;
    }
}
