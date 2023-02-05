CREATE TABLE endereco(

    id bigint NOT NULL auto_increment,
    logradouro VARCHAR(100) NOT NULL,
    cep VARCHAR(255) NOT NULL,
    numero VARCHAR(255) NOT NULL,
    complemento VARCHAR(255),
    cidade VARCHAR(255) NOT NULL,
    uf VARCHAR(2) NOT NULL,

    PRIMARY KEY(id)

)