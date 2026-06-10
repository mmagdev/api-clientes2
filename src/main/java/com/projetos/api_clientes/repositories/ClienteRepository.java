package com.projetos.api_clientes.repositories;

import com.projetos.api_clientes.entities.Cliente;
import com.projetos.api_clientes.factories.ConnectionFactory;

import java.time.LocalDateTime;

public class ClienteRepository {

    /*
    Método para inserir um novo cliente
    no banco de dados do sistema
     */

    public void inserir(Cliente cliente) throws Exception {

        //Abrir conexão com o banco de dados
        var factory = new ConnectionFactory();
        var connection = factory.getConnection();

        /*
        Executar o comando SQL para inserir
        os dados de um cliente no banco de dados
         */

        //Variável declarada para tratar o erro de retorno null antes do insert
        cliente.setDataCadastro(LocalDateTime.now());

        var statement = connection.prepareStatement("""
                insert into clientes(nome, email, cpf, telefone, data_cadastro)
                values (?,?,?,?,?)
                """);

        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEmail());
        statement.setString(3, cliente.getCpf());
        statement.setString(4, cliente.getTelefone());
        statement.setObject(5, cliente.getDataCadastro());
        statement.execute();

        //Fechando a conexão com o banco
        connection.close();




    }
}
