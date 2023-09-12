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
   date_emprunt DATE,
   dateReturn DATE
);
CREATE TABLE LivreEmprunteur
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    livre_id      INT,
    emprunteur_id INT,
    FOREIGN KEY (livre_id) REFERENCES LIVRE (id),
    FOREIGN KEY (emprunteur_id) REFERENCES Emprunteur (id)
);


DELIMITER //

CREATE TRIGGER tr_update_qnt_livre
    AFTER DELETE ON LivreEmprunteur
    FOR EACH ROW
BEGIN
    UPDATE  Livre
    SET     qnt = qnt + 1
    WHERE   id = OLD.livre_id;
END
    //
DELIMITER ;

ALTER TABLE livreemprunteur
    ADD COLUMN perdus Bit DEFAULT 0 ;

-- Insert sample data into Auteur table
INSERT INTO Auteur (name, lastName, nationalite, date_naissance)
VALUES
    ('John', 'Doe', 'American', '1980-05-15'),
    ('Jane', 'Smith', 'British', '1975-08-22'),
    ('Alice', 'Johnson', 'Canadian', '1990-03-10'),
    -- Add more Auteur records as needed
    ('Robert', 'Brown', 'French', '1985-11-27');

-- Insert sample data into Livre table
INSERT INTO Livre (titre, isbn, qnt, auteur_id)
VALUES
    ('Book 1', 'ISBN123', 10, 1),
    ('Book 2', 'ISBN456', 5, 2),
    ('Book 3', 'ISBN789', 8, 3),
    -- Add more Livre records as needed
    ('Book 4', 'ISBN987', 12, 4);

-- Insert sample data into Emprunteur table
INSERT INTO Emprunteur (name, lastName, is_dispo, date_emprunt)
VALUES
    ('Alice', 'Johnson', 1, '2023-01-10'),
    ('Bob', 'Smith', 1, '2023-02-15'),
    ('Charlie', 'Brown', 0, '2023-03-20'),
    -- Add more Emprunteur records as needed
    ('David', 'Davis', 1, '2023-04-25');

-- Insert sample data into LivreEmprunteur table
INSERT INTO LivreEmprunteur (livre_id, emprunteur_id)
VALUES
    (1, 1), -- Book 1 borrowed by Alice
    (2, 2), -- Book 2 borrowed by Bob
    (3, 3), -- Book 3 borrowed by Charlie
    -- Add more LivreEmprunteur records as needed
    (4, 4); -- Book 4 borrowed by David;
/*
#SELECT * FROM livre WHERE qnt > 0 ;
#SELECT l.* FROM livre AS l INNER JOIN livreemprunteur AS le ON l.id = le.livre_id
#SELECT l.* FROM livre As l INNER JOIN livreemprunteur AS le ON l.id = le.livre_id WHERE le.perdus = true

 */