CREATE TABLE clientes (

id              serial              primary key,
nome            varchar(100)        not null,
email           varchar(100)        not null,
cpf             varchar(11)         not null,
telefone        varchar(20)         not null,
data_cadastro   timestamp           not null default current_timestamp,
data_alteracao  timestamp           not null,
data_exclusao   timestamp           not null,
ativo           int                 not null default 1


)