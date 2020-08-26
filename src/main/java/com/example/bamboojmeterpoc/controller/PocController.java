package com.example.bamboojmeterpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.bamboojmeterpoc.dto.IPessoaResponse;
import com.example.bamboojmeterpoc.service.PocService;

@RestController
@RequestScope
@Validated
@RequestMapping("/poc")
public class PocController {

    @Autowired
    private PocService service;

    @GetMapping(path = "/{cpfOuCnpj}/pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IPessoaResponse> getPessoa(@PathVariable final String cpfOuCnpj) {

        try {
            IPessoaResponse response = this.service.getPessoaByCpfOuCnpj(cpfOuCnpj);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
