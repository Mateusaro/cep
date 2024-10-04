package com.example.demo;

import com.example.demo.controller.EnderecoController;
import com.example.demo.model.Endereco;
import com.example.demo.service.EnderecoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoControllerTest {

    @InjectMocks
    private EnderecoController enderecoController;

    @Mock
    private EnderecoService enderecoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEndereco_ReturnsEndereco_WhenCepExists() {
        String cep = "12345678";
        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        endereco.setLogradouro("Rua Teste");
        endereco.setBairro("Bairro Teste");
        endereco.setLocalidade("Cidade Teste");
        endereco.setUf("UF");
        when(enderecoService.getEnderecoPorCep(cep)).thenReturn(endereco);
        Endereco result = enderecoController.getEndereco(cep);
        assertNotNull(result);
        assertEquals(cep, result.getCep());
        assertEquals("Rua Teste", result.getLogradouro());
        assertEquals("Bairro Teste", result.getBairro());
        assertEquals("Cidade Teste", result.getLocalidade());
        assertEquals("UF", result.getUf());
        verify(enderecoService, times(1)).getEnderecoPorCep(cep);
    }

    @Test
    void getEndereco_ThrowsException_WhenCepDoesNotExist() {
        String cep = "12345678";
        when(enderecoService.getEnderecoPorCep(anyString())).thenThrow(new RuntimeException("CEP não encontrado"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> enderecoController.getEndereco(cep));
        assertEquals("CEP não encontrado", exception.getMessage());
        verify(enderecoService, times(1)).getEnderecoPorCep(cep);
    }
}
