import controller.AuteurController;
import controller.EmprunteurController;
import controller.LivreController;
import entity.Auteur;
import entity.Emprunteur;
import entity.Livre;
import repository.*;
import repository.impl.AuteurRepoImpl;
import repository.impl.EmprunteurRepoImpl;
import repository.impl.LivreEmprunteurImpl;
import repository.impl.LivreRepoImpl;
import service.AuteurService;
import service.EmprunteurService;
import service.LivreService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int print(int choix){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("\t*************************************************");
        System.out.println("\t*\t1  -  Ajouter un livre \t\t\t\t\t\t*");
        System.out.println("\t*	2  - Rechercher un livre par ID\t\t\t\t*");
        System.out.println("\t*	3  - afficher tous les livres\t\t\t\t*");
        System.out.println("\t*	4  - Modifie une livre\t\t\t\t\t\t*");
        System.out.println("\t*	5  - Supprimer une livre\t\t\t\t\t*");
        System.out.println("\t*	6  - Rechercher des livres par titre\t\t*");
        System.out.println("\t*	7  - Rechercher des livres par auteur\t\t*");
        System.out.println("\t*	8  - Emprunte livre\t\t\t\t\t\t\t*");
        System.out.println("\t*	9  - Statistique \t\t\t\t\t\t\t*");
        System.out.println("\t*	0  - Quitter \t\t\t\t\t\t\t\t*");
        System.out.println("\t*************************************************\n");

        do {
            System.out.println("\nChoisissez le numero de l'operation que vous souhaitez effectuer : ");
            choix = scanner.nextInt();

        }while (choix<0 || choix>9);
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
    public static void afficherLivres(List<Livre> listeLivres){
        for (Livre livr : listeLivres) {
            System.out.println("ID : " + livr.getId());
            System.out.println("Titre : " + livr.getTitre());
            System.out.println("ISBN : " + livr.getIsbn());
            System.out.println("Quantité : " + livr.getQnt());
            System.out.println("Auteur ID : " + livr.getAuteur());
            System.out.println();
        }
    }
    public static void afficherAuteur(List<Auteur> auteurs){
        for (Auteur auteur : auteurs) {
            System.out.println("ID : " + auteur.getId());
            System.out.println("Nom : " + auteur.getName());
            System.out.println("Prenom : " + auteur.getLastName());
            System.out.println("nationalite : " + auteur.getNationalite());
            System.out.println("date de naissance  : " + auteur.getDate_naissance());
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        ILivreRepo livreRepo = new LivreRepoImpl();
        IEmprunteurRepo iEmprunteurRepo = new EmprunteurRepoImpl();
        ILivreEmprunteurRepo livreEmprunteurRepo = new LivreEmprunteurImpl();
        IAuteurRepo iAuteurRepo = new AuteurRepoImpl();

        LivreService livreService = new LivreService(livreRepo);
        EmprunteurService emprunteurService = new EmprunteurService(iEmprunteurRepo,livreRepo);
        AuteurService service = new AuteurService(iAuteurRepo);

        LivreController livreController = new LivreController(livreService);
        EmprunteurController emprunteurController = new EmprunteurController(emprunteurService,livreService);
        AuteurController auteurController = new AuteurController(service);
        Scanner scanner = new Scanner(System.in);

        int choix=0 ;
        int choixEdite = 0 ;
         while (true){

             choix = print(choix);

            switch (choix){
                case 1:
                    Livre livre =new Livre();
                    Auteur auteur = new Auteur();

                    System.out.println("Enter Title : ");
                    livre.setTitre(scanner.nextLine());
                    System.out.println("Enter ISBN : ");
                    livre.setIsbn(scanner.nextLine());
                    System.out.println("Enter Quantity : ");
                    livre.setQnt(Long.parseLong(scanner.nextLine()));
                    afficherAuteur(auteurController.afficherAuteurs());
                    System.out.println("Enter Auteur Id : ");
                    int idAuteur = Integer.parseInt(scanner.nextLine()) ;
                    if (auteurController.trouverLivreParId(idAuteur)==null) {
                        System.out.println("Il n'y a pas de auteur");
                        break ;
                    }else {
                        auteur.setId(idAuteur);
                        livre.setAuteur(auteur);
                        livreController.add(livre);
                        System.out.println("le livre est ajouté");
                    }
                    break;
                case 2:
                    System.out.println("enter id : ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if ((livreController.trouverLivreParId(id) == null)) {
                        System.out.println("Il n'y a pas de livre");
                    } else {
                        List<Livre> livres = new ArrayList<>() ;
                        livres.add(livreController.trouverLivreParId(id));
                        afficherLivres(livres);
                    }
                    break;
                case 3:
                    afficherLivres(livreController.trouverTousLesLivres());
                    break;
                case 4:
                    Livre livreE =new Livre();
                    Auteur auteurE = new Auteur();
                    afficherLivres(livreController.trouverTousLesLivres());
                    System.out.println("enter id : ");
                    int idLivre = Integer.parseInt(scanner.nextLine());
                    if ((livreController.trouverLivreParId(idLivre) == null)) {
                        System.out.println("Il n'y a pas de livre");
                    } else {
                        livreE.setId(idLivre);
                        System.out.println("Enter Title : ");
                        livreE.setTitre(scanner.nextLine());
                        System.out.println("Enter ISBN : ");
                        livreE.setIsbn(scanner.nextLine());
                        System.out.println("Enter Quantity : ");
                        livreE.setQnt(Long.parseLong(scanner.nextLine()));
                        afficherAuteur(auteurController.afficherAuteurs());
                        System.out.println("Enter Auteur Id : ");
                        int idAuteurE = Integer.parseInt(scanner.nextLine());
                        if (auteurController.trouverLivreParId(idAuteurE) == null) {
                            System.out.println("Il n'y a pas de auteur");
                            break;
                        } else {
                            auteurE.setId(idAuteurE);
                            livreE.setAuteur(auteurE);
                            System.out.println(livreController.mettreAJourLivr(livreE));
                        }
                    }
                    break;
                case 5:
                    afficherLivres(livreController.trouverTousLesLivres());
                    System.out.println("enter id :");
                    System.out.println(livreController.supprimer(scanner.nextInt()));
                    break;
                case 6:
                    System.out.println("entre Titre de livre");
                    String titre = scanner.nextLine();
                    if (livreController.livresParTitre(titre) == null) {
                        System.out.println("Il n'y a pas de livre");
                    }else {
                        afficherLivres(livreController.livresParTitre(titre));
                    }
                    break;
                case 7:
                    System.out.println("entre Nom de auteur");
                    String nom = scanner.nextLine();
                    afficherLivres(livreController.livresParAuteur(nom));
                    break;
                case 8:
                    Emprunteur emprunteur = new Emprunteur();
                    livre = new Livre();
                    LocalDate localDate = LocalDate.now();
                    System.out.println("Enter name : ");
                    emprunteur.setName(scanner.nextLine());
                    System.out.println("Enter Last name : ");
                    emprunteur.setLastName(scanner.nextLine());
                    System.out.println("Enter date return : ");
                    emprunteur.setDateReturn(convertDate(scanner.nextLine()));
                    emprunteur.setDate_emprunt(Date.valueOf(localDate));

                    List<Livre> listeLivres = livreService.trouverTousLesLivres();
                    afficherLivres(listeLivres);
                    System.out.println("Sélectionnez id du livre");
                    livre = livreService.trouverLivreParId(Integer.parseInt(scanner.nextLine()));
                    emprunteurController.emprunteLivre(emprunteur,livre);
                    break;
                case 9:
                    StatistiqueService.generateReport();
                    break;
                case 0:
                    break;
            }
            if (choix == 0 ) break;
         }
    }
}

