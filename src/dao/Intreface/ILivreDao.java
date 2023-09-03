package dao.Intreface;

import entity.Livre;

import java.util.List;

public interface ILivreDao {
    void add(Livre livre);
    Livre findById(int id);
    List<Livre> findAll();
    void update(Livre livre);
    void delete(int id);
}
