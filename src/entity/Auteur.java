package entity;

import java.sql.Date;

public class Auteur {
    private int id ;
    private String full_name ;
    private String nationalite ;
    private Date date_naissance ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", nationalite='" + nationalite + '\'' +
                ", date_naissance=" + date_naissance +
                '}';
    }
}
