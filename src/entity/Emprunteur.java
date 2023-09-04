package entity;

import java.sql.Date;
import java.util.List;

public class Emprunteur extends Persone {
    private boolean is_deleted;
    private boolean is_dispo;
    private Date date_emprunt;
    private Date dateReturn;
    private List<Emprunteur> emprunteurs;

    public Emprunteur(){
    }
    public Emprunteur(String name, String lastName, String nationalite, Date date_naissance, boolean is_deleted, boolean is_dispo, Date date_emprunt, Date dateReturn, List<Emprunteur> emprunteurs) {
        super(name, lastName, nationalite, date_naissance);
        this.is_deleted = is_deleted;
        this.is_dispo = is_dispo;
        this.date_emprunt = date_emprunt;
        this.dateReturn = dateReturn;
        this.emprunteurs = emprunteurs;
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

    public List<Emprunteur> getEmprunteurs() {
        return emprunteurs;
    }

    public void setEmprunteurs(List<Emprunteur> emprunteurs) {
        this.emprunteurs = emprunteurs;
    }

    @Override
    public String toString() {
        return "Emprunteur{" +
                ", deleted=" + is_deleted +
                ", status=" + is_dispo +
                ", date_emprunt=" + date_emprunt +
                ", dateReturn=" + dateReturn +
                ", emprunteurs=" + emprunteurs +
                '}';
    }
}
