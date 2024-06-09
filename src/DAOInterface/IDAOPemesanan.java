/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Pemesanan;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public interface IDAOPemesanan {
    //read data
    public List<Pemesanan> getAll();
    //insert data
    public boolean insert(Pemesanan p);
    //update data
    public void update(Pemesanan p);
    //delete data
    public void delete(Pemesanan p);
    //search fata
    public List<Pemesanan> getAllByName(String BarangPsn);
}
