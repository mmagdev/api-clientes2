package com.projetos.api_clientes.controllers;


import com.projetos.api_clientes.entities.Cliente;
import com.projetos.api_clientes.dtos.ClienteRequestDto;
import com.projetos.api_clientes.repositories.ClienteRepository;
import org.springframework.web.bind.annotation.*;

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
    public String consultar() {
        return "Lista de clientes obtida com sucesso!";
    }

    @DeleteMapping("excluir")
    public String excluir() {
        return "Cliente removido com sucesso!";
    }


}
