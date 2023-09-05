package dao.impl;

import dao.DbConnection;
import dao.ILivreDao;
import entity.Livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LivreDaoImpl implements ILivreDao {
    Connection cn = DbConnection.dbConnection();
    private final String INSERT = "INSERT INTO livre( titre, isbn, qnt, auteur_id) VALUES (?,?,?,?)";
    private final String FIND_BY_ID = "SELECT id, name,lastName, nationalite,date_naissance FROM auteur WHERE id = ? ";
    private final  String FIND_ALL = "SELECT * FROM auteur";
    private final String UPDATE = "UPDATE auteur SET name = ?, lastName = ?,nationalite =?,date_naissance = ? WHERE id = ?";
    private final String DELETE = "DELETE FROM auteur WHERE id = ?";
    @Override
    public void add(Livre livre) {
        try{
            PreparedStatement statement = cn.prepareStatement(INSERT);

            statement.setString(1,livre.getTitre());
            statement.setString(2, livre.getIsbn());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Livre findById(int id) {
        return null;
    }

    @Override
    public List<Livre> findAll() {
        return null;
    }

    @Override
    public void update(Livre livre) {

    }

    @Override
    public void delete(int id) {

    }
}
