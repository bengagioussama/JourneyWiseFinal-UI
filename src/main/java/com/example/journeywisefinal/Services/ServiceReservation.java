package com.example.journeywisefinal.Services;


import com.example.journeywisefinal.Entities.Reservation;
import com.example.journeywisefinal.Utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ServiceReservation implements IService<Reservation> {
    private Connection connection = DataSource.getInstance().getCon();
    private Statement statement;
    public ServiceReservation(){
        try {
            statement= connection.createStatement();
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    @Override
    public void add(Reservation reservation) throws SQLException {
        String query = "INSERT INTO reservations VALUES (NULL, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, new java.sql.Date(reservation.getDateDebut().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(reservation.getDateFin().getTime()));
            preparedStatement.setInt(3, reservation.getNombrePassages());
            preparedStatement.setInt(4, reservation.getOffre());
            preparedStatement.setInt(5, 0);

            int res = preparedStatement.executeUpdate();
            System.out.println("Reservation added");
        }
    }


    @Override
    public void update(Reservation t) throws SQLException {
        if (t.getId() != 0) {
            String query = "UPDATE reservations " +
                    "SET dateDebut = ?," +
                    "dateFin = ?," +
                    "nbrPass = ?," +
                    "idOffre = ?," +
                    "idMembre = ? " +
                    "WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDate(1, new java.sql.Date(t.getDateDebut().getTime()));
                preparedStatement.setDate(2, new java.sql.Date(t.getDateFin().getTime()));
                preparedStatement.setInt(3, t.getNombrePassages());
                preparedStatement.setInt(4, t.getOffre());
                preparedStatement.setInt(5, 1);
                preparedStatement.setInt(6, t.getId());

                int res = preparedStatement.executeUpdate();
                System.out.println("Number of tuples modified: " + res);
            }
        } else {
            throw new SQLException("Reservation not found");
        }
    }


    @Override
    public void delete(int id) throws SQLException {
        try {
            if (get(id) != null) {
                String query = "delete from reservations where id=" + id;
                statement.executeUpdate(query);
            } else {
                throw new SQLException("Reservation unavailable");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


    @Override
    public ArrayList<Reservation> readAll() throws SQLException {
        ArrayList<Reservation>reservations = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from reservations");
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                Date dateDebut = resultSet.getDate(2);
                Date dateFin= resultSet.getDate(3);
                int nombrePassages = resultSet.getInt(4);
                int idOffre = resultSet.getInt(5);
                int id_membre=resultSet.getInt(6);
                reservations.add(new Reservation(id, dateDebut, dateFin, nombrePassages,idOffre, id_membre));
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
        return reservations;
    }
    public ArrayList<Reservation> readAllById(int idM) throws SQLException {
        ArrayList<Reservation>reservations = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from reservations where idMembre="+idM);
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                Date dateDebut = resultSet.getDate(2);
                Date dateFin= resultSet.getDate(3);
                int nombrePassages = resultSet.getInt(4);
                int idOffre = resultSet.getInt(5);
                int id_membre=resultSet.getInt(6);
                reservations.add(new Reservation(id, dateDebut, dateFin, nombrePassages, idOffre,id_membre));
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
        return reservations;
    }

    @Override
    public Reservation get(int idR) throws SQLException {
        try {
            ResultSet resultSet = statement.executeQuery("select * from reservations where id=" + idR);
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                Date dateDebut = resultSet.getDate(2);
                Date dateFin = resultSet.getDate(3);
                int nombrePassages = resultSet.getInt(4);
                int idOffre = resultSet.getInt(5);
                int user = resultSet.getInt(6); // a refaire

                return new Reservation(id, dateDebut, dateFin, nombrePassages, idOffre,user);
            } else {
                System.out.println("No reservation found with ID: " + idR);
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
        return null;
    }

}
