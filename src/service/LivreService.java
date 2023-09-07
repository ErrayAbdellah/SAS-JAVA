package service;

import entity.Livre;
import repository.ILivreRepo;

import java.util.ArrayList;
import java.util.List;

public class LivreService {

    private final ILivreRepo repo ;
    public LivreService(ILivreRepo repo){
        this.repo = repo ;
    }
    public void Addlivra(Livre livre){
        if (livre.getIsbn() == null || livre.getIsbn().isEmpty()) {
            System.out.println("ISBN ne peut pas être vide");
            return;
        }
        if (livre.getQnt() <= 0) {
            System.out.println("La quantité (Qnt) doit être supérieure à zéro");
            return;
        }

        repo.add(livre);
    }
    public Livre   trouverLivreParId(int id){
        Livre livre =new Livre();

        livre = repo.findById(id);
        if (livre == null){
            System.out.println("ne trouve pas cette livre");
            return null;
        }else {
            return livre ;
        }
    }

    public List<Livre> trouverTousLesLivres(){
        List<Livre> livres = new ArrayList<>();
        livres = repo.findAll();
        if (livres == null){
            System.out.println("Il n'y a pas de livre");
            return null;
        }else {
            return livres ;
        }
    }
    public void mettreAJourLivr(Livre livre){
        if (livre.getIsbn() == null || livre.getIsbn().isEmpty()) {
            System.out.println("ISBN ne peut pas être vide");
            return;
        }
        if (livre.getQnt() <= 0) {
            System.out.println("La quantité (Qnt) doit être supérieure à zéro");
            return;
        }
        repo.update(livre);
    }
}
