CREATE DATABASE tbStatus;

CREATE TABLE tbStatus (
	id serial primary key,
	descricao varchar(100) not null
);

INSERT INTO TBSTATUS (descricao) VALUES ('Cancelado');

SELECT * FROM TBSTATUS;