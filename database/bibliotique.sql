DROP DATABASE IF EXISTS db_bibliotique
CREATE DATABASE db_bibliotique
USE db_bibliotique

CREATE TABLE livre(
    id INT PRIMARY KEY AUTO_INCREMENT ,
    titre VARCHAR(255),
    auteur VARCHAR(255),
    isbn VARCHAR(255),
    disponible VARCHAR(255),
)
CREATE TABLE emprunte(
    id INT PRIMARY KEY AUTO_INCREMENT ,

)