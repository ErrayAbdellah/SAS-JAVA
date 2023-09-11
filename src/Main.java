import controller.EmprunteurController;
import controller.LivreController;
import repository.IEmprunteurRepo;
import repository.ILivreEmprunteurRepo;
import repository.ILivreRepo;
import repository.impl.EmprunteurRepoImpl;
import repository.impl.LivreEmprunteurImpl;
import repository.impl.LivreRepoImpl;
import service.EmprunteurService;
import service.LivreService;
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
        System.out.println("\t*	7  - Emprunte livre\t\t*");
        System.out.println("\t*	0  - Quitter \t\t\t\t\t\t\t\t*");
        System.out.println("\t*************************************************\n");

        do {
            System.out.println("\nChoisissez le numero de l'operation que vous souhaitez effectuer : ");
            choix = scanner.nextInt();

        }while (choix<0 || choix>8);
        return choix ;
    }

    public static void main(String[] args) throws Exception {
        ILivreRepo livreRepo = new LivreRepoImpl();
        IEmprunteurRepo iEmprunteurRepo = new EmprunteurRepoImpl();
        ILivreEmprunteurRepo livreEmprunteurRepo = new LivreEmprunteurImpl();

        LivreService livreService = new LivreService(livreRepo);
        EmprunteurService emprunteurService = new EmprunteurService(iEmprunteurRepo,livreRepo);

        LivreController livreController = new LivreController(livreService);
        EmprunteurController emprunteurController = new EmprunteurController(emprunteurService,livreService);


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
                case 7:
                    emprunteurController.emprunteLivre();
                    break;
                case 0:
                    break;
            }
            if (choix == 0 ) break;
         }

    }
}

