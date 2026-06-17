package com.projetos.api_clientes.dtos;

import java.time.LocalDateTime;

public record ClienteResponseDto(
        String nome,
        String email,
        String cpf,
        String telefone,
        LocalDateTime dataCadastro){

}
