package entity;

public class Livre {

    private int id ;
    private String titre ;
    private String isbn ;
    private long qnt ;
    private int auteur_id ;

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

    public int getAuteur_id() {
        return auteur_id;
    }

    public void setAuteur_id(int auteur_id) {
        this.auteur_id = auteur_id;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", isbn='" + isbn + '\'' +
                ", qnt=" + qnt +
                ", auteur_id=" + auteur_id +
                '}';
    }
}
