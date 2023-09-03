package dao.Intreface;

import entity.Auteur;

import java.util.List;

public interface IAuteurDao {
    void add(Auteur auteur);
    Auteur findById(int id);
    List<Auteur> findAll();
    void update(Auteur auteur);
    void delete(int id);
}
