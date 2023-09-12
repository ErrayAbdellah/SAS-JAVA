package controller;

import entity.Auteur;
import service.AuteurService;

import java.util.ArrayList;
import java.util.List;

public class AuteurController {
    private final AuteurService service ;

    public AuteurController(AuteurService service) {
        this.service = service;
    }

    public List<Auteur> afficherAuteurs(){
        List<Auteur> auteurs = new ArrayList<>();
        auteurs = service.afficherAuteurs();
        return auteurs;
    }
    public Auteur trouverLivreParId(int id){
        return service.trouverLivreParId(id);
    }
}
