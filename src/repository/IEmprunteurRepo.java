package repository;

import entity.Emprunteur;

import java.sql.SQLException;
import java.util.List;

public interface IEmprunteurRepo {
    void add(Emprunteur emprunteur) throws SQLException;
    Emprunteur findById(int id);
    List<Emprunteur> findAll();
    void update(Emprunteur emprunteur);
    void delete(int id);
    Emprunteur lastColumn() throws SQLException;
}
