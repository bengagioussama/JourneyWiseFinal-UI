package com.example.journalfx.Entities;

public class Journal {
    private int id;
    private String offreVoyage;
    private String paysVoyager;
    private String titre;
    private String descrption;
    /*private Date date_creation;*/
    private String url_image;
    private int id_user;
    private int id_res;

    public Journal(int id, String offreVoyage, String paysVoyager, String titre, String descrption, String url_image, int id_user, int id_res) {
        this.id = id;
        this.offreVoyage = offreVoyage;
        this.paysVoyager = paysVoyager;
        this.titre = titre;
        this.descrption = descrption;
        this.url_image = url_image;
        this.id_user = id_user;
        this.id_res= id_res;
    }

    public Journal(String offreVoyage, String paysVoyager, String titre, String descrption, String url_image, int id_user, int id_res) {
        this.offreVoyage = offreVoyage;
        this.paysVoyager = paysVoyager;
        this.titre = titre;
        this.descrption = descrption;
        this.url_image = url_image;
        this.id_user = id_user;
        this.id_res= id_res;
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

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public int getId_reservation() {
        return id_res;
    }

    public void setId_reservation(int id_user) {
        this.id_res = id_res;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", offreVoyage='" + offreVoyage + '\'' +
                ", paysVoyager='" + paysVoyager + '\'' +
                ", titre='" + titre + '\'' +
                ", descrption='" + descrption + '\'' +
                ", url_image='" + url_image + '\'' +
                ", id_user=" + id_user + '\'' +
                ", id_res=" + id_res +
                '}';
    }
}