package controller;

import entity.Emprunteur;

import entity.Livre;
import service.EmprunteurService;
import service.LivreService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmprunteurController {

    private final EmprunteurService emprunteurService ;
    private final LivreService livreService;
    Scanner scanner = new Scanner(System.in);

    public EmprunteurController(EmprunteurService emprunteurService, LivreService livreService) {
        this.emprunteurService = emprunteurService;
        this.livreService = livreService;
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

    public void emprunteLivre() throws Exception {
        Emprunteur emprunteur = new Emprunteur();
        Livre livre = new Livre();
        LocalDate localDate = LocalDate.now();
        System.out.println("Enter name : ");
        emprunteur.setName(scanner.nextLine());
        System.out.println("Enter Last name : ");
        emprunteur.setLastName(scanner.nextLine());
        System.out.println("Enter date return : ");
        emprunteur.setDateReturn(convertDate(scanner.nextLine()));
        emprunteur.setDate_emprunt(Date.valueOf(localDate));

        List<Livre> listeLivres = livreService.trouverTousLesLivres();

        for (Livre livr : listeLivres) {
            System.out.println("ID : " + livr.getId());
            System.out.println("Titre : " + livr.getTitre());
            System.out.println("ISBN : " + livr.getIsbn());
            System.out.println("Quantité : " + livr.getQnt());
            System.out.println("Auteur ID : " + livr.getAuteur());
            System.out.println(); // Ligne vide pour séparer les livres
        }
        System.out.println("Sélectionnez id du livre");
        livre = livreService.trouverLivreParId(Integer.parseInt(scanner.nextLine()));
        emprunteur.setLivre(livre);
        emprunteurService.ajouterEmprunte(emprunteur);

    }
}
