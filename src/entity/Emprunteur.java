package entity;

import java.sql.Date;
import java.util.List;

public class Emprunteur extends Persone {
    private boolean is_deleted;
    private boolean is_dispo;
    private Date date_emprunt;
    private Date dateReturn;
    private Livre livre;
    private List<Livre> livres;

    public Emprunteur(){
    }
    public Emprunteur(int id,String name, String lastName, String nationalite, Date date_naissance, boolean is_deleted, boolean is_dispo, Date date_emprunt, Date dateReturn, List<Livre> livres) {
        super(id, name, lastName, nationalite, date_naissance);
        this.is_deleted = is_deleted;
        this.is_dispo = is_dispo;
        this.date_emprunt = date_emprunt;
        this.dateReturn = dateReturn;
        this.livres = livres;
    }

    public boolean isDeleted() {
        return is_deleted;
    }

    public void setDeleted(boolean deleted) {
        this.is_deleted = deleted;
    }

    public boolean isStatus() {
        return is_dispo;
    }

    public void setStatus(boolean status) {
        this.is_dispo = status;
    }

    public Date getDate_emprunt() {
        return date_emprunt;
    }

    public void setDate_emprunt(Date date_emprunt) {
        this.date_emprunt = date_emprunt;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public List<Livre> getEmprunteurs() {
        return livres;
    }

    public void setEmprunteurs(List<Livre> livres) {
        this.livres = livres;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    @Override
    public String toString() {
        return "Emprunteur{" +
                ", deleted=" + is_deleted +
                ", status=" + is_dispo +
                ", date_emprunt=" + date_emprunt +
                ", dateReturn=" + dateReturn +
                ", emprunteurs=" + livres +
                ", livre=" + livre +
                '}';
    }
}
