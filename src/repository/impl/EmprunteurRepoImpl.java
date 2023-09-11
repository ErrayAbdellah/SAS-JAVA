package repository.impl;

import db.DbConnection;
import entity.Livre;
import repository.IEmprunteurRepo;
import entity.Emprunteur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmprunteurRepoImpl implements IEmprunteurRepo {
    private final String ADD= "INSERT INTO emprunteur (name, lastName, date_emprunt, dateReturn) VALUES (?,?,?,?)";
    private final String SELECT_LAST_COLUMN = "SELECT id FROM emprunteur ORDER BY id DESC LIMIT 1;";
    private final String DECR = "UPDATE livre SET qnt = qnt -1 WHERE id = ?;";
    Connection cn = DbConnection.dbConnection();
    @Override
    public void add(Emprunteur emprunteur) throws SQLException {
        PreparedStatement statement = cn.prepareStatement(ADD);
        statement.setString(1,emprunteur.getName());
        statement.setString(2,emprunteur.getLastName());
        statement.setDate(3,emprunteur.getDate_emprunt());
        statement.setDate(4,emprunteur.getDateReturn());
        statement.executeUpdate();
    }
    @Override
    public Emprunteur lastColumn() throws SQLException {
        Emprunteur emprunteur = new Emprunteur();
        PreparedStatement statement = cn.prepareStatement(SELECT_LAST_COLUMN);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            emprunteur.setId(resultSet.getInt(1));
            return emprunteur ;
        }else return null ;
    }

    @Override
    public void decr(int id) throws SQLException {
        PreparedStatement statement = cn.prepareStatement(DECR);
        statement.setInt(1,id);
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
