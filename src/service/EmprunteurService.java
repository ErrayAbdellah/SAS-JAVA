package service;

import entity.Emprunteur;
import repository.IEmprunteurRepo;
import repository.ILivreEmprunteurRepo;
import repository.ILivreRepo;
import repository.impl.EmprunteurRepoImpl;
import repository.impl.LivreEmprunteurImpl;
import repository.impl.LivreRepoImpl;

public class EmprunteurService {
    private final IEmprunteurRepo repo;
    private final ILivreRepo livreRepo ;
    public EmprunteurService(IEmprunteurRepo iEmprunteurRepo,ILivreRepo livreRepo){
        this.repo = iEmprunteurRepo ;
        this.livreRepo = livreRepo ;
    }

    public void ajouterEmprunte(Emprunteur emprunteur) throws Exception{
        ILivreEmprunteurRepo livreEmprunteurRepo = new LivreEmprunteurImpl();
        if (livreRepo.checkQnt(emprunteur.getLivre().getId()) <= 0 && livreRepo.findById(emprunteur.getLivre().getId())==null ){
            System.out.println("Il n'y a pas de livres");
            return;
        }
        repo.add(emprunteur);
        repo.decr(emprunteur.getLivre().getId());
        emprunteur.setId(repo.lastColumn().getId());
        livreEmprunteurRepo.add(emprunteur,emprunteur.getLivre());
    }
}
