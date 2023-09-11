package repository;

import entity.Emprunteur;
import entity.Livre;

import java.sql.SQLException;
import java.util.List;

public interface ILivreEmprunteurRepo {
    void add(Emprunteur emprunteur, Livre livre) throws SQLException;
    Emprunteur findById(int id) throws SQLException;
    List<Emprunteur> findAll() throws SQLException;

    void update(Emprunteur emprunteur) throws SQLException;
    void delete(int id) throws SQLException;
}
