package repository.impl;

import db.DbConnection;
import repository.IEmprunteurRepo;
import entity.Emprunteur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmprunteurRepoImpl implements IEmprunteurRepo {
    private final String ADD= "INSERT INTO emprunteur (name, lastName, date_emprunt, dateReturn) VALUES (?,?,?,?)";
    Connection cn = DbConnection.dbConnection();
    @Override
    public void add(Emprunteur emprunteur) throws SQLException {
        PreparedStatement statement = cn.prepareStatement(ADD);
        statement.setString(1,emprunteur.getName());
        statement.setString(2,emprunteur.getLastName());
        statement.setString(3,emprunteur.getName());
        statement.setString(4,emprunteur.getName());
        statement.executeUpdate();
    }

    @Override
    public Emprunteur findById(int id) {
        return null;
    }

    @Override
    public List<Emprunteur> findAll() {
        return null;
    }

    @Override
    public void update(Emprunteur emprunteur) {

    }

    @Override
    public void delete(int id) {

    }
}
