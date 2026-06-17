package com.projetos.api_clientes.repositories;

import com.projetos.api_clientes.entities.Cliente;
import com.projetos.api_clientes.factories.ConnectionFactory;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
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

    public List<Cliente> consultarPorNome(String nome) throws Exception {

        //Abrindo conexão com o banco
        var factory = new ConnectionFactory();
        var connection = factory.getConnection();

        //Consultando os clientes cadastrados no banco por nome
        try {

            var statement = connection.prepareStatement("""
                    select id, nome, email, cpf, telefone, data_cadastro
                    from clientes
                    where nome = ?
                    order by nome
                    """);

            statement.setString(1,"%" + nome + "%" );
            var result = statement.executeQuery();
            var lista = new ArrayList<Cliente>();

            while(result.next()){
                var cliente = new Cliente();

                cliente.setNome(result.getString("id"));
                cliente.setEmail(result.getString("email"));
                cliente.setCpf(result.getString("cpf"));
                cliente.setTelefone(result.getString("telefone"));
                cliente.setDataCadastro(result.getTimestamp("data_cadastro").toLocalDateTime());

                lista.add(cliente); //Adicionando o cliente à lista

            }

            connection.close();
            return lista;

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }
}
