CREATE  DATABASE  IF NOT EXISTS bancoteste;
USE bancoteste;
CREATE TABLE IF NOT EXISTS usuario(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45) NOT NULL,
senha VARCHAR(45) NOT NULL
);