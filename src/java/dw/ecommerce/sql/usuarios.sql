CREATE TABLE USUARIOS (
    ID SERIAL NOT NULL PRIMARY KEY,
    nome varchar(255),
    email varchar(255),
    senha varchar(255),
    cartaoCredito varchar(255),
    cpf varchar(11)
   
);