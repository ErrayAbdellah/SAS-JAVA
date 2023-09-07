package repository;

import entity.Emprunteur;

import java.util.List;

public interface IEmprunteurRepo {
    void add(Emprunteur emprunteur);
    Emprunteur findById(int id);
    List<Emprunteur> findAll();
    void update(Emprunteur emprunteur);
    void delete(int id);
}
