import controller.LivreController;
import db.DbConnection;
import entity.Livre;
import repository.ILivreRepo;
import repository.impl.AuteurRepoImpl;
import repository.impl.LivreRepoImpl;
import service.LivreService;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static int print(int choix){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("\t*************************************************");
        System.out.println("\t*\t1  -  Ajouter un livre \t\t\t\t\t\t*");
        System.out.println("\t*	2  - Rechercher un livre par ID\t\t\t\t*");
        System.out.println("\t*	3  - Rechercher tous les livres\t\t\t\t*");
        System.out.println("\t*	4  - Supprimer le livre\t\t\t\t\t\t*");
        System.out.println("\t*	5  - Rechercher des livres par titre\t\t*");
        System.out.println("\t*	6  - Rechercher des livres par auteur\t\t*");
        System.out.println("\t*	0  - Quitter \t\t\t\t\t\t\t\t*");
        System.out.println("\t*************************************************\n");
        do {
            System.out.println("\nChoisissez le numero de l'operation que vous souhaitez effectuer : ");
            choix = scanner.nextInt();
            //if ()
        }while (choix<0 || choix>8);
        return choix ;
    }
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
        ILivreRepo livreRepo = new LivreRepoImpl();
        LivreService livreService = new LivreService(livreRepo);
        LivreController livreController =new LivreController(livreService);

        Connection connection = DbConnection.dbConnection();
//        if (connection == null) {
//            System.out.println("error");


        int choix=0 ;

         while (true){

             choix = print(choix);

            switch (choix){
                case 1:
                    livreController.add();
                    break;
                case 2:
                    livreController.trouverLivreParId();
                    break;
                case 3:
                    livreController.trouverTousLesLivres();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    break;
            }
            if (choix == 0 ) break;
         }

    }
}

