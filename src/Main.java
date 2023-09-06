import db.DbConnection;
import entity.Auteur;
import entity.Livre;
import repository.impl.AuteurDaoImpl;
import repository.impl.LivreDaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static Date convertDate(String startDate) {
        try {

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/mm/dd");
            java.util.Date date = sdf1.parse(startDate);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            System.out.println(sqlStartDate);
            return sqlStartDate ;
        }catch (ParseException e){
            e.getMessage();
        }
        return null;
    }

    public static void main(String[] args) throws ParseException {

        Connection connection = DbConnection.dbConnection();
//        if (connection == null) {
//            System.out.println("error");

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter your ID: ");
//        int id = Integer.parseInt(scanner.nextLine());
//        System.out.println("Enter your name: ");
//        String name = scanner.nextLine();
//        System.out.println("Enter your Last name: ");
//        String lastName = scanner.nextLine();
//        System.out.println("Enter your nationalité: ");
//        String nationalite = scanner.nextLine();
//        System.out.println("Enter your birthday ");
//        String birthday = scanner.nextLine();
//        Auteur auteur = new Auteur(id,name, lastName, nationalite, convertDate(birthday));
        //Auteur auteur = new Auteur("name", "lastName", "nationalite", convertDate(birthday));

//
       AuteurDaoImpl auteurDao = new AuteurDaoImpl();
        LivreDaoImpl livreDao = new LivreDaoImpl();
//       auteurDao.update(auteur);

            Livre livre = new Livre(1,"Livre3","12345",12,auteurDao.findById(2));

            //livreDao.add(livre);
        livreDao.delete(5);
        System.out.println(livreDao.findById(5));
        livreDao.update(livre);

        }
    }

