package entity;

import java.util.List;

public class Livre {

    private int id ;
    private String titre ;
    private String isbn ;
    private long qnt ;
    private Auteur auteur ;

    private List<Emprunteur> emprunteurs ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public long getQnt() {
        return qnt;
    }

    public void setQnt(long qnt) {
        this.qnt = qnt;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public List<Emprunteur> getEmprunteurs() {
        return emprunteurs;
    }

    public void setEmprunteurs(List<Emprunteur> emprunteurs) {
        this.emprunteurs = emprunteurs;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", isbn='" + isbn + '\'' +
                ", qnt=" + qnt +
                ", auteur=" + auteur +
                ", emprunteurs=" + emprunteurs +
                '}';
    }

}
