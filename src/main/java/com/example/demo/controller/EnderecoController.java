package com.example.demo.controller;

import com.example.demo.service.EnderecoService;
import com.example.demo.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cep")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public Endereco getEndereco(@PathVariable String cep) {
        return enderecoService.getEnderecoPorCep(cep);
    }
}
