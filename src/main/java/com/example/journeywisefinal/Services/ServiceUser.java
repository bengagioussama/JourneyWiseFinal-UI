package com.example.journeywisefinal.Services;
import com.example.journeywisefinal.Entities.User;
import com.example.journeywisefinal.Utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceUser implements IService<User> {
    private Connection con = DataSource.getInstance().getCon();
    private Statement ste;

    public ServiceUser() {
        try {
            ste = con.createStatement();
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean validateLogin(String email, String password) {
        String verifyLogin = "SELECT count(1) FROM `user` WHERE `email` = '"+email+"' AND `password` = '"+password+ "';";
        try{

            ResultSet queryResult = ste.executeQuery(verifyLogin);
            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void add(User u) throws SQLException {
        String sql = "INSERT INTO User (id, name , lastName, email , password) VALUES (NULL, '"+u.getFirstName()+"', '"+u.getLastName()+"', '"+u.getEmail()+"', '"+u.getPwd()+"');  ";
        ste.executeUpdate(sql);
        System.out.println("User Ajouté !");
    }

    @Override
    public void update(User u) throws SQLException {
        String sql = "UPDATE User SET `name` = '"+u.getFirstName()+ "', `lastName` = '" +u.getLastName()+"', `Email` = '"+u.getEmail()+"', `password` = '"+ u.getPwd()+"' WHERE `id` = "+u.getId();
        ste.executeUpdate(sql);
        System.out.println("User mis à jour !");
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM `User` WHERE `id` = " + id;
        ste.executeUpdate(sql);
        System.out.println("User supprimé !");
    }

    @Override
    public ArrayList<User> readAll() throws SQLException {
        ArrayList<User> list = new ArrayList<>();
        try {
            String sql2 = "SELECT * FROM `User`;";
            ResultSet res = ste.executeQuery(sql2);

            while (res.next()) {
                long id = (res.getLong(1));
                String firstName = (res.getString(2));
                String lastName = (res.getString(3));
                String email = (res.getString(4));
                String pwd  = (res.getString(5));

                User u = new User((int) id,firstName,lastName,email,pwd);
                list.add(u);
            }
        }
        catch(SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

    @Override
    public User get(int id) throws SQLException {
        String sql = "SELECT * FROM `User` WHERE `id` = " + id;
        ResultSet res = ste.executeQuery(sql);
        if (res.next()) {
            String firstName = res.getString("name");
            String lastName = res.getString("lastName");
            String email = res.getString("email");
            String pwd = res.getString("password");
            return new User(id, firstName, lastName, email, pwd);
        }
        return null;    }
}
