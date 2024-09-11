CREATE DATABASE tbStatus;

CREATE TABLE tbStatus (
	id serial primary key,
	descricao varchar(100) not null
);

INSERT INTO TBSTATUS (descricao) VALUES ('Cancelado');

SELECT * FROM TBSTATUS;

create table tbPessoas(
	id serial primary key,
	nome varchar(200),
	email varchar(200),
	senha varchar(20),
	telefone varchar(100),
	endereco varchar(200)
);


delete from TBPESSOAS where ID = 0;

select * from TBPESSOAS;

create table tbProdutos (
	id serial primary key,
	descricao varchar(200),
	preco decimal(6, 2),
	quantidade int,
	idStatus int,
	foreign key (idStatus) references tbStatus(id)
)

select * from tbProdutos;

