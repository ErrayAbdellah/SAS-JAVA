package entity;

public class LivreEmprunt {
    private int id ;
    private int livre_id ;
    private int emprunteur_id ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivre_id() {
        return livre_id;
    }

    public void setLivre_id(int livre_id) {
        this.livre_id = livre_id;
    }

    public int getEmprunteur_id() {
        return emprunteur_id;
    }

    public void setEmprunteur_id(int emprunteur_id) {
        this.emprunteur_id = emprunteur_id;
    }

    @Override
    public String toString() {
        return "LivreEmprunt{" +
                "id=" + id +
                ", livre_id=" + livre_id +
                ", emprunteur_id=" + emprunteur_id +
                '}';
    }
}
