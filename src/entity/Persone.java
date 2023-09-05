package entity;

import java.sql.Date;

public class Persone {
    protected int id ;
    protected String name ;
    protected String lastName ;
    protected String nationalite ;
    protected Date date_naissance ;

    public Persone() {
    }

    public Persone(int id, String name, String lastName, String nationalite, Date date_naissance) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.nationalite = nationalite;
        this.date_naissance = date_naissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public java.sql.Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    @Override
    public String toString() {
        return "Persone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalite='" + nationalite + '\'' +
                ", date_naissance=" + date_naissance +
                '}';
    }
}
