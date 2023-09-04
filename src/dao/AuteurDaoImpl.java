package dao;

import dao.Intreface.IAuteurDao;
import entity.Auteur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuteurDaoImpl implements IAuteurDao {
    private Connection cn = DbConnection.dbConnection();
    private final String INSERT = "INSERT INTO auteur(name ,lastName,nationalite,date_naissance) VALUES(?,?,?,?)";
    private final String FIND_BY_ID = "SELECT id, name,lastName, nationalite,date_naissance FROM auteur WHERE id = ? ";
    private final  String FIND_ALL = "SELECT * FROM auteur";
    private final String UPDATE = "UPDATE auteur SET name = \"?\", lastName = \"?\",nationalite =\"?\",date_naissance = \"?\" WHERE id = ?";
    private final String DELETE = "DELETE FROM auteur WHERE id = ?";

    @Override
    public void add(Auteur auteur) {
        System.out.println("hellllllll"+auteur.getDate_naissance());

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

            while (resultSet.next()){
                auteur.setId(resultSet.getInt(1));
                auteur.setName(resultSet.getString(2));
                auteur.setLastName(resultSet.getString(3));
                auteur.setNationalite(resultSet.getString(4));
                auteur.setDate_naissance(Date.valueOf(resultSet.getString(5)));
                //statement.executeUpdate() ;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return auteur;
    }

    @Override
    public List<Auteur> findAll() {
        try{
            List<Auteur> auteurs = new ArrayList<>();
            System.out.println(auteurs);
//            PreparedStatement statement = cn.prepareStatement(FIND_ALL);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()){
//
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Auteur auteur) {

    }

    @Override
    public void delete(int id) {

    }
}
