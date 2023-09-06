package entity;

import java.sql.Date;
import java.util.List;

public class Auteur extends Persone {

    private List<Livre> livres ;

    public Auteur() {
    }

    public Auteur(int id, String name, String lastName, String nationalite, Date date_naissance) {
        super(id,name, lastName, nationalite, date_naissance);
    }
    public Auteur(String name, String lastName, String nationalite, Date date_naissance) {
        super(name, lastName, nationalite, date_naissance);
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "livres=" + livres +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalite='" + nationalite + '\'' +
                ", date_naissance=" + date_naissance +
                '}';
    }
}
