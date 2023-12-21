package com.example.journeywisefinal.Entities;

import java.util.Date;

public class Reservation {
    private int id;
    private Date dateDebut,dateFin;
    private int nombrePassages;
    private int idOffre;
    private int idUser;

    public Reservation(int id, Date dateDebut, Date dateFin, int nombrePassages, int idOffre, int user) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nombrePassages = nombrePassages;
        this.idOffre = idOffre;
        this.idUser = user;
    }

    public Reservation(Date dateDebut, Date dateFin, int nombrePassages, int idOffre, int user) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nombrePassages = nombrePassages;
        this.idOffre = idOffre;
        this.idUser = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNombrePassages() {
        return nombrePassages;
    }

    public void setNombrePassages(int nombrePassages) {
        this.nombrePassages = nombrePassages;
    }

    public int getOffre() {
        return idOffre;
    }

    public void setOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", nombrePassages=" + nombrePassages +
                ", id_offre='" + idOffre + '\'' +
                ", id_user=" + idUser +
                '}';
    }
}
