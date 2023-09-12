package service;

import entity.Auteur;
import repository.IAuteurRepo;

import java.util.ArrayList;
import java.util.List;

public class AuteurService {
private final IAuteurRepo repo ;

    public AuteurService(IAuteurRepo repo) {
        this.repo = repo;
    }
    public List<Auteur> afficherAuteurs(){
        List<Auteur> auteurs = new ArrayList<>();
        auteurs = repo.findAll();
        return auteurs ;
    }
    public Auteur trouverLivreParId(int id){
        Auteur auteur = new Auteur() ;
        auteur = repo.findById(id);
        return auteur ;
    }
}
