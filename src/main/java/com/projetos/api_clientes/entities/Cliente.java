package com.projetos.api_clientes.entities;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Cliente {

    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;
    private LocalDateTime dataExclusao;
    private Integer ativo;

}
