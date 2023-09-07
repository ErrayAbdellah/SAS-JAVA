package repository.impl;

import db.DbConnection;
import repository.IAuteurRepo;
import entity.Auteur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuteurRepoImpl implements IAuteurRepo {
    private Connection cn = DbConnection.dbConnection();
    private final String INSERT = "INSERT INTO auteur(name ,lastName,nationalite,date_naissance) VALUES(?,?,?,?)";
    private final String FIND_BY_ID = "SELECT id, name,lastName, nationalite,date_naissance FROM auteur WHERE id = ? ";
    private final  String FIND_ALL = "SELECT * FROM auteur";
    private final String UPDATE = "UPDATE auteur SET name = ?, lastName = ?,nationalite =?,date_naissance = ? WHERE id = ?";
    private final String DELETE = "DELETE FROM auteur WHERE id = ?";

    @Override
    public void add(Auteur auteur) {
        try {

            PreparedStatement statement = cn.prepareStatement(INSERT);
            statement.setString(1, auteur.getName());
            statement.setString(2, auteur.getLastName());
            statement.setString(3, auteur.getNationalite());
            statement.setDate(4, auteur.getDate_naissance());
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Auteur findById(int id) {
            Auteur auteur = new Auteur();
        try {
            PreparedStatement statement = cn.prepareStatement(FIND_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                System.out.println();
                auteur.setId(resultSet.getInt(1));
                auteur.setName(resultSet.getString(2));
                auteur.setLastName(resultSet.getString(3));
                auteur.setNationalite(resultSet.getString(4));
                auteur.setDate_naissance(Date.valueOf(resultSet.getString(5)));
           }else {
                return null ;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return auteur;
    }

    @Override
    public List<Auteur> findAll() {
        List<Auteur> auteurs = new ArrayList<>();
        try{
            //Auteur auteur = new Auteur();
            PreparedStatement statement = cn.prepareStatement(FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Auteur auteur = new Auteur();
                auteur.setId(rs.getInt(1));
                auteur.setName(rs.getString(2));
                auteur.setLastName(rs.getString(3));
                auteur.setNationalite(rs.getString(4));
                auteur.setDate_naissance(Date.valueOf(rs.getString(5)));
                auteurs.add(auteur);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(auteurs);
        return auteurs;
    }

    @Override
    public void update(Auteur auteur) {
        try{

                if (findById(auteur.getId())==null)
                {
                    System.out.println("auteur not found : id = "+ auteur.getId());
                } else {
                    PreparedStatement statement = cn.prepareStatement(UPDATE);
                    //System.out.println(findById(auteur.getId()));
                    statement.setString(1, auteur.getName());
                    statement.setString(2, auteur.getLastName());
                    statement.setString(3, auteur.getNationalite());
                    statement.setDate(4, auteur.getDate_naissance());
                    statement.setInt(5,auteur.getId());
                    statement.executeUpdate();
                    System.out.println(auteur);
                }


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            if (findById(id)==null)
            {
                System.out.println("auteur not found");
            }
            PreparedStatement statement = cn.prepareStatement(DELETE);
            statement.setInt(1,id);
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
