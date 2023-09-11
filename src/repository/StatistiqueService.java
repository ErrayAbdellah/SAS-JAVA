package repository;

import db.DbConnection;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatistiqueService {
       private static Connection cn = DbConnection.dbConnection();
       private static final String TOTALE_LIVRE = "SELECT COUNT(*) AS totaleLivres  FROM livre WHERE qnt > 0 ;";
       private static final String LIVRE_EMPRUNTRS = "SELECT COUNT(*) AS LivresEmpruntes FROM livre AS l INNER JOIN livreemprunteur AS le ON l.id = le.livre_id;";
       private static final String LIVRE_PERDUS = "SELECT COUNT(*) AS LivresPerdus FROM livre As l INNER JOIN livreemprunteur AS le ON l.id = le.livre_id WHERE le.perdus = true ;";
    public static void generateReport() {

        try {
            Statement stmt = cn.createStatement();
            ResultSet resultSet = stmt.executeQuery(TOTALE_LIVRE);
            resultSet.next();
            int totaleLivres = resultSet.getInt("totaleLivres");

            resultSet = stmt.executeQuery(LIVRE_EMPRUNTRS);
            resultSet.next();
            int LivresEmpruntes = resultSet.getInt("LivresEmpruntes");

            resultSet = stmt.executeQuery(LIVRE_PERDUS);
            resultSet.next();
            int LivresPerdus = resultSet.getInt("LivresPerdus");
            FileWriter writer = new FileWriter("csvFilePath.csv");


            writer.append("totaleLivres,LivresEmpruntes,LivresPerdus\n");
            writer.append(totaleLivres+","+LivresEmpruntes+","+LivresPerdus+"\n");

            writer.close();

            System.out.println("Données écrites avec succès dans le fichier CSV.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
