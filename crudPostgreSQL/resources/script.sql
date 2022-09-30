-- Database: cadastro

-- DROP DATABASE IF EXISTS cadastro;

CREATE TABLE cadastro_usuario(
    id serial NOT NULL PRIMARY KEY,
    nome varchar(250) NOT NULL,
    sobrenome varchar(250) NOT NULL,
    login varchar(250) NOT NULL,
    senha varchar(250) NOT NULL,
    email varchar(250) NOT NULL,
    telefone varchar(250) NOT NULL
);

SELECT * FROM cadastro_usuario;

