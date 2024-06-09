/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOUser;
import Helper.KoneksiDB;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author VNX
 */
public class DAOUser implements IDAOUser{
    private Connection con;

    public DAOUser() {
        con = KoneksiDB.getConnection();
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = con.prepareStatement(strGetByUsername);
            statement.setString(1, username);
            rs = statement.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Failed to close ResultSet: " + ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("Failed to close statement: " + ex);
                }
            }
        }
        return user;
    }

    @Override
    public boolean validateUser(String username, String password) {
        boolean isValid = false;
        User user = getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            isValid = true;
        }
        return isValid;
    }

    // SQL Query
    private final String strGetByUsername = "SELECT * FROM users WHERE username = ?;";
}
