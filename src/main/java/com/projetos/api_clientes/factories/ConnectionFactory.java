package com.projetos.api_clientes.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    /*
    Método para retornar uma conexão
    com o banco de dados
     */
    public Connection getConnection() throws Exception{

        var host = "jdbc:postgresql://localhost:5435/bd_apiclientes";
        var user = "coti";
        var pass = "Coti2026";

        return DriverManager.getConnection(host, user, pass);
    }
}
