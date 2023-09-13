package service;

import entity.Livre;
import repository.ILivreRepo;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreService {

    private final ILivreRepo repo ;
    public LivreService(ILivreRepo repo){
        this.repo = repo ;
    }
    public String Addlivra(Livre livre){
        if (livre.getIsbn() == null || livre.getIsbn().isEmpty()) {

            return "ISBN ne peut pas être vide";
        }
        if (livre.getQnt() <= 0) {
            return "La quantité (Qnt) doit être supérieure à zéro";
        }

        repo.add(livre);
        return "succès, le livre est ajouté";
    }
    public Livre   trouverLivreParId(int id){
        Livre livre = new Livre();
        livre = repo.findById(id);
        if (livre == null){
            return null;
        }else {
            return livre ;
        }
    }
    public List<Livre> trouverTousLesLivres(){
        List<Livre> livres = new ArrayList<>();
        livres = repo.findAll();
        if (livres == null){
            return null;
        }else {
            return livres ;
        }
    }
    public String mettreAJourLivr(Livre livre){
        if (livre.getIsbn() == null || livre.getIsbn().isEmpty()) {

            return "ISBN ne peut pas être vide";
        }
        if (livre.getQnt() <= 0) {
            return "La quantité (Qnt) doit être supérieure à zéro";
        }

        repo.update(livre);
        return "succès, le livre est modifie";
    }
    public List<Livre> livresParTitre(String titre){
        List<Livre> livres = new ArrayList<>();
        livres = repo.searchByTitre(titre);
        return livres ;
    }
    public List<Livre> livresParAuteur(String nom){
        List<Livre> livres = new ArrayList<>();
        livres =  repo.searchByََAuteur(nom);
        return livres;
    }
    public String supprimer(int id){

        if (repo.findById(id)==null){
            return "Il n'y a pas de livres";
        }
        repo.delete(id);
        return "succès, le livre est supprimer";
    }
}
