package controller;

import entity.Auteur;
import entity.Livre;
import repository.ILivreRepo;
import repository.impl.LivreRepoImpl;
import service.LivreService;

import java.util.Scanner;

public class LivreController {
    private final LivreService livreService ;
    private Scanner scanner = new Scanner(System.in);

    public LivreController(LivreService livreService){
        this.livreService = livreService;
    }

    public void add(){
        Livre livre =new Livre();
        Auteur auteur = new Auteur();

        System.out.println("Enter Title : ");
        livre.setTitre(scanner.nextLine());
        System.out.println("Enter ISBN : ");
        livre.setIsbn(scanner.nextLine());
        System.out.println("Enter Quantity : ");
        livre.setQnt(Long.parseLong(scanner.nextLine()));
        System.out.println("Enter Auteur Id : ");
        auteur.setId(Integer.parseInt(scanner.nextLine()));
        livre.setAuteur(auteur);

        livreService.Addlivra(livre);
    }

    public void trouverLivreParId(){
        System.out.println("enter id : ");
        int id = Integer.parseInt(scanner.nextLine());
        livreService.trouverLivreParId(id);
    }
    public void trouverTousLesLivres(){
        System.out.println(livreService.trouverTousLesLivres());
    }
    public void mettreAJourLivr(){
        Livre livre =new Livre();
        Auteur auteur = new Auteur();

        System.out.println("Enter id : ");
        livre.setTitre(scanner.nextLine());
        System.out.println("Enter Title : ");
        livre.setTitre(scanner.nextLine());
        System.out.println("Enter ISBN : ");
        livre.setIsbn(scanner.nextLine());
        System.out.println("Enter Quantity : ");
        livre.setQnt(Long.parseLong(scanner.nextLine()));
        System.out.println("Enter Auteur Id : ");
        auteur.setId(Integer.parseInt(scanner.nextLine()));
        livre.setAuteur(auteur);
    }
}
