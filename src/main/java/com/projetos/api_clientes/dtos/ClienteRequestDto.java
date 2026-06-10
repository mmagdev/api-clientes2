package com.projetos.api_clientes.dtos;

public record ClienteRequestDto(
        String nome,
        String email,
        String cpf,
        String telefone,
        String dataCadastro
) {}
