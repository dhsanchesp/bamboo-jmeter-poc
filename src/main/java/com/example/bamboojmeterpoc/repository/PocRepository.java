package com.example.bamboojmeterpoc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bamboojmeterpoc.domain.PessoaFisica;
import com.example.bamboojmeterpoc.domain.PessoaJuridica;

import lombok.Getter;

@Repository
public class PocRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Getter
    private final RowMapper<PessoaFisica> pfRowMapper = (rs, rowNum) -> PessoaFisica.builder()
                    .nome(rs.getString("nome"))
                    .cpf(rs.getString("cpf"))
                    .build();

    @Getter
    private final RowMapper<PessoaJuridica> pjRowMapper = (rs, rowNum) -> PessoaJuridica.builder()
                    .nomeFantasia(rs.getString("nome_fantasia"))
                    .razaoSocial(rs.getString("razao_social"))
                    .cnpj(rs.getString("cnpj"))
                    .build();

    private static final String SELECT_PF_BY_CPF = "SELECT * FROM TB_PESSOA_FISICA "
                    + "WHERE CPF = :cpf";

    private static final String SELECT_PJ_BY_CNPJ = "SELECT * FROM TB_PESSOA_JURIDICA "
                    + "WHERE CNPJ = :cnpj";

    public PessoaFisica getPessoaFisicaByCpf(final String cpf) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cpf", cpf);

        return this.jdbcTemplate.queryForObject(SELECT_PF_BY_CPF, params, this.getPfRowMapper());
    }

    public PessoaJuridica getPessoaJuridicaByCnpj(final String cnpj) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cnpj", cnpj);

        return this.jdbcTemplate.queryForObject(SELECT_PJ_BY_CNPJ, params, this.getPjRowMapper());
    }
}
