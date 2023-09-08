package service;

import entity.Emprunteur;
import repository.IEmprunteurRepo;
import repository.ILivreEmprunteurRepo;
import repository.impl.LivreEmprunteurImpl;

public class EmprunteurService {
    private final IEmprunteurRepo repo;

    public EmprunteurService(IEmprunteurRepo iEmprunteurRepo){
        this.repo = iEmprunteurRepo ;
    }

    public void ajouterEmprunte(Emprunteur emprunteur) throws Exception{
        ILivreEmprunteurRepo livreEmprunteurRepo = new LivreEmprunteurImpl();
        repo.add(emprunteur);
        livreEmprunteurRepo.add(emprunteur,emprunteur.getLivre());
    }
}
