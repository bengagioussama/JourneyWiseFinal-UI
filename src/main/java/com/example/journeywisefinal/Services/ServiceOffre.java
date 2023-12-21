package com.example.journeywisefinal.Services;

import com.example.journeywisefinal.Entities.Offres;
import com.example.journeywisefinal.Utils.DataSource;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ServiceOffre implements IService<Offres> {
    private Connection con = DataSource.getInstance().getCon();
    private PreparedStatement pst;

    public ServiceOffre() {
        try {
            // Use PreparedStatement instead of Statement
            pst = con.prepareStatement("");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void add(Offres o) throws SQLException {
        String sql = "INSERT INTO `offres` (`pays`, `cite`, `lieu`, `date`, `prix`) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, o.getPays());
            pst.setString(2, o.getCite());
            pst.setString(3, o.getLieu());
            pst.setDate(4, java.sql.Date.valueOf(o.getDate()));
            pst.setInt(5, (int) o.getPrix());
            pst.executeUpdate();
        }
        System.out.println("offre ajoutée !");
    }

    @Override
    public void update(Offres o) throws SQLException {
        String sql = "UPDATE `offres` SET `pays`=?, `cite`=?, `lieu`=?, `date`=?, `prix`=? WHERE `id_offre`=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, o.getPays());
            pst.setString(2, o.getCite());
            pst.setString(3, o.getLieu());
            pst.setDate(4, java.sql.Date.valueOf(o.getDate()));
            pst.setInt(5, (int) o.getPrix());
            pst.setInt(6, o.getId_offre());
            pst.executeUpdate();
        }
        System.out.println("offre modifiée !");
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM `offres` WHERE `id_offre`=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
        System.out.println("offre supprimée !");
    }

    @Override
    public ArrayList<Offres> readAll() throws SQLException {
        ArrayList<Offres> list = new ArrayList<>();
        String sql2 = "SELECT * FROM `offres`";
        try (Statement ste = con.createStatement(); ResultSet res = ste.executeQuery(sql2)) {
            while (res.next()) {
                int id = res.getInt(1);
                String pays = res.getString(2);
                String cite = res.getString(3);
                String lieu = res.getString(4);
                LocalDate date = LocalDate.parse(res.getString(5));
                int prix = res.getInt(6);
                Offres o = new Offres(id, pays, cite, lieu, date, prix);
                list.add(o);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public Offres get(int id) throws SQLException {
        String sql = "SELECT * FROM `offres` WHERE `id_offre`=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet res = pst.executeQuery()) {
                if (res.next()) {
                    String pays = res.getString("pays");
                    String cite = res.getString("cite");
                    String lieu = res.getString("lieu");
                    LocalDate date = LocalDate.parse(res.getString("date"));
                    int prix = res.getInt("prix");
                    return new Offres(id, pays, cite, lieu, date, prix);
                }
            }
        }
        return null;
    }
}
