/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOBarang;
import DAOInterface.IDAOBarang;
import Model.Barang;
import Model.TabelModelBarang;
import Model.TabelModelBarangStok;
import View.Dashboard;
import View.FormBarang;
import View.FormTabelBarangbyStok;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Lenovo
 */
public class ControllerBarang {
    
    public ControllerBarang(FormBarang frmBarang){
        this.frmBarang = frmBarang;
        iBarang = new DAOBarang();
    }
    
    public ControllerBarang(FormTabelBarangbyStok frmBarangStok){
        this.frmBarangStok = frmBarangStok;
        iBarang = new DAOBarang();
    }
    
    public void isiTable()
    {
       lstBrg = iBarang.getAll();
       TabelModelBarang tabelBrg = new TabelModelBarang(lstBrg);
       frmBarang.getTabelData().setModel(tabelBrg);
    }
    
    public void isiTableRestock()
    {
       lstBrg = iBarang.getAllByStok();
       TabelModelBarangStok tabelBrgStok = new TabelModelBarangStok(lstBrg);
       frmBarangStok.getTabelDataStok().setModel(tabelBrgStok);
    }
    
    public void insert()
    {
        Barang b = new Barang();
        b.setIDbrg(frmBarang.gettxtIDbrg().getText());
        b.setNamaBrg(frmBarang.gettxtNamaBrg().getText());
        b.setHargaBrg(frmBarang.gettxtHargaBrg().getText());
        b.setStok(Integer.parseInt(frmBarang.gettxtStok().getText()));
        b.setJenisBrg(frmBarang.gettxtJenisBrg().getText());
        b.setSuplier(frmBarang.gettxtSupplier().getText());
        boolean res = iBarang.insert(b);
        if(res)
            JOptionPane.showConfirmDialog(null, "input berhasil");
        else
            JOptionPane.showConfirmDialog(null, "Gagal/data duplikat");
           
    }
    
    public void reset()
    {
        if(!frmBarang.gettxtIDbrg().isEnabled())
            frmBarang.gettxtIDbrg().setEnabled(true);
        frmBarang.gettxtIDbrg().setText("");
        frmBarang.gettxtNamaBrg().setText("");
        frmBarang.gettxtHargaBrg().setText("");
        frmBarang.gettxtStok().setText("");
        frmBarang.gettxtJenisBrg().setText("");
        
    }
    
    public void isiField(int row)
    {
        frmBarang.gettxtIDbrg().setEnabled(false);
        frmBarang.gettxtIDbrg().setText(lstBrg.get(row).getIDbrg());
        frmBarang.gettxtNamaBrg().setText(lstBrg.get(row).getNamaBrg());
        frmBarang.gettxtHargaBrg().setText(lstBrg.get(row).getHargaBrg());
        frmBarang.gettxtStok().setText(lstBrg.get(row).getStok().toString());
        frmBarang.gettxtJenisBrg().setText(lstBrg.get(row).getJenisBrg());
    }
    
    public void update()
    {
        Barang b = new Barang();
        b.setNamaBrg(frmBarang.gettxtNamaBrg().getText());
        b.setHargaBrg(frmBarang.gettxtHargaBrg().getText());
        b.setStok(Integer.parseInt(frmBarang.gettxtStok().getText()));
        b.setJenisBrg(frmBarang.gettxtJenisBrg().getText());
        b.setIDbrg(frmBarang.gettxtIDbrg().getText());
        iBarang.update(b);
        JOptionPane.showConfirmDialog(null, "update berhasil");
    }
    
    public void delete()
    {
        Barang b = new Barang();
        b.setIDbrg(frmBarang.gettxtIDbrg().getText());
        iBarang.delete(b);
        JOptionPane.showConfirmDialog(null, "delete berhasil");
    }
    
    public void cari()
    {
        lstBrg = iBarang.getAllByName(frmBarang.gettxtCariBrg().getText());
        TabelModelBarang tabelBrg = new TabelModelBarang(lstBrg);
        frmBarang.getTabelData().setModel(tabelBrg);
    }
    FormBarang frmBarang;
    FormTabelBarangbyStok frmBarangStok;
    IDAOBarang iBarang;
    List<Barang> lstBrg;
}
