package dao.Intreface;

import entity.Auteur;

import java.sql.SQLException;
import java.util.List;

public interface IAuteurDao {
    void add(Auteur auteur) throws SQLException;
    Auteur findById(int id);
    List<Auteur> findAll();
    void update(Auteur auteur);
    void delete(int id);
}
