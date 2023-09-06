package repository.impl;

import db.DbConnection;
import entity.Auteur;
import repository.ILivreDao;
import entity.Livre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivreDaoImpl implements ILivreDao {
    Connection cn = DbConnection.dbConnection();
    private final String INSERT = "INSERT INTO livre( titre, isbn, qnt, auteur_id) VALUES (?,?,?,?)";
    private final String FIND_BY_ID = "SELECT l.id, titre, isbn, qnt, auteur_id, a.name, a.lastName, a.nationalite, a.date_naissance FROM livre AS l INNER JOIN auteur as a ON a.id = l.id  WHERE l.id = ?";
    private final  String FIND_ALL = "SELECT l.id, titre, isbn, qnt, auteur_id, a.name, a.lastName, a.nationalite, a.date_naissance FROM livre AS l INNER JOIN auteur as a ON a.id = l.auteur_id";
    private final String UPDATE = "UPDATE auteur SET name = ?, lastName = ?,nationalite =?,date_naissance = ? WHERE id = ?";
    private final String DELETE = "DELETE FROM auteur WHERE id = ?";

    public LivreDaoImpl(){

    }
    @Override
    public void add(Livre livre) {
        try{
            PreparedStatement statement = cn.prepareStatement(INSERT);

            statement.setString(1,livre.getTitre());
            statement.setString(2, livre.getIsbn());
            statement.setInt(3, (int) livre.getQnt());
            statement.setInt(4,livre.getAuteur().getId());
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Livre findById(int id) {
        Livre livre = new Livre();
        Auteur auteur = new Auteur();
        try{
            PreparedStatement statement = cn.prepareStatement(FIND_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                livre.setId(resultSet.getInt(1));
                livre.setTitre(resultSet.getString(2));
                livre.setIsbn(resultSet.getString(3));
                livre.setQnt(resultSet.getInt(4));
                //Auteur
                auteur.setId(resultSet.getInt(5));
                auteur.setName(resultSet.getString(6));
                auteur.setLastName(resultSet.getString(7));
                auteur.setNationalite(resultSet.getString(8));
                auteur.setDate_naissance(Date.valueOf(resultSet.getString(9)));
                livre.setAuteur(auteur);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return livre;
    }

    @Override
    public List<Livre> findAll() {
        List<Livre> livres = new ArrayList<>();
        try {
            PreparedStatement statement = cn.prepareStatement(FIND_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Livre livre = new Livre();
                Auteur auteur = new Auteur();

                livre.setId(resultSet.getInt(1));
                livre.setTitre(resultSet.getString(2));
                livre.setIsbn(resultSet.getString(3));
                livre.setQnt(resultSet.getInt(4));
                //Auteur
                auteur.setId(resultSet.getInt(5));
                auteur.setName(resultSet.getString(6));
                auteur.setLastName(resultSet.getString(7));
                auteur.setNationalite(resultSet.getString(8));
                auteur.setDate_naissance(Date.valueOf(resultSet.getString(9)));
                livre.setAuteur(auteur);
                livres.add(livre);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(livres);
        return livres;
    }

    @Override
    public void update(Livre livre) {
        List<Livre> livres = new ArrayList<>();
        System.out.println(livres);
    }

    @Override
    public void delete(int id) {

    }
}
