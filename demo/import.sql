CREATE TABLE tbPessoas (
	id SERIAL PRIMARY KEY,
	nome varchar(200),
	email varchar(200),
	senha varchar(200),
	telefone varchar(200),
	endereco varchar(200)
);

SELECT * FROM TBPESSOAS;


CREATE TABLE TBSTATUS (
	id serial PRIMARY KEY,
	situacao varchar(30)
);

SELECT * FROM tbstatus;


CREATE TABLE tbProduto (
	id serial PRIMARY KEY,
	descricao varchar(200) NOT null,
	preco decimal(6,2) NOT null,
	quantidade int NOT NULL,
	idStatus int,
	FOREIGN KEY (idStatus) REFERENCES tbStatus(id) ON UPDATE CASCADE ON DELETE cascade
);

INSERT INTO TBPRODUTO (DESCRICAO, PRECO, QUANTIDADE, IDSTATUS) VALUES
	('Peixe', 19.99, 200, 1);

SELECT * FROM tbProduto;