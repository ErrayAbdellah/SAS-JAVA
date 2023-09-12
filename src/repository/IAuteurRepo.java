package repository;

import entity.Auteur;

import java.sql.SQLException;
import java.util.List;

public interface IAuteurRepo {
    void add(Auteur auteur) throws SQLException;
    Auteur findById(int id);
    List<Auteur> findAll();
    boolean update(Auteur auteur);
    boolean delete(int id);
}
