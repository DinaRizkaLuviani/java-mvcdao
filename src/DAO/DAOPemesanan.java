/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOPemesanan;
import Helper.KoneksiDB;
import Model.Pemesanan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lenovo
 */
public class DAOPemesanan implements IDAOPemesanan{
    
    public DAOPemesanan()
    {
        con = KoneksiDB.getConnection();
    }

    @Override
    public List<Pemesanan> getAll() {
        List<Pemesanan> lstPmsn = null;
        try
        {
            lstPmsn = new ArrayList<Pemesanan>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                Pemesanan pmsn = new Pemesanan();
                pmsn.setIDpsn(rs.getInt("idPesanan"));
                pmsn.setTanggalPsn(rs.getTimestamp("tanggal"));
                pmsn.setBarangPsn(rs.getString("barangPesan"));
                pmsn.setTotHarga(rs.getString("totalHarga"));
                pmsn.setIDcust(rs.getInt("idCustomer"));
                lstPmsn.add(pmsn);
            }
            
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e);
        }
        return lstPmsn;
    }
    
    @Override
    public boolean insert(Pemesanan p) {
        boolean result = true;
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strInsert);
            statement.setInt(1, p.getIDpsn());
            statement.setTimestamp(2, p.getTanggalPsn());
            statement.setString(3, p.getBarangPsn());
            statement.setString(4, p.getTotHarga());
            statement.setInt(5, p.getIDcust());
            statement.execute();
        }catch(SQLException e)
        {
            System.out.println("gagal input");
            result = false;
        }
        finally
        {
        try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal input");
                result = false;
            }
        }
        return result;
    }
    
    @Override
    public void update(Pemesanan p) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strUpdate);
            statement.setTimestamp(1, p.getTanggalPsn());
            statement.setString(2, p.getBarangPsn());
            statement.setString(3, p.getTotHarga());
            statement.setInt(4, p.getIDcust());
            statement.setInt(5, p.getIDpsn());
            statement.execute();
        }catch(SQLException e)
        {
            System.out.println("gagal update");
        }
        finally
        {
        try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal update");
            }
        }
    }
    
    @Override
    public void delete(Pemesanan p) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strDelete);
            statement.setInt(1, p.getIDpsn());
            statement.execute();
        }catch(SQLException e)
        {
            System.out.println("gagal delete");
        }
        finally
        {
        try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal delete");
            }
        }
    }
    
    @Override
    public List<Pemesanan> getAllByName(String BarangPsn) {
        List<Pemesanan> lstPmsn = null;
        try
        {
            lstPmsn = new ArrayList<Pemesanan>();
            PreparedStatement st = con.prepareStatement(strSearch);
            st.setString(1, "%"+BarangPsn+"%");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Pemesanan pmsn = new Pemesanan();
                pmsn.setIDpsn(rs.getInt("idPesanan"));
                pmsn.setTanggalPsn(rs.getTimestamp("tanggal"));
                pmsn.setBarangPsn(rs.getString("barangPesan"));
                pmsn.setTotHarga(rs.getString("totalHarga"));
                pmsn.setIDcust(rs.getInt("idCustomer"));
                lstPmsn.add(pmsn);
            }
            
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e);
        }
        return lstPmsn;
    }
    
    Connection con;
    
    //SQL Query
    String strRead = "select * from tblPesanan;";
    String strInsert = "insert into tblPesanan (idPesanan,tanggal,barangPesan,totalHarga,idCustomer) values (?,?,?,?,?);";
    String strUpdate = "update tblPesanan set tanggal=?, barangPesan=?, totalHarga=?, idCustomer=? where idPesanan=?";
    String strDelete = "delete from tblPesanan where idPesanan=?";
    String strSearch = "select * from tblPesanan where barangPesan like ?;";

 }
