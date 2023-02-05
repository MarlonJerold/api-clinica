CREATE TABLE pacientes(

    id bigint NOT NULL auto_increment,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    crm VARCHAR(100) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    complemento VARCHAR(100) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    uf CHAR(2) NOT NULL,
    telefone VARCHAR(20) NOT NULL,

    PRIMARY KEY(id)

)