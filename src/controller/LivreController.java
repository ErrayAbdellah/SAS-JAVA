package controller;

import entity.Auteur;
import entity.Livre;
import repository.ILivreRepo;
import repository.impl.LivreRepoImpl;
import service.LivreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class LivreController {
    private final LivreService livreService ;
    private Scanner scanner = new Scanner(System.in);

    public LivreController(LivreService livreService){
        this.livreService = livreService;
    }

    public void add(Livre livre){
        livreService.Addlivra(livre);
    }

    public Livre trouverLivreParId(int id){
        return livreService.trouverLivreParId(id);
    }
    public List<Livre> trouverTousLesLivres(){
        List<Livre> livres = new ArrayList<>();
       livres = livreService.trouverTousLesLivres() ;
        return  livres ;
    }
    public String mettreAJourLivr(Livre livre){
         return livreService.mettreAJourLivr(livre);
    }

    public List<Livre> livresParTitre(String titre){
        List<Livre> livres = livreService.livresParTitre(titre);
        return livres ;
    }
    public List<Livre> livresParAuteur(String nom){
        List<Livre> livres = new ArrayList<>();
        livres =  livreService.livresParAuteur(nom);
        return livres;
    }

    public String supprimer(int id){
        return livreService.supprimer(id);
    }
}
