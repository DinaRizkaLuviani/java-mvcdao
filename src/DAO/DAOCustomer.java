/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOCustomer;
import Helper.KoneksiDB;
import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author VNX
 */
public class DAOCustomer implements IDAOCustomer {
    private Connection con;

    public DAOCustomer() {
        con = KoneksiDB.getConnection();
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setIdCustomer(rs.getString("idCustomer"));
                customer.setNamaCustomer(rs.getString("namaCustomer"));
                customer.setNoTelp(rs.getString("noTelp"));
                customer.setAlamat(rs.getString("alamat"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return customers;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        boolean result = true;
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strInsert);
            statement.setString(1, customer.getIdCustomer());
            statement.setString(2, customer.getNamaCustomer());
            statement.setString(3, customer.getNoTelp());
            statement.setString(4, customer.getAlamat());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            result = false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("Failed to close statement: " + ex);
                    result = false;
                }
            }
        }
        return result;
    }

    @Override
    public void updateCustomer(Customer customer) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strUpdate);
            statement.setString(1, customer.getNamaCustomer());
            statement.setString(2, customer.getNoTelp());
            statement.setString(3, customer.getAlamat());
            statement.setString(4, customer.getIdCustomer());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("Failed to close statement: " + ex);
                }
            }
        }
    }

    @Override
    public void deleteCustomer(String idCustomer) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strDelete);
            statement.setString(1, idCustomer);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("Failed to close statement: " + ex);
                }
            }
        }
    }

    @Override
    public Customer getCustomerById(String idCustomer) {
        Customer customer = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = con.prepareStatement(strGetById);
            statement.setString(1, idCustomer);
            rs = statement.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setIdCustomer(rs.getString("idCustomer"));
                customer.setNamaCustomer(rs.getString("namaCustomer"));
                customer.setNoTelp(rs.getString("noTelp"));
                customer.setAlamat(rs.getString("alamat"));
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
        return customer;
    }

    
    // SQL Queries
    private final String strRead = "SELECT * FROM customer;";
    private final String strInsert = "INSERT INTO customer (idCustomer, namaCustomer, noTelp, alamat) VALUES (?, ?, ?, ?);";
    private final String strUpdate = "UPDATE customer SET namaCustomer = ?, noTelp = ?, alamat = ? WHERE idCustomer = ?;";
    private final String strDelete = "DELETE FROM customer WHERE idCustomer = ?;";
    private final String strGetById = "SELECT * FROM customer WHERE idCustomer = ?;";
}
