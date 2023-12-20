package com.example.journeywisefinal.Entities;

public class Journal {
    private int id;
    private String offreVoyage;
    private String paysVoyager;
    private String titre;
    private String descrption;
    /*private Date date_creation;*/
    /*private String url_image;*/
    private int id_user;

    public Journal(int id, String offreVoyage, String paysVoyager, String titre, String descrption, int id_user) {
        this.id = id;
        this.offreVoyage = offreVoyage;
        this.paysVoyager = paysVoyager;
        this.titre = titre;
        this.descrption = descrption;
        this.id_user = id_user;
    }

    public Journal(String offreVoyage, String paysVoyager, String titre, String descrption, int id_user) {
        this.offreVoyage = offreVoyage;
        this.paysVoyager = paysVoyager;
        this.titre = titre;
        this.descrption = descrption;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOffreVoyage() {
        return offreVoyage;
    }

    public void setOffreVoyage(String offreVoyage) {
        this.offreVoyage = offreVoyage;
    }

    public String getPaysVoyager() {
        return paysVoyager;
    }

    public void setPaysVoyager(String paysVoyager) {
        this.paysVoyager = paysVoyager;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }


    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", offreVoyage='" + offreVoyage + '\'' +
                ", paysVoyager='" + paysVoyager + '\'' +
                ", titre='" + titre + '\'' +
                ", descrption='" + descrption + '\'' +
                ", id_user=" + id_user +
                '}';
    }
}