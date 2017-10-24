CREATE TABLE PRODUTOS (
    ID SERIAL NOT NULL PRIMARY KEY,
    categoria varchar(255),
    nome varchar(255),
    descricao varchar(255),
    preco real
);