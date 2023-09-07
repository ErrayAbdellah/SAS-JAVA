package repository;

import entity.Livre;

import java.util.List;

public interface ILivreRepo {
    void add(Livre livre);
    Livre findById(int id);
    List<Livre> findAll();
    void update(Livre livre);
    void delete(int id);
    List<Livre> searchByTitre(String titre);
    List<Livre> searchByََAuteur(String titre);
}
