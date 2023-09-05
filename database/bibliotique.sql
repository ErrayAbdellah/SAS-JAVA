DROP DATABASE IF EXISTS db_bibliotique;
CREATE DATABASE db_bibliotique;
USE db_bibliotique;


create table Auteur
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    name            VARCHAR(255),
    lastName       VARCHAR(255),
    nationalite    VARCHAR(255),
    date_naissance DATE
);
CREATE TABLE Livre(
      id        INT PRIMARY KEY AUTO_INCREMENT ,
      titre     VARCHAR(255),
      isbn      VARCHAR(255),
      qnt       INT(255),
      auteur_id INT ,
      FOREIGN KEY (auteur_id) REFERENCES Auteur(id)
);
CREATE TABLE Emprunteur(
       id           INT PRIMARY KEY AUTO_INCREMENT ,
       name         VARCHAR(255),
       lastName     VARCHAR(255),
       is_deleted   BIT default 0,
       is_dispo     BIT default 0,
       date_emprunt DATE,
       dateReturn DATE
);
CREATE TABLE LivreEmprunteur
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    livre      INT,
    emprunteur INT,
    FOREIGN KEY (livre) REFERENCES LIVRE (id),
    FOREIGN KEY (emprunteur) REFERENCES Emprunteur (id)
)


DELIMITER //

CREATE TRIGGER tr_update_qnt_livre
    AFTER DELETE ON LivreEmprunteur
    FOR EACH ROW
BEGIN
    UPDATE  Livre
    SET     qnt = qnt + 1
    WHERE   id = OLD.livre_id;
END;
//
DELIMITER ;















