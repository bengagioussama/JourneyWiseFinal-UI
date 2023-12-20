package com.example.journeywisefinal.Services;

import com.example.journeywisefinal.Entities.Journal;
import com.example.journeywisefinal.Utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceJournal implements IService<Journal> {
    private Connection connection = DataSource.getInstance().getCon();
    private Statement statement;

    public ServiceJournal() {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void add(Journal journal) throws SQLException {
        String query = "INSERT INTO journal VALUES (NULL, "
                + journal.getOffreVoyage() + ", "
                + journal.getPaysVoyager() + ", "
                + journal.getTitre() + ", "
                + journal.getDescrption() + ", "
                + journal.getId_user() + ")";
        int res = statement.executeUpdate(query);
        System.out.println("Nombre de tuples de journal ajoutée : " + res);
    }

    @Override
    public void update(Journal journal) throws SQLException {
        String query = "UPDATE journal SET " +
                "offreVoyage = " + journal.getOffreVoyage() + ", " +
                "paysVoyager = " + journal.getPaysVoyager() + ", " +
                "titre = " + journal.getTitre() + ", " +
                "descrption = " + journal.getDescrption() + ", " +
                "id_user = " + journal.getId_user() +
                " WHERE id = " + journal.getId();

        int res = statement.executeUpdate(query);
        System.out.println("Nombre de tuples de journal modifié YAY!!: " + res);
    }


    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM journal WHERE id = " + id;
        int res = statement.executeUpdate(query);
        System.out.println("Nombre de tuples de journal supprimés : " + res);
    }

    @Override
    public ArrayList<Journal> readAll() throws SQLException {
        ArrayList<Journal> journals = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM journal");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String offreVoyage = resultSet.getString(2);
                String paysVoyager = resultSet.getString(3);
                String titre = resultSet.getString(4);
                String descrption = resultSet.getString(5);
                int id_user = resultSet.getInt(6);

                journals.add(new Journal(id, offreVoyage, paysVoyager, titre, descrption, id_user));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return journals;
    }

    @Override
    public Journal get(int id) throws SQLException {
        String query = "SELECT * FROM journal WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            int journalId = resultSet.getInt(1);
            String offreVoyage = resultSet.getString(2);
            String paysVoyager = resultSet.getString(3);
            String titre = resultSet.getString(4);
            String descrption = resultSet.getString(5);
            int id_user = resultSet.getInt(6);

            return new Journal(journalId, offreVoyage, paysVoyager, titre, descrption, id_user);
        }
        return null;
    }

}
