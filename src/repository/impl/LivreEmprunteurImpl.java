package repository.impl;

import db.DbConnection;
import entity.Emprunteur;
import entity.Livre;
import repository.ILivreEmprunteurRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LivreEmprunteurImpl implements ILivreEmprunteurRepo {
    private final Connection cn = DbConnection.dbConnection();
    private final String ADD = "INSERT INTO livreemprunteur(livre_id, emprunteur_id) VALUES (?,?);";
    private final String DELETE = "DELETE FROM livreemprunteur WHERE id = ?";
    @Override
    public void add(Emprunteur emprunteur, Livre livre) throws SQLException {
        PreparedStatement statement = cn.prepareStatement(ADD);
        statement.setInt(1,livre.getId());
        statement.setInt(2,emprunteur.getId());
        statement.executeUpdate();
    }


    @Override
    public Emprunteur findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Emprunteur> findAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Emprunteur emprunteur) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement statement = cn.prepareStatement(DELETE);
        statement.setInt(1,id);
    }
}
