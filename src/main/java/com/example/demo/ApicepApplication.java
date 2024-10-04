package com.example.demo;

import com.example.demo.model.Endereco;
import com.example.demo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApicepApplication implements CommandLineRunner {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApicepApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Endereco endereco = new Endereco();
		endereco.setCep("22775046");  // Aqui você define explicitamente o valor do CEP
		endereco.setLogradouro("Avenida das Américas");
		endereco.setBairro("Barra da Tijuca");
		endereco.setLocalidade("Rio de Janeiro");
		endereco.setUf("RJ");

		// Salvar no banco de dados H2
		enderecoRepository.save(endereco);

		System.out.println("Dados de CEP mockados adicionados ao H2.");
	}
}
