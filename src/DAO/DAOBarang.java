/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOBarang;
import Helper.KoneksiDB;
import Model.Barang;
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
public class DAOBarang implements IDAOBarang{

    public DAOBarang()
    {
        con = KoneksiDB.getConnection();
    }
    @Override
    public List<Barang> getAll() {
        List<Barang> lstBrg = null;
        try
        {
            lstBrg = new ArrayList<Barang>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                Barang brg = new Barang();
                brg.setIDbrg(rs.getString("id_barang"));
                brg.setNamaBrg(rs.getString("nama"));
                brg.setHargaBrg(rs.getString("harga"));
                brg.setStok(rs.getInt("stok"));
                brg.setJenisBrg(rs.getString("jenis"));
                brg.setSuplier(rs.getString("supplier"));
                lstBrg.add(brg);
            }
            
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e);
        }
        return lstBrg;
        
    }
    
    @Override
    public boolean insert(Barang b) {
        boolean result = true;
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strInsert);
            statement.setString(1, b.getIDbrg());
            statement.setString(2, b.getNamaBrg());
            statement.setString(3, b.getHargaBrg());
            statement.setInt(4, b.getStok());
            statement.setString(5, b.getJenisBrg());
            statement.setString(6, b.getSuplier());
            
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
    public void update(Barang b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strUpdate);
            statement.setString(1, b.getNamaBrg());
            statement.setString(2, b.getHargaBrg());
            statement.setInt(3, b.getStok());
            statement.setString(4, b.getJenisBrg());
            statement.setString(5, b.getIDbrg());
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
    public void delete(Barang b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strDelete);
            statement.setString(1, b.getIDbrg());
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
    public List<Barang> getAllByName(String id_barang) {
        List<Barang> lstBrg = null;
        try
        {
            lstBrg = new ArrayList<Barang>();
            PreparedStatement st = con.prepareStatement(strSearch);
            st.setString(1, "%"+id_barang+"%");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Barang brg = new Barang();
                brg.setIDbrg(rs.getString("id_barang"));
                brg.setNamaBrg(rs.getString("nama"));
                brg.setHargaBrg(rs.getString("harga"));
                brg.setStok(rs.getInt("stok"));
                brg.setJenisBrg(rs.getString("jenis"));
                lstBrg.add(brg);
            }
            
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e);
        }
        return lstBrg;
    }
    
    @Override
    public List<Barang> getAllByStok() {
        
        List<Barang> lstBrg = null;
        try
        {
            lstBrg = new ArrayList<Barang>();
            PreparedStatement st = con.prepareStatement(strStok);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Barang brg = new Barang();
                brg.setIDbrg(rs.getString("id_barang"));
                brg.setNamaBrg(rs.getString("nama"));
                brg.setHargaBrg(rs.getString("harga"));
                brg.setStok(rs.getInt("stok"));
                brg.setJenisBrg(rs.getString("jenis"));
                lstBrg.add(brg);
            }
            
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e);
        }
        return lstBrg;
    }
    
    Connection con;
    //SQL Query
    String strRead = "select * from tbl_barang order by nama asc;";
    String strInsert = "insert into tbl_barang (id_barang,nama,harga,stok,jenis,supplier) values (?,?,?,?,?,?);";
    String strUpdate = "update tbl_barang set nama=?, harga=?, stok=?, jenis=? where id_barang=?";
    String strDelete = "delete from tbl_barang where id_barang=?";
    String strSearch = "select * from tbl_barang where id_barang like ?;";
    String strStok = "select * from tbl_barang where stok <10;";
}
