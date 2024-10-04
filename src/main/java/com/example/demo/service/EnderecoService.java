package com.example.demo.service;

import com.example.demo.model.Endereco;
import com.example.demo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco getEnderecoPorCep(String cep) {
        return enderecoRepository.findById(cep)
                .orElseThrow(() -> new RuntimeException("CEP não encontrado"));
    }
}
