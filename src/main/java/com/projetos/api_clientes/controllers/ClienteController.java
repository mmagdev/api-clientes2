package com.projetos.api_clientes.controllers;


import com.projetos.api_clientes.dtos.ClienteResponseDto;
import com.projetos.api_clientes.entities.Cliente;
import com.projetos.api_clientes.dtos.ClienteRequestDto;
import com.projetos.api_clientes.repositories.ClienteRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @PostMapping("inserir")
    public String inserir(@RequestBody ClienteRequestDto dto) {

        try {
            //Capturando os dados do novo cliente
            var cliente = new Cliente();

            cliente.setNome(dto.nome());
            cliente.setEmail(dto.nome());
            cliente.setCpf(dto.cpf());
            cliente.setTelefone(dto.telefone());

            //Salvando o cliente no banco de dados
            var repository = new ClienteRepository();
            repository.inserir(cliente);

            return "Cliente cadastrado com sucesso";

        }
        catch (Exception e) {
            return "Erro: " + e.getMessage();

        }

    }

    @PutMapping("atualizar")
    public String atualizar() {
        return "Cliente atualizado com sucesso!";
    }

    @GetMapping("consultar")
    public List<ClienteResponseDto> consultar(String nome) {

        //TODO: não está buscando o cliente no banco de dados!!!!!!

        try {
            var repository = new ClienteRepository();
            var lista = repository.consultarPorNome(nome);

            //Copiando os resultados para uma lista do ClienteResponseDto
            return lista.stream()
                    .map(cliente -> new ClienteResponseDto(
                            cliente.getNome(),
                            cliente.getEmail(),
                            cliente.getCpf(),
                            cliente.getTelefone(),
                            cliente.getDataCadastro()
                    ))
                    .toList();
        }
        catch (Exception e) {

            e.printStackTrace();
            return null;


        }
    }

    @DeleteMapping("excluir")
    public String excluir() {
        return "Cliente removido com sucesso!";
    }


}
